package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Equipment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;

public class MaintainEquipmentInfoPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintainEquipmentInfoPage frame = new MaintainEquipmentInfoPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MaintainEquipmentInfoPage() throws SQLException {
		setTitle("Equipment Infomation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 485, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Equipment e = new Equipment();
		float cap = e.getCapacity();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 60, 444, 61);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("The Capacity of your equipment is "+cap+" L.");
		scrollPane.setViewportView(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JButton btnAdd = new JButton("Update");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.setForeground(new Color(30, 144, 255));
		btnAdd.setBounds(182, 198, 133, 45);
		contentPane.add(btnAdd);
		
		JButton button = new JButton("Back");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(12, 6, 68, 29);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame home = new HomePage();
				home.setLocation(100, 50);
				home.setSize(600, 500);
				home.setVisible(true);
			}

		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame upe = new UpdateEquipCapacity();
				upe.setLocation(100, 50);
				upe.setSize(550, 400);
				upe.setVisible(true);
			}

		});
		

	}
}
