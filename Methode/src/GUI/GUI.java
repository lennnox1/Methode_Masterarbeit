package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import Data.Auspraegungen;
import Data.Kriterien;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;

import java.awt.Color;
import java.awt.Container;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable Krit_tab;
	private JTable Ausp_tab;
	private JScrollPane Ausp_scroll;
	private JScrollPane Krit_scroll;


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
				if (Krit_scroll.isVisible()){
					Krit_scroll.setVisible(false);
				}
				else{
					Krit_scroll.setVisible(true);
				}
				if (Ausp_scroll.isVisible()){
					Ausp_scroll.setVisible(false);
				}
				else{
					Ausp_scroll.setVisible(true);
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
		
	
		
		
		
		
		Krit_scroll = new JScrollPane();	
		Krit_tab = new JTable(data, columnNames);
		Krit_scroll.setBounds(10, 71, 250, 137);
		Krit_scroll.setViewportView(Krit_tab);
		contentPane.add(Krit_scroll);
		Krit_scroll.setVisible(false);
		
		
	
		
		String[] columnNames1 = {"Ahg",
                "Ausprägung"
               };

		ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungen();
		Object[][] data1 = new Object[Ausparray.size()][2] ;
		int ind1 = 0;
		for (Auspraegungen ap : Ausparray)
		{
			data1[ind1][0]=ap.Auspr_Nr;
			data1[ind1][1]=ap.Auspr_Beschreibung;
			++ind1;
		}
		

		
		
		
		Ausp_scroll = new JScrollPane();	
		Ausp_tab = new JTable(data1, columnNames1);
		Ausp_scroll.setBounds(261, 71, 110, 128);
		Ausp_scroll.setViewportView(Ausp_tab);
		contentPane.add(Ausp_scroll);
		Ausp_scroll.setVisible(false);
	}
}
