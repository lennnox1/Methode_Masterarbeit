package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Kriterien;
import net.miginfocom.swing.MigLayout;
import sql_connector.Krit_SQL;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class MIGLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int n =4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MIGLayout frame = new MIGLayout();
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
	public MIGLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[20.00][272.00,grow][][]", "[][][][][grow]"));


		Kriterien krit = Krit_SQL.giveKrit(n);



		JLabel labelOPNR = new JLabel("O1:");
		contentPane.add(labelOPNR, "cell 0 0,alignx left,aligny top");

		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,alignx left,aligny top,grow");
		textField.setColumns(10);



		JLabel labelKritNR = new JLabel(krit.Krit_Nr+":");
		contentPane.add(labelKritNR, "cell 0 1,alignx left,aligny top");

		JTextArea krit_Besch = new JTextArea();
		krit_Besch.setLineWrap(true);
		krit_Besch.setWrapStyleWord(true);
		krit_Besch.setText(krit.Krit_Beschreibung);
		contentPane.add(krit_Besch, "cell 1 1,alignx left,aligny top,grow");
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "cell 2 1,alignx right,aligny top");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		contentPane.add(rdbtnNewRadioButton, "cell 3 1,alignx left,aligny top");
	}

}
