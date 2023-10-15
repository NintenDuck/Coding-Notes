import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Disco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disco frame = new Disco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Disco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int discoSpeed = 100;
				try {
					while (true) {
						getContentPane().setBackground(Color.RED);
						Thread.sleep(discoSpeed);
						getContentPane().setBackground(Color.PINK);
						Thread.sleep(discoSpeed);
						getContentPane().setBackground(Color.BLUE);
						Thread.sleep(discoSpeed);
						getContentPane().setBackground(Color.GREEN);
						Thread.sleep(discoSpeed);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		t.start();
	}

}
