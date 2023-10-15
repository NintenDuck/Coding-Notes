import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFirstNumber;
	private JTextField txtSecondNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
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
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setBounds(48, 88, 80, 14);
		contentPane.add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(48, 134, 80, 14);
		contentPane.add(lblSecondNumber);
		
		txtFirstNumber = new JTextField();
		txtFirstNumber.setBounds(138, 85, 30, 20);
		contentPane.add(txtFirstNumber);
		txtFirstNumber.setColumns(10);
		
		txtSecondNumber = new JTextField();
		txtSecondNumber.setBounds(138, 131, 30, 20);
		contentPane.add(txtSecondNumber);
		txtSecondNumber.setColumns(10);
		
		JLabel lblResult = new JLabel("No number");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblResult.setBounds(229, 88, 176, 46);
		contentPane.add(lblResult);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(txtFirstNumber.getText());
				int num2 = Integer.parseInt(txtSecondNumber.getText());
				JOptionPane.showMessageDialog(null, "The sum is: " + Integer.toString(num1+num2));
			}
		});
		btnCalculate.setBounds(48, 174, 120, 23);
		contentPane.add(btnCalculate);
	}
}
