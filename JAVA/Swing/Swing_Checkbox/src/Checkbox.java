import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checkbox extends JFrame {
	boolean pie=false, bur=false,ban=false,rot=false;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkbox frame = new Checkbox();
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
	public Checkbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Choose the dishes you like:");
		lblNewLabel.setBounds(10, 11, 165, 14);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Pie");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					bur=true;
				} else {
					bur = false;
				}
			}
		});
		chckbxNewCheckBox.setBounds(10, 55, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Burger");
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pie=true;
				} else {
					pie = false;
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(10, 81, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Rotten Fish");
		chckbxNewCheckBox_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					rot=true;
				} else {
					rot=false;
				}
			}
		});
		chckbxNewCheckBox_1_1.setBounds(10, 107, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Banana");
		chckbxNewCheckBox_1_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ban=true;
				} else {
					ban = false;
				}
			}
		});
		chckbxNewCheckBox_1_2.setBounds(10, 133, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg="You Like";
				if (pie) {msg += " pie,";}
				if (bur) {msg += " burger,";}
				if (ban) {msg += " banana,";}
				if (rot) {msg += " rotten fish";}
				JOptionPane.showMessageDialog( null, msg );
			}
		});
		btnNewButton.setBounds(10, 163, 89, 23);
		contentPane.add(btnNewButton);
	}
}
