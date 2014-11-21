package multiPane02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * pannel containing a resizable image 
 * 
 * @author ernesto
 * 
 */

public class ImgPanel extends JPanel {
	ImageIcon imagen;
	String dir;
	int grassGrowth;

	/**
	 * 
	 * @param dir
	 *            path of the image to resize
	 */
	public ImgPanel(String dir) {
		super();
		this.dir = dir;
	}
	
	/**
	 * redraws the pannel resizing the image
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
