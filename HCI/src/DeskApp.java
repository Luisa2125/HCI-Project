import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;



<<<<<<< Updated upstream
=======











>>>>>>> Stashed changes
import com.barcodelib.barcode.QRCode;

import javax.swing.JSpinner;


public class DeskApp extends JFrame implements ActionListener{
	
	
	
	
	private JFrame frame;
	private JFrame pop;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnIngresar;
	private JButton btnRegistrar;
	private JButton mclases;
	private JButton importar;
	private JButton vivo;
	private JLabel label;
	private JButton atras;
	private JPanel inicio;
	private JPanel categorias;
	private JPanel clases;
	private JPanel ver1;
	private JPanel registro;
	private boolean karate = true;
	private boolean dance = true;
	private JCheckBox karateI;
	private JCheckBox ballet;
	private JPanel Nm;
	private JPanel menuAct;
	private JPanel menuVer;
	private JPanel crearClase;
	private ArrayList<Usuario> users= new ArrayList<Usuario>();
	private JMenuBar iconos;
	
	//String[] cats = {"","",""};
	String[] classs = {"","",""};
	Color b = new Color(10,250,255);
	Color fondo = new Color(115,198,182);
	Color oscuro = new Color(19,141,117);
	Color fondo1 = new Color(127, 179, 213 );
	Color oscuro1 = new Color(41, 128, 185);
	Color popC = new Color(169, 204, 227);
	int i = 0;
<<<<<<< Updated upstream
	
=======
	ArrayList<Component> categorias1 = new ArrayList<Component>();
	ArrayList<Component> clases1 = new ArrayList<Component>();
	List<String> cats = new ArrayList<String>();
>>>>>>> Stashed changes
	private JPasswordField pas;
	int numero1 = 10;
	int numero2 = 15;
	int num1 = 30;
	int num2 = 70;
	private JLabel INICIO;
	private JLabel REGISTRO;
	private JLabel CLASES;
	private JLabel CATEGORIAS;
	private JLabel VIVO;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeskApp window = new DeskApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public DeskApp() throws IOException {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(fondo);
		frame.getContentPane().setLayout(null);
		pop();
		menu();
		INICIO = new JLabel("Inicio de  Sesion");
		INICIO.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		INICIO.setBounds(400, 50, 700, 200);
		INICIO.setForeground(Color.WHITE);
		
		REGISTRO = new JLabel("Registro");
		REGISTRO.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		REGISTRO.setBounds(600, 50, 700, 200);
		REGISTRO.setForeground(Color.WHITE);
		
		CLASES = new JLabel("Clases");
		CLASES.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		CLASES.setBounds(400, 50, 700, 200);
		CLASES.setForeground(Color.WHITE);
		
		CATEGORIAS = new JLabel("Categorias");
		CATEGORIAS.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		CATEGORIAS.setBounds(600, 50, 700, 200);
		CATEGORIAS.setForeground(Color.WHITE);
		
		VIVO = new JLabel("En Vivo");
		VIVO.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		VIVO.setBounds(400, 50, 700, 200);
		VIVO.setForeground(Color.WHITE);
		
		
		inicio = singIn(INICIO);
		inicio.setVisible(true);
		
		

		
		
		categorias = new JPanel();
		categorias.setBounds(0, 700, 1100, 1100);
		//clases.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		categorias.setBackground(fondo1);
		categorias.setLayout(null);
		categorias1 = categoria(karate,dance);
		for (int i=0;i<categorias1.size();i++){
			categorias.add(categorias1.get(i));
			//cats.add((categoria(karate,dance).get(i)).getName());
			
		}
		
		
		clases = new JPanel();
		clases.setBounds(0, 700, 1100, 1100);
		//clases.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		clases.setBackground(fondo1);
		clases.setLayout(null);
		clases1 = clases();
		for (int i=0;i<clases1.size();i++){
			clases.add(clases1.get(i));
		}
		clases.setToolTipText("HOLAAAAA");
		
		
		
		crearClase = crearClase();
		
		ver1 = Olvide();
		registro = registro(REGISTRO);
		Nm = menuVivo();
		menuAct = menuA();
		menuVer = codigoQRVideo();
		
		
		
		
		
		clases.setVisible(false);
		ver1.setVisible(false);
		registro.setVisible(false);
		Nm.setVisible(false);
		menuAct.setVisible(false);
		menuVer.setVisible(false);
		categorias.setVisible(false);
		iconos.setVisible(false);
		crearClase.setVisible(false);
		INICIO.setVisible(true);
		REGISTRO.setVisible(false);
		CATEGORIAS.setVisible(false);
		CLASES.setVisible(false);
		VIVO.setVisible(false);
		
		
		frame.getContentPane().add(INICIO);
		frame.getContentPane().add(REGISTRO);
		frame.getContentPane().add(CLASES);
		frame.getContentPane().add(CATEGORIAS);
		frame.getContentPane().add(VIVO);
		frame.getContentPane().add(inicio);	
		frame.getContentPane().add(ver1);
		frame.getContentPane().add(registro);
		frame.getContentPane().add(Nm);
		frame.getContentPane().add(menuAct);
		frame.getContentPane().add(menuVer);
		frame.getContentPane().add(categorias);
		frame.getContentPane().add(clases);
		frame.getContentPane().add(crearClase);
		
		frame.getContentPane().add(iconos);
		label = new JLabel("");
		label.setIcon(new ImageIcon("/home/luisa/icon1.png"));
		label.setBounds(515, 200, 300, 317);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 1350, 1550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void pop(){
		pop = new JFrame();
		pop.setBounds(100, 100, 1300, 1000);
		pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pop.getContentPane().setLayout(null);
		pop.getContentPane().setBackground(popC);
		
		ArrayList<Component> imgs = new ArrayList<Component>();
		
		JButton btnSaltarInfo = new JButton("SALTAR INFO");
		btnSaltarInfo.setFont(new Font("Dialog", Font.BOLD, 28));
		btnSaltarInfo.setForeground(Color.WHITE);
		btnSaltarInfo.setBackground(oscuro1);
		btnSaltarInfo.setBounds(736, 900, 310, 60);
		btnSaltarInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					Process proc = Runtime.getRuntime().exec("obs");
					pop.setVisible(false);
				}catch(IOException r){
					System.out.println("NOOOOOOO");
				}
				
			}
		});
		pop.getContentPane().add(btnSaltarInfo);
		
		JLabel img = new JLabel("");
		img.setBounds(60, 60, 1190, 800);
