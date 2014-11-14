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
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
		toolBar.setOpaque(false);
		contentPane.add(toolBar);

		JLabel lblNewLabel_2 = new JLabel("Perfect sun");
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblNewLabel_2);
		JToolbarSeparator separator = new JToolbarSeparator();
		toolBar.add(separator);

		JLabel lblNewLabel = new JLabel("Cloudy");
		lblNewLabel.setIconTextGap(3);
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblNewLabel);
		JToolbarSeparator separator2 = new JToolbarSeparator();
		toolBar.add(separator2);
		
		JLabel lblNewLabel_1 = new JLabel("Rains");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblNewLabel_1);
		JToolbarSeparator separator3 = new JToolbarSeparator();
		toolBar.add(separator3);

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Refresh@Low.png")));
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

		// multiple selection
		int[] selectedIx = list.getSelectedIndices();

		// Get all the selected items using the indices
		for (int i = 0; i < selectedIx.length; i++) {
			Object sel = list.getModel().getElementAt(selectedIx[i]);
		}

		// Get the index of the first selected item
		// int firstSelIx = list.getSelectedIndex();

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
		 * 
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
		contentPane.add(panel);
	}
	
	
	/**
	 * 
	 * Inner class JToolBarSeparator is a separator whose dimensions are fixed and use predefined colors
	 *
	 */
	
	public class JToolbarSeparator extends JComponent {

		private static final long serialVersionUID = 1L;

		public JToolbarSeparator() {
			setMaximumSize(new Dimension(1000, 70));
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Dimension size = getSize();
			int pos = size.width / 2;
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(pos, 3, pos, size.height - 10);
			g.drawLine(pos, 2, pos + 1, 2);
			g.setColor(Color.white);
			g.drawLine(pos + 1, 3, pos + 1, size.height - 5);
			g.drawLine(pos, size.height - 4, pos + 1, size.height - 4);

		}
	}
}
