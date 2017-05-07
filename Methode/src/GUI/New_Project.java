package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql_connector.Krit_SQL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class New_Project extends JFrame  {

	private JPanel contentPane;
	private JTextField txtRownr;
	private JTextField Krit_id;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Project frame = new New_Project();
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
	public New_Project() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Row:");
		lblName.setBounds(10, 22, 46, 17);
		contentPane.add(lblName);
		
		txtRownr = new JTextField();
		txtRownr.setBounds(45, 19, 22, 20);
		contentPane.add(txtRownr);
		txtRownr.setColumns(10);
		
		JButton btnShowRow = new JButton("Show row");
		btnShowRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Krit_id.setText(Krit_SQL.giveKrit(Integer.parseInt(txtRownr.getText())));}
		});
		btnShowRow.setBounds(102, 18, 146, 23);
		contentPane.add(btnShowRow);
		
		Krit_id = new JTextField();
		Krit_id.setBounds(105, 65, 86, 20);
		contentPane.add(Krit_id);
		Krit_id.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 96, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(105, 128, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(105, 168, 86, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 68, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
