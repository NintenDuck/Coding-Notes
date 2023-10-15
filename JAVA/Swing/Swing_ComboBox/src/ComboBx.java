import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ComboBx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBx frame = new ComboBx();
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
	public ComboBx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
				if (item.getStateChange() == ItemEvent.SELECTED) {
					if (item.getItem().toString().equals("London")) {
						System.out.println("You're Awesome");
					}
					System.out.println("Item selected " + comboBox.getSelectedItem().toString());
					System.out.println(comboBox.getSelectedIndex());
				}
			}
		});
		comboBox.setToolTipText("");
		comboBox.setBounds(48, 11, 297, 22);
		contentPane.add(comboBox);
		
		comboBox.addItem("-- Choose --");
		comboBox.addItem("London");
		comboBox.addItem("Mexico");
		comboBox.addItem("India");
	}

}
