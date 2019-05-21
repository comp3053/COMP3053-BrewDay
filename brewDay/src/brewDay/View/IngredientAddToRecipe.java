package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import brewDay.Database;
import brewDay.Recipe;
import brewDay.RecipeIngredient;

import java.awt.Font;

public class IngredientAddToRecipe extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngredientAddToRecipe frame = new IngredientAddToRecipe(0, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param rid 
	 */
	public IngredientAddToRecipe(int rid, String name) {
		setResizable(false);
		setTitle("Add ingredient to recipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblpleaseFillIn = new JLabel(
				"<html>Please fill the new ingredient information then press \"Finish\" button to submit it.</html>");
		lblpleaseFillIn.setFont(new Font("Dialog", Font.BOLD, 14));
		lblpleaseFillIn.setBackground(Color.GREEN);
		lblpleaseFillIn.setBounds(70, 55, 303, 63);
		contentPane.add(lblpleaseFillIn);

		JButton button = new JButton("Back");
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setForeground(new Color(30, 144, 255));
		button.setBounds(18, 7, 75, 36);
		contentPane.add(button);

		button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	dispose();

        	JFrame main;
			try {
				main = new IngredientPage();
			
        	main.setLocation(100,50);
        	main.setSize(600, 500);
        	main.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	}

        	});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 133, 165, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 163, 165, 26);
		contentPane.add(textField_2);

		
		JLabel label_1 = new JLabel("Ingredient name:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(51, 136, 149, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Quantity:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(81, 166, 83, 16);
		contentPane.add(label_2);
		textField_2.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();				
				if((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)|| (keyChar == '.')){
					
				}else{
					e.consume();
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(255, 105, 180));
		btnNewButton_1.setBounds(168, 289, 81, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblwhenYouAdd = new JLabel("<html>When you add ingredient, the system will automatically add units. \n\t\tL for water, \n\t\tg for malts, \n\t\tg for hops, \n\t\tg for yeasts, \n\t\tg for sugars, \n\t\tg for additives</html>");
		lblwhenYouAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		lblwhenYouAdd.setBackground(Color.GREEN);
		lblwhenYouAdd.setBounds(51, 194, 303, 83);
		contentPane.add(lblwhenYouAdd);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int mark1 = 0;
				int mark2 =0;
				int mark3=0;
				int mark4=1;
				
				if (textField_1.getText().trim().equals("")) {
					String messege = "You must input name!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark1 = 1;
				}
				else if (textField_2.getText().trim().equals("")) {
					String messege = "You must input quantity!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark2 = 1;
				}
				else if (textField_3.getText().trim().equals("")) {
					String messege = "You must input unit!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark3 = 1;
				}
				else if(textField_1.getText().trim().equals("water")||textField_1.getText().trim().equals("malts")||textField_1.getText().trim().equals("hops")||textField_1.getText().trim().equals("yeasts")||textField_1.getText().trim().equals("sugars")||textField_1.getText().trim().equals("additives"))
				{
					mark4 = 0;
				}
				else if(mark4==1) {
					String messege = "Ingredient not exit!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					mark3 = 1;
				}
				else
				if(mark1 ==0 && mark2 == 0&&mark3==0){
					String ingrename = textField_1.getText();
					String quan = textField_2.getText();
					float quantity = Float.parseFloat(quan);
					String unit = textField_3.getText();
					RecipeIngredient rein = new RecipeIngredient(ingrename,quantity,unit);
				try {
					rein.addIngredientToRecipe(rid, name);
					dispose();
					JFrame main;
					
					main = new MainIngredient();
				
	        	main.setLocation(100,50);
	        	main.setSize(600, 500);
	        	main.setVisible(true);
					String messege="Success add new ingredient.";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}

		});
	}
}