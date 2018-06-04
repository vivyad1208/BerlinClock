package clock;

import java.util.Calendar;

public class SetTime {


	public synchronized void setMinutesTop(BerlinClock clock, Calendar cal) {
		int minute = cal.get(Calendar.MINUTE);
		MinutesTopPanel[] minutesTopPanels = clock.getMinutesTopPanels();
		for (int i = 0; i < minutesTopPanels.length; i++) {
			minutesTopPanels[i].backgroundColor = i<minute/5 ? MinutesTopPanel.activeColor : MinutesTopPanel.defaultColor;
			minutesTopPanels[i].repaint();
		}
		// Bottom Panel Execution
		setMinutesBottom(cal, clock.getMinutesBottomPanels(), minute);
	}


	public void setMinutesBottom(Calendar cal, MinutesBottomPanel[] minutesBottomPanels, int minute) {
		for (int i = 0; i < minutesBottomPanels.length; i++) {
			minutesBottomPanels[i].backgroundColor = (minute%5==0 || minute%5<i+1) ? MinutesBottomPanel.defaultColor : MinutesBottomPanel.activeColor;
			minutesBottomPanels[i].repaint();
		}
	}

	public synchronized void setHoursTop(BerlinClock clock, Calendar cal) {
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		HoursTopPanel[] hoursTopPanels = clock.getHoursTopPanels();
		for (int i = 0; i < hoursTopPanels.length; i++) {
			hoursTopPanels[i].backgroundColor = i<hourOfDay/5 ? HoursTopPanel.activeColor : HoursTopPanel.defaultColor;
			hoursTopPanels[i].repaint();
		}
		// Bottom Panel Execution
		setHoursBottom(cal, clock.getHoursBottomPanels(), hourOfDay);
	}

	public void setHoursBottom(Calendar cal, HoursBottomPanel[] hourBottomPanels, int hourOfDay) {
		for (int i = 0; i < hourBottomPanels.length; i++) {
			hourBottomPanels[i].backgroundColor = (hourOfDay%5==0 || hourOfDay%5<i+1) ? HoursBottomPanel.defaultColor : HoursBottomPanel.activeColor;
			hourBottomPanels[i].repaint();
		}
	}
}
