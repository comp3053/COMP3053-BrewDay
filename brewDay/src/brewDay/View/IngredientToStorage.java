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

public class IngredientToStorage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JLabel lblNewLabel;

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
	public IngredientToStorage() throws SQLException {
		
		setTitle("Recommend succes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lbltheTableBelow = new JLabel("<html>The table below shows the recipe list:</html>");
		lbltheTableBelow.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lbltheTableBelow.setBounds(81, 47, 286, 29);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(53, 89, 332, 131);
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
		
		lblNewLabel = new JLabel("<html>Please click recipe name to brew the exact recipe</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(81, 246, 332, 29);
		contentPane.add(lblNewLabel);
	}
}
