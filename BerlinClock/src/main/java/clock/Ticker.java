package clock;

import java.util.Calendar;
import java.util.TimeZone;

public class Ticker implements Runnable {

	private volatile boolean beep = true;
	private volatile boolean skip = false;
	private long extraTimeTaken = 0;

	private volatile byte prevSecond = 60;
	private volatile byte prevMinute = 60;

	private BerlinClock clock;
	private final SetTime setTime;

	public Ticker(BerlinClock clock) {
		this.clock = clock;
		setTime = new SetTime();
	}

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

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private long repaintPanelsAndGetTimeTaken(long millis) {
		// Repaint the SECOND'S Panel
		repaintSecondsPanel();

		// If change in minute
		if(!repaintMinutesRequired(millis))
			return getDifferenceInMillis(millis);

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(clock.getTimeZone()));

		// Repaint Minute Panels
		repaintMinutePanels(cal);

		// If change in hour
		if(!repaintHoursRequired(cal))
			return getDifferenceInMillis(millis);

		// Repaint Hour Panels
		repaintHourPanels(cal);

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


	private void repaintMinutePanels(Calendar cal) {
		// Repaint Minute Panels
		setTime.setMinutes(cal, clock.getMinutesTopPanels(), true);
		// Repaint Bottom Minute Panels
		setTime.setMinutesBottom(cal, clock.getMinutesBottomPanels(), true);
	}


	private void repaintHourPanels(Calendar cal) {
		// Repaint Hour Panels
		setTime.setHours(cal, clock.getHoursTopPanels(), true);
		// Repaint Bottom Hour Panels
		setTime.setHoursBottom(cal, clock.getHoursBottomPanels(), true);
	}


	// Apply @Test
	private long getDifferenceInMillis(long millis) {
		return System.currentTimeMillis() - millis;
	}


	// Apply @Test
	private boolean repaintMinutesRequired(long millis) {
		byte seconds = (byte)((millis/1000)%60);
		boolean repaint = prevSecond>seconds;
		prevSecond = seconds;
		return repaint;
	}


	// Apply @Test
	private boolean repaintHoursRequired(Calendar cal) {
		byte minutes = (byte) cal.get(Calendar.MINUTE);
		boolean repaint = prevMinute>minutes;
		prevMinute = minutes;
		return repaint;
	}

}
