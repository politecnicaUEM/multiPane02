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
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class InitGUI extends JFrame {

	private ImgPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";
	private JLabel labelInfo;
	private String sel;
	private ListModel jList1Model;

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
//		for (LookAndFeelInfo info : javax.swing.UIManager
//				.getInstalledLookAndFeels()) {
//			try {
//				javax.swing.UIManager
//						.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
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
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toolBar.setOpaque(false);
		contentPane.add(toolBar);
		
		/** Strings with the info for the toolbat buttons */
		String[] names = {"Perfect sun","Cloudy","Rains","Windy"};
		String[] icons = {"/Images/Sunshine@Low.png","/Images/Cloudy@Low.png","/Images/Cloud-Download@Low.png","/Images/Refresh@Low.png"};
		final String[] backgrounds = {"Images/Background1.png","Images/Background2.jpg","Images/Cloud-Download@Low.png","Images/Refresh@Low.png"};
		/**
		 * Creates the 4 buttons for the toolbar and creates a mouseListener for them
		 */
		for(int i=0; i<names.length; i++){
			final JLabel label = new JLabel(names[i]);
			label.setName(Integer.toString(i));
			label.setIcon(new ImageIcon(InitGUI.class
					.getResource(icons[i])));
			label.setIconTextGap(3);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel aux = (JLabel) e.getComponent();
					System.out.println(aux.getName());
					contentPane.setImg(backgrounds[Integer.parseInt(aux.getName())]);
					contentPane.repaint();
				}
			});
			toolBar.add(label);
			if(i<(names.length-1))
				toolBar.add(new JToolbarSeparator ());
		}

		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

		/**
		 * Defining JList and its model for supplying content
		 */
		JPanel listPanel = new JPanel();
		panel2.setOpaque(false);
		panel2.add(listPanel);
		listPanel.setLayout(new GridLayout(1, 0, 0, 0));
		jList1Model = new DefaultComboBoxModel(new String[] {"Water", "Petrol", "Milk" });
		final JList list = new JList();
		listPanel.add(list,BorderLayout.CENTER);
		list.setFont(new Font("Courier New", Font.PLAIN, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(new Color(238, 238, 238));
		list.setModel(jList1Model);
		

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
		panel2.add(btnOpenDialog,BorderLayout.EAST);

		/**
		 * JList selected
		 * @param evt
		 */
		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		contentPane.add(panel3);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

		final JSlider slider = new JSlider();
		slider.setOpaque(false);
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		panel3.add(slider);
		panel3.setBackground(Color.GRAY);
		
		labelInfo = new JLabel("Dropping...");
		panel3.add(labelInfo);
		
		/**
		 * shows an optionpane with a dialog asking for confirmation
		 */
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dialoging
				String message = "Are you 100% sure?";
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					// User clicked YES.
					int[] selectedIx = list.getSelectedIndices();
					labelInfo.setText("Dropping...");
					Object[] selected = list.getSelectedValues();
					 for(Object s : selected){
						 labelInfo.setText(labelInfo.getText()+" "+s.toString());
					 }
					 labelInfo.setText(labelInfo.getText() + " at " + slider.getValue() + "%");				
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
					labelInfo.setText(" Dropping... nothing yet");
				}
			}
		});



		/**
		 * calls our drawing panel
		 */
		JPanel panel4 = new ImgPanel(hierbaDir);
		contentPane.add(panel4);
	}
	
	/**
	 * Class that adjusts the toolbatSeparators to work when whe resize the frame
	 * @author Owen
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
