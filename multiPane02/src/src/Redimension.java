package src;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Redimension the image with a jpanel
 * 
 */
public class Redimension extends JPanel {
	ImageIcon imagen;
	String dir;

	public Redimension(String dir) {
		super();
		this.dir = dir;
	}

	/**
	 * Resize method
	 * @see paint()
	 */
	public void paint(Graphics g) {
		Dimension size = getSize();
		imagen = new ImageIcon(getClass().getClassLoader().getResource(dir));
		if (imagen.getImage() != null) {
			g.drawImage(imagen.getImage(), 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		}
	}
}