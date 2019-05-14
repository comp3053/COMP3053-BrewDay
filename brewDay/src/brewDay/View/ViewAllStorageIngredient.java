package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;

public class ViewAllStorageIngredient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStorageIngredient frame = new ViewAllStorageIngredient();
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
	public ViewAllStorageIngredient() {
		setTitle("Storage Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 53, 345, 183);
		contentPane.add(scrollPane);
		
		Object[] columnNames =	{"Ingredient name", "Amount", "Unit"};
		Object[][] rowData = {
				{"beer", 1, 'l'},
				{"dasd", 6, 'g'},
				{"asd", 6, 'g'},
				{"asd", 6, 'g'},
				{"asd", 6, 'g'},
				{"fsdght", 6, 'g'},
				{"yfgfst", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'}
        };
		
		table = new JTable(rowData, columnNames);
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Back");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(12, 12, 68, 29);
		contentPane.add(button);
	}
}
