package clock;

import static org.junit.Assert.*;

import org.junit.Test;

public class TickerTest {

	Ticker ticker = new Ticker();

	// Test Passed
	@Test
	public void testDifferenceInMillis() {
		long expected = 100;
		long max = 150;	// In case of Gradle, if suppose the test fails try increasing the max time
		long actual = ticker.getDifferenceInMillis(System.currentTimeMillis() - expected);
		assertEquals(max, expected, actual);
	}

	// Test Passed
	@Test
	public void testRepaintMinutesRequired() {
		boolean expected = true;
		int seconds = 6;
		boolean actual = ticker.repaintMinutesRequired(seconds);	// Repaint Required
		assertEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testRepaintMinutesRequired_Case2() {
		boolean expected = false;
		int seconds = 6;
		ticker.repaintMinutesRequired(seconds);						// Repaint Required - Repainted
		boolean actual = ticker.repaintMinutesRequired(++seconds);	// Repaint Not Required
		assertEquals(expected, actual);
	}

	// Test Passes
	@Test
	public void testRepaintHoursRequired() {
		boolean expected = true;
		int minutes = 25;
		boolean actual = ticker.repaintHoursRequired(minutes);		// Repaint Required
		assertEquals(expected, actual);
	}

	// Test Passed
	@Test
	public void testRepaintHoursRequired_Case2() {
		boolean expected = false;
		int minutes = 25;
		ticker.repaintHoursRequired(minutes);						// Repaint Required - Repainted
		boolean actual = ticker.repaintHoursRequired(++minutes);	// Repaint Not Required
		assertEquals(expected, actual);
	}
}
