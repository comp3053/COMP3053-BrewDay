package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brewDay.Brew;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JList;
import java.awt.Color;

public class shoppingList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoppingList frame = new shoppingList(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param batchsize 
	 * @throws SQLException 
	 */
	public shoppingList(float batchsize) throws SQLException {
		setTitle("shopping list");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(6, 6, 75, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 51, 513, 308);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		List<String> shoplist = new LinkedList<String>();
		shoplist = Brew.shoppingListForUI(batchsize);
		JList list = new JList();
		String[] oblist = shoplist.toArray(new String[] {});
		
		list.setListData(oblist);
		panel.add(list);
	}
}