package clock;

import java.awt.Color;
import java.util.Calendar;
import java.util.TimeZone;

public class SecondsPanel extends CurvedPanel implements Runnable {

	private static final long serialVersionUID = 7386269100619226440L;

	private BerlinClock clock;

	private boolean beep = true;
	private boolean skip = false;
	private Color activeColor = Color.YELLOW;
	private long extraTimeTaken = 0;
	private volatile byte prevSecond = 60;
	private volatile byte prevMinute = 60;

	private final SetTime setTime;

	public SecondsPanel() {
		super(225, defaultColor);
		setOpaque(false);
		setTime = new SetTime();
	}

	void setClock(BerlinClock clock) {
		this.clock = clock;
	}

	@Override
	public void run() {
		while(true) {
			if(!isPainted()) {
				sleep(100);
				continue;
			}
			extraTimeTaken = reassignAndGetExtraTime(System.currentTimeMillis());
			sleep(1000-extraTimeTaken);
		}	
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private long reassignAndGetExtraTime(long millis) {
		// Repaint the SECOND'S Panel
		if(skip) {
			backgroundColor = beep ? activeColor : defaultColor;
			repaint();
			beep = !beep;
		}
		skip = !skip;

		// Check Minute Panel
		prevSecond = paintMinuteAndReturnCurrentSecond(millis);

		return System.currentTimeMillis() - millis;
	}


	private byte paintMinuteAndReturnCurrentSecond(long millis) {
		byte seconds = (byte)((millis/1000)%60);
		if(prevSecond>seconds) {
			// Set Minute Clock
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(clock.getTimeZone()));
			setTime.setMinutesTop(clock, cal);
			// Check Hour Panel
			prevMinute = paintHourAndReturnCurrentMinute(cal);
		}
		return seconds;
	}


	private byte paintHourAndReturnCurrentMinute(Calendar cal) {
		byte minutes = (byte) cal.get(Calendar.MINUTE);
		if(prevMinute>minutes) {
			// Set Hour Clock
			setTime.setHoursTop(clock, cal);
		}
		return minutes;
	}
	
}
