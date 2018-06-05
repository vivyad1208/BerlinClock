package clock;

import java.awt.Color;
import java.awt.Graphics;

public class HoursBottomPanel extends CurvedPanel {

	private static final long serialVersionUID = 8424178074427613833L;

	public static final Color activeColor = Color.RED;

	@SuppressWarnings("unused")
	private FourPosition pos;

	public HoursBottomPanel(FourPosition pos) {
		super(30, defaultColor);
		setOpaque(false);
		this.pos = pos;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
