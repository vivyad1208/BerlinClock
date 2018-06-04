package clock;

import java.awt.Color;

public class HoursTopPanel extends CurvedPanel {

	private static final long serialVersionUID = 1117108797321766630L;

	public static final Color activeColor = Color.RED;

	@SuppressWarnings("unused")
	private FourPosition pos;

	public HoursTopPanel(FourPosition pos) {
		super(30, defaultColor);
		setOpaque(false);
		this.pos = pos;
	}
}
