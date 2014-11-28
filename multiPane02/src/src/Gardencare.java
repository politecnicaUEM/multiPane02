package src;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Gardencare {

	static JLabel lblNewLabel_4;
	JPanel panel_inferior;
	private JFrame frame;
	JSlider slider;
	JList list;

	/**
	 * Launch the application.
	 * @author Issam Natour
	 * 
	 */
	
	
	/**
	*This is the main method
	*@see main()
	*
	*/

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gardencare window = new Gardencare();
			
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @see Gardencare()
	 */
	public Gardencare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @see initialize()
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_superior = new JPanel();
		frame.getContentPane().add(panel_superior);
		panel_superior.setLayout(new GridLayout(0, 4, 0, 0));

		JToolBar toolBar = new JToolBar();
		panel_superior.add(toolBar);
		

		/**
		 * @see listener of sun
		 * 
		 */
		
		JLabel lblNewLabel = new JLabel("Perfect sun");
		lblNewLabel.setIcon(new ImageIcon(Gardencare.class.getResource("/img/Sunshine@Low.png")));
		toolBar.add(lblNewLabel);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				slider.setValue(15);
			}
		});

		JToolBar toolBar_1 = new JToolBar();
		panel_superior.add(toolBar_1);
		/**
		 *@see listener of rains
		 * 
		 */
		JLabel lblNewLabel_1 = new JLabel("Cloudly");
		lblNewLabel_1.setIcon(new ImageIcon(Gardencare.class.getResource("/img/Cloudy@Low.png")));
		toolBar_1.add(lblNewLabel_1);

		/**
		 *@see listener of cloudfly
		 * 
		 */
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				list.setSelectedIndex(2);
			}
		});
		JToolBar toolBar_2 = new JToolBar();
		panel_superior.add(toolBar_2);

		/**
		 *@see listener of windy
		 * 
		 */
		JLabel lblNewLabel_2 = new JLabel("Rains");
		lblNewLabel_2.setIcon(new ImageIcon(Gardencare.class.getResource("/img/Cloud-Download@Low.png")));
		toolBar_2.add(lblNewLabel_2);

		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JDialogo dialogo = new JDialogo();
				dialogo.setVisible(true);
			}
		});
		
		JToolBar toolBar_3 = new JToolBar();
		panel_superior.add(toolBar_3);

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(Gardencare.class.getResource("/img/Refresh@Low.png")));
		toolBar_3.add(lblNewLabel_3);
		
		/**
		 *@see listener of windy
		 * 
		 */

		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				frame.setBounds(100, 100, 650, 500);
				frame.setVisible(false);
				frame.setVisible(true);
			}
		});
		JPanel panel_central1 = new JPanel();
		frame.getContentPane().add(panel_central1);
		panel_central1.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Gardencare.class
				.getResource("/img/Water-Drop.png")));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		
		btnNewButton.setToolTipText("Tooltip");
		
		panel_central1.add(btnNewButton, BorderLayout.EAST);

		
		/**
		*Event JButton
		*@return new JDialog frame
		*
		*/
		
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JDialogo dialogo = new JDialogo();
				dialogo.setVisible(true);

			}

		});
		
		JScrollPane scrollPane = new JScrollPane();
		panel_central1.add(scrollPane, BorderLayout.CENTER);
// Lista de objetos del JList
	 list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "water","Petrol","Milk" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);

		JPanel panel_central2 = new JPanel();
		frame.getContentPane().add(panel_central2);
		panel_central2.setLayout(new BorderLayout(0, 0));

	 slider = new JSlider();
		slider.setValue(25);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		panel_central2.add(slider);
		
		final JLabel positionslider = new JLabel("  "+String.valueOf(slider.getValue())+"   ");
		panel_central2.add(positionslider, BorderLayout.EAST);
		slider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    
		        String valorslider ="  "+  String.valueOf(slider.getValue()+"   ");
		        positionslider.setText(valorslider);
		      }
		    });
		 panel_inferior = new JPanel();
		 
		 
		 
		JPanel panel_resize = new Redimension("img/hierba-footer.png");
		frame.getContentPane().add(panel_resize);

		
		

	

	}
}
