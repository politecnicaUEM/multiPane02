package multiPane02;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;


/**
 * Interface Garden Care (not finished)
 * 
 * @author Vladimir Bocancea
 */
public class InitGUI {

	private JFrame frame;
	JToolBar jToolBar;
	JList<Object> jList;
	JSlider jSlider;
	private JScrollPane jScrollPane;
	private JButton jButtonGota;
	private JPanel jPanelActions;
	private JPanel jPanelLista;
	private JLabel jLabelSun;
	private JLabel jLabelCloudy;
	private JLabel jLabelRain;
	private JLabel jLabelWindy;
	private JPanel jPanelToolBar;
	private JPanel jPanelGreen;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component horizontalGlue_2;
	private Component horizontalGlue_3;
	private Component horizontalGlue_4;
	private Component verticalStrut;
	private Box horizontalBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitGUI window = new InitGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {

			}
		});
		/**
		 * the big frame has a layaout with 1 column and 4 rows,
		 */
		frame.setBounds(100, 100, 636, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 1, 0, 0));

		/**
		 * First row is a jToolBar
		 */
		jToolBar = new JToolBar();
		frame.getContentPane().add(jToolBar);

		jPanelToolBar = new JPanel();
		jToolBar.add(jPanelToolBar);

		/**
		 * listener of button jLabelSun, change selection of jList and jSlider
		 */

		/**
		 * listener of button jLabelCloudy, change selection of jList and
		 * jSlider
		 */

		/**
		 * listener of button jLabelRain, change selection of jList and jSlider
		 */

		/**
		 * listener of button jLabelWindy, change selection of jList and jSlider
		 */
		jPanelToolBar.setLayout(new BorderLayout(0, 0));

		horizontalBox = Box.createHorizontalBox();
		jPanelToolBar.add(horizontalBox, BorderLayout.SOUTH);

		horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);

		jLabelSun = new JLabel("Perfect sun");
		horizontalBox.add(jLabelSun);
		jLabelSun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				jList.setSelectedIndex(1);
				jSlider.setValue(80);
			}
		});
		jLabelSun.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine.png")));

		horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);

		jLabelCloudy = new JLabel("Cloudy");
		horizontalBox.add(jLabelCloudy);
		jLabelCloudy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				jList.setSelectedIndex(2);
				jSlider.setValue(50);

			}
		});
		jLabelCloudy.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy.png")));

		horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_3);

		jLabelRain = new JLabel("Rains");
		horizontalBox.add(jLabelRain);
		jLabelRain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				jList.setSelectedIndex(3);
				jSlider.setValue(30);

			}
		});
		jLabelRain.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloud-Download.png")));

		horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_4);

		jLabelWindy = new JLabel("Windy");
		horizontalBox.add(jLabelWindy);
		jLabelWindy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				jList.setSelectedIndex(4);
				jSlider.setValue(45);

			}
		});
		jLabelWindy.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Refresh.png")));

		verticalStrut = Box.createVerticalStrut(2);
		horizontalBox.add(verticalStrut);

		horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		/**
		 * second row has a JPanel with a jList and a JButon
		 */
		jPanelActions = new JPanel();
		frame.getContentPane().add(jPanelActions);
		jPanelActions.setLayout(new BoxLayout(jPanelActions, BoxLayout.X_AXIS));

		jPanelLista = new JPanel();
		jPanelActions.add(jPanelLista);
		jPanelLista.setLayout(new GridLayout(0, 1, 0, 0));

		jScrollPane = new JScrollPane();
		jPanelLista.add(jScrollPane);

		jList = new JList<Object>();
		jList.setModel(new AbstractListModel<Object>() {

			private static final long serialVersionUID = 1L;

			String[] values = new String[] { "Water", "Petrol", "Milk",
					"aaaaa", "bbbbb", "ccccc", "dddd" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		jScrollPane.setViewportView(jList);

		jButtonGota = new JButton("");

		/**
		 * listener of button jLabelGota, shows a confirmation dialog
		 */
		jButtonGota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String message = "Are you 100% sure?";
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					// User clicked YES.
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
				}
			}
		});
		jButtonGota.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Water-Drop.png")));
		jButtonGota.setMargin(new Insets(0, 0, 0, 0));

		jPanelActions.add(jButtonGota);

		/**
		 * 4th row is a JSlider
		 */
		jSlider = new JSlider();
		jSlider.setValue(50);
		jSlider.setSnapToTicks(true);
		jSlider.setPaintTicks(true);
		jSlider.setPaintLabels(true);
		jSlider.setMajorTickSpacing(10);
		frame.getContentPane().add(jSlider);

		/**
		 * jPanelGreen is class Green, extends JPanel
		 */
		jPanelGreen = new ImgPanel("Images/hierba-footer.png");
		frame.getContentPane().add(jPanelGreen);

	}

}
