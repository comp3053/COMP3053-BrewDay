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
import brewDay.Recipe;

public class AddRecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(
				"<html>Please complete the table with your new recipe information then press \"Finish\" button to submit it.</html>");
		label.setBackground(Color.GREEN);
		label.setBounds(82, 7, 350, 36);
		contentPane.add(label);

		JButton button = new JButton("Back");
		button.setForeground(Color.BLUE);
		button.setBounds(6, 6, 75, 36);
		contentPane.add(button);

		button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	setVisible(false);

        	JFrame MaintainR = new MaintainRecipePage();
        	MaintainR.setLocation(100,50);
        	MaintainR.setSize(600, 500);
        	MaintainR.setVisible(true);
        	}

        	});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 53, 165, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 83, 165, 26);
		contentPane.add(textField_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 113, 165, 26);
		contentPane.add(textField);

		JLabel label_1 = new JLabel("Recipe name:");
		label_1.setBounds(42, 58, 83, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Quantity:");
		label_2.setBounds(42, 88, 83, 16);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Unit:");
		label_3.setBounds(42, 118, 83, 16);
		contentPane.add(label_3);

		JButton btnNewButton_1 = new JButton("Finish");
		btnNewButton_1.setForeground(new Color(255, 105, 180));
		btnNewButton_1.setBounds(6, 196, 81, 36);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String quan = textField_2.getText();
				float quantity = Float.parseFloat(quan);
				String unit = textField.getText();
				Recipe r = new Recipe(name, quantity, unit);
				r.addRecipeToDB();
				setVisible(false);

				JFrame addRE = new AddRecipePage();
				addRE.setLocation(100, 50);
				addRE.setSize(600, 500);
				addRE.setVisible(true);
			}

		});
	}
}