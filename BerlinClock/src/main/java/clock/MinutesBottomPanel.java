package clock;

import java.awt.Color;
import java.awt.Graphics;

public class MinutesBottomPanel extends CurvedPanel {

	private static final long serialVersionUID = -4932855425133192389L;

	public static final Color activeColor = Color.ORANGE;

	@SuppressWarnings("unused")
	private FourPosition pos;

	public MinutesBottomPanel(FourPosition pos) {
		super(15, defaultColor);
		setOpaque(false);
		this.pos = pos;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
