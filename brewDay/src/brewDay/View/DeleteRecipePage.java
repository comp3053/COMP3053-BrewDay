package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DeleteRecipePage extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	 */
	public DeleteRecipePage() {
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
        	setVisible(false);

        	JFrame MaintainR = new MaintainRecipePage();
        	MaintainR.setLocation(100,50);
        	MaintainR.setSize(600, 500);
        	MaintainR.setVisible(true);
        	}

        	});
		
		JLabel lblSelectRecipe = new JLabel("Select recipe:");
		lblSelectRecipe.setBounds(28, 83, 91, 16);
		contentPane.add(lblSelectRecipe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 78, 204, 27);
		contentPane.add(comboBox);
		
		JLabel lbltheTableBelow = new JLabel("<html>The table below shows the ingredient of your recipe:</html>");
		lbltheTableBelow.setBounds(28, 112, 340, 16);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(28, 140, 436, 189);
		contentPane.add(scrollPane);
		
		Object[] columnNames =	{"Ingredient", "Amount", "Unit"};
		Object[][] rowData = {
				{"water", 1, 'l'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'},
				{"yeast", 6, 'g'}
        };
		
		table = new JTable(rowData, columnNames);
		table.setBackground(new Color(255, 182, 193));
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		
		scrollPane.setViewportView(table);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinish.setForeground(new Color(250, 128, 114));
		btnFinish.setBounds(28, 360, 91, 40);
		contentPane.add(btnFinish);
	}
}