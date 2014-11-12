import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.net.URL;
import javax.swing.JSlider;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GardenCare {
	
	private JFrame frame;
	private String Mensaje = "";
	private JLabel MensajePersonalizado;
	private JSlider slider;
	
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

	// Constructor de la interfaz
	public GardenCare() {
		initialize();
		frame.pack();
		frame.setVisible(true);
	}

	// Inicializacion de componentes
	@SuppressWarnings("serial")
	private void initialize() {
		
		frame = new JFrame("GardenCare SinEventos");
		MensajePersonalizado = new JLabel();
		MensajePersonalizado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MensajePersonalizado.setHorizontalAlignment(SwingConstants.LEFT);
		
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

		JToolBar toolBar = new JToolBar();
		panel_7.add(toolBar, BorderLayout.CENTER);
		toolBar.setOpaque(false);

		JLabel lblNewLabel = new JLabel(" Perfect Sun   ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(GardenCare.class
				.getResource("/Images/FlatSunny.png")));
		toolBar.add(lblNewLabel);
		JToolbarSeparator separator = new JToolbarSeparator();
		toolBar.add(separator);

		JLabel lblNewLabel_1 = new JLabel(" Cloudy   ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setIcon(new ImageIcon(GardenCare.class
				.getResource("/Images/FlatCloudy.png")));
		toolBar.add(lblNewLabel_1);
		JToolbarSeparator separator2 = new JToolbarSeparator();
		toolBar.add(separator2);

		JLabel lblNewLabel_3 = new JLabel(" Rains   ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(GardenCare.class
				.getResource("/Images/FlatRain.png")));
		toolBar.add(lblNewLabel_3);
		JToolbarSeparator separator3 = new JToolbarSeparator();
		toolBar.add(separator3);

		JLabel lblNewLabel_2 = new JLabel(" Windy   ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(GardenCare.class
				.getResource("/Images/FlatWindy.png")));
		toolBar.add(lblNewLabel_2);

		slider = new JSlider(0,100,25);
		slider.setPaintLabels(true);		
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_6.setLayout(gbl_panel_6);

		JList<Object> list = new JList<Object>(new AbstractListModel<Object>() {
			String[] values = new String[] { "Water", "Petrol", "Milk" };

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
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.anchor = GridBagConstraints.NORTH;
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 12;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.HORIZONTAL;
		gbc_list.gridx = 1;
		gbc_list.gridy = 0;
		panel_6.add(list, gbc_list);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				String message = "Are you 100% sure?";
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					Mensaje = "";
				 // Ha clikeado si
					Mensaje += "   Dropping...."+ slider.getValue() + " of ";
					int[] selectedIx = list.getSelectedIndices();
					for (int i = 0; i < selectedIx.length; i++) {
					     Object sel = list.getModel().getElementAt(selectedIx[i]);
					     if (i ==0){
					    	 Mensaje+= sel;
					     } else if (i == 1){
					    	 Mensaje+= " and "+sel;
					     } else {
					    	 Mensaje+= " and "+sel+" too!!!";
					    }	
					}
					MensajePersonalizado.setText(Mensaje+".");
					
				} else if (answer == JOptionPane.NO_OPTION) {
				 // Ha clikeado no
				}
			}
		});
		lblNewLabel_10.setIcon(new ImageIcon(GardenCare.class.getResource("/Images/Boton.png")));
		// Tooltip Gota
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridheight = 3;
		gbc_lblNewLabel_10.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_10.gridx = 13;
		gbc_lblNewLabel_10.gridy = 0;
		panel_6.add(lblNewLabel_10, gbc_lblNewLabel_10);

		JLabel lblNewLabel_4 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel_6.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		
		panel_9.add(slider, BorderLayout.NORTH);
		
		
		panel_9.add(MensajePersonalizado, BorderLayout.CENTER);

		ResizableBackground panel_8 = new ResizableBackground("/Images/hierba-footer.png");
		panel_8.setBackgroundImage(panel_8.createImage().getImage());
		panel_2.add(panel_8);
	}

	// Clase anidada para crear separadores grises con sombra y de 
	// tamaño fijo horizontal y vertical
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
	
	// Clase anidada para crear un fondo resizable
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
		public void paint(Graphics g) {
			Dimension size = getSize();
			if (bgImage != null) {
				g.drawImage(createImage().getImage(), 0, 0, size.width, size.height, null);
			}
			super.paint(g);
		}
	}
}