package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import brewDay.Recipe;
import java.awt.Font;

public class AddRecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecipePage frame = new AddRecipePage();
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
	public AddRecipePage() {
		setResizable(false);
		setTitle("Add Recipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblpleaseFillIn = new JLabel(
				"<html>Please fill in the blank with your new recipe information then press \"Finish\" button to submit it.</html>");
		lblpleaseFillIn.setFont(new Font("Dialog", Font.BOLD, 14));
		lblpleaseFillIn.setBackground(Color.GREEN);
		lblpleaseFillIn.setBounds(70, 55, 303, 63);
		contentPane.add(lblpleaseFillIn);

		JButton button = new JButton("Back");
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setForeground(new Color(30, 144, 255));
		button.setBounds(18, 7, 75, 36);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame MaintainR = new MaintainRecipePage();
				MaintainR.setLocation(100, 50);
				MaintainR.setSize(600, 500);
				MaintainR.setVisible(true);
			}

		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 133, 165, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 163, 165, 26);
		contentPane.add(textField_2);

		JLabel ququ = new JLabel("L");
		ququ.setFont(new Font("Dialog", Font.BOLD, 14));
		ququ.setBounds(194, 193, 165, 26);
		contentPane.add(ququ);

		JLabel label_1 = new JLabel("Recipe name:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(81, 136, 109, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Quantity:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(81, 166, 83, 16);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Unit:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(81, 196, 83, 16);
		contentPane.add(label_3);

		JButton btnNewButton_1 = new JButton("Finish");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(255, 105, 180));
		btnNewButton_1.setBounds(164, 253, 81, 36);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int mark1 = 0;
				int mark2 = 0;
				int mark3 = 0;
				int mark4 = 0;
				String name = textField_1.getText();
				String quan = textField_2.getText();
				float quantity = Float.parseFloat(quan);
				String unit = ququ.getText();
				Recipe rtemp = new Recipe(name);
				if (rtemp.whetherInDB() == true) {
					String messege = "Your recipe name is already EXIST!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);

				}
				else {
					mark4 =1;
				}
				if (textField_1.getText().trim().equals("")) {
					String messege = "You must input name!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark1 = 1;
				}
				if (textField_2.getText().trim().equals("")) {
					String messege = "You must input quantity!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark2 = 1;
				}
				if (mark1 == 1 && mark2 == 1) {
					String messege = "Please write something to add!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark2 = 1;
				}
				if (quantity <= 0) {
					String messege = "Quantity should be positive number!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark3 = 1;
				}
				if (mark1 == 0 && mark2 == 0 && mark3 == 0&&mark4==0) {
					Recipe r = new Recipe(name, quantity, unit);
					String messege = "Recipe " + name + "has already been added.";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					r.addRecipeToDB();

				}
			}

		});
	}
}