package multiPane02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ventana1 extends JDialog {


	 private Container contenedor;
	
	 
	 public ventana1(){
	  contenedor=getContentPane();
	  contenedor.setLayout(null);
	  //Asigna un titulo a la barra de titulo
	  setTitle("I am opening another window");
	  //tamaño de la ventana
	  setSize(300,200);
	  //pongo un fondo
	  contenedor.setBackground(Color.cyan);
	  //pone la ventana en el Centro de la pantalla
	  setLocationRelativeTo(null);
	 }
	}