<<<<<<< Updated upstream
		img.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l1.png"));
=======
		img.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/l1.png"));
>>>>>>> Stashed changes
		img.setBorder(BorderFactory.createLineBorder(oscuro1));
		pop.getContentPane().add(img);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(60, 60, 1190, 800);
<<<<<<< Updated upstream
		img1.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l2.png"));
=======
		img1.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/l2.png"));
>>>>>>> Stashed changes
		img1.setBorder(BorderFactory.createLineBorder(oscuro));
		pop.getContentPane().add(img1);
		JLabel img2 = new JLabel("");
		img2.setBounds(60, 60, 1190, 800);
		img2.setBorder(BorderFactory.createLineBorder(oscuro));
<<<<<<< Updated upstream
		img2.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l3.png"));
		pop.getContentPane().add(img2);
		JLabel img3 = new JLabel("");
		img3.setBounds(60, 60, 1190, 800);
		img3.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l4.png"));
=======
		img2.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/l3.png"));
		pop.getContentPane().add(img2);
		JLabel img3 = new JLabel("");
		img3.setBounds(60, 60, 1190, 800);
		img3.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/l4.png"));
>>>>>>> Stashed changes
		img3.setBorder(BorderFactory.createLineBorder(oscuro));
		pop.getContentPane().add(img3);
		
		img.setVisible(false);
		img2.setVisible(false);
		img3.setVisible(false);
		img1.setVisible(true);
		imgs.add(img1);
		imgs.add(img);
		imgs.add(img3);
		imgs.add(img2);
		
		JButton btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setFont(new Font("Dialog", Font.BOLD, 28));
		btnAnterior.setForeground(Color.WHITE);
		btnAnterior.setBackground(oscuro1);
		btnAnterior.setBounds(127, 900, 200, 60);
		btnAnterior.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(0<i && i<=3){
					i -=1;
				}else{
					i = 0;
				}
				imgs.get(i+1).setVisible(false);
				imgs.get(i).setVisible(true);
			}
		});
		pop.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setFont(new Font("Dialog", Font.BOLD, 28));
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBackground(oscuro1);
		btnSiguiente.setBounds(360, 900, 200, 60);
		btnSiguiente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(0<=i && i<3){
					i +=1;
				}else{
<<<<<<< Updated upstream
					i = 0;
=======
					i = 1;
>>>>>>> Stashed changes
				}
				imgs.get(i-1).setVisible(false);
				imgs.get(i).setVisible(true);
				
			}
		});
		pop.getContentPane().add(btnSiguiente);
		
		
	}
	public void menu(){
		iconos = new JMenuBar();
		iconos.setBounds(0, 0, 1350, 60);
		iconos.setBackground(oscuro);
		
		
		JLabel bacI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/back.png"));
		bacI.setBounds(0, 0, 48, 40);
		JMenuItem back = new JMenuItem("Regresar");
		//back.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/atras.png"));
		back.setFont(new Font("Dialog", Font.BOLD, 27));
		back.setBackground(oscuro);
		back.setForeground(Color.white);
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				
				if(registro.isVisible()){
					registro.setVisible(false);
					inicio.setVisible(true);
					REGISTRO.setVisible(false);
					INICIO.setVisible(true);
					iconos.setVisible(false);
				
				}if(clases.isVisible()){
					clases.setVisible(false);
					CLASES.setVisible(false);
					categorias.setVisible(true);
					CATEGORIAS.setVisible(true);
				}if(ver1.isVisible()){
					ver1.setVisible(false);
					inicio.setVisible(true);
					INICIO.setVisible(true);
				}if(Nm.isVisible()){
					Nm.setVisible(false);
					categorias.setVisible(true);
					VIVO.setVisible(false);
					CATEGORIAS.setVisible(true);
				}if(inicio.isVisible()){
					inicio.setVisible(true);
					INICIO.setVisible(true);
				}
				if(categorias.isVisible()){
					categorias.setVisible(false);
					categorias.setVisible(true); 
<<<<<<< Updated upstream
=======
					CATEGORIAS.setVisible(true);
>>>>>>> Stashed changes
					frame.setBackground(fondo1);
				}
			}	
		});
			JLabel crearI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/crear1.png"));
			crearI.setBounds(0, 0, 48, 40);
			JMenuItem crearC = new JMenuItem("Crear Clase");
			crearC.setFont(new Font("Dialog", Font.BOLD, 27));
			crearC.setBackground(oscuro);
			crearC.setForeground(Color.white);
			crearC.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(clases.isVisible()){
						clases.setVisible(false);
						crearClase.setVisible(true);
					}
				}
			});
			
			
			JLabel envI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/video.png"));
			envI.setBounds(0, 0, 48, 40);
			envI.setBackground(oscuro);
			JMenuItem envivo = new JMenuItem("En vivo");
			envivo.setFont(new Font("Dialog", Font.BOLD, 27));
			envivo.setBackground(oscuro);
			envivo.setForeground(Color.white);
			envivo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(inicio.isVisible()){
						inicio.setVisible(true);
						INICIO.setVisible(true);
					}if(registro.isVisible()){
						registro.setVisible(true);
						REGISTRO.setVisible(true);
						envivo.setBackground(Color.DARK_GRAY);
					}if(clases.isVisible()){
						clases.setVisible(false);
						CLASES.setVisible(false);
						Nm.setVisible(true);
						VIVO.setVisible(true);
					}if(ver1.isVisible()){
						ver1.setVisible(true); 
					}if(Nm.isVisible()){
						Nm.setVisible(false);
						menuAct.setVisible(false);
						menuVer.setVisible(false);
						Nm.setVisible(true); 
						VIVO.setVisible(true);
					}if(inicio.isVisible()){
						inicio.setVisible(true);
						INICIO.setVisible(true);
					}if(categorias.isVisible()){
						categorias.setVisible(false);
						CATEGORIAS.setVisible(false);
						Nm.setVisible(true); 
						VIVO.setVisible(true);
					}
					
					
				}
			});
			
			
			JMenuItem categorias1 = new JMenuItem("Categorias");
			JLabel catI = new JLabel();
			categorias1.setBackground(oscuro);
			if(dance){
				catI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/balerina.png"));
			}if(karate){
				catI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/karateI.png"));
			}if(karate && dance){
				catI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/both.png"));
				
			}		
			catI.setBounds(0, 0, 48, 40);
			catI.setBackground(oscuro);
			categorias1.setFont(new Font("Dialog", Font.BOLD, 27));
			categorias1.setForeground(Color.white);
			categorias1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(inicio.isVisible()){
						inicio.setVisible(true);
						INICIO.setVisible(true);
					}if(registro.isVisible()){
						registro.setVisible(true);
						REGISTRO.setVisible(true);
						categorias.setBackground(Color.DARK_GRAY);
					}if(clases.isVisible()){
						clases.setVisible(false);
						categorias.setVisible(true);
						CATEGORIAS.setVisible(true);
					}if(ver1.isVisible()){
						ver1.setVisible(true); 
					}if(Nm.isVisible()){
						Nm.setVisible(false);
						menuAct.setVisible(false);
						menuVer.setVisible(false);
						categorias.setVisible(true); 
						CATEGORIAS.setVisible(true);
					}if(inicio.isVisible()){
						inicio.setVisible(true);
						INICIO.setVisible(true);
					}if(categorias.isVisible()){
						categorias.setVisible(true);
						CATEGORIAS.setVisible(true);
						
					}if(clases.isVisible()){
						clases.setVisible(false);
						categorias.setVisible(true);
						CATEGORIAS.setVisible(true);
						
					}
				}
			});
			JLabel sesI = new JLabel(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/logout.png"));
			sesI.setBackground(oscuro);
			sesI.setBounds(0, 0, 48, 40);
			JMenuItem sesion = new JMenuItem("Cerrar Sesión");
			sesion.setFont(new Font("Dialog", Font.BOLD, 27));
			sesion.setBackground(oscuro);
			sesion.setForeground(Color.WHITE);
			sesion.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(registro.isVisible()){
						registro.setVisible(true);
						REGISTRO.setVisible(true);
						sesion.setBackground(Color.DARK_GRAY); 
					}if(clases.isVisible()){
						clases.setVisible(false);
						inicio.setVisible(true); 
						INICIO.setVisible(true);
					}if(ver1.isVisible()){
						ver1.setVisible(false);
						inicio.setVisible(true); 
					}if(Nm.isVisible()){
						Nm.setVisible(false);
						menuAct.setVisible(false);
						menuVer.setVisible(false);
						inicio.setVisible(true); 
					}if(inicio.isVisible()){
						inicio.setVisible(true);
						INICIO.setVisible(true);
					}if(categorias.isVisible()){
						categorias.setVisible(false);
						CATEGORIAS.setVisible(false);
						inicio.setVisible(true); 
						INICIO.setVisible(true);
					}
					
<<<<<<< Updated upstream
					categorias.setBackground(fondo);
=======
					iconos.setVisible(false);
>>>>>>> Stashed changes
					frame.getContentPane().setBackground(fondo);
				}
			});
				/*home;
	private JPanel inicio;
	private JPanel clases;
	private JPanel ver1;
	private JPanel registro;*/	
		 
			
		/*
		 
		
		JMenu setting = new JMenu("Herramientas");
		setting.setForeground(Color.WHITE);
<<<<<<< Updated upstream
		//setting.setIcon(new ImageIcon("/home/luisa/Desktop/sett.png"));
=======
		//setting.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/sett.png"));
>>>>>>> Stashed changes
		setting.setBackground(Color.GRAY);
		setting.setFont(new Font("Dialog", Font.PLAIN, 27));
		
		
		JMenuItem salir = new JMenuItem("Salir",KeyEvent.VK_A);
<<<<<<< Updated upstream
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
=======
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/eliminate.png"));
>>>>>>> Stashed changes
		salir.setBackground(Color.GRAY);
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Dialog", Font.PLAIN, 22));
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			
			}	
		});
		JMenuItem ayuda = new JMenuItem("Ayuda",KeyEvent.VK_A);
<<<<<<< Updated upstream
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
=======
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/eliminate.png"));
>>>>>>> Stashed changes
		ayuda.setBackground(Color.GRAY);
		ayuda.setForeground(Color.WHITE);
		ayuda.setFont(new Font("Dialog", Font.PLAIN, 22));
		ayuda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			
			}	
		});
		setting.add(ayuda);
		setting.add(sesion);
		setting.add(salir);
		*/
		//iconos.add(setting);
		iconos.add(envI);
		iconos.add(envivo);
		iconos.add(catI);
		iconos.add(categorias1);
		iconos.add(crearI);
		iconos.add(crearC);
		iconos.add(bacI);
		iconos.add(back);
		iconos.add(sesI);
		iconos.add(sesion);
		
		
	}
	public JPanel singIn(JLabel INICIO){
		JPanel inicio = new JPanel();
<<<<<<< Updated upstream
		inicio.setBounds(100, 400, 1141, 1100);
=======
		inicio.setBounds(100, 600, 1141, 1100);
>>>>>>> Stashed changes
		
		inicio.setBackground(fondo);
		inicio.setLayout(null);
		
		
		
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	    System.out.println(Arrays.toString(fontNames));
		
		
		JLabel lblNewLabel = new JLabel("USUARIO: ");
<<<<<<< Updated upstream
		lblNewLabel.setFont(new Font("FreeSerif", Font.BOLD, 31));
		lblNewLabel.setBounds(285, 248, 284, 51);
=======
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel.setBounds(200, 200, 284, 51);
>>>>>>> Stashed changes
		lblNewLabel.setForeground(Color.BLACK);
		inicio.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("CONTRASEÑA: ");
<<<<<<< Updated upstream
		lblNewLabel1.setFont(new Font("FreeSerif", Font.BOLD, 31));
		lblNewLabel1.setForeground(Color.BLACK);
		lblNewLabel1.setBounds(285, 348, 284, 51);
		inicio.add(lblNewLabel1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textField_2.setForeground(Color.GRAY);
		textField_2.setBounds(489, 248, 350, 51);
=======
		lblNewLabel1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel1.setForeground(Color.BLACK);
		lblNewLabel1.setBounds(200, 348, 284, 51);
		inicio.add(lblNewLabel1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 31));
		textField_2.setForeground(Color.GRAY);
		textField_2.setBounds(550, 200, 450, 51);
>>>>>>> Stashed changes
		inicio.add(textField_2);
		textField_2.setColumns(10);
		
		JPasswordField textP= new JPasswordField();
<<<<<<< Updated upstream
		textP.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textP.setForeground(Color.GRAY);
		textP.setBounds(559, 348, 300, 51);
=======
		textP.setFont(new Font("Dialog", Font.BOLD, 31));
		textP.setForeground(Color.GRAY);
		textP.setBounds(550, 348, 450, 51);
>>>>>>> Stashed changes
		inicio.add(textP);
		textP.setColumns(10);
		
		JButton lblNewLabel2 = new JButton("Olvidé mi Contraseña");
<<<<<<< Updated upstream
		lblNewLabel2.setFont(new Font("FreeSerif", Font.BOLD, 28));
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setBackground(fondo);
		lblNewLabel2.setBounds(700, 400, 400, 45);
=======
		lblNewLabel2.setFont(new Font("Century Schoolbook L", Font.BOLD, 31));
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setBackground(fondo);
		lblNewLabel2.setBounds(613, 410, 400, 45);
		lblNewLabel2.setBorder(BorderFactory.createLineBorder(fondo));
>>>>>>> Stashed changes
		lblNewLabel2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				inicio.setVisible(false);
				ver1.setVisible(true);
			}	
		});
		inicio.add(lblNewLabel2);
		inicio.add(textP);
		
		btnIngresar = new JButton("    INGRESAR");
		btnIngresar.setFont(new Font("Dialog", Font.BOLD, 28));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(oscuro);
		btnIngresar.setBounds(168, 680, 300, 70);
		//btnIngresar.setToolTipText("ingresar");
		btnIngresar.setBorder(BorderFactory.createLineBorder(b));
		btnIngresar.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/ingresar.png"));
		btnIngresar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				System.out.println("1. "+textP.getText());
				if(ver(textField_2.getText(),textP.getText())){
					
					inicio.setVisible(false);
					categorias.setVisible(true);
					frame.getContentPane().setBackground(fondo1);
					textField_2.setText(null);
					textP.setText(null);
					iconos.setVisible(true);
					iconos.setBackground(oscuro1);
					iconos.getComponent(0).setBackground(oscuro1);
					iconos.getComponent(1).setBackground(oscuro1);
					iconos.getComponent(2).setBackground(oscuro1);
					iconos.getComponent(3).setBackground(oscuro1);
					iconos.getComponent(4).setBackground(oscuro1);
					iconos.getComponent(5).setBackground(oscuro1);
					iconos.getComponent(8).setBackground(oscuro1);
					iconos.getComponent(9).setBackground(oscuro1);
					iconos.getComponent(0).setVisible(true);
					iconos.getComponent(1).setVisible(true);
					iconos.getComponent(2).setVisible(true);
					iconos.getComponent(3).setVisible(true);
					iconos.getComponent(4).setVisible(true);
					iconos.getComponent(5).setVisible(true);
					iconos.getComponent(8).setVisible(true);
					iconos.getComponent(9).setVisible(true);
					INICIO.setVisible(false);
					CATEGORIAS.setVisible(true);
			
					
				}
			}	
		});
		
		inicio.add(btnIngresar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 28));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(oscuro);
