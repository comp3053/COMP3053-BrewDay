package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class RecommendSuccessful extends JFrame {

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
					RecommendSuccessful frame = new RecommendSuccessful();
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
	public RecommendSuccessful() {
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
		
		table = new JTable(rowData, columnNames);
		table.setBackground(new Color(255, 182, 193));
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		
		scrollPane.setViewportView(table);
		
		contentPane.add(scrollPane);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(12, 12, 81, 29);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("<html>Please click recipe name to brew the exact recipe</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(81, 246, 332, 29);
		contentPane.add(lblNewLabel);
	}
}
