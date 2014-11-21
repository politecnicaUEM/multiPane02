package multiPane02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

/**
 * This class implements the interface main frame and its controls 
 * @author ernesto
 * @version 1.0-beta
 * @see ImgPanel
 *
 */

public class InitGUI extends JFrame {

	private JPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";
	private JLabel lblNewLabel_4;
	private String sel;

	/**
	 * Launch the application.
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
	}

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 492);
		setTitle("Garden care");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setBackground(new Color(0,0,0,0));
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(toolBar);

		JLabel lblNewLabel_2 = new JLabel("Perfect sun");
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				/**
				 * Change the Background
				 */
				contentPane.setBackground((Color.YELLOW));
				/**
				 * Create new frame and  i have inserted an gif in relation to the Label.
				 */
				JFrame frame = new JFrame("hol");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/gif-sol.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);

			}
		});
		lblNewLabel_2.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblNewLabel_2);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		JLabel lblNewLabel = new JLabel("Cloudy");
		lblNewLabel.setIconTextGap(3);
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				/**
				 * Change the Background
				 */
				contentPane.setBackground((Color.CYAN));
				/**
				 * Create new frame and  i have inserted an gif in relation to the Label.
				 */
				JFrame frame = new JFrame("hol");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/tiempo_sol_y_nube.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);

			}

		});
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblNewLabel);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		JLabel lblNewLabel_1 = new JLabel("Rains");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				/**
				 * Change the Background
				 */
				contentPane.setBackground((Color.BLUE));
				/**
				 * Create new frame and  i have inserted an gif in relation to the Label.
				 */
				JFrame frame = new JFrame("hol");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/LLuvia.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblNewLabel_1);
		toolBar.addSeparator();

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				/**
				 * Change the Background
				 */
				contentPane.setBackground((Color.RED));
				/**
				 * Create new frame and  i have inserted an gif in relation to the Label.
				 */
				JFrame frame = new JFrame("hol");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Viento.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);

			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		/*
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
		
		/*
		 * customized square button
		 */
		JButton btnOpenDialog = new JButton("");
		btnOpenDialog.setToolTipText("Go?");
		btnOpenDialog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Water-Drop.png")));
		btnOpenDialog.setMnemonic('W');
		btnOpenDialog.setMargin(new Insets(0, 0, 0, 0));
		panel_2.add(btnOpenDialog);

		/**
		 * JList selected
		 * @param evt
		 */
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(0,0,0,0));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JSlider slider = new JSlider();
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		panel_1.add(slider);

		lblNewLabel_4 = new JLabel("Dropping...");
		panel_1.add(lblNewLabel_4);

		/*
		 * shows an optiopane with a dialog asking for confirmation
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

		/*
		 * calls our drawing panel
		 */
		JPanel panel = new ImgPanel(hierbaDir);
		contentPane.add(panel);

	}
}
