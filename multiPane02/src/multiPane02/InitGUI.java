package multiPane02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.event.MouseAdapter;

import javax.swing.border.EtchedBorder;

//import sun.misc.Cleaner;

/**
 * Principal Frame of the applicaion
 * @author Nicolas
 *
 */
public class InitGUI extends JFrame {

	private JPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";
	private JLabel lblInfoGame;
	private boolean itsSunny;
	private boolean itsCLouldy;
	private boolean itsRaining;
	private boolean itsWindy;
	private JLabel lblPerfectSunny;
	private JLabel lblCloudly;
	JLabel lblWindy;
	JSlider slider;
	JPanel Firstpanel;
	JToolBar toolBar;
	JLabel lblRains;
	JPanel panelList;
	JLabel lblGrassHealth;
	int grassHealth;

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

	// {
	// for (LookAndFeelInfo info : javax.swing.UIManager
	// .getInstalledLookAndFeels()) {
	// try {
	// javax.swing.UIManager
	// .setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }

	/**
	 * Create the frame.
	 */
	public InitGUI() {

		itsSunny = false;
		itsCLouldy = false;
		itsRaining = false;
		itsWindy = false;
		grassHealth = 100;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 400);
		setTitle("Garden care");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(toolBar);

		lblPerfectSunny = new JLabel("Perfect sun");
		lblPerfectSunny.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPerfectSunny.setIconTextGap(3);
		lblPerfectSunny.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblPerfectSunny);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		lblCloudly = new JLabel("Cloudy");
		lblCloudly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCloudly.setIconTextGap(3);
		lblCloudly.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblCloudly);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		lblRains = new JLabel("Rains");
		lblRains.setIconTextGap(3);
		lblRains.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRains.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblRains);
		toolBar.addSeparator();

		lblWindy = new JLabel("Windy");
		lblWindy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWindy.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblWindy);
		toolBar.addSeparator();

		lblGrassHealth = new JLabel(Integer.toString(grassHealth));
		lblGrassHealth
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGrassHealth.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Green@Low.png")));
		toolBar.add(lblGrassHealth);

		Firstpanel = new JPanel();
		contentPane.add(Firstpanel);
		Firstpanel.setLayout(new BoxLayout(Firstpanel, BoxLayout.X_AXIS));

		panelList = new JPanel();
		Firstpanel.add(panelList);
		panelList.setLayout(new GridLayout(1, 0, 0, 0));

		/**
		 * Defining JList and its model for supplying content
		 */
		ListModel jList1Model = new DefaultComboBoxModel(new String[] {
				"Water", "Petrol", "Milk" });
		final JList list = new JList();
		panelList.add(list);
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
		Firstpanel.add(btnOpenDialog);

		/**
		 * JList selected
		 * 
		 * @param evt
		 */
		JPanel sliderPannel = new JPanel();
		contentPane.add(sliderPannel);
		sliderPannel.setLayout(new BoxLayout(sliderPannel, BoxLayout.Y_AXIS));

		slider = new JSlider();
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		sliderPannel.add(slider);

		lblInfoGame = new JLabel("Dropping...");
		sliderPannel.add(lblInfoGame);

		/**
		 * shows an option pane with a dialog asking for confirmation
		 */
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dialoging
				if (itsRaining || itsCLouldy || itsSunny) {
					String message = "Are you 100% sure?";
					int answer = JOptionPane.showConfirmDialog(frame, message);
					if (answer == JOptionPane.YES_OPTION) {
						int[] selectedIx = list.getSelectedIndices();
						lblInfoGame.setText(lblInfoGame.getText()
								+ " and dropping...");
						// Get all the selected items using the indices
						for (int i = 0; i < selectedIx.length; i++) {
							String sel;
							sel = (String) list.getModel().getElementAt(
									selectedIx[i]);
							lblInfoGame.setText(lblInfoGame.getText() + " "
									+ sel + " ");
							System.out.println(sel);
						}
						calculateGrassHealth(selectedIx, slider.getValue());
						lblInfoGame.setText(lblInfoGame.getText() + " at "
								+ slider.getValue() + "%");
						// User clicked YES.
					} else if (answer == JOptionPane.NO_OPTION) {
						// User clicked NO.
						lblInfoGame.setText(" Dropping... nothing yet");
					}
					resetClimates();
					lblGrassHealth.setText(Integer.toString(grassHealth));
				}
				else lblInfoGame.setText("Select a climate please!");
					
			}
		});

		
		/**
		 * listeners of the labe perfect sunny
		 */
		lblPerfectSunny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(itsRaining || itsCLouldy)) {
					itsSunny = !itsSunny;
					lblInfoGame.setText(generateClimateText());

				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!itsSunny)
					lblPerfectSunny.setBorder(new EtchedBorder(
							EtchedBorder.LOWERED, null, null));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (!itsSunny)
					lblPerfectSunny.setBorder(null);

			}
		});
		
		/**
		 * listeners of the label cloudly
		 */
		lblCloudly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(itsSunny || itsRaining)) {
					itsCLouldy = !itsCLouldy;
					lblInfoGame.setText(generateClimateText());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!itsCLouldy)
					lblCloudly.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
							null, null));
			}

			public void mouseExited(MouseEvent arg0) {
				if (!itsCLouldy)
					lblCloudly.setBorder(null);
			}

		});

		/**
		 * listeners of the lable rains
		 */
		lblRains.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(itsSunny || itsCLouldy)) {
					itsRaining = !itsRaining;
					lblInfoGame.setText(generateClimateText());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!itsRaining)
					lblRains.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
							null, null));
			}

			public void mouseExited(MouseEvent arg0) {
				if (!itsRaining)
					lblRains.setBorder(null);
			}

		});
		
		/**
		 * listeners of the label windy
		 */
		lblWindy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				itsWindy = !itsWindy;
				lblInfoGame.setText(generateClimateText());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!itsWindy)
					lblWindy.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
							null, null));
			}

			public void mouseExited(MouseEvent arg0) {
				if (!itsWindy)
					lblWindy.setBorder(null);
			}
		});

		/**
		 * calls our drawing panel
		 */
		JPanel panelImage = new ImgPanel(hierbaDir);
		contentPane.add(panelImage);
	}

	/**
	 * uncheck all labels of the toolbar
	 */
	private void resetClimates() {
		lblCloudly.setBorder(null);
		lblPerfectSunny.setBorder(null);
		lblWindy.setBorder(null);
		lblRains.setBorder(null);
		itsSunny = false;
		itsCLouldy = false;
		itsRaining = false;
		itsWindy = false;
	}

	/**
	 * generates a message depending on the climates selected by the user
	 * @return a strings with the climates selected
	 */
	private String generateClimateText() {
		String text = "";
		if (itsSunny)
			text = "It's sunny";
		if (itsCLouldy)
			text = "It's cloudly";
		if (itsRaining)
			text = "It's raining";

		if (itsWindy) {
			if ((itsSunny || itsCLouldy || itsRaining))
				text = text + " and windy";
			else
				text = "its windy";
		}
		return text;

	}

	/**
	 * Calculate how the grass react to the action of the user.
	 * @param selectedIx with what liquid is the user watering (petrol,water or milk)
	 * @param value how much quantity
	 */
	void calculateGrassHealth(int[] selectedIx, int value) {
		for (int i = 0; i < selectedIx.length; i++) {
			System.out.println(selectedIx[i]);
			if (selectedIx[i] == 0) { // water selected
				if (itsSunny) {
					if (value > 70)
						grassHealth += 5;
					else
						grassHealth -= 5;
				}
				if (itsCLouldy) {
					if (value < 50 && value > 15)
						grassHealth += 5;
					else
						grassHealth -= 5;
				}
				if (itsRaining) {
					if (value < 15)
						grassHealth += 5;
					else
						grassHealth -= 5;
				}
			}
			if(selectedIx[i]==2){//milk
				if(value>30)
					grassHealth-=5;
			}
			if(selectedIx[i]==1){ //petrol
				grassHealth -= (value/2);
			}
				

		}
	}

}
