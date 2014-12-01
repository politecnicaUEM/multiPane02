import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaSecundaria extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSecundaria frame = new VentanaSecundaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSecundaria() {
		setTitle("It is cloudy.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaSecundaria.this.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(VentanaSecundaria.class.getResource("/res/autum.png")));
		panel.add(btnNewButton);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
	}

}
