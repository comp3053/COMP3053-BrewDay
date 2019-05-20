package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Database;
import brewDay.Recipe;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DeleteRecipePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRecipePage frame = new DeleteRecipePage();
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
	public DeleteRecipePage() throws SQLException {
		setTitle("Delete Recipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Please choose one recipe that you want to delete, and press \"Finish\" button to submit it.</html>");
		lblNewLabel.setBounds(28, 6, 340, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(27, 46, 68, 29);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	dispose();

        	JFrame MaintainR = new MaintainRecipePage();
        	MaintainR.setLocation(100,50);
        	MaintainR.setSize(600, 500);
        	MaintainR.setVisible(true);
        	}

        	});
		
		
		
		JLabel lbltheTableBelow = new JLabel("<html>The table below shows the ingredient of your recipe:</html>");
		lbltheTableBelow.setBounds(28, 112, 340, 16);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(28, 140, 436, 189);
		contentPane.add(scrollPane);
		
		Vector<String> columnName = new Vector<String>();//×Ö¶ÎÃû
		Vector<Vector<Object>> dataVector = new
		Vector<Vector<Object>>();
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
		
		JLabel lblSelectRecipe = new JLabel("Select recipe:");
		lblSelectRecipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectRecipe.setBounds(73, 335, 91, 16);
		contentPane.add(lblSelectRecipe);
		
		textField = new JTextField();
		textField.setBounds(176, 330, 166, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnFinish.setForeground(new Color(250, 128, 114));
		btnFinish.setBounds(28, 360, 91, 40);
		contentPane.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				Recipe r = new Recipe(name);
				if(textField.getText().trim().equals("")) {
					String messege="You must input name!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
				if(r.whetherInDB()==false) {
					String messege="No such recipe!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
				else {
				
				
				r.deleteRecipe(name);
					
				dispose();
				JFrame MaintainR = new MaintainRecipePage();
	        	MaintainR.setLocation(100,50);
	        	MaintainR.setSize(600, 500);
	        	MaintainR.setVisible(true);
	        	String messege="Recipe " + name + " has been successfully removed from the database.";
				JFrame win = new PromptWindow(messege);
				win.setLocation(500, 80);
				win.setSize(400, 200);
				win.setVisible(true);
				
				}
			}

		});
	}
}

