package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Brew;
import brewDay.Database;
import brewDay.Note;
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

public class NoteMain extends JFrame {

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
					NoteMain frame = new NoteMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public NoteMain() throws SQLException {
		setTitle("Note");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("<html>Note mainpage</html>");
		lblNewLabel.setBounds(28, 6, 340, 40);
		contentPane.add(lblNewLabel);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(27, 46, 68, 29);
		contentPane.add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				JFrame home = new HomePage();
				home.setLocation(100, 50);
				home.setSize(600, 500);
				home.setVisible(true);
			}

		});

		JButton btnAdd = new JButton("Add Note");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setForeground(new Color(30, 144, 255));
		btnAdd.setBounds(27, 83, 88, 29);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame addn;
				try {
					addn = new NoteAddToBrew();

					addn.setLocation(400, 80);
					addn.setSize(500, 500);
					addn.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JLabel lbltheTableBelow = new JLabel("<html>The table below shows the note record:</html>");
		lbltheTableBelow.setBounds(28, 112, 340, 16);
		contentPane.add(lbltheTableBelow);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 140, 436, 189);
		contentPane.add(scrollPane);

		Vector<String> columnName = new Vector<String>();// �ֶ���
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>();
		columnName.add("Note Index");
		columnName.add("Content");
		columnName.add("Date");
		columnName.add("BrewID");

		ResultSet rs = Note.AllNote();

		while (rs.next()) {
			Vector<Object> vec = new Vector<Object>();// single for big Vector
			for (int i = 1; i <= 4; i++) {
				vec.add(rs.getObject(i));
			}
			dataVector.add(vec);
		}

		table = new JTable(dataVector, columnName);
		scrollPane.add(table.getTableHeader());
		scrollPane.add(table);
		scrollPane.setViewportView(table);

		JLabel lblSelectRecipe = new JLabel("Input NoteId:");
		lblSelectRecipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectRecipe.setBounds(98, 336, 100, 16);
		contentPane.add(lblSelectRecipe);

		textField = new JTextField();
		textField.setBounds(186, 330, 166, 29);
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

		JButton btnedit = new JButton("Edit");
		btnedit.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnedit.setForeground(new Color(250, 128, 114));
		btnedit.setBounds(187, 370, 61, 29);
		contentPane.add(btnedit);

		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().trim().equals("")) {
					String messege = "You must input Note id!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
				String nid = textField.getText();
				int id = Integer.parseInt(nid);
				Note note = new Note();

				try {
					if (note.whetherInDB(id) == false) {
						String messege = "No such note!";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 80);
						win.setSize(400, 200);
						win.setVisible(true);
					} else {
						// edit

						String oldtext;
						try {
							oldtext = Note.getText(id);

							dispose();
							JFrame edn = new NoteWritingPage(0, "Edit", id, oldtext);
							edn.setLocation(400, 80);
							edn.setSize(500, 500);
							edn.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton btndelete = new JButton("delete");
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 13));

		btndelete.setForeground(new Color(250, 128, 114));
		btndelete.setBounds(261, 370, 91, 29);
		contentPane.add(btndelete);
		btndelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (textField.getText().trim().equals("")) {
					String messege = "You must input Note id!";
					JFrame win = new PromptWindow(messege);
					win.setLocation(500, 80);
					win.setSize(400, 200);
					win.setVisible(true);
				}
				String nid = textField.getText();
				int id = Integer.parseInt(nid);
				Note note = new Note();
				try {
					if (note.whetherInDB(id) == false) {
						String messege = "No such note!";
						JFrame win = new PromptWindow(messege);
						win.setLocation(500, 80);
						win.setSize(400, 200);
						win.setVisible(true);
					} else {

						Note.UIdelete(id);
						dispose();
						JFrame notemain;
						try {
							notemain = new NoteMain();

							notemain.setLocation(100, 50);
							notemain.setSize(600, 500);
							notemain.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
	}
}