package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Brew;
import brewDay.Database;
import brewDay.Recipe;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;

public class RecommendSuccessful extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecommendSuccessful frame = new RecommendSuccessful(0);
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
	public RecommendSuccessful(float batchsize) throws SQLException {
		
		setTitle("Recommend succeed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lbltheTableBelow = new JLabel("<html>The table below shows the recipe list:</html>");
		lbltheTableBelow.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lbltheTableBelow.setBounds(111, 12, 286, 29);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(65, 53, 332, 164);
		contentPane.add(scrollPane);
		
		
		Vector<String> columnName = new Vector<String>();


		columnName.add("name");
		columnName.add("amount");
		columnName.add("unit");
	
		Vector<Vector<Object>> dataVector= Brew.recommendForUI(batchsize);
		new JTable(dataVector, columnName);
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);	
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(12, 12, 81, 29);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame recomain = new RecommandRecipePage();
				recomain.setLocation(100, 50);
				recomain.setSize(600, 500);
				recomain.setVisible(true);
			}

		});
		
		lblNewLabel = new JLabel("<html>Please input the recipe name that you want to brew right now:</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(65, 229, 363, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setBounds(92, 281, 145, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBrew = new JButton("Brew!");
		btnBrew.setForeground(new Color(50, 205, 50));
		btnBrew.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBrew.setBounds(249, 283, 92, 25);
		contentPane.add(btnBrew);
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String a = textField.getText();
				JFrame brews = new BrewPage(a,batchsize);
				brews.setLocation(100, 50);
				brews.setSize(600, 500);
				brews.setVisible(true);
			}

		});
	}
}
