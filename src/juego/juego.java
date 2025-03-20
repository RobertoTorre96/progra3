package juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class juego {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					juego window = new juego();
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
	public juego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel laminatablero = new JPanel(); //contenedeor de tablero
		laminatablero.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.getContentPane().add(laminatablero);
		
		Tablero tablero=new Tablero();
		laminatablero.add(tablero);
	}

}
