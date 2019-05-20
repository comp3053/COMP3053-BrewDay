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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import brewDay.Database;
import brewDay.Recipe;
import java.awt.Font;

public class UpdateEditPage extends JFrame {

	private JPanel contentPane;

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
	 * 
	 * @param num
	 */
	public UpdateEditPage(String name, float num) {
		setResizable(false);
		setTitle("Edit and update Recipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblpleaseFillIn = new JLabel(
				"<html>Please edit in the blank with your selected recipe information then press \"Finish\" button to submit it.</html>");
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

				JFrame upmain;
				try {
					upmain = new UpdateRecipePage();

					upmain.setLocation(100, 50);
					upmain.setSize(600, 500);
					upmain.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JLabel nameme = new JLabel(name);
		nameme.setFont(new Font("Dialog", Font.BOLD, 14));
		nameme.setBounds(194, 133, 165, 26);
		contentPane.add(nameme);

		String number = Float.toString(num);
		textField_2 = new JTextField();
		textField_2.setText(number);
		textField_2.setColumns(10);
		textField_2.setBounds(194, 163, 165, 26);
		contentPane.add(textField_2);
		textField_2.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();				
				if((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)|| (keyChar == '.')){
					
				}else{
					e.consume();
				}
			}
		});

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
				String quan = textField_2.getText();
				float quantity = Float.parseFloat(quan);
				Recipe r = new Recipe(name);
				if(textField_2.getText().trim().equals("")) {
					String messege="You must input new value!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
				if (quantity > 0) {
					try {
						r.updateQuantity(quantity, name);
						dispose();
						JFrame upRE = new UpdateRecipePage();

						upRE.setLocation(100, 50);
						upRE.setSize(600, 500);
						upRE.setVisible(true);
						String messege = "Success.";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 80);
						win.setSize(400, 200);
						win.setVisible(true);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} 
				
				else {
					String messege = "You must input a positive number.";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
			}

		});
	}
}