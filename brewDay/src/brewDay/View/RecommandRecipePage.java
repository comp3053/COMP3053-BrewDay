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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class RecommandRecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecommandRecipePage frame = new RecommandRecipePage();
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
	public RecommandRecipePage() {
		setTitle("Recommend");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("<html>How many litres do you want to brew?</html>");
		lblNewLabel.setBounds(88, 71, 245, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<html>L</html>");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(251, 113, 13, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textField.setBounds(134, 105, 116, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Recommend!");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setBounds(110, 171, 170, 42);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float getCapacity;
				String size = textField.getText();
				float batchsize = Float.parseFloat(size);
				int mark1 = 0;
				try {
					getCapacity = Equipment.Capacity();

					if (batchsize > getCapacity) {
						mark1 = 0;
					} else {
						mark1 = 1;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (mark1 == 1) {
					dispose();

					JFrame sucess;
					try {
						sucess = new RecommendSuccessful(batchsize);
					
					sucess.setLocation(100, 50);
					sucess.setSize(600, 500);
					sucess.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					

					String messege="Equipment capacity is not enough!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
			}

		});

		JButton button = new JButton("Back");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.setBounds(20, 16, 75, 36);
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
	}

}
