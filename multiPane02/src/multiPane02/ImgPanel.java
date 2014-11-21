package multiPane02;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * 
 * @author Owen Clazadilla
 * draws a rezisable image
 */

public class ImgPanel extends JPanel{
	ImageIcon imagen=null;
	String dir=null;
	
	public ImgPanel(String dir) {
		super();
		this.dir=dir;
	}
	
	/**
	 * Rewrites the image direction that was saved in the panel to the parameter given.
	 * @param dir
	 */
	public void setImg(String dir){
		this.dir=dir;
	}
	
	/**
	 * Resizes the image of the background panel when the frame is resized.
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
