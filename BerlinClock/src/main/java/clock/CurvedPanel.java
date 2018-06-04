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
    int width;
    int height;
    Dimension arcs;

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
        setColor(backgroundColor);

        painted = true;
    }

    public void setColor(Color color) {
    	if(graphics!=null) {
    		graphics.setColor(color);
	    	graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background

	        graphics.setColor(Color.BLACK);
	        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
    	}
    }

    public boolean isPainted() {
    	return painted;
    }
}