<<<<<<< Updated upstream
		btnRegistrar.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/registrar.png"));
=======
		btnRegistrar.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/registrar.png"));
>>>>>>> Stashed changes
		btnRegistrar.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		btnRegistrar.setBounds(748, 680, 300, 70);
		btnRegistrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				inicio.setVisible(false);
				registro.setVisible(true);
				iconos.setVisible(true);
				iconos.setBackground(fondo);
				iconos.getComponent(0).setVisible(false);
				iconos.getComponent(1).setVisible(false);
				iconos.getComponent(2).setVisible(false);
				iconos.getComponent(3).setVisible(false);
				iconos.getComponent(4).setVisible(false);
				iconos.getComponent(5).setVisible(false);
				iconos.getComponent(8).setVisible(false);
				iconos.getComponent(9).setVisible(false);
				iconos.getComponent(6).setBackground(fondo);
				iconos.getComponent(7).setBackground(fondo);
				iconos.setBorder(BorderFactory.createLineBorder(fondo));
				INICIO.setVisible(false);
				REGISTRO.setVisible(true);
			}	
		});
		inicio.add(btnRegistrar);
		
		return inicio;
	}
	public boolean ver(String usuario,String pasw){
		boolean res = false;
		for(int i =0;i<users.size();i++){
			System.out.println("1."+usuario+"-"+users.get(i).getUser());
			System.out.println("2."+pasw+"-"+users.get(i).getPasword());
			if ((users.get(i).getUser()).equals(usuario) && (users.get(i).getPasword()).equals(pasw)){
				
				res = true;
			}
		}
	
		System.out.println("RES "+res);
		return res;
		
	}
	public ArrayList<Component> categoria(Boolean karate, Boolean dance){
		ArrayList<Component> cat = new ArrayList<Component>();
		
		JLabel clase = new JLabel("CATEGORIAS ");
		clase.setFont(new Font("Dialog", Font.BOLD, 31));
		clase.setForeground(Color.BLACK);
		clase.setBounds(400, 0, 384, 51);
		
		
		JLabel categ = new JLabel("Categoria 1");
		categ.setFont(new Font("Dialog", Font.PLAIN, 28));
		categ.setForeground(Color.BLACK);
		categ.setBounds(10, 10, 174, 51);
		if(!(cats.contains(categ.getText()))){
			cats.add(categ.getText());
		}
		
		JButton cate= new JButton("CATEGORIA 1");
		if(karate){
			cate.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/karate.png"));
		}if(dance){
			cate.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/ballet.png"));
		}if(karate && dance){
			cate.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/karate.png"));
			JButton catg= new JButton("CATEGORIA 2");
			catg.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/ballet.png"));
			catg.setBounds(210, 50,174 ,172);
			catg.setForeground(Color.BLACK);
			catg.setBackground(fondo1);
			catg.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ProbandoAction button
					categorias.setVisible(false);
					clases.setVisible(true);
					CLASES.setVisible(true);
					CATEGORIAS.setVisible(false);
				}	
			});
			
			cat.add(catg);
			JLabel catego = new JLabel("Categoria 2");
			catego.setFont(new Font("Dialog", Font.PLAIN, 28));
			catego.setForeground(Color.BLACK);
			catego.setBackground(fondo1);
			catego.setBounds(210, 10, 174, 51);
			if(!(cats.contains(catego.getText()))){
				cats.add(catego.getText());
			}
			
			
			cat.add(catego);
		}
		cate.setBounds(15, 50,174 ,172);
		cate.setBackground(fondo1);
		cate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				categorias.setVisible(false);
				clases.setVisible(true);
				CLASES.setVisible(true);
				CATEGORIAS.setVisible(false);
			}	
		});
		cat.add(clase);
		cat.add(categ);
		
		cat.add(cate);
		
		return cat;
		
	}
	public ArrayList<Component> clases(){
		ArrayList<Component> clases = new ArrayList<Component>();
		JLabel clase = new JLabel("CLASES ");
		clase.setFont(new Font("Dialog", Font.BOLD, 31));
		clase.setForeground(Color.black);
		clase.setBackground(fondo1);
		clase.setBounds(400, 0, 384, 51);
		
		
		JLabel clase1 = new JLabel("Clase 1 ");
		clase1.setFont(new Font("Dialog", Font.PLAIN, 28));
		clase1.setForeground(oscuro1);
<<<<<<< Updated upstream
		clase1.setBounds(10, 10, 174, 51);
		
		JButton c1= new JButton("CLASE 1");
		c1.setBackground(fondo1);
		c1.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/icon.png"));
		c1.setBounds(15, 50,174 ,172);
=======
		clase1.setBounds(10, 30, 174, 51);
		
		JButton c1= new JButton("CLASE 1");
		c1.setBackground(fondo1);
		c1.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/icon.png"));
		c1.setBounds(15, 70,174 ,172);
>>>>>>> Stashed changes
		
		clases.add(clase1);
		clases.add(clase);
		clases.add(c1);
		
		
		return clases;
	}
	public JPanel Olvide(){
		JPanel ver = new JPanel();
<<<<<<< Updated upstream
		ver.setBounds(100, 400, 1141, 1100);
=======
		ver.setBounds(100, 600, 1141, 1100);
>>>>>>> Stashed changes
		ver.setBackground(fondo);
		ver.setLayout(null);
		
		JLabel correo = new JLabel("INGRESE CORREO: ");
		correo.setFont(new Font("Dialog", Font.BOLD, 31));
		correo.setForeground(Color.WHITE);
		correo.setBounds(70, 248, 384, 51);
		
		
		JTextField textFieldC = new JTextField();
		textFieldC.setFont(new Font("Dialog", Font.BOLD, 31));
		textFieldC.setBounds(400, 248, 550, 51);
		
		
		
		JLabel ctx = new JLabel("NUEVA CONTRASEÑA: ");
		ctx.setFont(new Font("Dialog", Font.BOLD, 31));
		ctx.setForeground(Color.WHITE);
		ctx.setBounds(50, 448, 384, 51);
		
		
		JTextField textctx = new JTextField();
		textctx.setFont(new Font("Dialog", Font.BOLD, 31));
		textctx.setBounds(400, 448, 550, 51);
		
		
		JButton veri = new JButton("VERIFICAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		veri.setBackground(oscuro);
		veri.setBounds(668, 680, 250, 100);
		veri.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				ver.setVisible(false);
				inicio.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ya se cambió su pasword", "VERIFICACION", JOptionPane.INFORMATION_MESSAGE);
			}	
		});
		
		
		atras = new JButton("");
		atras.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/atras.png"));
		atras.setBounds(900, 1000,90, 88);
		atras.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				ver.setVisible(false);
				inicio.setVisible(true);
			}		
		});
		
		ver.add(correo);
		ver.add(textFieldC);
		ver.add(ctx);
		ver.add(textctx);
		ver.add(veri);
		ver.add(atras);
		
		return ver;
		
	}
	public JPanel registro(JLabel REGISTRO){
		JPanel reg = new JPanel();
<<<<<<< Updated upstream
		reg.setBounds(104, 402, 1141, 1100);
=======
		reg.setBounds(100, 600, 1141, 1100);
>>>>>>> Stashed changes
		reg.setBackground(fondo);
		reg.setLayout(null);
		
		
		REGISTRO.setVisible(true);
		JLabel correo = new JLabel("CORREO: ");
<<<<<<< Updated upstream
		correo.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		correo.setForeground(Color.BLACK);
		correo.setBounds(10, 248, 284, 51);
=======
		correo.setFont(new Font("Dialog", Font.PLAIN, 31));
		correo.setForeground(Color.BLACK);
		correo.setBounds(0, 48, 284, 51);
>>>>>>> Stashed changes
		reg.add(correo);
		
		JTextField textcorreo = new JTextField();
		textcorreo.setFont(new Font("Dialog", Font.BOLD, 31));
		textcorreo.setBounds(400, 48, 470, 51);
		reg.add(textcorreo);
		
		
		JLabel user = new JLabel("USUARIO: ");
<<<<<<< Updated upstream
		user.setFont(new Font("FreeSerif", Font.PLAIN,31));
		user.setForeground(Color.BLACK);
		user.setBounds(10, 348, 284, 51);
=======
		user.setFont(new Font("Dialog", Font.PLAIN,31));
		user.setForeground(Color.BLACK);
		user.setBounds(0, 148, 284, 51);
>>>>>>> Stashed changes
		reg.add(user);
		
		JTextField textuser = new JTextField();
		textuser.setFont(new Font("Dialog", Font.BOLD, 31));
		textuser.setBounds(400, 148, 470, 51);
		reg.add(textuser);
		
		JLabel name = new JLabel("NOMBRE: ");
<<<<<<< Updated upstream
		name.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		name.setForeground(Color.BLACK);
		name.setBounds(10, 448, 284, 51);
=======
		name.setFont(new Font("Dialog", Font.PLAIN, 31));
		name.setForeground(Color.BLACK);
		name.setBounds(0, 248, 284, 51);
>>>>>>> Stashed changes
		reg.add(name);
		
		JTextField textname = new JTextField();
		textname.setFont(new Font("Dialog", Font.BOLD, 31));
		textname.setBounds(400, 248, 470, 51);
		reg.add(textname);
		
		
		JLabel age = new JLabel("EDAD: ");
<<<<<<< Updated upstream
		age.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		age.setForeground(Color.BLACK);
		age.setBounds(10, 548, 284, 51);
		reg.add(age);
		
		JTextField textage = new JTextField();
		textage.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textage.setBounds(300, 548, 80, 51);
		reg.add(textage);
		
		JLabel pasw = new JLabel("CONTRASEÑA: ");
		pasw.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		pasw.setForeground(Color.BLACK);
		pasw.setBounds(10, 648, 284, 51);
=======
		age.setFont(new Font("Dialog", Font.PLAIN, 31));
		age.setForeground(Color.BLACK);
		age.setBounds(0, 348, 284, 51);
		reg.add(age);
		
		JTextField textage = new JTextField();
		textage.setFont(new Font("Dialog", Font.BOLD, 31));
		textage.setBounds(400, 348, 60, 51);
		reg.add(textage);
		
		JLabel pasw = new JLabel("CONTRASEÑA: ");
		pasw.setFont(new Font("Dialog", Font.PLAIN, 31));
		pasw.setForeground(Color.BLACK);
		pasw.setBounds(0, 448, 284, 51);
>>>>>>> Stashed changes
		reg.add(pasw);
		
		JPasswordField textpasw = new JPasswordField();
		textpasw.setFont(new Font("Dialog", Font.BOLD, 31));
		textpasw.setBounds(400, 448, 470, 51);
		reg.add(textpasw);
		
		
		JLabel paswVer = new JLabel("REPITA CONTRASEÑA: ");
<<<<<<< Updated upstream
		paswVer.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		paswVer.setForeground(Color.BLACK);
		paswVer.setBounds(10, 748, 384, 51);
		reg.add(paswVer);
		
		JPasswordField textpaswVer = new JPasswordField();
		textpaswVer.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textpaswVer.setBounds(300, 818, 350, 51);
		reg.add(textpaswVer);
		
		JLabel gen = new JLabel("Genero: ");
		gen.setFont(new Font("FreeSerif", Font.PLAIN, 35));
		gen.setForeground(new Color(14, 102, 85));
		gen.setBounds(760, 362, 384, 51);
		reg.add(gen);
		JRadioButton fem = new JRadioButton("Femenino");
		fem.setBounds(760, 402, 170, 23);
		fem.setFont(new Font("Dialog", Font.PLAIN,28));
		fem.setBackground(fondo);
		fem.setForeground(Color.black);
		reg.add(fem);
		JRadioButton mas = new JRadioButton("Masculino");
		mas.setBounds(760, 442, 170, 23);
		mas.setFont(new Font("Dialog", Font.PLAIN,28));
=======
		paswVer.setFont(new Font("Dialog", Font.PLAIN, 31));
		paswVer.setForeground(Color.BLACK);
		paswVer.setBounds(0, 548, 384, 51);
		reg.add(paswVer);
		
		JPasswordField textpaswVer = new JPasswordField();
		textpaswVer.setFont(new Font("Dialog", Font.BOLD, 31));
		textpaswVer.setBounds(400, 548, 470, 51);
		reg.add(textpaswVer);
		
		
		
		JLabel gen = new JLabel("GENERO: ");
		gen.setFont(new Font("Dialog", Font.PLAIN, 31));
		gen.setForeground(new Color(14, 102, 85));
		gen.setBounds(500, 348, 384, 51);
		gen.setForeground(Color.WHITE);
		reg.add(gen);
		ButtonGroup genero = new ButtonGroup();
		JRadioButtonMenuItem fem = new JRadioButtonMenuItem("Femenino");
		fem.setBounds(700, 365, 190, 23);
		fem.setFont(new Font("Dialog", Font.PLAIN,31));
		fem.setBackground(fondo);
		fem.setForeground(Color.BLACK);
		reg.add(fem);
		genero.add(fem);
		JRadioButtonMenuItem mas = new JRadioButtonMenuItem("Masculino");
		mas.setBounds(900, 365, 190, 23);
		mas.setFont(new Font("Dialog", Font.PLAIN,31));
>>>>>>> Stashed changes
		mas.setBackground(fondo);
		mas.setForeground(Color.BLACK);
		reg.add(mas);
		genero.add(mas);
		
		if (mas.isSelected()){
			fem.setSelected(false);
			
		}else if (fem.isSelected()){
			mas.setSelected(false);
		}
		
		JLabel mensaje = new JLabel("<html>Ahora elije el deporte que gustes!!<html>");
		mensaje.setBounds(500, 600, 600, 200);
		mensaje.setForeground(Color.white);
		mensaje.setFont(new Font("Century Schoolbook L", Font.BOLD, 31));
		reg.add(mensaje);
		
		
<<<<<<< Updated upstream
		karateI = new JRadioButton("Karate");
		karateI.setBounds(760, 662, 149, 23);
		karateI.setFont(new Font("Dialog", Font.PLAIN,28));
		karateI.setBackground(fondo);
		karateI.setForeground(Color.black);
		reg.add(karateI);
		ballet = new JRadioButton("danza");
		ballet.setBounds(760, 702, 149, 23);
		ballet.setFont(new Font("Dialog", Font.PLAIN,28));
=======
		karateI = new JCheckBox("Karate");
		karateI.setBounds(600,800, 149, 23);
		karateI.setFont(new Font("Dialog", Font.PLAIN,31));
		karateI.setBackground(fondo);
		karateI.setForeground(Color.black);
		reg.add(karateI);
		ballet = new JCheckBox("danza");
		ballet.setBounds(800,800, 149, 23);
		ballet.setFont(new Font("Dialog", Font.PLAIN,31));
>>>>>>> Stashed changes
		ballet.setBackground(fondo);
		ballet.setForeground(Color.black);
		reg.add(ballet);
		
		
		
		
		JButton veri = new JButton("    REGISTRAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		
		veri.setBackground(oscuro);
<<<<<<< Updated upstream
		veri.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/registrar.png"));
=======
		veri.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/registrar.png"));
>>>>>>> Stashed changes
		veri.setBorder(BorderFactory.createLineBorder(b));
		veri.setBounds(100, 700, 300, 70);
		veri.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Usuario nuevo = new Usuario();
				nuevo.setEmail(textcorreo.getText());
				nuevo.setName(textname.getText());
				nuevo.setUser(textuser.getText());
				nuevo.setPasword(textpasw.getText(), textpaswVer.getText());
				//nuevo.setAge(Integer.valueOf(textage.getText()));
				nuevo.setKarate(karateI.isSelected());
				nuevo.setDanza(ballet.isSelected());
				//nuevo.completo();
				users.add(nuevo);
				System.out.println(users);
				karate = karateI.isSelected();
				dance = ballet.isSelected();
				System.out.println(nuevo.completo+"-"+nuevo.completo);
				//ProbandoAction button
				if(nuevo.verde){
					reg.setVisible(false);
					categorias.setVisible(true);
					frame.getContentPane().setBackground(fondo1);
					//JOptionPane.showMessageDialog(null, "SUCCES", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
					//JOptionPane.showMessageDialog(categorias,"SUCCES", "REGISTRO", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/registrar.png"));
					users.add(nuevo);
					
					textcorreo.setText(null);
					textname.setText(null);
					textuser.setText(null);
					textpasw.setText(null);
					textpaswVer.setText(null);
					karateI.setSelected(false);
					ballet.setSelected(false);
					iconos.setVisible(true);
					iconos.setBackground(oscuro1);
					iconos.getComponent(0).setBackground(oscuro1);
					iconos.getComponent(0).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(1).setBackground(oscuro1);
					iconos.getComponent(1).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(2).setBackground(oscuro1);
					iconos.getComponent(2).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(3).setBackground(oscuro1);
					iconos.getComponent(3).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(4).setBackground(oscuro1);
					iconos.getComponent(4).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(5).setBackground(oscuro1);
					iconos.getComponent(5).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(6).setBackground(oscuro1);
					iconos.getComponent(6).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(7).setBackground(oscuro1);
					iconos.getComponent(7).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(8).setBackground(oscuro1);
					iconos.getComponent(8).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(9).setBackground(oscuro1);
					iconos.getComponent(9).setFont(new Font("Dialog",Font.BOLD,27));
					iconos.getComponent(0).setVisible(true);
					iconos.getComponent(1).setVisible(true);
					iconos.getComponent(2).setVisible(true);
					iconos.getComponent(3).setVisible(true);
					iconos.getComponent(4).setVisible(true);
					iconos.getComponent(5).setVisible(true);
					iconos.getComponent(8).setVisible(true);
					iconos.getComponent(9).setVisible(true);
					REGISTRO.setVisible(false);
					CATEGORIAS.setVisible(true);
					
				}else{
					reg.setVisible(true);
					
				}
			}	
		});
		
		
		reg.add(veri);
		
		return reg;
	}public JPanel menuA(){
		JPanel mA = new JPanel();
<<<<<<< Updated upstream
		mA.setBounds(80, 500, 1141, 1100);
=======
		mA.setBounds(80, 600, 1141, 1100);
>>>>>>> Stashed changes
		mA.setBackground(fondo1);
		
		mA.setLayout(null);
		
		
		String link = "https://www.twitch.tv/hcikb";
		JLabel instrucciones = new JLabel("<html>Para poder observar su video en vivo, ingrese al siguiente link: <BR>"+link+"<BR>o ingresa desde su telefono escaneando el siguiente codigo QR:");
<<<<<<< Updated upstream
		instrucciones.setBounds(200, 100, 900, 400);
=======
		instrucciones.setBounds(200, 0, 900, 400);
>>>>>>> Stashed changes
		instrucciones.setFont(new Font("Dialog", Font.PLAIN, 32));
		instrucciones.setForeground(Color.WHITE);
		
		codigoQR(link);
		
		String archiv = System.getProperty("user.home")+"/codidodemo.png";
		
		JLabel qrC= new JLabel("");
		System.out.println(archiv);
		qrC.setIcon(new ImageIcon(archiv));
		qrC.setBounds(300, 260,600,600);
		
		mA.add(instrucciones);
		mA.add(qrC);
		
		JButton ver = new JButton("Empezar");
<<<<<<< Updated upstream
		ver.setBounds(400, 950, 300, 60);
=======
		ver.setBounds(400, 850, 300, 60);
>>>>>>> Stashed changes
		ver.setBackground(oscuro1);
		ver.setFont(new Font("Dialog", Font.BOLD, 28));
		ver.setForeground(Color.WHITE);
		ver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
					pop.setVisible(true);
				
			}
		});
		
		mA.add(ver);
		
		return mA;
		
		
	}
	public void codigoQR(String link){
		int udm = 0;
		int resol = 78;
		float mi = 1.000f;
		float md = 1.000f;
		float ms = 1.000f;
		float min = 1.000f;
		int rot = 0;
		float tam = 18.000f;
		
		
		
		try{
			QRCode cod = new QRCode();
			cod.setData(link);
			cod.setDataMode(QRCode.MODE_BYTE);
			
			cod.setUOM(udm);
			cod.setLeftMargin(mi);
			cod.setResolution(resol);
			cod.setRightMargin(md);
			cod.setTopMargin(ms);
			cod.setBottomMargin(min);;
			cod.setRotate(rot);
			cod.setModuleSize(tam);
			
			String archiv = System.getProperty("user.home")+"/codidodemo.png";
			cod.renderBarcode(archiv);
			
			
			
			
			
		}catch(Exception e){
			System.out.println("NO FUNCIONA BRUTA");
			
		}
	}
	public JPanel codigoQRVideo(){
		JPanel mqr = new JPanel();
<<<<<<< Updated upstream
		mqr.setBounds(100, 400, 1141, 1100);
=======
		mqr.setBounds(100, 600, 1141, 1100);
>>>>>>> Stashed changes
		mqr.setBackground(fondo1);
		mqr.setLayout(null);
		
		
		String link = "https://www.twitch.tv/hcikb/videos/all";
		JLabel mens = new JLabel("<html>Para ver los videos disponibles en vivo <BR>Ingrese al siguiente link:<BR>"+link+"<BR> o escanee el siguiente codigo QR: <html>");
		mens.setFont(new Font("Dialog", Font.PLAIN, 32));
		mens.setForeground(Color.WHITE);
<<<<<<< Updated upstream
		mens.setBounds(300, 200, 600, 400);
=======
		mens.setBounds(300, 0, 600, 400);
>>>>>>> Stashed changes
		
		mqr.add(mens);
		
		
		
		
		
		codigoQR(link);
		
		String archiv = System.getProperty("user.home")+"/codidodemo.png";
		
		JLabel qrC= new JLabel("");
		System.out.println(archiv);
		qrC.setIcon(new ImageIcon(archiv));
		qrC.setBounds(300, 310,600,600);
		
		
		mqr.add(qrC);
		
		
		
		return mqr;
	}
	public JPanel menuVivo() throws IOException{
		JPanel men = new JPanel();
<<<<<<< Updated upstream
		men.setBounds(100, 500, 1100, 100);
=======
		men.setBounds(100, 520, 1100, 100);
>>>>>>> Stashed changes
		men.setBackground(fondo1);
		men.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		men.setLayout(null);
		
		
		
		
		JButton ver = new JButton("VER EN VIVO");
<<<<<<< Updated upstream
		ver.setBounds(80, 50, 400, 60);
		ver.setBackground(oscuro1);
		ver.setFont(new Font("Dialog", Font.BOLD, 31));
		ver.setForeground(Color.black);
=======
		ver.setBounds(80, 25, 400, 60);
		ver.setBackground(oscuro1);
		ver.setFont(new Font("Dialog", Font.BOLD, 31));
		ver.setForeground(Color.WHITE);
>>>>>>> Stashed changes
		ver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				menuAct.setVisible(false);
				menuVer.setVisible(true);
			}
		});
		//ver.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	
		
		JButton grabar = new JButton("GRABAR EN VIVO");
