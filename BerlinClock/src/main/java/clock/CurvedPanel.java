package clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CurvedPanel extends JPanel {

	private static final long serialVersionUID = -8324391964902847276L;

	public static final Color defaultColor = Color.WHITE;

	protected Color backgroundColor;
    private int cornerRadius = 15;
    private Graphics2D graphics;
    private boolean painted = false;
    private int width;
    private int height;
    private Dimension arcs;

    public CurvedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        arcs = new Dimension(cornerRadius, cornerRadius);
        width = getWidth();
        height = getHeight();
        graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the rounded panel with borders.

		graphics.setColor(backgroundColor);
    	graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background

        graphics.setColor(Color.BLACK);
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border

        painted = true;
    }

    public boolean isPainted() {
    	return painted;
    }
}

