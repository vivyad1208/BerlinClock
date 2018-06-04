package clock;

import java.awt.Color;

public class MinutesTopPanel extends CurvedPanel {

	private static final long serialVersionUID = 4577062623296566138L;

	public static final Color activeColor = Color.ORANGE;

	@SuppressWarnings("unused")
	private ElevenPosition pos;

	public MinutesTopPanel(ElevenPosition pos) {
		super(15, defaultColor);
		setOpaque(false);
		this.pos = pos;
	}

}