<<<<<<< Updated upstream
		grabar.setBounds(630, 50, 400, 60);
		grabar.setBackground(oscuro1);
		grabar.setFont(new Font("Dialog", Font.BOLD, 31));
		grabar.setForeground(Color.black);
=======
		grabar.setBounds(630, 25, 400, 60);
		grabar.setBackground(oscuro1);
		grabar.setFont(new Font("Dialog", Font.BOLD, 31));
		grabar.setForeground(Color.WHITE);
>>>>>>> Stashed changes
		//grabar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		grabar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				menuVer.setVisible(false);
				menuAct.setVisible(true);
			}
		});
		
		
	
		men.add(ver);
		men.add(grabar);
		
		
		
		return men;
	}

	
	public JPanel crearClase(){
		JPanel crear = new JPanel();
		crear.setBounds(100, 600, 1141, 1100);
		crear.setBackground(fondo1);
		crear.setLayout(null);
		
		JLabel nombre1 = new JLabel("NOMBRE: ");
		nombre1.setFont(new Font("Dialog", Font.PLAIN, 31));
		nombre1.setForeground(Color.WHITE);
		nombre1.setBounds(100, 48, 284, 51);
		crear.add(nombre1);
		
		JTextField nombre2 = new JTextField();
		nombre2.setFont(new Font("Dialog", Font.BOLD, 31));
		nombre2.setBounds(390, 48, 350, 51);
		
		crear.add(nombre2);
		
		
		JLabel categorias2 = new JLabel("CATEGORIA: ");
		categorias2.setFont(new Font("Dialog", Font.PLAIN,31));
		categorias2.setForeground(Color.WHITE);
		categorias2.setBounds(100, 148, 284, 51);
		crear.add(categorias2);
		/*
		JTextField textuser = new JTextField();
		textuser.setFont(new Font("Dialog", Font.BOLD, 31));
		textuser.setBounds(300, 348, 350, 51);
		crear.add(textuser);
		*/
		
		cats.add("Otros");
		String[] cats1 = cats.toArray(new String[0]);
		JComboBox categorias1 = new JComboBox(cats1);
		categorias1.setFont(new Font("Dialog", Font.PLAIN,31));
		categorias1.setForeground(oscuro1);
		categorias1.setBounds(390, 148, 350, 51);
		crear.add(categorias1);
		
		
		JLabel descripcion1 = new JLabel("DESCRIPCIÓN: ");
		descripcion1.setFont(new Font("Dialog", Font.PLAIN, 31));
		descripcion1.setForeground(Color.WHITE);
		descripcion1.setBounds(100, 248, 284, 51);
		crear.add(descripcion1);
		
		JTextArea descripcion2 = new JTextArea();
		descripcion2.setFont(new Font("Dialog", Font.BOLD, 31));
		descripcion2.setBounds(390, 248, 600, 400);
		JScrollPane bar = new JScrollPane();
		descripcion2.add(bar);
		crear.add(descripcion2);
		
		JButton crear1 = new JButton("GRABAR CLASE");
		crear1.setFont(new Font("Dialog", Font.BOLD, 31));
		crear1.setBounds(400, 750, 300, 50);
		crear1.setBackground(oscuro1);
		crear1.setForeground(Color.WHITE);
		crear1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					Process proc = Runtime.getRuntime().exec("streamer -t 0:0:30 -c /dev/video1 -f rgb24 -r 3  -o   nuevaclase"+i+".avi");
					
					System.out.println(proc.getOutputStream().toString());
					pop.setVisible(false);
					if(numero1==850){
						num1 += (172+61+25);
						num2 += (172+61+25);
						numero1 = 10;
						numero2 = 15;
					}else{
						numero1+=210;
						numero2+=210;
					}
					
					JLabel clase1 = new JLabel(nombre2.getText());
					clase1.setFont(new Font("Dialog", Font.PLAIN, 28));
					clase1.setForeground(oscuro1);
					clase1.setBounds(numero1, num1, 174, 51);
					
					JButton c1= new JButton(nombre2.getText());
					c1.setBackground(fondo1);
					c1.setIcon(new ImageIcon("/home/luisa/Desktop/Desktop/UVG/HCI/proyecto/icon.png"));
					c1.setBounds(numero2, num2,174 ,172);
					
					clases.add(clase1);
					clases.add(c1);
					crearClase.setVisible(false);
					clases.setVisible(true);
				
				}catch(IOException r){
					System.out.println("NOOOOOOO");
				}
			
				try{
					Timer time = new Timer();
					
					Process proc1 = Runtime.getRuntime().exec("camorama");
					Thread.sleep(30000);
					
					proc1.exitValue();
				
				}catch(IOException r){
					System.out.println("NOOOOOOO");
				} catch (InterruptedException e1) {
					//TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("TIEMPO NO FUNCIONO");
				}
			}
				
		});
		crear.add(crear1);
		
		return crear;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

