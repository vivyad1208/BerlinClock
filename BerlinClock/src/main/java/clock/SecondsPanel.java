package clock;

import java.awt.Color;

public class SecondsPanel extends CurvedPanel {

	private static final long serialVersionUID = 7386269100619226440L;
	public static final Color activeColor = Color.YELLOW;

	public SecondsPanel() {
		super(225, defaultColor);
		setOpaque(false);
	}
	
}
