package clock;


/**
 * Class Responsible for setting the time on respective panels of the Berlin clock.
 * The methods of this class are synchronized due to calling of repaint method.
 * @author Vivek
 */
public class SetTime {

	private boolean repaint = true;

	public SetTime() {}
	
	public SetTime(boolean paint) {
		repaint = paint;
	}
	
	// Apply @Test
	public synchronized boolean[] minutesTop(MinutesTopPanel[] minutesTopPanels, int minutes) {
		checkMinute(minutes);

		boolean[] activeMinutePanels = new boolean[minutesTopPanels.length];
		for (int i = 0; i < minutesTopPanels.length; i++) {
			boolean active = i < minutes/5;
			if(repaint) {
				minutesTopPanels[i].backgroundColor = active ? MinutesTopPanel.activeColor : CurvedPanel.defaultColor;
				minutesTopPanels[i].repaint();
			}
			activeMinutePanels[i] = active;
		}
		return activeMinutePanels;
	}


	// Apply @Test
	public synchronized boolean[] minutesBottom(MinutesBottomPanel[] minutesBottomPanels, int minutes) {
		checkMinute(minutes);

		boolean[] activeMinutePanels = new boolean[minutesBottomPanels.length];
		for (int i = 0; i < minutesBottomPanels.length; i++) {
			boolean active = (minutes%5!=0 && minutes%5>i);
			if(repaint) {
				minutesBottomPanels[i].backgroundColor = active ?  MinutesTopPanel.activeColor : CurvedPanel.defaultColor;
				minutesBottomPanels[i].repaint();
			}
			activeMinutePanels[i] = active;
		}
		return activeMinutePanels;
	}


	// Apply @Test
	public synchronized boolean[] hoursTop(HoursTopPanel[] hoursTopPanels, int hours) {
		checkHour(hours);

		boolean[] activeHoursPanels = new boolean[hoursTopPanels.length];
		for (int i = 0; i < hoursTopPanels.length; i++) {
			boolean active = i<hours/5;
			if(repaint) {
				hoursTopPanels[i].backgroundColor = active ? HoursTopPanel.activeColor : CurvedPanel.defaultColor;
				hoursTopPanels[i].repaint();
			}
			activeHoursPanels[i] = active;
		}
		return activeHoursPanels;
	}


	// Apply @Test
	public synchronized boolean[] hoursBottom(HoursBottomPanel[] hoursBottomPanels, int hours) {
		checkHour(hours);

		boolean[] activeHoursPanels = new boolean[hoursBottomPanels.length];
		for (int i = 0; i < hoursBottomPanels.length; i++) {
			boolean active = (hours%5!=0 && hours%5>i);
			if(repaint) {
				hoursBottomPanels[i].backgroundColor = active ? HoursTopPanel.activeColor : CurvedPanel.defaultColor;
				hoursBottomPanels[i].repaint();
			}
			activeHoursPanels[i] = active;
		}
		return activeHoursPanels;
	}


	public boolean checkMinute(int minutes) {
		if(minutes>60)
			throw new IllegalArgumentException(new StringBuilder("Minutes cannot be greater then 60.[").append(minutes).append("]").toString());
		return true;
	}


	public boolean checkHour(int hours) {
		if(hours>24)
			throw new IllegalArgumentException(new StringBuilder("Hours cannot be greater then 24.[").append(hours).append("]").toString());
		return true;
	}
}
