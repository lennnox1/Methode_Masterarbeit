package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import Data.Kriterien;
import sql_connector.Krit_SQL;

import java.awt.Color;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable Krit_tab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNeuesProjekt = new JButton("Neues Projekt");
		btnNeuesProjekt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNeuesProjekt.setBounds(10, 11, 122, 23);
		contentPane.add(btnNeuesProjekt);
		
		JButton button = new JButton("Projekt laden");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(141, 11, 122, 23);
		contentPane.add(button);
		
		JButton btnKatalogAnzeign = new JButton("Katalog anzeigen");
		btnKatalogAnzeign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Krit_tab.isVisible()){
					Krit_tab.setVisible(false);
				}
				else{
					Krit_tab.setVisible(true);
				}
			}
		});
		btnKatalogAnzeign.setBounds(273, 11, 137, 23);
		contentPane.add(btnKatalogAnzeign);
		
		String[] columnNames = {"Kh",
                "Kriterium"
               };
	/*	Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};*/
		ArrayList<Kriterien> Kritarray=Krit_SQL.giveKrits();
		

		Object[][] data = new Object[Kritarray.size()][2] ;
		int ind = 0;
		for (Kriterien kr : Kritarray)
		{
			data[ind][0]=kr.Krit_Nr;
			data[ind][1]=kr.Krit_Beschreibung;
			++ind;
		}
		
		
		Krit_tab = new JTable(data, columnNames);
		Krit_tab.setBorder(new LineBorder(new Color(0, 0, 0)));
		Krit_tab.setBounds(128, 123, 250, 137);
		contentPane.add(Krit_tab);
		Krit_tab.setVisible(false);
		
	}
}
