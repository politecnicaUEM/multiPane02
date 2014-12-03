import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Window;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListDataEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BookCamp implements ActionListener{
	private JTable table;
	JPanel panel_4 = new JPanel();

	public BookCamp(){
		initGUI();
	}
	
	
	private void initGUI() {
    JFrame bookCampF = new JFrame("Menu Book Camp");
//    menuBookCamp.setSize(220, 200);
    bookCampF.setSize(775, 275);
    bookCampF.setVisible(true);
    bookCampF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JMenuBar jmb = new JMenuBar();
	Act7 actLibro= new Act7();
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiOpen = new JMenuItem("Open CVS File");
    
    ArrayList<Libro> lib=actLibro.leerCSV();
    ArrayList<Libro> libCambio;
  
    jmiOpen.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
    		System.out.println("Tabla llenada con exito");
    		
    		for(int i=0; i<lib.size();i++){
    			table.setValueAt(lib.get(i).getTitulo(),i,0);
    			table.setValueAt(lib.get(i).getAutor(),i,1);
    			table.setValueAt(lib.get(i).getEditorial(),i,2);
    			table.setValueAt(lib.get(i).getAnio(),i,3);
    			table.setValueAt(lib.get(i).getStock(),i,4);
    			table.setValueAt(lib.get(i).getId(),i,5);
    		}
		}
	});
    
    JMenuItem jmiClose = new JMenuItem("Close CVS File");
    jmiClose.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			table.setModel(new DefaultTableModel(lib.size(), 6));
    		System.out.println("Tabla vaciada");
    		bookCampF.getContentPane().repaint();
		}
	});
    JMenuItem jmiSave = new JMenuItem("Save changes in CVS File");
    jmiSave.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<Libro> libCambio = null;
			for (int i = 0; i < 6; i++) {
					String titulo=(String) table.getValueAt(i, 0);
					String autor=(String) table.getValueAt(i, 1);
					String editorial=(String) table.getValueAt(i, 2);
					String anio=(String) table.getValueAt(i, 3);
					String stock=(String) table.getValueAt(i, 4);
					String id=(String) table.getValueAt(i, 5);
					Libro book= new Libro(titulo, autor, editorial, anio, stock, id);
					libCambio.add(book);
			}
			System.out.println("cambio guardado");
		}
	});
    JMenuItem jmiExit = new JMenuItem("Exit Application");
    jmiExit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
    		System.exit(0);
		}
	});
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    JMenu jmOptions = new JMenu("Options");
    JMenu bookOpt = new JMenu("Book Options");
    JMenuItem b = new JMenuItem("Add new book");
    JMenuItem c = new JMenuItem("Modify book");
    JMenuItem d = new JMenuItem("Delete book");
    bookOpt.add(b);
    bookOpt.add(c);
    bookOpt.add(d);
    jmOptions.add(bookOpt);
    JMenu editorialOpt = new JMenu("Editorial Options");
    editorialOpt.add(new JMenuItem("Modify Editorial"));
    editorialOpt.add(new JMenuItem("Delete Editorial"));
    jmOptions.add(editorialOpt);

    jmb.add(jmOptions);

    JMenu jmOthers = new JMenu("Others");
    JMenuItem jmiSupport = new JMenuItem("Support");
    JMenuItem jmiDonations = new JMenuItem("Donations");
    jmb.add(jmOthers);
    jmOthers.add(jmiSupport);
    jmOthers.add(jmiDonations);
    
    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiAbout = new JMenuItem("About");
    JMenuItem jmiTherms= new JMenuItem("Therms");
    jmHelp.add(jmiAbout);
    jmHelp.add(jmiTherms);
    jmb.add(jmHelp);
    
    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
    b.addActionListener(this);
    c.addActionListener(this);
    d.addActionListener(this);
    jmiAbout.addActionListener(this);

    bookCampF.setJMenuBar(jmb);
    bookCampF.getContentPane().setLayout(new BorderLayout(0, 0));;
    
    JPanel panel_2 = new JPanel();
    bookCampF.getContentPane().add(panel_2, BorderLayout.WEST);
    panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
    
    JScrollPane scrollPane = new JScrollPane();
    panel_2.add(scrollPane);
    
        table = new JTable();
        table.setModel(new DefaultTableModel(lib.size(), 6));
        JTableHeader th=new JTableHeader();
        table.setTableHeader(th);
        //table.createScrollPaneForTable(arg0);

        table.setRowSelectionAllowed(false);
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        //bookCampF.getContentPane().add(table, BorderLayout.NORTH);
        scrollPane.setViewportView(table);
    Font font= new Font("Arial", Font.BOLD, 16);
    
    JPanel panel = new JPanel();
    panel_2.add(panel);
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    
    JPanel panel_3 = new JPanel();
    bookCampF.getContentPane().add(panel_3, BorderLayout.SOUTH);
    panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
    
    
    panel_3.add(panel_4);
    
    JLabel label_2 = new JLabel();
    panel_4.add(label_2);
    label_2.setText("Did you enjoy it?");
    label_2.setHorizontalAlignment(SwingConstants.CENTER);
    label_2.setFont(new Font("Arial", Font.BOLD, 16));
    
    JSlider slider = new JSlider();
    panel_4.add(slider);
    slider.setValue(0);
    
    JLabel label_1 = new JLabel("");
    panel_4.add(label_1);
    
    JPanel panel_6 = new JPanel();
    panel_3.add(panel_6);
    
    JButton btnEnviar = new JButton("Enviar");
    btnEnviar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String message = "Enviar el Formulario?";
			 JFrame dialog= new JFrame();
			 int answer = JOptionPane.showConfirmDialog(dialog, message);
			 if (answer == JOptionPane.YES_OPTION) {
					 JFrame enviar=new JFrame("Formulario enviado");
					 Window w= new Window(enviar);
					 JPanel pan= new JPanel();
					 w.add(pan);
					 JLabel sli=new JLabel();
					 String l;
					 if(slider.getValue()<25){
						 message="La app no te ha gustado nada de nada!!!  WTF";
						 JOptionPane.showMessageDialog(dialog, message);}
						 else if(slider.getValue()<50){
							 message="La app no te ha gustado mucho";
							 JOptionPane.showMessageDialog(dialog, message);}
							 else if(slider.getValue()<75){
								 message="La app te ha gustado un poquillo";
								 JOptionPane.showMessageDialog(dialog, message);}
								 else
									 message="La app te parece la autentica leche!";
									 JOptionPane.showMessageDialog(dialog, message);
					 
					 String bi="Formulario enviado satisfactoriamente!";
					 pan.add(new JLabel(bi));
					 
					 //enviar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
					 enviar.setSize(400, 250);//configurando tamaño de la ventana
					 enviar.setVisible(true);//configurando visualización de la ventana
				     Component comp=enviar;
				     w.add(bi, comp);
					 w.setVisible(true);
					 w.isMaximumSizeSet();
			 } else if (answer == JOptionPane.CANCEL_OPTION) {
				 message = "Estas seguro de que no quieres enviarlo?";
				 dialog= new JFrame();
				 answer = JOptionPane.showConfirmDialog(dialog, message);
				 if(answer == JOptionPane.YES_OPTION){
					 message = "Mandalo cuando estes seguro";
					 dialog= new JFrame();
					 JOptionPane.showMessageDialog(dialog, message);
				 }else{
					  message = "Enviar el Formulario?";
					  dialog= new JFrame();
					  answer = JOptionPane.showConfirmDialog(dialog, message);
				 }
			 }else{
				 message = "Puedes enviarlo mas tarde";
				 dialog= new JFrame();
				 JOptionPane.showMessageDialog(dialog, message);
				 
			 }
			 
   	}
    });
    
    JPanel panel_8 = new JPanel();
    panel_6.add(panel_8);
    panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    panel_6.add(btnEnviar);
    JButton btnReiniciar = new JButton("Salir");
    btnReiniciar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(-1);
    	}
    });
    panel_6.add(btnReiniciar);
    
    JPanel panel_7 = new JPanel();
    bookCampF.getContentPane().add(panel_7, BorderLayout.NORTH);
    
    JPanel panel_1 = new JPanel();
    bookCampF.getContentPane().add(panel_1, BorderLayout.EAST);
    
    JButton button = new JButton("");
    button.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
			 String message = "Quieres reservar una mesa de billar en el establecimiento mas cercano??";
			 JFrame dialog= new JFrame();
			 int answer = JOptionPane.showConfirmDialog(dialog, message);
			 if (answer == JOptionPane.YES_OPTION) {
				 JFrame billar=new JFrame("Reserva mesas de billar");
				 Window w= new Window(billar); 
				 String bi="Este es tu establecimiento mas cercano para jugar un billar";
//			        billar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
			        billar.setSize(400, 250);//configurando tamaño de la ventana
			        billar.setVisible(true);//configurando visualización de la ventana
			        Component comp=billar;
			        w.add(bi, comp);
				 w.setVisible(true);
				 w.isMaximumSizeSet();
//				 String url = "http://www.twitter.com";
//		    		URL obj = null;
//					try {
//						obj = new URL(url);
//					} catch (MalformedURLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		    		HttpURLConnection conn = null;
//					try {
//						conn = (HttpURLConnection) obj.openConnection();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		    		conn.setReadTimeout(5000);
//		    		conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//		    		conn.addRequestProperty("User-Agent", "Mozilla");
//		    		conn.addRequestProperty("Referer", "google.com");
//		    		try {
//						conn.connect();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
			 } else if (answer == JOptionPane.NO_OPTION) {
			 // User clicked NO.
			 }
    	}
    });
    button.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\DAM\\Desarrollo de Interfaces\\PNGs\\Magic-Eight-Ball.png"));
    
    JButton btnNewButton = new JButton("");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
			 String message = "Quieres reservar un billete de avion??";
			 JFrame dialog= new JFrame();
			 int answer = JOptionPane.showConfirmDialog(dialog, message);
			 if (answer == JOptionPane.YES_OPTION) {
				 JFrame avion=new JFrame("Reserva billetes de avion");
				Window w= new Window(avion); 
				String av="Este es tu establecimiento mas cercano para viajar";
//		        avion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
		        avion.setSize(400, 250);//configurando tamaño de la ventana
		        avion.setVisible(true);//configurando visualización de la ventana
		        Component comp=avion;
		        w.add(av, comp);
			 } else if (answer == JOptionPane.NO_OPTION) {
			 // User clicked NO.
			 }
    	}
    });
    btnNewButton.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\DAM\\Desarrollo de Interfaces\\PNGs\\Airport.png"));
    
    JButton btnNewButton_1 = new JButton("");
    btnNewButton_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
    			 String message = "Quieres reservar en un camping??";
    			 JFrame dialog= new JFrame();
    			 int answer = JOptionPane.showConfirmDialog(dialog, message);
    			 if (answer == JOptionPane.YES_OPTION) {
    				JFrame camping=new JFrame("Reserva en camping");
    				Window w= new Window(camping); 
    				String av="Este es tu establecimiento mas cercano para ir de acampada";
//    				camping.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
    				camping.setSize(400, 250);//configurando tamaño de la ventana
    				camping.setVisible(true);//configurando visualización de la ventana
    		        Component comp=camping;
    		        w.add(av, comp);
    			 } else if (answer == JOptionPane.NO_OPTION) {
    			 // User clicked NO.
    			 }
        	}
    });
    btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\DAM\\Desarrollo de Interfaces\\PNGs\\Camping.png"));
    
    JLabel label = new JLabel("Mas atividades...");
    label.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent arg0) {
    		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	}
    	@Override
    	public void mouseExited(MouseEvent arg0) {
    		label.setBorder(null);
    	}
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		JFrame masActs=new JFrame("Mas Actividades...");
    		masActs.setSize(50, 10);
    		//JPanel ppal=new JPanel();
    		JPanel elig=new JPanel();
    		JPanel masA= new JPanel();
    		JPanel masB= new JPanel();
    		//ppal.add(masA);
    		JLabel elige=new JLabel("Elige entre las siguientes actividades:\n");
    		//JLabel[] lista= {new JLabel("Futbol"),new JLabel("Futbol"),new JLabel("Futbol")};
    		JButton l1=new JButton("Fubol");
    		JButton l2=new JButton("Baloncesto");
    		JButton l3=new JButton("Cine");
    		JButton l4=new JButton("Teatro");
    		JButton l5=new JButton("Esgrima");
    		JButton l6=new JButton("Boxeo");
    		JButton l7=new JButton("Danza");
    		JButton l8=new JButton("BMX");
    		JButton l9=new JButton("Awesome");
    		//l2.setSize(5, 5);
    		
    		masActs.add(masA);
    		
    		masA.add(l1);
    		masA.add(l2);
    		masA.add(l3);
    		
    		masA.add(masB);
    		masB.add(l4);
    		masB.add(l5);
    		masB.add(l6);
    		
    		masA.add(elig);
    		elig.add(l7);
    		elig.add(l8);
    		elig.add(l9);
    		
    		
    		
			Window w= new Window(masActs); 
			String av="Elige una de las siguientes:";
			//List list = (List) Arrays.asList("Hello", "World!", "How", "Are", "You");
		   // w.add(list);
			masActs.setSize(400, 250);
			masActs.setVisible(true);
	        Component comp=masActs;
	        w.add(av, comp);
    	}
    });
    
    JSeparator separator = new JSeparator();
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(
    	gl_panel_1.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_panel_1.createSequentialGroup()
    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
    				.addGroup(gl_panel_1.createSequentialGroup()
    					.addGap(7)
    					.addComponent(button)
    					.addGap(4)
    					.addComponent(btnNewButton)
    					.addGap(4)
    					.addComponent(btnNewButton_1))
    				.addGroup(gl_panel_1.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
    			.addContainerGap(12, Short.MAX_VALUE))
    		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
    			.addContainerGap(177, Short.MAX_VALUE)
    			.addComponent(label)
    			.addContainerGap())
    );
    gl_panel_1.setVerticalGroup(
    	gl_panel_1.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_panel_1.createSequentialGroup()
    			.addGap(7)
    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
    				.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				.addComponent(button, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
    			.addPreferredGap(ComponentPlacement.RELATED)
    			.addComponent(label)
    			.addGap(5)
    			.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addGap(33))
    );
    panel_1.setLayout(gl_panel_1);
    btnNewButton_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
    			 String message = "Quieres reservar en un camping??";
    			 JFrame dialog= new JFrame();
    			 int answer = JOptionPane.showConfirmDialog(dialog, message);
    			 if (answer == JOptionPane.YES_OPTION) {
    				JFrame camping=new JFrame("Reserva en camping");
    				Window w= new Window(camping); 
    				String av="Este es tu establecimiento mas cercano para ir de acampada";
//    				camping.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
    				camping.setSize(400, 250);//configurando tamaño de la ventana
    				camping.setVisible(true);//configurando visualización de la ventana
    		        Component comp=camping;
    		        w.add(av, comp);
    			 } else if (answer == JOptionPane.NO_OPTION) {
    			 // User clicked NO.
    			 }
        	}
    });
    bookCampF.setVisible(true);
    
  }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void hooola(){
		System.out.println("hola");
	}
	
	public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                BookCamp ml = new BookCamp();
                //ml.setVisible(true);
            }
        });
    }
}

