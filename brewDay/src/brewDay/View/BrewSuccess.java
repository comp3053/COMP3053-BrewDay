package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrewSuccess extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrewSuccess frame = new BrewSuccess();
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
	public BrewSuccess() {
		setTitle("Brew success");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lbltheTableBelow = new JLabel("<html>You have brew success</html>");
		lbltheTableBelow.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lbltheTableBelow.setBounds(81, 47, 286, 29);
		contentPane.add(lbltheTableBelow);
		
		/*JScrollPane scrollPane = new JScrollPane();            
		scrollPane.setBounds(53, 89, 332, 131);
		contentPane.add(scrollPane);*/
		
		
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setBounds(12, 12, 81, 29);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	dispose();

        	JFrame home = new HomePage();
        	home.setLocation(100,50);
        	home.setSize(600, 500);
        	home.setVisible(true);
        	}

        	});
		
		lblNewLabel = new JLabel("<html>Please click back to homepage</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(81, 246, 332, 29);
		contentPane.add(lblNewLabel);
	}
}
