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
import javax.swing.JPasswordField;
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
	private JRadioButton karateI;
	private JRadioButton ballet;
	private JPanel Nm;
	private JPanel menuAct;
	private JPanel menuVer;
	private ArrayList<Usuario> users= new ArrayList<Usuario>();
	private JMenuBar iconos;
	Color b = new Color(10,250,255);
	Color fondo = new Color(115,198,182);
	Color oscuro = new Color(19,141,117);
	Color fondo1 = new Color(127, 179, 213 );
	Color oscuro1 = new Color(41, 128, 185);
	Color popC = new Color(169, 204, 227);
	int i = 0;
	
	private JPasswordField pas;
	

	

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
		inicio = singIn();
		inicio.setVisible(true);
		
		

		
		
		categorias = new JPanel();
		categorias.setBounds(0, 500, 1100, 1100);
		//clases.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		categorias.setBackground(fondo1);
		categorias.setLayout(null);
		for (int i=0;i<categoria(karate,dance).size();i++){
			categorias.add(categoria(karate,dance).get(i));
		}
		
		clases = new JPanel();
		clases.setBounds(0, 500, 1100, 1100);
		//clases.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		clases.setBackground(fondo1);
		clases.setLayout(null);
		for (int i=0;i<clases().size();i++){
			clases.add(clases().get(i));
		}
		clases.setToolTipText("HOLAAAAA");
		
		
		
		
		
		ver1 = Olvide();
		registro = registro();
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
		
		
		frame.getContentPane().add(inicio);	
		frame.getContentPane().add(ver1);
		frame.getContentPane().add(registro);
		frame.getContentPane().add(Nm);
		frame.getContentPane().add(menuAct);
		frame.getContentPane().add(menuVer);
		frame.getContentPane().add(categorias);
		frame.getContentPane().add(clases);
		
		frame.getContentPane().add(iconos);
		label = new JLabel("");
		label.setIcon(new ImageIcon("/home/luisa/logo.png"));
		label.setBounds(515, 150, 252, 272);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 1300, 1550);
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
		img.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l1.png"));
		img.setBorder(BorderFactory.createLineBorder(oscuro1));
		pop.getContentPane().add(img);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(60, 60, 1190, 800);
		img1.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l2.png"));
		img1.setBorder(BorderFactory.createLineBorder(oscuro));
		pop.getContentPane().add(img1);
		JLabel img2 = new JLabel("");
		img2.setBounds(60, 60, 1190, 800);
		img2.setBorder(BorderFactory.createLineBorder(oscuro));
		img2.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l3.png"));
		pop.getContentPane().add(img2);
		JLabel img3 = new JLabel("");
		img3.setBounds(60, 60, 1190, 800);
		img3.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/l4.png"));
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
					i = 0;
				}
				imgs.get(i-1).setVisible(false);
				imgs.get(i).setVisible(true);
				
			}
		});
		pop.getContentPane().add(btnSiguiente);
		
		
	}
	public void menu(){
		iconos = new JMenuBar();
		iconos.setBounds(0, 0, 1300, 60);
		iconos.setBackground(Color.BLACK);
		
		
		
		JMenuItem back = new JMenuItem("	Regresar",new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/back.png"));
		//back.setIcon(new ImageIcon("/home/luisa/Desktop/atras.png"));
		back.setFont(new Font("Dialog", Font.PLAIN, 27));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				
				if(registro.isVisible()){
					registro.setVisible(false);
					inicio.setVisible(true);
				
				}if(clases.isVisible()){
					clases.setVisible(false);
					categorias.setVisible(true);
				}if(ver1.isVisible()){
					ver1.setVisible(false);
					inicio.setVisible(true);
				}if(Nm.isVisible()){
					Nm.setVisible(false);
					categorias.setVisible(true);
				}if(inicio.isVisible()){
					inicio.setVisible(true);
				}
				if(categorias.isVisible()){
					categorias.setVisible(false);
					categorias.setVisible(true); 
					frame.setBackground(fondo1);
				}
			}	
		});
		
			JMenuItem envivo = new JMenuItem("	En vivo",new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/video.png"));
			
			envivo.setFont(new Font("Dialog", Font.PLAIN, 27));
			envivo.setBounds(0, 0, 300, 60);
			envivo.setBackground(Color.BLACK);
			envivo.setForeground(Color.WHITE);
			envivo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(inicio.isVisible()){
						inicio.setVisible(true);
					}if(registro.isVisible()){
						registro.setVisible(true);
					}if(clases.isVisible()){
						clases.setVisible(false);
						Nm.setVisible(true); 
					}if(ver1.isVisible()){
						ver1.setVisible(true); 
					}if(Nm.isVisible()){
						Nm.setVisible(false);
						menuAct.setVisible(false);
						menuVer.setVisible(false);
						Nm.setVisible(true); 
					}if(inicio.isVisible()){
						inicio.setVisible(true);
					}if(categorias.isVisible()){
						categorias.setVisible(false);
						Nm.setVisible(true); 
					}
					
					
				}
			});
			
			
			JMenuItem categorias1 = new JMenuItem("	Categorias");
			if(dance){
				categorias1 = new JMenuItem("	Categorias",new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/balerina.png"));
			}if(karate){
				categorias1 = new JMenuItem("	Categorias",new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/karateI.png"));
			}if(karate && dance){
				categorias1 = new JMenuItem("	Categorias",new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/both.png"));
				
			}
			
			
			categorias1.setFont(new Font("Dialog", Font.PLAIN, 27));
			categorias1.setBackground(Color.BLACK);
			categorias1.setForeground(Color.WHITE);
			categorias1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(inicio.isVisible()){
						inicio.setVisible(true);
						
					}if(registro.isVisible()){
						registro.setVisible(true);
					}if(clases.isVisible()){
						clases.setVisible(false);
						categorias.setVisible(true); 
					}if(ver1.isVisible()){
						ver1.setVisible(true); 
					}if(Nm.isVisible()){
						Nm.setVisible(false);
						menuAct.setVisible(false);
						menuVer.setVisible(false);
						categorias.setVisible(true); 
					}if(inicio.isVisible()){
						inicio.setVisible(true);
					}if(categorias.isVisible()){
						categorias.setVisible(true);
						
					}if(clases.isVisible()){
						clases.setVisible(false);
						categorias.setVisible(true);
						
					}
				}
			});
			
			JMenuItem sesion = new JMenuItem("	Cerrar Sesión",new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/logout.png"));
			sesion.setFont(new Font("Dialog", Font.PLAIN, 27));
			sesion.setBackground(Color.BLACK);
			sesion.setForeground(Color.WHITE);
			sesion.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(registro.isVisible()){
						registro.setVisible(false);
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
					}if(categorias.isVisible()){
						categorias.setVisible(false);
						inicio.setVisible(true); 
					}
					
					categorias.setBackground(fondo);
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
		//setting.setIcon(new ImageIcon("/home/luisa/Desktop/sett.png"));
		setting.setBackground(Color.GRAY);
		setting.setFont(new Font("Dialog", Font.PLAIN, 27));
		
		
		JMenuItem salir = new JMenuItem("Salir",KeyEvent.VK_A);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
		salir.setBackground(Color.GRAY);
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Dialog", Font.PLAIN, 22));
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			
			}	
		});
		JMenuItem ayuda = new JMenuItem("Ayuda",KeyEvent.VK_A);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
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
		iconos.add(envivo);
		iconos.add(categorias1);
		iconos.add(back);
		iconos.add(sesion);
		
		
	}
	public JPanel singIn(){
		JPanel inicio = new JPanel();
		inicio.setBounds(100, 400, 1141, 1100);
		
		inicio.setBackground(fondo);
		inicio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO: ");
		lblNewLabel.setFont(new Font("FreeSerif", Font.BOLD, 31));
		lblNewLabel.setBounds(285, 248, 284, 51);
		lblNewLabel.setForeground(Color.BLACK);
		inicio.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("CONTRASEÑA: ");
		lblNewLabel1.setFont(new Font("FreeSerif", Font.BOLD, 31));
		lblNewLabel1.setForeground(Color.BLACK);
		lblNewLabel1.setBounds(285, 348, 284, 51);
		inicio.add(lblNewLabel1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textField_2.setForeground(Color.GRAY);
		textField_2.setBounds(489, 248, 350, 51);
		inicio.add(textField_2);
		textField_2.setColumns(10);
		
		JPasswordField textP= new JPasswordField();
		textP.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textP.setForeground(Color.GRAY);
		textP.setBounds(559, 348, 300, 51);
		inicio.add(textP);
		textP.setColumns(10);
		
		JButton lblNewLabel2 = new JButton("Olvidé mi Contraseña");
		lblNewLabel2.setFont(new Font("FreeSerif", Font.BOLD, 28));
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setBackground(fondo);
		lblNewLabel2.setBounds(700, 400, 400, 45);
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
		btnIngresar.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/ingresar.png"));
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
				}
			}	
		});
		
		inicio.add(btnIngresar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 28));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(oscuro);
		btnRegistrar.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/registrar.png"));
		btnRegistrar.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		btnRegistrar.setBounds(748, 680, 300, 70);
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
		
		JButton cate= new JButton("CATEGORIA 1");
		if(karate){
			cate.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/karate.png"));
		}if(dance){
			cate.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/ballet.png"));
		}if(karate && dance){
			cate.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/karate.png"));
			JButton catg= new JButton("CATEGORIA 2");
			catg.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/ballet.png"));
			catg.setBounds(210, 50,174 ,172);
			catg.setForeground(Color.BLACK);
			catg.setBackground(fondo1);
			catg.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//ProbandoAction button
					categorias.setVisible(false);
					clases.setVisible(true);
				}	
			});
			cat.add(catg);
			JLabel catego = new JLabel("Categoria 2");
			catego.setFont(new Font("Dialog", Font.PLAIN, 28));
			catego.setForeground(Color.BLACK);
			catego.setBackground(fondo1);
			catego.setBounds(210, 10, 174, 51);
			cat.add(catego);
		}
		cate.setBounds(15, 50,174 ,172);
		cate.setBackground(fondo1);
		cate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				categorias.setVisible(false);
				clases.setVisible(true);
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
		clase1.setBounds(10, 10, 174, 51);
		
		JButton c1= new JButton("CLASE 1");
		c1.setBackground(fondo1);
		c1.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/icon.png"));
		c1.setBounds(15, 50,174 ,172);
		
		clases.add(clase1);
		clases.add(clase);
		clases.add(c1);
		
		
		return clases;
	}
	public JPanel Olvide(){
		JPanel ver = new JPanel();
		ver.setBounds(100, 400, 1141, 1100);
		ver.setBackground(fondo);
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
		reg.setBackground(fondo);
		reg.setLayout(null);
		
		JLabel correo = new JLabel("CORREO: ");
		correo.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		correo.setForeground(Color.BLACK);
		correo.setBounds(10, 248, 284, 51);
		reg.add(correo);
		
		JTextField textcorreo = new JTextField();
		textcorreo.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textcorreo.setBounds(300, 248, 350, 51);
		reg.add(textcorreo);
		
		
		JLabel user = new JLabel("USUARIO: ");
		user.setFont(new Font("FreeSerif", Font.PLAIN,31));
		user.setForeground(Color.BLACK);
		user.setBounds(10, 348, 284, 51);
		reg.add(user);
		
		JTextField textuser = new JTextField();
		textuser.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textuser.setBounds(300, 348, 350, 51);
		reg.add(textuser);
		
		JLabel name = new JLabel("NOMBRE: ");
		name.setFont(new Font("FreeSerif", Font.PLAIN, 31));
		name.setForeground(Color.BLACK);
		name.setBounds(10, 448, 284, 51);
		reg.add(name);
		
		JTextField textname = new JTextField();
		textname.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textname.setBounds(300, 448, 350, 51);
		reg.add(textname);
		
		
		JLabel age = new JLabel("EDAD: ");
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
		reg.add(pasw);
		
		JPasswordField textpasw = new JPasswordField();
		textpasw.setFont(new Font("FreeSerif", Font.BOLD, 31));
		textpasw.setBounds(300, 648, 350, 51);
		reg.add(textpasw);
		
		
		JLabel paswVer = new JLabel("REPITA CONTRASEÑA: ");
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
		mas.setBackground(fondo);
		mas.setForeground(Color.BLACK);
		reg.add(mas);
		if (mas.isSelected()){
			fem.setSelected(false);
			
		}else if (fem.isSelected()){
			mas.setSelected(false);
		}
		
		
		karateI = new JRadioButton("Karate");
		karateI.setBounds(760, 662, 149, 23);
		karateI.setFont(new Font("Dialog", Font.PLAIN,28));
		karateI.setBackground(fondo);
		karateI.setForeground(Color.black);
		reg.add(karateI);
		ballet = new JRadioButton("danza");
		ballet.setBounds(760, 702, 149, 23);
		ballet.setFont(new Font("Dialog", Font.PLAIN,28));
		ballet.setBackground(fondo);
		ballet.setForeground(Color.black);
		reg.add(ballet);
		
		
		
		
		JButton veri = new JButton("    REGISTRAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		
		veri.setBackground(oscuro);
		veri.setIcon(new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/registrar.png"));
		veri.setBorder(BorderFactory.createLineBorder(b));
		veri.setBounds(100, 900, 300, 70);
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
					//JOptionPane.showMessageDialog(categorias,"SUCCES", "REGISTRO", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("/home/luisa/Desktop/UVG/HCI/proyecto/registrar.png"));
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
		mA.setBounds(80, 500, 1141, 1100);
		mA.setBackground(fondo1);
		
		mA.setLayout(null);
		
		String link = "https://www.twitch.tv/hcikb";
		JLabel instrucciones = new JLabel("<html>Para poder observar su video en vivo, ingrese al siguiente link: <BR>"+link+"<BR>o ingresa desde su telefono escaneando el siguiente codigo QR:");
		instrucciones.setBounds(200, 100, 900, 400);
		instrucciones.setFont(new Font("Dialog", Font.PLAIN, 32));
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
		mqr.setBounds(100, 400, 1141, 1100);
		mqr.setBackground(fondo1);
		mqr.setLayout(null);
		
		
		String link = "https://www.twitch.tv/hcikb/videos/all";
		JLabel mens = new JLabel("<html>Para ver los videos disponibles en vivo <BR>Ingrese al siguiente link:<BR>"+link+"<BR> o escanee el siguiente codigo QR: <html>");
		mens.setFont(new Font("Dialog", Font.PLAIN, 32));
		mens.setForeground(Color.WHITE);
		mens.setBounds(300, 200, 600, 400);
		
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
		men.setBackground(fondo1);
		men.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		men.setLayout(null);
		
		
		
		
		JButton ver = new JButton("VER EN VIVO");
		ver.setBounds(80, 50, 400, 60);
		ver.setBackground(oscuro1);
		ver.setFont(new Font("Dialog", Font.BOLD, 31));
		ver.setForeground(Color.black);
		ver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				menuAct.setVisible(false);
				menuVer.setVisible(true);
			}
		});
		//ver.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	
		
		JButton grabar = new JButton("GRABAR EN VIVO");
		grabar.setBounds(630, 50, 400, 60);
		grabar.setBackground(oscuro1);
		grabar.setFont(new Font("Dialog", Font.BOLD, 31));
		grabar.setForeground(Color.black);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	


}

