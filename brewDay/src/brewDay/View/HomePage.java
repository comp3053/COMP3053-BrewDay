package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewAllRecipes = new JButton("RECIPES");
		btnViewAllRecipes.setBounds(101, 27, 188, 29);
		contentPane.add(btnViewAllRecipes);
		
		JButton btnFeelingGood = new JButton("Recommend");
		btnFeelingGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFeelingGood.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnFeelingGood.setBounds(101, 174, 188, 43);
		contentPane.add(btnFeelingGood);
		
		JButton btnIngredients = new JButton("INGREDIENTS");
		btnIngredients.setBounds(101, 64, 188, 29);
		contentPane.add(btnIngredients);
		
		JButton btnBrew_1 = new JButton("BREW!");
		btnBrew_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnBrew_1.setBounds(101, 105, 188, 57);
		contentPane.add(btnBrew_1);
		
		JButton btnEquipment = new JButton("EQUIPMENT");
		btnEquipment.setBounds(101, 229, 188, 29);
		contentPane.add(btnEquipment);
		
		JButton btnStorage = new JButton("STORAGE");
		btnStorage.setBounds(101, 270, 188, 29);
		contentPane.add(btnStorage);
		
		JButton btnNotes = new JButton("NOTES");
		btnNotes.setBounds(101, 311, 188, 29);
		contentPane.add(btnNotes);
		
		JButton btnLog = new JButton("Log");
		btnLog.setBounds(101, 352, 188, 29);
		contentPane.add(btnLog);
		
		JLabel label = new JLabel("Hello! What would you like to do today?");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(45, 6, 341, 21);
		contentPane.add(label);
	}
}
