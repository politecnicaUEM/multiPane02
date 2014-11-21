package multiPane02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
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

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class implements the interface main frame and its controls 
 * @author ernesto
 * @author comments by Javier Martinez Miro
 * @version 1.0-beta
 * @see ImgPanel
 *
 */

/**
 * @author Javier Martinez Miro
 * Declare the class and extends JFrame which inherit his methods
 *
 */
public class InitGUI extends JFrame {

	/**
	 * Declare attributes
	 */
	private JPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";
	private JLabel lblNewLabel_4;
	private String sel;
	final JSlider slider;
	JButton btnOpenDialog = new JButton("");

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
		
		/**
		 * Sets the main view
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 390, 400);
		setTitle("Garden care");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		/**
		 * Create a JToolBar to choose the water conditions, and add it JToolBar to the ContentPanel
		 * @param 
		 */
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(toolBar);

		/**
		 * Create the first label of the JToolBar with the MouseListener which changes the label
		 */
		JPanel panel_1 = new JPanel();
		slider = new JSlider();
		JLabel perfectSun=new JLabel("Perfect-Sun: Too much water will be needed (85%)                     ");
		JLabel lblNewLabel_2 = new JLabel("Perfect sun");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			/**
			 * Declare an Override method "mouseEntered" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
			}
			
			/**
			 * Declare an Override method "mouseExited" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel_2.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(true)
				slider.setValue(85);
				panel_1.remove(lblNewLabel_4);
				lblNewLabel_4=perfectSun;
				panel_1.add(lblNewLabel_4);
				btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/gotas.png")));
				panel_1.repaint();
				
			}
		});
		
		/**
		 * Declare a JSlider to set the water amount and add it a Listener to set 85 it value
		 */
		
		/**lblNewLabel_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(JSlider slider) {
				
			}
		});
		*
		/**
		 * Set the first label's icon 
		 */
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblNewLabel_2);
		toolBar.addSeparator();

		/**
		 * Create the second label of the JToolBar with the MouseListener which changes the label 
		 */
		JLabel lblNewLabel = new JLabel("Cloudy");
		JLabel cloudy= new JLabel("Cloudy: Today you dont need much water, it probably rains (25%)                      ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			/**
			 * Declare an Override method "mouseEntered" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			
			/**
			 * Declare an Override method "mouseExited" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				slider.setValue(25);
				//panel_1.remove(lblNewLabel_2);
				panel_1.remove(lblNewLabel_4);
				lblNewLabel_4=cloudy;
				panel_1.add(lblNewLabel_4);
				btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/gotaPar.png")));
				panel_1.repaint();
			}
		});
		
		/**
		 * Set the second label's icon 
		 */
		lblNewLabel.setIconTextGap(3);
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblNewLabel);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();
		
		/**
		 * Create the third label of the JToolBar with the MouseListener which changes the label
		 */
		JLabel lblNewLabel_1 = new JLabel("Rains");
		JLabel rains= new JLabel("Rains: Today you dont need any water, it's the cheaper! (5%)                ");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			/**
			 * Declare an Override method "mouseEntered" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel_1.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				slider.setValue(5);
				//panel_1.remove(lblNewLabel_2);
				panel_1.remove(lblNewLabel_4);
				lblNewLabel_4=rains;
				panel_1.add(lblNewLabel_4);
				btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/gota.png")));
				panel_1.repaint();
				
			}
		});
		
		/**
		 * Set the third label's icon 
		 */
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblNewLabel_1);
		toolBar.addSeparator();

		/**
		 * Create the fourth label of the JToolBar with the MouseListener which changes the label
		 */
		JLabel lblNewLabel_3 = new JLabel("Windy");
		JLabel windy= new JLabel("Windy: Today you have to wait for the best time of the day (40%)                   ");
		String w="Windy";
		Font f=new Font("Impact", Font.BOLD,14);
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			
			/**
			 * Declare an Override method "mouseEntered" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			
			/**
			 * Declare an Override method "mouseExited" with the Listener for change the border of the label (to make an effect view)
			 */
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel_3.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent m) {
				//if(lblNewLabel_4!=windy)
				slider.setValue(45);
				//panel_1.remove(lblNewLabel_2);
				panel_1.remove(lblNewLabel_4);
				lblNewLabel_4=windy;
				panel_1.add(lblNewLabel_4);
				btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/gotasWindy.png")));
				panel_1.repaint();
			}
		});
		
		/**
		 * Set the fourth label's icon 
		 */
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
		final ListModel jList1Model = new DefaultComboBoxModel(new String[] {"Water", "Petrol", "Milk" });
		JList<?> list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			
			/**
			 * Declare an Override method "valueChanged" with the Listener to change the button icon 
			 */
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
					if(list.getSelectedValue()!="Water"||list.getSelectedValue()!="Petrol")
		        	btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/milk.gif")));
					else if(list.getSelectedValue()!="Petrol"||list.getSelectedValue()!="Milk")
			        btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/agua.png")));
					else// (list.getSelectedValue()!="Milk"||list.getSelectedValue()!="Water")
			        btnOpenDialog.setIcon(new ImageIcon(InitGUI.class.getResource("/Images/gasolina.png")));
		        	//try if it works, but it doesn't)
		        	System.out.println("hola");
			}
		   });
		
		/**
		 * Add the list to the panel and set the font/list settings
		 */
		panel_3.add(list);
		list.setFont(new Font("Courier New", Font.PLAIN, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(new Color(238, 238, 238));
		list.setModel(jList1Model);
		
		
		//multiple selection
		int[] selectedIx = list.getSelectedIndices();

	    /**
	     *  Get all the selected items using the indices
	     */
	    for (int i = 0; i < selectedIx.length; i++) {
	      Object sel = list.getModel().getElementAt(selectedIx[i]);
	    }

		/**
		 * Customized square button
		 */

		/**
		 * Set the button settings
		 */
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
		
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		/**
		 * Set how JSlider is going to appear
		 */
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		panel_1.add(slider);
		
		/**
		 * Design the content of the dialog
		 */
		lblNewLabel_4 = new JLabel("Dropping...");
		panel_1.add(lblNewLabel_4);
		
		/**
		 * Shows an option pane with a dialog asking for confirmation
		 */
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Final dialogue with the user to decide if he finished
				 */
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
		 * Calling our drawing panel/application 
		 */
		JPanel panel = new ImgPanel(hierbaDir);
		contentPane.add(panel);
	}
}
