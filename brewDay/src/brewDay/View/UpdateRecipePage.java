package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class UpdateRecipePage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRecipePage frame = new UpdateRecipePage();
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
	public UpdateRecipePage() {
		setTitle("Update Recipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Please choose one recipe that you want to update, and press \"Finish\" button to submit it.</html>");
		lblNewLabel.setBounds(28, 6, 340, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
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
		lblSelectRecipe.setBounds(28, 76, 91, 16);
		contentPane.add(lblSelectRecipe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 72, 204, 27);
		contentPane.add(comboBox);
		
		JLabel lbltheTableBelow = new JLabel("<html>The table below shows the ingredient of your recipe:</html>");
		lbltheTableBelow.setBounds(28, 98, 340, 16);
		contentPane.add(lbltheTableBelow);
		
		JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(28, 126, 332, 177);
		contentPane.add(scrollPane);
		
		Object[] columnNames =	{"Ingredient", "Amount", "Unit"};
		Object[][] rowData = {
				{"water", 1, 'l'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'},
				{"yeast", 7, 'g'}
        };
		
		table = new JTable(rowData, columnNames);
		table.setBackground(new Color(255, 255, 0));
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		
		scrollPane.setViewportView(table);
		
		JLabel lbldoubleClickThe = new JLabel("<html>Double click the attribute of an ingredient that you want it to be updated.</html>");
		lbldoubleClickThe.setBounds(28, 309, 332, 29);
		contentPane.add(lbldoubleClickThe);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setForeground(new Color(250, 128, 114));
		btnFinish.setBounds(28, 340, 78, 29);
		contentPane.add(btnFinish);
	}
}
