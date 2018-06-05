package clock;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetTimeTest {

	int hoursCase1 = 5;
	int hoursCase2 = 23;

	int minutesCase1 = 12;
	int minutesCase2 = 56;

	SetTime ticker = new SetTime(false);
	BerlinClock clock = new BerlinClock(false);

	private boolean[] getBooleans(int size, int till) {
		boolean[] bools = new boolean[size];
		for(int i=0; i<size; i++) {
			bools[i] = till>i;
		}
		return bools;
	}

	// Test Passed
	@Test
	public void testHoursTop() {
		int hours = hoursCase1;
		HoursTopPanel[] panels = clock.getHoursTopPanels();
		boolean[] expected = getBooleans(panels.length, hours/5);
		boolean[] actual = ticker.hoursTop(panels, hours);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testHoursTop_Case2() {
		int hours = hoursCase2;
		HoursTopPanel[] panels = clock.getHoursTopPanels();
		boolean[] expected = getBooleans(panels.length, hours/5);
		boolean[] actual = ticker.hoursTop(panels, hours);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testHoursBottom() {
		int hours = hoursCase1;
		HoursBottomPanel[] panels = clock.getHoursBottomPanels();
		boolean[] expected = getBooleans(panels.length, hours%5);
		boolean[] actual = ticker.hoursBottom(panels, hours);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testHoursBottom_Case2() {
		int hours = hoursCase2;
		HoursBottomPanel[] panels = clock.getHoursBottomPanels();
		boolean[] expected = getBooleans(panels.length, hours%5);
		boolean[] actual = ticker.hoursBottom(panels, hours);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testMinutesTop() {
		int minutes = minutesCase1;
		MinutesTopPanel[] panels = clock.getMinutesTopPanels();
		boolean[] expected = getBooleans(panels.length, minutes/5);
		boolean[] actual = ticker.minutesTop(panels, minutes);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testMinutesTop_Case2() {
		int minutes = minutesCase2;
		MinutesTopPanel[] panels = clock.getMinutesTopPanels();
		boolean[] expected = getBooleans(panels.length, minutes/5);
		boolean[] actual = ticker.minutesTop(panels, minutes);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testMinutesBottom() {
		int minutes = minutesCase1;
		MinutesBottomPanel[] panels = clock.getMinutesBottomPanels();
		boolean[] expected = getBooleans(panels.length, minutes%5);
		boolean[] actual = ticker.minutesBottom(panels, minutes);
		assertArrayEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testMinutesBottom_Case2() {
		int minutes = minutesCase2;
		MinutesBottomPanel[] panels = clock.getMinutesBottomPanels();
		boolean[] expected = getBooleans(panels.length, minutes%5);
		boolean[] actual = ticker.minutesBottom(panels, minutes);
		assertArrayEquals(expected, actual);
	}

}
