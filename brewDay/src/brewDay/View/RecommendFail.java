package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class RecommendFail extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecommendFail frame = new RecommendFail();
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
	public RecommendFail() {
		setTitle("Recommend fail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltheTableBelow = new JLabel("<html>Sorry, the system cannot recommend any recipe. You can click the recipe name to check the missing ingredient and add them to your shopping list.</html>");
		lbltheTableBelow.setBounds(53, 35, 332, 58);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(53, 105, 332, 131);
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
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(0, 6, 94, 29);
		contentPane.add(btnBack);
	}

}
