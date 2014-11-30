package multiPane02;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * draws a rezisable image
 * @author Victor
 * @see InitGUI
 */
public class ImgPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	ImageIcon imagen;
	String dir;

	public ImgPanel(String dir) {
		super();
		this.dir=dir;
	}

	public void paint(Graphics g) {
		Dimension size = getSize();
		imagen = new ImageIcon(InitGUI.class.getResource(
				"/images/hierba-footer.png"));
		if (imagen.getImage() != null) {
			g.drawImage(imagen.getImage(), 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		}
	}
}