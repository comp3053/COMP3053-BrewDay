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
import brewDay.StorageIngredient;

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
					IngredientToStorage frame = new IngredientToStorage();
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
		
		Vector<String> columnName = new Vector<String>();//×Ö¶ÎÃû
		Vector<Vector<Object>> dataVector = new
		Vector<Vector<Object>>();
		columnName.add("name");
		columnName.add("amount");
		columnName.add("unit");
		
		ResultSet rs= StorageIngredient.AllStorageIngredient();
		
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
		
		button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	dispose();

        	JFrame home = new HomePage();
        	home.setLocation(100,50);
        	home.setSize(600, 500);
        	home.setVisible(true);
        	}

        	});
	}
}
