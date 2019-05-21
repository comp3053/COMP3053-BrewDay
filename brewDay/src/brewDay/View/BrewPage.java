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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class BrewPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrewPage frame = new BrewPage("Input",0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param batchsize 
	 */
	public BrewPage(String aname, float batchsize) {
		setTitle("Brew");
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

				JFrame home = new HomePage();
				home.setLocation(100, 50);
				home.setSize(600, 500);
				home.setVisible(true);
			}

		});

		JLabel lblNewLabel = new JLabel("Enter the recipe name:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 100, 156, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setText(aname);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField.setBounds(240, 95, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTheNumberOf = new JLabel("<html>The number of litres:</html>");
		lblTheNumberOf.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblTheNumberOf.setBounds(72, 128, 184, 30);
		contentPane.add(lblTheNumberOf);

		String size = batchsize+"";
		textField_1 = new JTextField();
		textField_1.setText(size);
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(240, 131, 130, 26);
		contentPane.add(textField_1);
		textField_1.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();				
				if((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)|| (keyChar == '.')){
					
				}else{
					e.consume();
				}
			}
		});

		JButton button = new JButton("BREW!");
		button.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		button.setBounds(116, 177, 188, 57);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int mark1 = 0;
				int mark2 = 0;
				int mark3 = 0;
				String name = textField.getText();
				String size = textField_1.getText();
				int getSize = Integer.parseInt(size);
				float getCapacity;
				try {
					getCapacity = Equipment.Capacity();

					// System.out.println(getCapacity);
					if (getSize > getCapacity) {
						String messege="Equipment capacity is not enough!";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 80);
						win.setSize(400, 200);
						win.setVisible(true);	
					} else {
						mark2 = 1;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Recipe r = new Recipe(name);
				if (r.whetherInDB() == false) {
					String messege="No such recipe in database!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 300);
					win.setSize(400, 200);
					win.setVisible(true);
				} else {
					
					mark3 = 1;

				}
				Brew b = new Brew(getSize, r);
				try {
					if(b.enoughIngredient(r) == false) {
						String messege="No enough ingredient for this recipe!";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 300);
						win.setSize(400, 200);
						win.setVisible(true);
					}
					else {
						mark1 = 1;
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// Not finish, useless code here.
				if (mark1 == 1&& mark2 == 1 && mark3 == 1) {

					
					try {
						b.implement(r);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String messege="You brew success.";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
			}

		});
	}
}
