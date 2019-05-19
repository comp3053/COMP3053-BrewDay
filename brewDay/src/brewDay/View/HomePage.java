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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	static JFrame frame = new JFrame();

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
		setBounds(100, 100, 434, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnViewAllRecipes = new JButton("ALL RECIPES");
		btnViewAllRecipes.setBounds(101, 27, 188, 29);
		contentPane.add(btnViewAllRecipes);

		btnViewAllRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				JFrame allRecipe;
				try {
					allRecipe = new ViewAllRecipe();
					allRecipe.setLocation(100, 50);
					allRecipe.setSize(600, 500);
					allRecipe.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});	  

		JButton btnFeelingGood = new JButton("Recommend");
		btnFeelingGood.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnFeelingGood.setBounds(101, 174, 188, 43);
		contentPane.add(btnFeelingGood);

		btnFeelingGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame recom = new RecommandRecipePage();
				recom.setLocation(100, 50);
				recom.setSize(600, 500);
				recom.setVisible(true);
			}
		});

		JButton btnIngredients = new JButton("INGREDIENTS");
		btnIngredients.setBounds(101, 64, 188, 29);
		contentPane.add(btnIngredients);

		btnIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame ingre;
				try {
					ingre = new IngredientPage();
					ingre.setLocation(100, 50);
					ingre.setSize(600, 500);
					ingre.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		JButton btnBrew_1 = new JButton("BREW!");
		btnBrew_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnBrew_1.setBounds(101, 105, 188, 57);
		contentPane.add(btnBrew_1);

		btnBrew_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame bre = new BrewPage();
				bre.setLocation(100, 50);
				bre.setSize(600, 500);
				bre.setVisible(true);
			}
		});

		JButton btnEquipment = new JButton("EQUIPMENT");
		btnEquipment.setBounds(101, 229, 188, 29);
		contentPane.add(btnEquipment);

		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame equip = new MaintainEquipmentInfoPage();
				equip.setLocation(100, 50);
				equip.setSize(600, 500);
				equip.setVisible(true);
			}
		});

		JButton btnStorage = new JButton("STORAGE");
		btnStorage.setBounds(101, 270, 188, 29);
		contentPane.add(btnStorage);

		btnStorage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame stor = new ViewAllStorageIngredient();
				stor.setLocation(100, 50);
				stor.setSize(600, 500);
				stor.setVisible(true);
			}
		});

		JButton btnNotes = new JButton("NOTES");
		btnNotes.setBounds(101, 311, 188, 29);
		contentPane.add(btnNotes);

		btnNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame note = new NoteWritingPage();
				note.setLocation(100, 50);
				note.setSize(600, 500);
				note.setVisible(true);
			}
		});

		JButton btnLog = new JButton("Log");
		btnLog.setBounds(101, 352, 188, 29);
		contentPane.add(btnLog);

		// there is no log yet...
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame logg = new Log();
				logg.setLocation(100, 50);
				logg.setSize(600, 500);
				logg.setVisible(true);
			}
		});

		JLabel label = new JLabel("Hello! What would you like to do today?");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(45, 6, 341, 21);
		contentPane.add(label);
	}
}
