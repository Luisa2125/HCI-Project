import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Graphics;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
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

import com.barcodelib.barcode.QRCode;


public class DeskApp {
	
	
	
	
	private JFrame frame;
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
	private JPanel home;
	private JPanel inicio;
	private JPanel clases;
	private JPanel ver1;
	private JPanel registro;
	private boolean karate = true;
	private boolean dance = false;
	private JRadioButton karateI;
	private JRadioButton ballet;
	private JPanel Nm;
	private JPanel menuAct;
	private JPanel menuVer;
	private ArrayList<Usuario> users= new ArrayList<Usuario>();
	private JMenuBar iconos;
	Color b = new Color(10,250,255);
	

	

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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		menu();
		inicio = singIn();
		inicio.setVisible(true);

		home = home();
		
		clases = new JPanel();
		clases.setBounds(0, 500, 1500, 1600);
		clases.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		clases.setBackground(Color.BLACK);
		clases.setLayout(null);
		clases.add(categoria());
		
		
		
		
		
		ver1 = Olvide();
		registro = registro();
		Nm = menuVivo();
		menuAct = menuA();
		menuVer = codigoQRVideo();
		
		
		
		
		home.setVisible(false);
		clases.setVisible(false);
		ver1.setVisible(false);
		registro.setVisible(false);
		Nm.setVisible(false);
		menuAct.setVisible(false);
		menuVer.setVisible(false);
		
		
		frame.getContentPane().add(inicio);	
		frame.getContentPane().add(home);
		frame.getContentPane().add(clases);
		frame.getContentPane().add(ver1);
		frame.getContentPane().add(registro);
		frame.getContentPane().add(Nm);
		frame.getContentPane().add(menuAct);
		frame.getContentPane().add(menuVer);
		
