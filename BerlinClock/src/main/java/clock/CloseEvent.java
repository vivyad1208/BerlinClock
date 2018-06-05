package clock;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseEvent extends WindowAdapter {

	@SuppressWarnings("unused")
	private BerlinClock clock;

	public CloseEvent(BerlinClock clock) {
		this.clock = clock;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Berlin Clock Closing!");
	}
}
