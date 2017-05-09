package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.text.Caret;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Projekte;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import sql_connector.New_project_SQL;
import sql_connector.list_projectsSQL;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class GUI extends JFrame {

	
	private JPanel contentPane;
	private JTable Krit_tab;
	private JTable Ausp_tab;
	private JScrollPane Ausp_scroll;
	private JScrollPane Krit_scroll;
	private JTextField  txtProjekt;
	private JLabel lblName;
	private JButton btnOk;
	private JComboBox saved_Projects; 
	private JTextField txtMon_Nr;
	private JTextField textField_1;
	private JRadioButton rdbtnAusp_1;
	private JRadioButton[] jrbColor = new JRadioButton[20];
	private JPanel panel;

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
				if (lblName.isVisible()){
					lblName.setVisible(false);
				}
				else{
					lblName.setVisible(true);
				}
				if (txtProjekt.isVisible()){
					txtProjekt.setVisible(false);
				}
				else{
					txtProjekt.setVisible(true);
				}
				if (btnOk.isVisible()){
					btnOk.setVisible(false);
				}
				else{
					btnOk.setVisible(true);
				}
			}
		});
		btnNeuesProjekt.setBounds(10, 11, 122, 23);
		contentPane.add(btnNeuesProjekt);
		
		JButton button = new JButton("Projekt laden");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(String.valueOf(list_projectsSQL.giveMontage_Nr(saved_Projects.getSelectedItem().toString())));
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
		Krit_tab.getColumnModel().getColumn(0).setMaxWidth(40);
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
	
		
	
		
		
		
		txtProjekt = new JTextField();
		txtProjekt.setBounds(55, 45, 86, 20);
		contentPane.add(txtProjekt);
		txtProjekt.setColumns(10);
		txtProjekt.setVisible(false);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 45, 46, 14);
		contentPane.add(lblName);
		lblName.setVisible(false);
		
	
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.out.println(txtProjekt.getText());
			New_project_SQL.createProject(txtProjekt.getText());
			saved_Projects.addItem(txtProjekt.getText());
			}
		});
		btnOk.setBounds(151, 41, 59, 23);
		contentPane.add(btnOk);
		btnOk.setVisible(false);
	
		ArrayList<Projekte> Projectsarray= list_projectsSQL.giveProjects();
		Object[] Project_data = new Object[Projectsarray.size()] ;
		int ind2 = 0;
		for (Projekte ap1 : Projectsarray)
		{
			Project_data[ind2]=ap1.Projekt_name;
			
			++ind2;
		}
		saved_Projects = new JComboBox(Project_data);
		saved_Projects.setBounds(324, 45, 86, 20);
		contentPane.add(saved_Projects);
		
		txtMon_Nr = new JTextField();
		txtMon_Nr.setBounds(10, 219, 86, 20);
		contentPane.add(txtMon_Nr);
		txtMon_Nr.setColumns(10);
		
		JButton btnOk_1 = new JButton("ok");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New_project_SQL.set_Montage_Nr(Integer.valueOf(txtMon_Nr.getText()),txtProjekt.getText());
			}
		});
		btnOk_1.setBounds(117, 219, 89, 23);
		contentPane.add(btnOk_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(242, 219, 86, 20);
		contentPane.add(textField_1);
		
		
	
		
		
		int n=1;
		JRadioButton rdbtnAusp_1 = new JRadioButton(Ausp_SQL.giveAusp(n));
		rdbtnAusp_1.setBounds(10, 71, 250, 137);
		contentPane.add(rdbtnAusp_1);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=1;
				System.out.println(t);
				++t;
			}
		});
		btnNext.setBounds(345, 218, 89, 23);
		contentPane.add(btnNext);
		
	}		
}
