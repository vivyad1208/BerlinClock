package clock;

import java.util.Calendar;
import java.util.TimeZone;

public class Ticker implements Runnable {

	private volatile boolean beep = true;
	private volatile boolean skip = false;
	private long extraTimeTaken = 0;

	private volatile int prevSecond = 60;
	private volatile int prevMinute = 60;

	private BerlinClock clock;
	private final SetTime setTime;

	public Ticker() {
		setTime = new SetTime();
	}

	public Ticker(BerlinClock clock) {
		this();
		this.clock = clock;
	}

	public void setClock(BerlinClock clock) {
		this.clock = clock;
	}

	private void sleep(long millis) {
		try { Thread.sleep(millis); }
		catch (InterruptedException e) { e.printStackTrace(); }
	}


	/**
	 * Responsible for proper functioning of clock.
	 * Calls {@link #repaintPanelsAndGetTimeTaken(long)}
	 */
	@Override
	public void run() {
		while(true) {
			if(!clock.getSecondsPanel().isPainted()) {
				sleep(100);
				continue;
			}
			extraTimeTaken = repaintPanelsAndGetTimeTaken(System.currentTimeMillis());
			sleep(1000 - extraTimeTaken);
		}	
	}

	/**
	 * Perpetuates the functioning of clock.
	 * Changes the state of Second's indicator on top in every 2 seconds.
	 * Changes the state of the other section of the clock if required.
	 * 
	 * Methods Used
	 * {@link #repaintSecondsPanel()}			// Update Seconds Panel
	 * {@link #repaintMinutesRequired(int)}		// Check -> Change in minute
	 * {@link #getDifferenceInMillis(long)}		// Get Time Difference
	 * {@link #repaintMinutesAndHours(long)}	// Change the state of the minute and hour section
	 * 
	 * @param millis
	 * @return long timeTaken
	 */
	final long repaintPanelsAndGetTimeTaken(long millis) {
		// Repaint the SECOND'S Panel
		repaintSecondsPanel();

		// If change in minute
		int seconds = (int) (millis/1000)%60 ;
		if(!repaintMinutesRequired(seconds)) {
			return getDifferenceInMillis(millis);
		}

		return repaintMinutesAndHours(millis);
	}


	/**
	 * Changes the state of the minute and hour section of the clock if required.
	 * 
	 * Methods Used
	 * {@link SetTime#minutes(int, MinutesTopPanel[], MinutesBottomPanel[])}	// Update minute section
	 * {@link SetTime#hours(int, HoursTopPanel[], HoursBottomPanel[])}			// Update hours section
	 * @param millis
	 * @return long timeTaken
	 */
	private long repaintMinutesAndHours(long millis) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(clock.getTimeZone()));

		// Repaint Minute Panels
		int minutes = cal.get(Calendar.MINUTE);
		setTime.minutesTop(clock.getMinutesTopPanels(), minutes);
		setTime.minutesBottom(clock.getMinutesBottomPanels(), minutes);

		// If change in hour
		if(!repaintHoursRequired(minutes)) {
			return getDifferenceInMillis(millis);
		}

		// Repaint Hour Panels
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		setTime.hoursTop(clock.getHoursTopPanels(), hours);
		setTime.hoursBottom(clock.getHoursBottomPanels(), hours);

		return getDifferenceInMillis(millis);
	}


	private void repaintSecondsPanel() {
		// Repaint the SECOND'S Panel
		SecondsPanel secondsPanel = clock.getSecondsPanel();
		if(skip) {
			secondsPanel.backgroundColor = beep ? SecondsPanel.activeColor : CurvedPanel.defaultColor;
			secondsPanel.repaint();
			beep = !beep;
		}
		skip = !skip;
	}


	// Applied @Test
	public long getDifferenceInMillis(long millis) {
		long currentMillis = System.currentTimeMillis();
		if(millis>currentMillis)
			throw new IllegalArgumentException(new StringBuilder("Invlid MilliSecond [").append(millis).append("]>[").append(currentMillis).append("]").toString());
		return System.currentTimeMillis() - millis;
	}


	// Applied @Test
	public boolean repaintMinutesRequired(int seconds) {
		if(seconds>60)
			throw new IllegalArgumentException(new StringBuilder("Seconds cannot be greater then 60.[").append(seconds).append("]").toString());
		boolean repaint = prevSecond>seconds;
		prevSecond = seconds;
		return repaint;
	}

	// Applied @Test
	public boolean repaintHoursRequired(int minutes) {
		if(minutes>60)
			throw new IllegalArgumentException(new StringBuilder("Minutes cannot be greater then 60.[").append(minutes).append("]").toString());
		boolean repaint = prevMinute>minutes;
		prevMinute = minutes;
		return repaint;
	}

}
