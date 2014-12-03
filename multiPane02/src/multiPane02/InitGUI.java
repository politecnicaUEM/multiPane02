package multiPane02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * Declare the Garden Care Class
 *@author Iván Reyes
 *@author www.uem.es
 *@version 2.0
 */

public class InitGUI extends JFrame {

	private JPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";
	private JLabel lblNewLabel_4;
	private String sel;
	private String amigos = "Images/Folks.png";

	/**
	 * Launch the main application
	 * Call Class ImgPanel
	 * @see ImgPanel
	 * @param args adds arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitGUI frame = new InitGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	{
		for (LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels()) {
			try {
				javax.swing.UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 400);
		setTitle("Garden care");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(toolBar);
		//meto un escuchador para abrir una página WEB
		
		JButton Mensaje= new JButton("Url");
		Mensaje.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				 try {
					Desktop.getDesktop().browse(new URI("http://www.frikipedia.es/friki/Linux"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		Mensaje.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(Mensaje);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();
		
		JButton butonDisplay = new JButton("Cloudly");
		butonDisplay.addActionListener(new ActionListener() {
				//abro un Jdialog <<ventana nueva>>>
			
				public void actionPerformed(ActionEvent e) {
					
					ventana1 ven = new ventana1();
					ven.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
					ven.setVisible(true); 
					
				    
				
			}

		});
		
		
		butonDisplay.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(butonDisplay);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();
		
		JButton btnRains = new JButton("Rains");
		
		btnRains.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
				toolBar.setBackground((Color.yellow));
				}
		});
		toolBar.add(btnRains);
		btnRains.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.addSeparator();

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		/**
		 * Defining JList and its model for supplying content
		 */
		
		ListModel jList1Model = new DefaultComboBoxModel(new String[] {
				"Water", "Petrol", "Milk" });
		JList list = new JList();
		panel_3.add(list);
		list.setFont(new Font("Courier New", Font.PLAIN, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(new Color(238, 238, 238));
		list.setModel(jList1Model);
		
		
		//multiple selection
		int[] selectedIx = list.getSelectedIndices();

	    // Get all the selected items using the indices
	    for (int i = 0; i < selectedIx.length; i++) {
	      Object sel = list.getModel().getElementAt(selectedIx[i]);
	    }

	    // Get the index of the first selected item
	  //  int firstSelIx = list.getSelectedIndex();

		/**
		 * customized square button
		 */

		JButton btnOpenDialog = new JButton("");
		btnOpenDialog.setToolTipText("Go?");
		btnOpenDialog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpenDialog.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Water-Drop.png")));
		btnOpenDialog.setMnemonic('W');
		btnOpenDialog.setMargin(new Insets(0, 0, 0, 0));
		panel_2.add(btnOpenDialog);

		/**
		 * JList selected
		 * @param evt
		 */
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JSlider slider = new JSlider();
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		panel_1.add(slider);
		
		lblNewLabel_4 = new JLabel("Dropping...");
		panel_1.add(lblNewLabel_4);
		
		/**
		 * shows an optioJpane with a dialog asking for confirmation
		 */
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dialoging
				String message = "Are you 100% sure?";
				
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					int[] selectedIx = list.getSelectedIndices();
					lblNewLabel_4.setText("Dropping...");
				    // Get all the selected items using the indices
				    for (int i = 0; i < selectedIx.length; i++) {
				      sel = (String) list.getModel().getElementAt(selectedIx[i]);
				      lblNewLabel_4.setText(lblNewLabel_4.getText() + " " + sel + " ");
				      System.out.println(sel);
				    }
				    lblNewLabel_4.setText(lblNewLabel_4.getText() + " at " + slider.getValue() + "%");
					// User clicked YES.				
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
					lblNewLabel_4.setText(" Dropping... nothing yet");
				}
			}
		});



		/**
		 * calls our drawing panel
		 */
		JPanel panel = new ImgPanel(hierbaDir);
		//meto un escuchador para que salga un mensaje de texto cuando saque el raton del Panel
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String message = "Do you want to close this windows?";
				String cadena = "THAT'S IS ALL FOLKS";
				//si digo yes cerrara la apliacion
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					int respuesta = JOptionPane.showConfirmDialog(frame, cadena);
					System.exit(answer);
					//si digo no me mostrará escribirá un mensaje en otra area
				}else if (answer == JOptionPane.NO_OPTION){
					lblNewLabel_4.setText("so you can continue doing THE FRIKI");
				}
			}
		});
		contentPane.add(panel);
	}
}
