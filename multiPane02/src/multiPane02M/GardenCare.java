package multiPane02M;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.net.URL;

import javax.swing.JSlider;
import javax.swing.AbstractListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Miguel Martin 
 */
 
public class GardenCare {
	
	private JFrame frame;
	
	/**
	 * Method to run the application
	 * @param main Run the application
	 * 
	 */
	
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GardenCare window = new GardenCare();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initializes the initial method
	 * @see GardenCare Initializes the initial method
	 */
	public GardenCare() {
		initialize();
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * This method contains the components of the program (frame, button, labels.etc)
	 * @see initialize()
	 */
	
	private void initialize() {
		frame = new JFrame("Garden Care");

		frame.setPreferredSize(new Dimension(430, 450));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_5.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);

		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10, BorderLayout.NORTH);

		JToolBar toolBar = new JToolBar();
		panel_7.add(toolBar, BorderLayout.CENTER);
		toolBar.setOpaque(false);

		JLabel lblNewLabel = new JLabel(" Perfect Sun   ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			/**
			 * @see mouseClicked
			 * Event to actuate the frame Soleado
			 */
			public void mouseClicked(MouseEvent arg0) {
			JFrame frame = new JFrame("Soleado");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel textLabel = new JLabel("",SwingConstants.CENTER);
			textLabel.setPreferredSize(new Dimension(300,100));
			textLabel.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/soleado.gif")));
			frame.getContentPane().add(textLabel,BorderLayout.CENTER);
			
			frame.setLocationRelativeTo(null);
			frame.pack();
			frame.setVisible(true);
			
			
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/sol.PNG")));
		toolBar.add(lblNewLabel);
		JToolbarSeparator separator = new JToolbarSeparator();
		toolBar.add(separator);

		JLabel lblNewLabel_1 = new JLabel(" Cloudy   ");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			/**
			 * @see mouseClicked
			 * Event to actuate the frame Nublado
			 */
			public void mouseClicked(MouseEvent arg0) {
				JFrame frame = new JFrame("Nublado");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setPreferredSize(new Dimension(300,100));
				textLabel.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/nublado.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);
				
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/nube.PNG")));
		toolBar.add(lblNewLabel_1);
		JToolbarSeparator separator2 = new JToolbarSeparator();
		toolBar.add(separator2);

		JLabel lblNewLabel_3 = new JLabel(" Rains   ");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			/**
			 * @see mouseClicked
			 * Event to actuate the frame LLuvia
			 */
			public void mouseClicked(MouseEvent arg0) {
				JFrame frame = new JFrame("LLuvia");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setPreferredSize(new Dimension(300,100));
				textLabel.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/lluvia.gif")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);
				
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/nubes.PNG")));
		toolBar.add(lblNewLabel_3);
		JToolbarSeparator separator3 = new JToolbarSeparator();
		toolBar.add(separator3);

		JLabel lblNewLabel_2 = new JLabel(" Windy   ");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			/**
			 * @see mouseClicked
			 * Event to actuate the frame Niebla
			 */
			public void mouseClicked(MouseEvent arg0) {
				JFrame frame = new JFrame("Niebla");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JLabel textLabel = new JLabel("",SwingConstants.CENTER);
				textLabel.setPreferredSize(new Dimension(300,100));
				textLabel.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/niebla.jpg")));
				frame.getContentPane().add(textLabel,BorderLayout.CENTER);
				
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/wind.PNG")));
		toolBar.add(lblNewLabel_2);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_6.setLayout(gbl_panel_6);

		final JList<Object> list = new JList<Object>(new AbstractListModel() {
			String[] values = new String[] {"Water", "Petrol", "Milk"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});

		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setValueIsAdjusting(true);
		
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.anchor = GridBagConstraints.NORTH;
		gbc_list.gridheight = 4;
		gbc_list.gridwidth = 12;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.HORIZONTAL;
		gbc_list.gridx = 1;
		gbc_list.gridy = 0;
		panel_6.add(list, gbc_list);
		
		JLabel lblNewLabel_4 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_6.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		

		ResizableBackground panel_8 = new ResizableBackground(
				"/Images/hierba-footer.png");
		panel_8.setBackgroundImage(panel_8.createImage().getImage());
		panel_2.add(panel_8);
		
		final JSlider slider = new JSlider(0,100,25);
		slider.setPaintTicks(true);
		// hatched in the slider
		slider.setMajorTickSpacing(25);
		// Numbers in the slider 5 to 5
		slider.setMinorTickSpacing(5);
		// show numbers in the slider
		slider.setPaintLabels(true);
		panel_9.add(slider, BorderLayout.CENTER);
		
	
		
		final JLabel label = new JLabel("");
		panel_9.add(label, BorderLayout.NORTH);
		
		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override 
			/**
			 * Event to actuate the Jdialog 
			 * @return button mouseClicked
			 */
			public void mouseClicked(MouseEvent arg0) {
				int [] seleccione = list.getSelectedIndices();
				Object  selec = null;
				for (int i = 0; i < seleccione.length; i++) {
				      selec = list.getModel().getElementAt(seleccione[i]);
				    }
				
				
				int seleccion = JOptionPane.showOptionDialog(button, "Are you 100% sure?", 
				
						   "Selecciona una opción",
						   JOptionPane.YES_NO_CANCEL_OPTION,
						   JOptionPane.QUESTION_MESSAGE,
						   null,    // null for default icon.
						   new Object[] { "Cancelar", "No", "Yes" },   // null for YES, NO y CANCEL
						   "opcion 1");
						 
						if (seleccion == 0){
						   
						   
						   }else if(seleccion == 1){
							  
							   int vuelta = JOptionPane.showOptionDialog(button, "OKAY!!", "OKAY!!",
									   JOptionPane.YES_NO_CANCEL_OPTION,
									   JOptionPane.QUESTION_MESSAGE,
									   null,    // null for default icon
									   new Object[] { "OK" },   // null for YES, NO y CANCEL
									   "opcion 1");
						   }else{
							  
							   for (int i = 0; i < seleccione.length; i++) {
								      selec = (String) list.getModel().getElementAt(seleccione[i]);
								      label.setText(label.getText() + " " + selec + " ");
								      
								      
								    }
							   // show the text in to the label
							   label.setText(label.getText()+" tienen de porcentaje: "+ slider.getValue() + "%");
						   }
						
						
						
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//image for Button
		button.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/gota.PNG")));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 13;
		gbc_button.gridy = 0;
		panel_6.add(button, gbc_button);

		
	}

	/**
	 * A toolbar-specific separator. An object with dimension but no contents used to divide buttons on a tool bar into groups.
	 * 
	 * @see JToolbarSeparator
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
	
	/**
	 * This method increases the image acording the frame
	 * @see ResizableBackground 
	 * 
	 *
	 */
	public class ResizableBackground extends JPanel {

		private static final long serialVersionUID = 1L;
		private Image bgImage;
		private String path;

		public ResizableBackground(String path) {
			super();
			this.path = path;
			this.setOpaque(false);
		}

		public void setBackgroundImage(Image bgImage) {
			this.bgImage = bgImage;
		}
		
		public ImageIcon createImage() {
			URL imgURL = getClass().getResource(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL);
			} else {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
		}

		@Override
		/**
		 * This method get the image
		 * @see ResizableBackground 
		 * 
		 *
		 */
		public void paint(Graphics g) {
			Dimension size = getSize();
			if (bgImage != null) {
				g.drawImage(createImage().getImage(), 0, 0, size.width,
						size.height, null);
			}
			super.paint(g);
		}
	}
}
