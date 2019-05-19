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

public class PromptWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String a="a";
					PromptWindow frame = new PromptWindow(a);
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
	public PromptWindow(String i) {
		setTitle("Prompt Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
/*		setBounds(100, 100, 500, 300);*/
		contentPane = new JPanel();
/*		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(i);
		lblNewLabel.setBounds(88, 71, 245, 29);
		contentPane.add(lblNewLabel);


		JButton button = new JButton("Back");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.setBounds(20, 16, 75, 36);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
	}

}

