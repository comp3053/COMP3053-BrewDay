
package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Brew;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class NoteAddToBrew extends JFrame {

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
					NoteAddToBrew frame = new NoteAddToBrew();
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
	public NoteAddToBrew() throws SQLException {
		setTitle("Note");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Please see the brew history.</html>");
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

        	JFrame mainn;
			try {
				mainn = new NoteMain();
			
        	mainn.setLocation(100,50);
        	mainn.setSize(600, 500);
        	mainn.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	}

        	});
		
		
		
		JLabel lbltheTableBelow = new JLabel("<html>The table below shows brew record:</html>");
		lbltheTableBelow.setBounds(28, 112, 340, 16);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(28, 140, 436, 189);
		contentPane.add(scrollPane);
		
		Vector<String> columnName = new Vector<String>();
		Vector<Vector<Object>> dataVector = new
		Vector<Vector<Object>>();
		columnName.add("Brew index");
		columnName.add("Amount");
		columnName.add("Date");
		columnName.add("Recipe id");
		
		ResultSet rs= Brew.Record();
		
		while(rs.next()){
		Vector<Object> vec = new Vector<Object>();//single for big Vector
		for(int i=1;i<=4;i++){
		vec.add(rs.getObject(i));
		}
		dataVector.add(vec);
		}
		
		table = new JTable(dataVector, columnName);
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);	
		scrollPane.setViewportView(table);
		
		JLabel lblSelectRecipe = new JLabel("Select brewid:");
		lblSelectRecipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectRecipe.setBounds(73, 335, 91, 16);
		contentPane.add(lblSelectRecipe);
		
		textField = new JTextField();
		textField.setBounds(176, 330, 166, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

				} else {
					e.consume();
				}
			}
		});
		
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnFinish.setForeground(new Color(250, 128, 114));
		btnFinish.setBounds(28, 360, 91, 40);
		contentPane.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				if (textField.getText().trim().equals("")) {
					String messege = "Empty input!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				} 
				try {
					String idid = textField.getText();
					int bid = Integer.parseInt(idid);
					Brew b = new Brew(bid);
					if(b.whetherInDB(bid)==false) {
						String messege = "No this brew record!";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 80);
						win.setSize(400, 200);
						win.setVisible(true);
					}
					else {
						
					
					dispose();

					
					JFrame write = new NoteWritingPage(bid,"Add",0,null);

					write.setLocation(100,50);
   	write.setSize(600, 500);
   	write.setVisible(true);}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	}

	        	});
	}
}

