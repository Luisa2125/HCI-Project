import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
	private JPanel qr;
	private ArrayList<Usuario> users= new ArrayList<Usuario>();
	private JMenuBar iconos;
	

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
	 */
	public DeskApp() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		inicio = singIn();
		inicio.setVisible(true);

		home = home();
		
		clases = new JPanel();
		clases.setBounds(100, 400, 1141, 1100);
		clases.setBackground(Color.GRAY);
		clases.setLayout(null);
		
		
		
		JTabbedPane misC = new JTabbedPane();
		misC = clasesP(clases);
		misC.setBackground(Color.WHITE);
		misC.setBounds(10, 10, 1100, 850);
		clases.add(misC);
		
		ver1 = Olvide();
		registro = registro();
		qr = codigoQRVideo();
		qr.setVisible(false);
		
		
		home.setVisible(false);
		clases.setVisible(false);
		ver1.setVisible(false);
		registro.setVisible(false);
		
	
		
		frame.getContentPane().add(inicio);	
		frame.getContentPane().add(home);
		frame.getContentPane().add(clases);
		frame.getContentPane().add(ver1);
		frame.getContentPane().add(registro);
		
		frame.getContentPane().add(iconos);
		label = new JLabel("");
		label.setIcon(new ImageIcon("/home/luisa/logo.png"));
		label.setBounds(515, 150, 252, 272);
		frame.getContentPane().add(label);
		frame.setBounds(100, 100, 1300, 1550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menu(JPanel actual,JPanel sig){
		JMenuBar Menu = new JMenuBar();
		Menu.setBounds(0, 0, 200, 60);
		Menu.setBackground(Color.GRAY);
		
		
		
		JMenuItem back = new JMenuItem("Back",KeyEvent.VK_A);
		//back.setIcon(new ImageIcon("/home/luisa/Desktop/atras.png"));
		back.setBackground(Color.GRAY);
		
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				actual.setVisible(false);
				sig.setVisible(true); 
			
			}	
		});
		JMenuItem home = new JMenuItem("Home",KeyEvent.VK_A);
		//home.setIcon(new ImageIcon("/home/luisa/Desktop/home.png"));
		home.setBackground(Color.GRAY);
		
		
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				actual.setVisible(false);
				home.setVisible(true); 
			
			}	
		});
		JMenuItem el = new JMenuItem("Drop",KeyEvent.VK_A);
		//el.setIcon(new ImageIcon("/home/luisa/Desktop/eliminate.png"));
		el.setBackground(Color.GRAY);
		
		JMenu setting = new JMenu("Settings");
		//setting.setIcon(new ImageIcon("/home/luisa/Desktop/sett.png"));
		setting.setBackground(Color.GRAY);
		
		Menu.add(setting);
		Menu.add(home);
		Menu.add(back);
		Menu.add(el);
		
		
		return Menu;
	}
	public JPanel home(){
		JPanel home = new JPanel();
		home.setBounds(104, 402, 1141, 1100);
		home.setBackground(Color.GRAY);
		home.setLayout(null);
		
		mclases = new JButton("MIS CLASES");
		mclases.setFont(new Font("Dialog", Font.BOLD, 29));
		mclases.setForeground(Color.WHITE);
		mclases.setBackground(Color.DARK_GRAY);
		mclases.setBounds(400, 280, 300, 70);
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
		importar.setForeground(Color.WHITE);
		importar.setBackground(Color.DARK_GRAY);
		importar.setBounds(440, 480, 210, 70);
		home.add(importar);
		
		vivo = new JButton("EN VIVO");
		vivo.setFont(new Font("Dialog", Font.BOLD, 29));
		vivo.setForeground(Color.WHITE);
		vivo.setBackground(Color.DARK_GRAY);
		vivo.setBounds(440, 680, 210, 70);
		home.add(vivo);
		
		
		
		
		
		iconos = menu(home,inicio);
		
		
	
		
		return home;
		
	}
	public JPanel singIn(){
		JPanel inicio = new JPanel();
		inicio.setBounds(100, 400, 1141, 1100);
		inicio.setBackground(Color.GRAY);
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
		lblNewLabel2.setBackground(Color.GRAY);
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
		btnIngresar.setBackground(Color.DARK_GRAY);
		btnIngresar.setBounds(168, 680, 200, 50);
		btnIngresar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				if(ver(textField_2.getText(),textField_3.getText())){
					inicio.setVisible(false);
					home.setVisible(true);
				}
			}	
		});
		inicio.add(btnIngresar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 25));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.DARK_GRAY);
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
	public JTabbedPane clasesP(JPanel clases){
		JTabbedPane misC = new JTabbedPane();
		JPanel jazz = new JPanel();
		JPanel ballet = new JPanel();
		JPanel hip = new JPanel();
		
		JPanel patadas = new JPanel();
		JPanel golpes = new JPanel();
		JPanel catas = new JPanel();
		
		atras = new JButton("");
		atras.setIcon(new ImageIcon("/home/luisa/Desktop/atras.png"));
		atras.setBounds(900, 1000,900, 88);
		atras.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				misC.setVisible(false);
				home.setVisible(true);
			}		
		});
		
		misC.add(atras);
		
		if(karate == true && dance == false){
			misC.addTab("Patadas", patadas);
			misC.addTab("GolpesM", golpes);
			misC.addTab("Catas", catas);
		}if(dance == true && karate == false){
			misC.addTab("Ballet", ballet);
			misC.addTab("Jazz", jazz);
			misC.addTab("HipHop", hip);
		}if(dance == true && karate == true){
			misC.addTab("Ballet", ballet);
			misC.addTab("Jazz", jazz);
			misC.addTab("HipHop", hip);
			misC.addTab("Patadas", patadas);
			misC.addTab("GolpesM", golpes);
			misC.addTab("Catas", catas);
		}
		return misC;
		
		
	}
	public JPanel Olvide(){
		JPanel ver = new JPanel();
		ver.setBounds(100, 400, 1141, 1100);
		ver.setBackground(Color.GRAY);
		ver.setLayout(null);
		
		JLabel correo = new JLabel("INGRESE CORREO: ");
		correo.setFont(new Font("FreeSerif", Font.BOLD, 31));
		correo.setForeground(Color.WHITE);
		correo.setBounds(70, 248, 384, 51);
		
		
		JTextField textFieldC = new JTextField();
		textFieldC.setBounds(400, 248, 550, 51);
		
		
		
		JLabel ctx = new JLabel("NUEVA CONTRASEÑA: ");
		ctx.setFont(new Font("FreeSerif", Font.BOLD, 31));
		ctx.setForeground(Color.WHITE);
		ctx.setBounds(50, 448, 384, 51);
		
		
		JTextField textctx = new JTextField();
		textctx.setBounds(400, 448, 550, 51);
		
		
		JButton veri = new JButton("VERIFICAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		veri.setBackground(Color.DARK_GRAY);
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
		reg.setBackground(Color.GRAY);
		reg.setLayout(null);
		
		JLabel correo = new JLabel("CORREO: ");
		correo.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		correo.setForeground(Color.WHITE);
		correo.setBounds(10, 248, 284, 51);
		reg.add(correo);
		
		JTextField textcorreo = new JTextField();
		textcorreo.setBounds(300, 248, 350, 51);
		reg.add(textcorreo);
		
		
		JLabel user = new JLabel("USUARIO: ");
		user.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		user.setForeground(Color.WHITE);
		user.setBounds(10, 348, 284, 51);
		reg.add(user);
		
		JTextField textuser = new JTextField();
		textuser.setBounds(300, 348, 350, 51);
		reg.add(textuser);
		
		JLabel name = new JLabel("NOMBRE: ");
		name.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		name.setForeground(Color.WHITE);
		name.setBounds(10, 448, 284, 51);
		reg.add(name);
		
		JTextField textname = new JTextField();
		textname.setBounds(300, 448, 350, 51);
		reg.add(textname);
		
		
		JLabel age = new JLabel("EDAD: ");
		age.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		age.setForeground(Color.WHITE);
		age.setBounds(10, 548, 284, 51);
		reg.add(age);
		
		JTextField textage = new JTextField();
		textage.setBounds(300, 548, 350, 51);
		reg.add(textage);
		
		JLabel pasw = new JLabel("CONTRASEÑA: ");
		pasw.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		pasw.setForeground(Color.WHITE);
		pasw.setBounds(10, 648, 284, 51);
		reg.add(pasw);
		
		JTextField textpasw = new JTextField();
		textpasw.setBounds(300, 648, 350, 51);
		reg.add(textpasw);
		
		
		JLabel paswVer = new JLabel("REPITA CONTRASEÑA: ");
		paswVer.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		paswVer.setForeground(Color.WHITE);
		paswVer.setBounds(10, 748, 384, 51);
		reg.add(paswVer);
		
		JTextField textpaswVer = new JTextField();
		textpaswVer.setBounds(300, 748, 350, 51);
		reg.add(textpaswVer);
		
		JLabel gen = new JLabel("Genero: ");
		gen.setFont(new Font("FreeSerif", Font.PLAIN, 25));
		gen.setForeground(Color.WHITE);
		gen.setBounds(760, 362, 384, 51);
		reg.add(gen);
		JRadioButton fem = new JRadioButton("Femenino");
		fem.setBounds(760, 402, 149, 23);
		fem.setBackground(Color.DARK_GRAY);
		fem.setForeground(Color.WHITE);
		reg.add(fem);
		JRadioButton mas = new JRadioButton("Masculino");
		mas.setBounds(760, 442, 149, 23);
		mas.setBackground(Color.DARK_GRAY);
		mas.setForeground(Color.WHITE);
		reg.add(mas);
		if (mas.isSelected()){
			fem.setSelected(false);
			
		}else if (fem.isSelected()){
			mas.setSelected(false);
		}
		
		
		karateI = new JRadioButton("Karate");
		karateI.setBounds(760, 662, 149, 23);
		karateI.setBackground(Color.DARK_GRAY);
		karateI.setForeground(Color.WHITE);
		reg.add(karateI);
		ballet = new JRadioButton("danza");
		ballet.setBounds(760, 702, 149, 23);
		ballet.setBackground(Color.DARK_GRAY);
		ballet.setForeground(Color.WHITE);
		reg.add(ballet);
		
		if (karateI.isSelected()){
			karate = true;
		}if(ballet.isSelected()){
			dance = true;
		}
		
		
		JButton veri = new JButton("REGISTRAR");
		veri.setFont(new Font("Dialog", Font.BOLD, 30));
		veri.setForeground(Color.WHITE);
		veri.setBackground(Color.DARK_GRAY);
		veri.setBounds(100, 880, 250, 100);
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
				reg.setVisible(false);
				inicio.setVisible(true);
				JOptionPane.showMessageDialog(null, "SUCCES", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
			}	
		});
		
		atras = new JButton("");
		atras.setIcon(new ImageIcon("/home/luisa/Desktop/atras.png"));
		atras.setBounds(900, 1000,90, 88);
		atras.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				registro.setVisible(false);
				inicio.setVisible(true);
			}		
		});
		reg.add(atras);
		reg.add(veri);
		return reg;
	}
	public JPanel codigoQRVideo(){
		JPanel qr = new JPanel();
		qr.setBounds(104, 402, 1141, 1100);
		qr.setBackground(Color.GRAY);
		qr.setLayout(null);
		
		int udm = 0;
		int resol = 72;
		float mi = 0.000f;
		float md = 0.000f;
		float ms = 0.000f;
		float min = 0.000f;
		int rot = 0;
		float tam = 5.000f;
		
		
		JLabel jtxtcodigo = new JLabel("escanea el codigo QR para acceder al video \npor medio de los lentes de realidad aumentada");
		jtxtcodigo.setFont(new Font("Dialog", Font.BOLD, 30));
		jtxtcodigo.setForeground(Color.WHITE);
		jtxtcodigo.setBackground(Color.GRAY);
		jtxtcodigo.setBounds(10, 200, 350, 100);
		
		String link = "soyluna.net/capitulo-13-segunda-temporada/";
		
		qr.add(jtxtcodigo);
		
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
			
			String archiv = System.getProperty("user.home")+"/codidodemo.gif";
			cod.renderBarcode(archiv);
			
			
			//Desktop d = Desktop.getDesktop();
			//d.open(new File(archiv));
			
			JLabel qrC= new JLabel("");
			qrC.setIcon(new ImageIcon(archiv));
			qrC.setBounds(10, 400,400,400);
			
			
			qr.add(qrC);
			
		}catch(Exception e){
			System.out.println("NO FUNCIONA BRUTA");
			
		}
		
		
		
		return qr;
	}
}
