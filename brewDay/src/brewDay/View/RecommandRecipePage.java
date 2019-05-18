package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Brew;
import brewDay.Equipment;
import brewDay.Recipe;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class RecommandRecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecommandRecipePage frame = new RecommandRecipePage();
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
	public RecommandRecipePage() {
		setTitle("Recommend");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>How many litres do you want to brew?</html>");
		lblNewLabel.setBounds(88, 71, 245, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>L</html>");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(251, 113, 13, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textField.setBounds(134, 105, 116, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Recommend!");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setBounds(110, 171, 170, 42);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Back");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.setBounds(20, 16, 75, 36);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	dispose();

        	
        	/*float getCapacity = Equipment.Capacity();
			//System.out.println(getCapacity);
			if(batchsize > getCapacity)
			{
				System.out.println("The current capacity is not enough, "+ getCapacity + " is less than "+batchsize);
				break;
			}
			else 
			{

				flag = Brew.recommend(batchsize);
				if (flag == false)
				{
					break;
				}
				else {
					//System.out.println("The following recipes are recommend:");
					Scanner sc = new Scanner(System.in);
					System.out.println("Which recipe do you want to brew? Please input the recipe name:");
					String s = sc.nextLine();
					Recipe r = new Recipe(s);

					Brew b = new Brew(batchsize, r);
					b.implement(r);
					System.out.println("Brew Finished");
					break;
				}

			}*/
        	
			
        	JFrame home = new HomePage();
        	home.setLocation(100,50);
        	home.setSize(600, 500);
        	home.setVisible(true);
        	}

        	});
	}
}
