import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Este un panel con imágenes.
 * 
 * @author Samuel García
 * @verion v.0.1
 * @see ImgPanel
 *
 */
public class Multipanel extends JFrame {

	private JPanel contentPane;
	private String hierbaDir = "/res/grass.png";
	private JSlider slider;
	private JLabel lblDropping;
	private JLabel lblNewLabel_3;
	private JList list;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Multipanel frame = new Multipanel();
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
	public Multipanel() {
		
		setTitle("Garden care");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 4, 0, 0));

		JToolBar toolBar = new JToolBar();
		panel.add(toolBar);

		JLabel lblNewLabel = new JLabel("Perfect Sun");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Multipanel.class
				.getResource("/res/Sunshine.png")));
		toolBar.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBorder(new EmptyBorder(20, 10, 20, 10));
		toolBar.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Cloudy");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				VentanaSecundaria nuevaventana = new VentanaSecundaria();
				nuevaventana.setVisible(true);
				
				lblDropping.setText("It's cloudy.");
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Multipanel.class
				.getResource("/res/Cloudy.png")));
		toolBar.add(lblNewLabel_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBorder(new EmptyBorder(20, 10, 20, 10));
		toolBar.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Rains");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				String s = (String) JOptionPane.showInputDialog(contentPane,
	                    "Complete the sentence:\n"
	                    + "\"It's raining...\"",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    "ham");
				//list.addElement(s);
						        
				list.setBackground(Color.cyan);
				lblDropping.setText(s);
			}
			
		});
		lblNewLabel_2.setIcon(new ImageIcon(Multipanel.class
				.getResource("/res/Cloud-Download.png")));
		toolBar.add(lblNewLabel_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBorder(new EmptyBorder(20, 10, 20, 10));
		toolBar.add(separator_2);

		lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// dimensión de la ventana
				Dimension dimVentana = getSize();
				
				// dimensión de la pantalla
				Dimension dimScreen = getToolkit().getScreenSize();
				
				// nuevas coordenadas aleatorias para reubicar la ventana
				int x = (int) (Math.random()*(dimScreen.width-dimVentana.width));
				int y = (int) (Math.random()*(dimScreen.height-dimVentana.height));
				
				//cambio de ubicación la ventana
				setLocation(x,y);
				lblDropping.setText("There is a hurricane. The window is moving!!!!");
				
						
				list.setBackground(Color.orange);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(Multipanel.class
				.getResource("/res/Refresh.png")));
		toolBar.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		list = new JList();
		panel_4.add(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Water", "Petrol", "Milk", "Toad" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(Multipanel.class.getResource("/res/Green@Low.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("GO!!!");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Dialoging
				String message = "Are you 100% sure?";
				Component frame = null;
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					// User clicked YES.
					List<String> values = list.getSelectedValuesList();
					StringBuilder sb = new StringBuilder();
					sb.append("Dropping...");
					for (String value : values) {
						sb.append(value);
						sb.append(" ");
					}
					sb.append("at ");
					sb.append(slider.getValue());
					sb.append("%");
					lblDropping.setText(sb.toString());
					/* Código de Ernesto
					 * int[] selectedIx = list.getSelectedIndices();
 						lblNewLabel_4.setText("Dropping...");
 						// Get all the selected items using indexes
 						for (int i = 0; i < selectedIx.length; i++) {
 							sel = (String) list.getModel().getElementAt(selectedIx[i]);
 							lblNewLabel_4.setText(lblNewLabel_4.getText() + " " + sel + " ")
 						}
 						lblNewLabel_4.setText(lblNewLabel_4.getText() + " at " + slider.getValue() + "%");
					 */

				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
					JOptionPane.showMessageDialog(frame, 
							"It is about to rain.\n Don't forget your umbrella",
							"GO BACK",
							JOptionPane.WARNING_MESSAGE);
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(frame,
						    "Option Cancelled.",
						    "CANCEL",
						    JOptionPane.ERROR_MESSAGE);
					list.setBackground(Color.white);
				}
			}

		});
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setIcon(new ImageIcon(Multipanel.class
				.getResource("/res/Water-Drop@Low.png")));
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		slider = new JSlider();
		panel_5.add(slider);

		lblDropping = new JLabel("Dropping...");
		panel_2.add(lblDropping);

		/**
		 * Llamamos a nuestro panel de dibujo
		 */
		JPanel panel1 = new ImgPanel(hierbaDir);
		getContentPane().add(panel1);
	}

}
