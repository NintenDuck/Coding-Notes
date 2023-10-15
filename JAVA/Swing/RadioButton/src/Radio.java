import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Radio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Radio frame = new Radio();
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
	public Radio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 11, 250, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textField.setFont(new Font(textField.getText(), Font.PLAIN, E_RESIZE_CURSOR));
				System.out.println("Regular Style");
			}
		});
		rdbtnRegular.setBounds(65, 38, 109, 23);
		contentPane.add(rdbtnRegular);
		
		JRadioButton rdbtnBold = new JRadioButton("Bold");
		rdbtnBold.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textField.setFont(new Font(textField.getText(), Font.BOLD, E_RESIZE_CURSOR));
			}
		});
		rdbtnBold.setBounds(65, 64, 109, 23);
		contentPane.add(rdbtnBold);
		
		JRadioButton rdbtnItalic = new JRadioButton("Italic");
		rdbtnItalic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textField.setFont(new Font(textField.getText(), Font.ITALIC, E_RESIZE_CURSOR));
			}
		});
		rdbtnItalic.setBounds(65, 90, 109, 23);
		contentPane.add(rdbtnItalic);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnBold);
		buttonGroup.add(rdbtnItalic);
		buttonGroup.add(rdbtnRegular);
	}
}
