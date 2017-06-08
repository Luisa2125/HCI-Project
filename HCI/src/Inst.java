

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Inst {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(187, 170, 70, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(200, 284, 70, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
