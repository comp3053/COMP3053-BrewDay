
	package View;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import brewDay.Brew;
	import brewDay.Equipment;
	import brewDay.Recipe;

	import javax.swing.JLabel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JButton;
	import java.awt.Color;
	import javax.swing.JTextField;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;

	public class UpdateEquipCapacity extends JFrame {

		private JPanel contentPane;
		private JTextField textField;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpdateEquipCapacity frame = new UpdateEquipCapacity();
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
		public UpdateEquipCapacity() {
			setTitle("Update Capacity");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 361);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JButton btnNewButton = new JButton("Back");
			btnNewButton.setForeground(new Color(30, 144, 255));
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			btnNewButton.setBounds(16, 17, 76, 29);
			contentPane.add(btnNewButton);

			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();

					JFrame home;
					try {
						home = new MaintainEquipmentInfoPage();
					
					home.setLocation(100, 50);
					home.setSize(600, 500);
					home.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			});

			JLabel lblNewLabel = new JLabel("Enter the new Capacity:");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel.setBounds(72, 100, 156, 16);
			contentPane.add(lblNewLabel);

			textField = new JTextField();
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			textField.setBounds(240, 95, 130, 26);
			contentPane.add(textField);
			textField.setColumns(10);

			JButton button = new JButton("Finish");
			button.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			button.setBounds(116, 177, 188, 57);
			contentPane.add(button);

			button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					String cap = textField.getText();
					int capacity = Integer.parseInt(cap);
					if (capacity < 0) {
						String messege="You cannot input negative number!";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 80);
						win.setSize(400, 200);
						win.setVisible(true);
					} else {
						try {
							Equipment equip = new Equipment();
							equip.updateCapacity(capacity);
							dispose();
							JFrame home;
							home = new MaintainEquipmentInfoPage();
							home.setLocation(100, 50);
							home.setSize(600, 500);
							home.setVisible(true);
							String messege="Your new Capacity is "+capacity+".";
							JFrame win = new PromptWindow(messege);
							win.setLocation(500, 80);
							win.setSize(400, 200);
							win.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}

			});
		}
	}
