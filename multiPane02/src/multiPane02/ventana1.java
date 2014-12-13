package multiPane02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Rectangle;


/**
 * Declare mi ventana
 *@author Iván Reyes
 *@author www.uem.es
 *@version 2.0
 */
public class ventana1 extends JDialog {


	 private Container contenedor;
	
	 

		/**
		 * Voy a abrir una ventana
		 * Call Class ventana1
		 * @see ventana1
		 * @param args adds arguments
		 */
	 
	 public ventana1(){
	  contenedor=getContentPane();
	  getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	  
	  JLabel lblNewLabel = new JLabel("");
	  lblNewLabel.setBounds(new Rectangle(0, 0, 600, 700));
	  lblNewLabel.setIcon(new ImageIcon(ventana1.class.getResource("/Images/Folks.png")));
	  getContentPane().add(lblNewLabel);
	  //Asigna un titulo a la barra de titulo
	  setTitle("I am opening another window");
	  //tamaño de la ventana
	  setSize(300,200);
	
	 // contenedor.setBackground(Color.cyan);
	  //pone la ventana en el Centro de la pantalla
	  setLocationRelativeTo(null);
	 }
	}

