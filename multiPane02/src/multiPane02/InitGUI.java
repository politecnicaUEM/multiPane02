package multiPane02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.beans.value.ChangeListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;

public class InitGUI extends JFrame {

	private JPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";
	private JLabel lblNewLabel_4;
	private String sel;
	private JSlider slider;

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
		setBounds(100, 100, 400, 400);
		setTitle("Garden care");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		// contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		panel_4.add(toolBar);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);

		JLabel lblNewLabel_2 = new JLabel("Perfect sun");
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		// border to component in one line
		separator.setBorder(new EmptyBorder(20, 10, 20, 10));
		;

		// border to component the formal way
		// javax.swing.border.Border current = separator.getBorder();
		// EmptyBorder empty = new EmptyBorder(20, 10, 20, 10);
		// if (current == null)
		// {
		// separator.setBorder(empty);
		// }
		// else
		// {
		// separator.setBorder(new CompoundBorder(empty, current));
		// }

		JLabel lblNewLabel = new JLabel("Cloudy");
		lblNewLabel.setIconTextGap(3);
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblNewLabel);

		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator2);
		// border to component in one line
		separator2.setBorder(new EmptyBorder(20, 10, 20, 10));
		;
		JLabel lblNewLabel_1 = new JLabel("Rains");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblNewLabel_1);

		JSeparator separator3 = new JSeparator();
		separator3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator3);
		// border to component in one line
		separator3.setBorder(new EmptyBorder(20, 10, 20, 10));
		;

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblNewLabel_3);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_2);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
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

//		// multiple selection
//		int[] selectedIx = list.getSelectedIndices();
//
//		// Get all the selected items using the indices
//		for (int i = 0; i < selectedIx.length; i++) {
//			Object sel = list.getModel().getElementAt(selectedIx[i]);
//		}

		// Get the index of the first selected item
		// int firstSelIx = list.getSelectedIndex();

		/**
		 * customized square button
		 */

		JButton btnOpenDialog = new JButton("");
		btnOpenDialog.setPressedIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Green.png")));
		btnOpenDialog.setRolloverIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Green.png")));
		btnOpenDialog.setToolTipText("Go?");
		btnOpenDialog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpenDialog.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Water-Drop.png")));
		btnOpenDialog.setMnemonic('W');
		btnOpenDialog.setMargin(new Insets(0, 0, 0, 0));
		panel_2.add(btnOpenDialog);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		slider = new JSlider();
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		// migueleando
		// try http://www.jroller.com/santhosh/entry/tooltips_can_say_more
		// slider.setToolTipText(String.valueOf(slider.getValue()));
		// slider.addChangeListener(new ChangeListener() {
		// public void stateChanged(ChangeEvent ce) {
		// slider = (JSlider)ce.getSource();
		// if (!slider.getValueIsAdjusting()) {
		// slider.setToolTipText(Integer.parseInt(slider.getValue());
		// }
		// }
		// });

		slider.setValue(25);
		panel_1.add(slider);
		// init Label4
		lblNewLabel_4 = new JLabel("Dropping..");
		panel_1.add(lblNewLabel_4);

		/**
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
					// Get all the selected items using indexes
					for (int i = 0; i < selectedIx.length; i++) {
						sel = (String) list.getModel().getElementAt(
								selectedIx[i]);
						lblNewLabel_4.setText(lblNewLabel_4.getText() + " "
								+ sel + " ");
						System.out.println(sel);
					}
					lblNewLabel_4.setText(lblNewLabel_4.getText() + " at "
							+ slider.getValue() + "%");
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
		getContentPane().add(panel);
	}
}
