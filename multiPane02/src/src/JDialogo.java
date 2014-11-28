package src;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
/**
 * The Jdialog of the button
 * @author Issam 
 * 
 */
public class JDialogo extends JDialog {

	public JDialogo() {

		setResizable(false);

		setTitle("Seleccionar una opcion");

		setBounds(100, 100, 325, 180);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Are you sure 100%?");
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(JDialogo.class.getResource("/img/Cloudy@Low.png")));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel label_vacio = new JLabel("");
		panel.add(label_vacio);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("No");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Si");
		panel_1.add(btnNewButton);
	}
}