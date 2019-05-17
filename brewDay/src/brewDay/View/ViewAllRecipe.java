package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import brewDay.Recipe;

public class ViewAllRecipe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllRecipe frame = new ViewAllRecipe();
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
	public ViewAllRecipe() throws SQLException {
		setTitle("All Recipe Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 53, 345, 183);
		contentPane.add(scrollPane);
		
		/*Object[] columnNames =	{"Recipe Name", "Quantity", "Unit"};
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
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		
		scrollPane.setViewportView(table);*/
		
		Vector<String> columnName = new Vector<String>();//字段名
		Vector<Vector<Object>> dataVector = new
		Vector<Vector<Object>>(); //存储所有数据，里面每个小的Vector是存单行的
		columnName.add("name");
		columnName.add("amount");
		columnName.add("unit");
		
		ResultSet rs= Recipe.allRecipe();
		
		while(rs.next()){
		Vector<Object> vec = new Vector<Object>();//single for big Vector
		for(int i=2;i<=4;i++){
		vec.add(rs.getObject(i));
		}
		dataVector.add(vec);
		}
		
		table = new JTable(dataVector, columnName);
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		
		scrollPane.setViewportView(table);
		//DataBase.free(conn, stmt, rs);
		
		JButton button = new JButton("Back");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(12, 12, 68, 29);
		contentPane.add(button);
	}
}