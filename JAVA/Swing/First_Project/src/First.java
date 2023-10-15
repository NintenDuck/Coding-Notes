import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class First extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First frame = new First();
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
	public First() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelloWorld = new JLabel("Hola Mundo");
		lblHelloWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWorld.setBounds(47, 52, 300, 24);
		lblHelloWorld.setForeground(new Color(255, 255, 255));
		lblHelloWorld.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
		contentPane.add(lblHelloWorld);
		
		JButton btnHelloWorld = new JButton("'Say Hello!'");
		btnHelloWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHelloWorld.setText("Hello to you too!!!");
			}
		});
		btnHelloWorld.setBounds(101, 87, 200, 23);
		contentPane.add(btnHelloWorld);
	}
}
