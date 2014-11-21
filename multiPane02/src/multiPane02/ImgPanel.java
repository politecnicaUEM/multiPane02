package multiPane02;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * drawing a rezisable image using Graphics abstract class
 * 
 * @author ernesto
 * @version 1.0-beta
 * @see InitGUI
 */

public class ImgPanel extends JPanel{
	ImageIcon imagen;
	String dir;
	
	public ImgPanel(String dir) {
		super();
		this.dir=dir;
	}
	
	/**
	 * This method draws the image and sets it to be drawable along the application layout size
	 */
	public void paint(Graphics g){
		Dimension size = getSize();
		imagen = new ImageIcon(getClass().getClassLoader().getResource(dir));
		if(imagen.getImage()!=null){
			g.drawImage(imagen.getImage(), 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		}
		
	}
}
