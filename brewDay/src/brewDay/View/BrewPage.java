package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

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
					BrewPage frame = new BrewPage();
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
	public BrewPage() {
		setTitle("Brew");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[] columnNames =	{"ID", "Rcipe name", "Date"};
		Object[][] rowData = {
				{"1", 1, 'l'},
				{"2", 6, 'g'},
				{"3", 6, 'g'},
				{"4", 6, 'g'},
				{"2", 6, 'g'},
				{"3", 6, 'g'},
				{"4", 6, 'g'},
				{"2", 6, 'g'},
				{"3", 6, 'g'},
				{"4", 6, 'g'},
        };
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnNewButton.setBounds(16, 17, 76, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter the recipe name:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 100, 156, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField.setBounds(240, 95, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTheNumberOf = new JLabel("<html>The number of litres:</html>");
		lblTheNumberOf.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblTheNumberOf.setBounds(72, 128, 184, 30);
		contentPane.add(lblTheNumberOf);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(240, 131, 130, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Sorry, the recipe is not exit.</html>");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(139, 234, 191, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("BREW!");
		button.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		button.setBounds(116, 177, 188, 57);
		contentPane.add(button);
	}
}
