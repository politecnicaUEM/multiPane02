package conEventos;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import multiPane02.ImgPanel;

public class InitGUI {

	private JFrame frame;

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
		frame.setBounds(100, 100, 515, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JToolBar toolBar = new JToolBar();
		panel.add(toolBar);

		JLabel lblNewLabel = new JLabel("Perfect sun");
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class
				.getResource("/images/Sunshine.png")));
		toolBar.add(lblNewLabel);
		toolBar.addSeparator();

		JLabel lblNewLabel_1 = new JLabel("Cloudy");
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class
				.getResource("/images/Cloudy.png")));
		toolBar.add(lblNewLabel_1);
		toolBar.addSeparator();

		JLabel lblNewLabel_2 = new JLabel("Rains");
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class
				.getResource("/images/Cloud-Download.png")));
		toolBar.add(lblNewLabel_2);
		toolBar.addSeparator();

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class
				.getResource("/images/Refresh.png")));
		toolBar.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Water", "Petrol", "Milk" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(2);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(UIManager.getColor("238,238,238"));
		panel_4.add(list);

		JButton btnNewButton = new JButton("");
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(0));;
		btnNewButton.setBackground(UIManager.getColor("238,238,238"));
		btnNewButton.setIcon(new ImageIcon(InitGUI.class
				.getResource("/images/Water-Drop.png")));
		btnNewButton.setMargin(new Insets(3, 3, 3, 3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = "Are you 100% sure?";
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					// User clicked YES.
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
				}
			}
		});
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JSlider slider = new JSlider();
		panel_2.add(slider);

		JPanel resize = new ImgPanel("images/hierba-footer.png");
		frame.getContentPane().add(resize);
		resize.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	

}
