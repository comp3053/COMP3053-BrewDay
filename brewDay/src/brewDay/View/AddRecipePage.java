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
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("<html>Please complete the table with your new recipe information then press \"Finish\" button to submit it.</html>");
		label.setBackground(Color.GREEN);
		label.setBounds(57, 61, 350, 36);
		contentPane.add(label);
		
		JButton button = new JButton("Back");
		button.setForeground(Color.BLUE);
		button.setBounds(6, 6, 75, 36);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 109, 165, 26);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Recipe name:");
		label_1.setBounds(59, 114, 83, 16);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(298, 109, 52, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finish");
		btnNewButton_1.setForeground(new Color(255, 105, 180));
		btnNewButton_1.setBounds(6, 236, 81, 36);
		contentPane.add(btnNewButton_1);
	}
}
