package clock;

import java.util.Calendar;

public class SetTime {


	// Apply @Test
	public synchronized boolean[] setMinutes(Calendar cal, MinutesTopPanel[] minutesTopPanels, boolean repaint) {
		boolean[] activeMinutePanels = new boolean[minutesTopPanels.length];
		int minute = cal.get(Calendar.MINUTE);
		for (int i = 0; i < minutesTopPanels.length; i++) {
			boolean active = i<minute/5;
			if(repaint) {
				minutesTopPanels[i].backgroundColor = active ? MinutesTopPanel.activeColor : CurvedPanel.defaultColor;
				minutesTopPanels[i].repaint();
			}
			activeMinutePanels[i] = active;
		}
		return activeMinutePanels;
	}


	// Apply @Test
	public synchronized boolean[] setMinutesBottom(Calendar cal, MinutesBottomPanel[] minutesBottomPanels, boolean repaint) {
		boolean[] activeMinutePanels = new boolean[minutesBottomPanels.length];
		int minute = cal.get(Calendar.MINUTE);
		for (int i = 0; i < minutesBottomPanels.length; i++) {
			boolean active = (minute%5!=0 && minute%5>i);
			if(repaint) {
				minutesBottomPanels[i].backgroundColor = active ?  MinutesTopPanel.activeColor : CurvedPanel.defaultColor;
				minutesBottomPanels[i].repaint();
			}
			activeMinutePanels[i] = active;
		}
		return activeMinutePanels;
	}


	// Apply @Test
	public synchronized boolean[] setHours(Calendar cal, HoursTopPanel[] hoursTopPanels, boolean repaint) {
		boolean[] activeHoursPanels = new boolean[hoursTopPanels.length];
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		for (int i = 0; i < hoursTopPanels.length; i++) {
			boolean active = i<hourOfDay/5;
			if(repaint) {
				hoursTopPanels[i].backgroundColor = active ? HoursTopPanel.activeColor : CurvedPanel.defaultColor;
				hoursTopPanels[i].repaint();
			}
			activeHoursPanels[i] = active;
		}
		return activeHoursPanels;
	}


	// Apply @Test
	public synchronized boolean[] setHoursBottom(Calendar cal, HoursBottomPanel[] hourBottomPanels, boolean repaint) {
		boolean[] activeHoursPanels = new boolean[hourBottomPanels.length];
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		for (int i = 0; i < hourBottomPanels.length; i++) {
			boolean active = (hourOfDay%5!=0 && hourOfDay%5>i);
			if(repaint) {
				hourBottomPanels[i].backgroundColor = active ? HoursTopPanel.activeColor : CurvedPanel.defaultColor;
				hourBottomPanels[i].repaint();
			}
			activeHoursPanels[i] = active;
		}
		return activeHoursPanels;
	}
}
