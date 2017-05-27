

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Inst {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnteriroanteriro = new JButton("ANTERIOR");
		btnAnteriroanteriro.setBounds(127, 635, 117, 25);
		frame.getContentPane().add(btnAnteriroanteriro);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(322, 665, 117, 25);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnSaltarInfo = new JButton("SALTAR INFO");
		btnSaltarInfo.setBounds(736, 676, 117, 25);
		frame.getContentPane().add(btnSaltarInfo);
	}
}
