package multiPane02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

/**
 * The class implements options, buttons with events and changes color
 * @author Victor Uriarte
 * @version 1.0
 * @see ImgPanel
 */

public class InitGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String hierbaDir = "/images/hierba-footer.png";
	String [] opciones;
	private JSlider slider;
	private JLabel lblNewLabel_4;

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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
			}
		
		}
	
	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		final JToolBar toolBar = new JToolBar();
		panel.add(toolBar);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		final JLabel lblNewLabel = new JLabel("Perfect Sun");
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/**
				 * Change ToolBar Color
				 */
				
				toolBar.setBackground((Color.YELLOW));
				
				/**
				 * Create new frame with gif image smiling sun
				 */
				JFrame frame = new JFrame("Solecito");
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/images/giphy.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				textLabel.setToolTipText("Solecito");
				frame.setLocationRelativeTo(null);
				frame.setBounds(300, 100, 400, 400);
				frame.setVisible(true);
			}
		});
		toolBar.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/images/Sunshine@Low.png")));
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		toolBar.add(horizontalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Cloudy");
		lblNewLabel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/**
				 * Change ToolBar Color
				 */
				
				toolBar.setBackground((Color.GRAY));
				
				/**
				 * Create new frame with gif image cloudy
				 */
				JFrame frame = new JFrame("Nublado");
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/images/cloudy1.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				textLabel.setToolTipText("Nubes");
				frame.setLocationRelativeTo(null);
				frame.setBounds(300, 100, 400, 400);
				frame.setVisible(true);
				
				
			}
		});
		
		toolBar.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class.getResource("/images/Cloudy@Low.png")));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(30);
		toolBar.add(horizontalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rains");
		lblNewLabel_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/**
				 * Change ToolBar Color
				 */
				
				toolBar.setBackground((Color.BLUE));
				
				/**
				 * Create new frame with gif image rains
				 */
				JFrame frame = new JFrame("Lluvia");
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/images/rains1.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				textLabel.setToolTipText("Ayy que se mojan los ciervos!!");
				frame.setLocationRelativeTo(null);
				frame.setBounds(300, 100, 825, 350);
				frame.setVisible(true);
				
				
			}
		});
		
		toolBar.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class.getResource("/images/Cloud-Download@Low.png")));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(30);
		toolBar.add(horizontalStrut_2);
		
		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/**
				 * Change ToolBar Color
				 */
				
				toolBar.setBackground((Color.ORANGE));
				
				/**
				 * Create new frame with gif image smiling sun
				 */
				JFrame frame = new JFrame("Vientoo");
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setIcon(new ImageIcon(InitGUI.class.getResource("/images/wing.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);

				textLabel.setToolTipText("Zas!");
				frame.setLocationRelativeTo(null);
				frame.setBounds(300, 100, 300, 188);
				frame.setVisible(true);
			}
		});
		
		toolBar.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class.getResource("/images/Refresh@Low.png")));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		String [] opciones = {"Water", "Petrol", "Milk"};
		final JList list = new JList(opciones);
		list.setToolTipText("Choose an option");
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.add(list);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(InitGUI.class.getResource("/images/Green.png")));
		//Ponemos una mano como cursor cuando pase por encima del boton
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//Creamos un escuchador para el boton
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			//The method displays a modal window
			public void actionPerformed(ActionEvent arg0) {
				// Dialoging
				 String message = "Are you 100% sure?";
				 Component frame = null;
				int answer = JOptionPane.showConfirmDialog(frame, message);
				 if (answer == JOptionPane.YES_OPTION) {
				 // User clicked YES. 
					 List<String> values = list.getSelectedValuesList();
					 StringBuilder sb = new StringBuilder();
					 sb.append("Dropping ");
					 for (String value : values){
						 sb.append(value);
						 sb.append(" ");
					 }
					 sb.append("at ");
					 sb.append(slider.getValue());
					 sb.append("%");
					 lblNewLabel_4.setText(sb.toString()); 
					 
				 } else if (answer == JOptionPane.NO_OPTION) {
				 // User clicked NO.
					 lblNewLabel_4.setText("Dropping... nothing yet");
				 }
				
			}
						
			
		});
		//Hotkey for action button
		btnNewButton.setMnemonic('W');
		//Texto que saldrá al mantener el cursor sobre el boton
		btnNewButton.setToolTipText("Go?");
		btnNewButton.setIcon(new ImageIcon(InitGUI.class.getResource("/images/Water-Drop.png")));
		btnNewButton.setMargin(new Insets(0,0,0,0));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		slider = new JSlider();
		slider.setToolTipText("Move the Slider");
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		panel_2.add(slider);
		
		lblNewLabel_4 = new JLabel("Dropping...");
		panel_2.add(lblNewLabel_4);
		
		this.setTitle("Garden Care");
		
		Image icon = new ImageIcon(getClass().getResource("/images/Themes@Low.png")).getImage();
		setIconImage(icon);
		
		/**
		 * calls our drawing panel
		 */
		JPanel panel7 = new ImgPanel(hierbaDir);
		contentPane.add(panel7);
		
		
	}
	
	
	
	
}
