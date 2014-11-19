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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;

/**
 * <P> Añadidos Listeners en labels y cambio de fondo
 * @author Patricia Alonso Gallego
 * @version 2.0
 * @see <b>GardenCare</>
 */

public class InitGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ImgPanel contentPane;
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
		contentPane = new ImgPanel("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(false);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(4, 0, 0, 0));

		JToolBar toolBar = new JToolBar();
		panel_4.add(toolBar);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toolBar.setOpaque(false);

		 /**
	     * Label with icon and listener; Then add to toolBar	     
	     */		
		JLabel lblNewLabel_2 = new JLabel("  Perfect sun  ");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.ChangeBackground("Images/Sunshine.png");
				contentPane.repaint();
			}
		});		
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblNewLabel_2);
		JToolbarSeparator separator = new JToolbarSeparator();
		toolBar.add(separator);

		/**
	     * Label with icon and listener; Then add to toolBar	     
	     */	
		JLabel lblNewLabel = new JLabel("  Cloudy  ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.ChangeBackground("Images/Cloudy.png");
				contentPane.repaint();
			}
		});
		lblNewLabel.setIconTextGap(3);
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblNewLabel);
		JToolbarSeparator separator2 = new JToolbarSeparator();
		toolBar.add(separator2);

		/**
	     * Label with icon and listener; Then add to toolBar	     
	     */	
		JLabel lblNewLabel_1 = new JLabel("  Rains  ");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.ChangeBackground("Images/Cloud-Download.png");
				contentPane.repaint();
				
			}
		});
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblNewLabel_1);
		JToolbarSeparator separator3 = new JToolbarSeparator();
		toolBar.add(separator3);

		/**
	     * Label with icon and listener; Then add to toolBar	     
	     */	
		JLabel lblNewLabel_3 = new JLabel("  Windy  ");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.ChangeBackground("Images/Refresh.png");
				contentPane.repaint();
				
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		panel_2.setOpaque(false);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		/**
		 * Defining JList and its model for supplying content. Then add to panel
		 */
		JList<Object> list = new JList<Object>();
		ListModel<Object> jList1Model = new DefaultComboBoxModel<Object>(new String[] {"Water", "Petrol", "Milk"});
		
		list.setFont(new Font("Courier New", Font.PLAIN, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,null));
		list.setBackground(new Color(238, 238, 238));
		list.setModel(jList1Model);
		// multiple selection
		int[] selectedIx = list.getSelectedIndices();
		panel_3.add(list);

		/**
		 * Button and Tooltip.
		 */
		JButton btnOpenDialog = new JButton("");
		btnOpenDialog.setToolTipText("Go?");
		btnOpenDialog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/Water-Drop.png")));
		btnOpenDialog.setMnemonic('W');
		btnOpenDialog.setMargin(new Insets(0, 0, 0, 0));
		panel_2.add(btnOpenDialog);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.setOpaque(false);

		/**
		 * Slider
		 */
		JSlider slider = new JSlider();
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		slider.setOpaque(false);
		panel_1.add(slider);

		lblNewLabel_4 = new JLabel("Dropping...");
		panel_1.add(lblNewLabel_4);
		JPanel panel = new ImgPanel(hierbaDir);
		panel_4.setOpaque(false);
		panel_4.add(panel);

		/**
		 * Button Listener for show a confirmation window
		 * and a customized text
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
						lblNewLabel_4.setText(lblNewLabel_4.getText() + " "	+ sel + " ");
						System.out.println(sel);
					}
					lblNewLabel_4.setText(lblNewLabel_4.getText() + " at "+ slider.getValue() + "%");
					// User clicked YES.
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
					lblNewLabel_4.setText(" Dropping... nothing yet");
				}
			}
		});
		
	}

	/**
	 * 
	 * Inner class JToolBarSeparator is a separator whose dimensions are fixed
	 * and use predefined colors
	 *
	 */

	public class JToolbarSeparator extends JComponent {

		private static final long serialVersionUID = 1L;

		/**
		 * Set the maximun size of the new Separator
		 */
		public JToolbarSeparator() {
			setMaximumSize(new Dimension(1000, 70));
		}

		/**
		 * Override the paintComponent for use gray color and change horizontal 
		 * and vertical size
		 */
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