		frame.getContentPane().add(iconos);
		label = new JLabel("");
		label.setIcon(new ImageIcon("/home/luisa/logo.png"));
		label.setBounds(515, 150, 252, 272);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 1300, 1550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void menu(){
		iconos = new JMenuBar();
		iconos.setBounds(0, 0, 1300, 40);
		iconos.setBackground(Color.BLACK);
		
		
		
		JMenuItem back = new JMenuItem("                         Atras",KeyEvent.VK_A);
		//back.setIcon(new ImageIcon("/home/luisa/Desktop/atras.png"));
		back.setFont(new Font("Dialog", Font.PLAIN, 22));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				
				if(registro.isVisible()){
					registro.setVisible(false);
					inicio.setVisible(true);
				}if(home.isVisible()){
					home.setVisible(false);
					inicio.setVisible(true);
				}if(clases.isVisible()){
					clases.setVisible(false);
					home.setVisible(true);
				}if(ver1.isVisible()){
					ver1.setVisible(false);
					inicio.setVisible(true);
				}if(Nm.isVisible()){
					Nm.setVisible(false);
					home.setVisible(true);
				}if(inicio.isVisible()){
					inicio.setVisible(true);
				}
				/*home;
	private JPanel inicio;
	private JPanel clases;
	private JPanel ver1;
	private JPanel registro;*/	
		 
			
			}	
		});
		JMenuItem home = new JMenuItem("                         Menu",KeyEvent.VK_A);
		//home.setIcon(new ImageIcon("/home/luisa/Desktop/home.png"));
		home.setFont(new Font("Dialog", Font.PLAIN, 22));
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				if(registro.isVisible()){
					registro.setVisible(false);
					home.setVisible(true); 
				}if(home.isVisible()){
					home.setVisible(false);
					home.setVisible(true); 
				}if(clases.isVisible()){
					clases.setVisible(false);
					home.setVisible(true); 
				}if(ver1.isVisible()){
					ver1.setVisible(false);
					home.setVisible(true); 
				}if(Nm.isVisible()){
					Nm.setVisible(false);
					menuAct.setVisible(false);
					menuVer.setVisible(false);
					home.setVisible(true); 
				}
				
				
			
			}	
		});
		JMenuItem el = new JMenuItem("                         Eliminar",KeyEvent.VK_A);
		el.setForeground(Color.WHITE);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
		el.setBackground(Color.BLACK);
		el.setFont(new Font("Dialog", Font.PLAIN, 22));
		
		JMenu setting = new JMenu("Herramientas");
		setting.setForeground(Color.WHITE);
		//setting.setIcon(new ImageIcon("/home/luisa/Desktop/sett.png"));
		setting.setBackground(Color.BLACK);
		setting.setFont(new Font("Dialog", Font.PLAIN, 22));
		
		JMenuItem sesion = new JMenuItem("Cerrar Cuenta",KeyEvent.VK_A);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
		sesion.setBackground(Color.BLACK);
		sesion.setForeground(Color.WHITE);
		sesion.setFont(new Font("Dialog", Font.PLAIN, 22));
		sesion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				if(registro.isVisible()){
					registro.setVisible(false);
					inicio.setVisible(true); 
				}if(home.isVisible()){
					home.setVisible(false);
					inicio.setVisible(true); 
				}if(clases.isVisible()){
					clases.setVisible(false);
					inicio.setVisible(true); 
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
				}
				 
			
			}	
		});
		JMenuItem salir = new JMenuItem("Salir",KeyEvent.VK_A);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
		salir.setBackground(Color.BLACK);
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Dialog", Font.PLAIN, 22));
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			
			}	
		});
		JMenuItem ayuda = new JMenuItem("Ayuda",KeyEvent.VK_A);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
		ayuda.setBackground(Color.BLACK);
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
		
		iconos.add(setting);
		iconos.add(home);
		iconos.add(back);
		iconos.add(el);
		
		
	}
	public JPanel home(){
		JPanel home = new JPanel();
		home.setBounds(150, 502, 1000, 1000);
		home.setBackground(Color.BLACK);
		home.setLayout(null);
		home.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		mclases = new JButton("MIS CLASES");
		mclases.setFont(new Font("Dialog", Font.BOLD, 29));
		mclases.setForeground(b);
		mclases.setBackground(Color.BLACK);
		mclases.setBounds(350, 230, 300, 70);
		//mclases.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		mclases.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				home.setVisible(false);
				clases.setVisible(true);
			}	
		});
		home.add(mclases);
		
		importar = new JButton("IMPORTAR");
		importar.setFont(new Font("Dialog", Font.BOLD, 29));
		importar.setForeground(Color.GREEN);
		importar.setBackground(Color.BLACK);
		importar.setBounds(390, 430, 210, 70);
		//importar.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		home.add(importar);
		
		vivo = new JButton("EN VIVO");
		vivo.setFont(new Font("Dialog", Font.BOLD, 29));
		vivo.setForeground(b);
		vivo.setBackground(Color.BLACK);
		//vivo.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		vivo.setBounds(390, 630, 210, 70);
		vivo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				home.setVisible(false);
				Nm.setVisible(true);
			}	
		});
		home.add(vivo);
		
		
		
		
		
	
		
		
	
		
		return home;
		
	}
	public JPanel singIn(){
		JPanel inicio = new JPanel();
		inicio.setBounds(100, 400, 1141, 1100);
		inicio.setBackground(Color.BLACK);
		inicio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO: ");
		lblNewLabel.setFont(new Font("FreeSerif", Font.BOLD, 31));
		lblNewLabel.setBounds(285, 248, 284, 51);
		lblNewLabel.setForeground(Color.WHITE);
		inicio.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("CONTRASEÑA: ");
		lblNewLabel1.setFont(new Font("FreeSerif", Font.BOLD, 31));
		lblNewLabel1.setForeground(Color.WHITE);
		lblNewLabel1.setBounds(285, 348, 284, 51);
		inicio.add(lblNewLabel1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textField_2.setForeground(Color.BLACK);
		textField_2.setBounds(489, 248, 350, 51);
		inicio.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textField_3.setForeground(Color.BLACK);
		textField_3.setBounds(559, 348, 300, 51);
		inicio.add(textField_3);
		textField_3.setColumns(10);
		
		JButton lblNewLabel2 = new JButton("Olvidé mi Contraseña");
		lblNewLabel2.setFont(new Font("FreeSerif", Font.BOLD, 25));
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setBackground(Color.BLACK);
		lblNewLabel2.setBounds(700, 399, 300, 45);
		lblNewLabel2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				inicio.setVisible(false);
				ver1.setVisible(true);
			}	
		});
		
		inicio.add(lblNewLabel2);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Dialog", Font.BOLD, 25));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.BLACK);
		btnIngresar.setBounds(168, 680, 200, 50);
		
		btnIngresar.setBorder(BorderFactory.createLineBorder(b));
		btnIngresar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				//if(ver(textField_2.getText(),textField_3.getText())){
					inicio.setVisible(false);
					home.setVisible(true);
					textField_2.setText(null);
					textField_3.setText(null);
				//}
			}	
		});
		inicio.add(btnIngresar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 25));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		btnRegistrar.setBounds(748, 680, 300, 50);
		btnRegistrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				inicio.setVisible(false);
				registro.setVisible(true);
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
	public JButton categoria(){
		JButton cate= new JButton("CATEGORIA 1");
		cate.setIcon(new ImageIcon("/home/luisa/logo.png"));
		cate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				inicio.setVisible(false);
				registro.setVisible(true);
			}	
		});
		return cate;
		
	}
	public JPanel Olvide(){
		JPanel ver = new JPanel();
		ver.setBounds(100, 400, 1141, 1100);
		ver.setBackground(Color.BLACK);
		ver.setLayout(null);
		
		JLabel correo = new JLabel("INGRESE CORREO: ");
		correo.setFont(new Font("FreeSerif", Font.BOLD, 31));
		correo.setForeground(Color.WHITE);
		correo.setBounds(70, 248, 384, 51);
		
		
		JTextField textFieldC = new JTextField();
		textFieldC.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textFieldC.setBounds(400, 248, 550, 51);
		
		
		
		JLabel ctx = new JLabel("NUEVA CONTRASEÑA: ");
		ctx.setFont(new Font("FreeSerif", Font.BOLD, 31));
		ctx.setForeground(Color.WHITE);
		ctx.setBounds(50, 448, 384, 51);
		
		
		JTextField textctx = new JTextField();
		textctx.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textctx.setBounds(400, 448, 550, 51);
		
		
		JButton veri = new JButton("VERIFICAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		veri.setBackground(Color.BLACK);
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
		atras.setIcon(new ImageIcon("/home/luisa/Desktop/atras.png"));
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
	public JPanel registro(){
		JPanel reg = new JPanel();
		reg.setBounds(104, 402, 1141, 1100);
		reg.setBackground(Color.BLACK);
		reg.setLayout(null);
		
		JLabel correo = new JLabel("CORREO: ");
		correo.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		correo.setForeground(Color.WHITE);
		correo.setBounds(10, 248, 284, 51);
		reg.add(correo);
		
		JTextField textcorreo = new JTextField();
		textcorreo.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textcorreo.setBounds(300, 248, 350, 51);
		reg.add(textcorreo);
		
		
		JLabel user = new JLabel("USUARIO: ");
		user.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		user.setForeground(Color.WHITE);
		user.setBounds(10, 348, 284, 51);
		reg.add(user);
		
		JTextField textuser = new JTextField();
		textuser.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textuser.setBounds(300, 348, 350, 51);
		reg.add(textuser);
		
		JLabel name = new JLabel("NOMBRE: ");
		name.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		name.setForeground(Color.WHITE);
		name.setBounds(10, 448, 284, 51);
		reg.add(name);
		
		JTextField textname = new JTextField();
		textname.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textname.setBounds(300, 448, 350, 51);
		reg.add(textname);
		
		
		JLabel age = new JLabel("EDAD: ");
		age.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		age.setForeground(Color.WHITE);
		age.setBounds(10, 548, 284, 51);
		reg.add(age);
		
		JTextField textage = new JTextField();
		textage.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textage.setBounds(300, 548, 350, 51);
		reg.add(textage);
		
		JLabel pasw = new JLabel("CONTRASEÑA: ");
		pasw.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		pasw.setForeground(Color.WHITE);
		pasw.setBounds(10, 648, 284, 51);
		reg.add(pasw);
		
		JTextField textpasw = new JTextField();
		textpasw.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textpasw.setBounds(300, 648, 350, 51);
		reg.add(textpasw);
		
		
		JLabel paswVer = new JLabel("REPITA CONTRASEÑA: ");
		paswVer.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		paswVer.setForeground(Color.WHITE);
		paswVer.setBounds(10, 748, 384, 51);
		reg.add(paswVer);
		
		JTextField textpaswVer = new JTextField();
		textpaswVer.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textpaswVer.setBounds(300, 748, 350, 51);
		reg.add(textpaswVer);
		
		JLabel gen = new JLabel("Genero: ");
		gen.setFont(new Font("FreeSerif", Font.PLAIN, 27));
		gen.setForeground(Color.WHITE);
		gen.setBounds(760, 362, 384, 51);
		reg.add(gen);
		JRadioButton fem = new JRadioButton("Femenino");
		fem.setBounds(760, 402, 149, 23);
		fem.setFont(new Font("Dialog", Font.PLAIN,22));
		fem.setBackground(Color.BLACK);
		fem.setForeground(Color.GREEN);
		reg.add(fem);
		JRadioButton mas = new JRadioButton("Masculino");
		mas.setBounds(760, 442, 149, 23);
		mas.setFont(new Font("Dialog", Font.PLAIN,22));
		mas.setBackground(Color.BLACK);
		mas.setForeground(Color.GREEN);
		reg.add(mas);
		if (mas.isSelected()){
			fem.setSelected(false);
			
		}else if (fem.isSelected()){
			mas.setSelected(false);
		}
		
		
		karateI = new JRadioButton("Karate");
		karateI.setBounds(760, 662, 149, 23);
		karateI.setFont(new Font("Dialog", Font.PLAIN,22));
		karateI.setBackground(Color.BLACK);
		karateI.setForeground(b);
		reg.add(karateI);
		ballet = new JRadioButton("danza");
		ballet.setBounds(760, 702, 149, 23);
		ballet.setFont(new Font("Dialog", Font.PLAIN,22));
		ballet.setBackground(Color.BLACK);
		ballet.setForeground(b);
		reg.add(ballet);
		
		if (karateI.isSelected()){
			karate = true;
		}if(ballet.isSelected()){
			dance = true;
		}
		
		
		JButton veri = new JButton("REGISTRAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		veri.setBackground(Color.BLACK);
		veri.setBounds(100, 880, 250, 100);
		veri.setBorder(BorderFactory.createLineBorder(Color.GREEN));
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
				
				users.add(nuevo);
				System.out.println(users);
				//ProbandoAction button
				if(nuevo.verde){
					reg.setVisible(false);
					inicio.setVisible(true);
					JOptionPane.showMessageDialog(null, "SUCCES", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
					users.add(nuevo);
					
					textcorreo.setText(null);
					textname.setText(null);
					textuser.setText(null);
					textpasw.setText(null);
					textpaswVer.setText(null);
					karateI.setSelected(false);
					ballet.setSelected(false);
					
				}else{
					reg.setVisible(true);
					
				}
			}	
		});
		
		
		reg.add(veri);
		
		return reg;
	}public JPanel menuA(){
		JPanel mA = new JPanel();
		mA.setBounds(80, 400, 1141, 1100);
		mA.setBackground(Color.BLACK);
		mA.setLayout(null);
		
		String link = "https://www.twitch.tv/hcikb";
		JLabel instrucciones = new JLabel("<html>Para poder observar su video en vivo, ingrese al siguiente link: <BR>"+link+"<BR>o ingresa desde su telefono escaneando el siguiente codigo QR:");
		instrucciones.setBounds(200, 100, 900, 400);
		instrucciones.setFont(new Font("Dialog", Font.PLAIN, 25));
		instrucciones.setForeground(Color.WHITE);
		
		codigoQR(link);
		
		String archiv = System.getProperty("user.home")+"/codidodemo.png";
		
		JLabel qrC= new JLabel("");
		System.out.println(archiv);
		qrC.setIcon(new ImageIcon(archiv));
		qrC.setBounds(300, 360,600,600);
		
		mA.add(instrucciones);
		mA.add(qrC);
		
		JButton ver = new JButton("Empezar");
		ver.setBounds(400, 950, 300, 60);
		ver.setBackground(Color.BLACK);
		ver.setFont(new Font("Dialog", Font.BOLD, 28));
		ver.setForeground(Color.GRAY);
		ver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					Process proc = Runtime.getRuntime().exec("obs");
				}catch(IOException r){
					System.out.println("NOOOOOOO");
				}
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
		mqr.setBounds(100, 400, 1141, 1100);
		mqr.setBackground(Color.BLACK);
		mqr.setLayout(null);
		
		
		String link = "https://www.twitch.tv/hcikb/videos/all";
		JLabel mens = new JLabel("<html>Para ver los videos disponibles en vivo <BR>Ingrese al siguiente link:<BR>"+link+"<BR> o escanee el siguiente codigo QR: <html>");
		mens.setFont(new Font("FreeSerif", Font.PLAIN, 28));
		mens.setForeground(Color.WHITE);
		mens.setBounds(300, 200, 584, 400);
		
		mqr.add(mens);
		
		
		
		
		
		codigoQR(link);
		
		String archiv = System.getProperty("user.home")+"/codidodemo.png";
		
		JLabel qrC= new JLabel("");
		System.out.println(archiv);
		qrC.setIcon(new ImageIcon(archiv));
		qrC.setBounds(300, 460,600,600);
		
		
		mqr.add(qrC);
		
		
		
		return mqr;
	}
	public JPanel menuVivo() throws IOException{
		JPanel men = new JPanel();
		men.setBounds(100, 500, 1100, 100);
		men.setBackground(Color.BLACK);
		men.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		men.setLayout(null);
		
		
		
		
		JButton ver = new JButton("VER EN VIVO");
		ver.setBounds(80, 50, 400, 60);
		ver.setBackground(Color.BLACK);
		ver.setFont(new Font("Dialog", Font.BOLD, 31));
		ver.setForeground(b);
		ver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				menuAct.setVisible(false);
				menuVer.setVisible(true);
			}
		});
		//ver.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	
		
		JButton grabar = new JButton("GRABAR EN VIVO");
		grabar.setBounds(630, 50, 400, 60);
		grabar.setBackground(Color.BLACK);
		grabar.setFont(new Font("Dialog", Font.BOLD, 31));
		grabar.setForeground(b);
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
	
	
	


}

