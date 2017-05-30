package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Kriterienkataloge;
import Data.Projekte;
import gUITable.TableRendererPanel;
import sql_connector.New_KatalogSQL;
import sql_connector.New_project_SQL;
import sql_connector.list_projectsSQL;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI_MAIN extends JFrame {

	private JPanel contentPane;
	private JTextField txtFProjName;
	private TableRendererPanel katalog;
	private JLabel lblProjName;
	private JButton btnOk;
	private int[] Katalog_id ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MAIN frame = new GUI_MAIN();
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
	public GUI_MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 150, 0, 0, 150, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblKriterienkataloge = new JLabel("Kriterienkataloge:");
		GridBagConstraints gbc_lblKriterienkataloge = new GridBagConstraints();
		gbc_lblKriterienkataloge.insets = new Insets(0, 0, 5, 5);
		gbc_lblKriterienkataloge.gridx = 1;
		gbc_lblKriterienkataloge.gridy = 0;
		contentPane.add(lblKriterienkataloge, gbc_lblKriterienkataloge);

		JLabel lblProjekte = new JLabel("Projekte:");
		GridBagConstraints gbc_lblProjekte = new GridBagConstraints();
		gbc_lblProjekte.insets = new Insets(0, 0, 5, 0);
		gbc_lblProjekte.gridx = 4;
		gbc_lblProjekte.gridy = 0;
		contentPane.add(lblProjekte, gbc_lblProjekte);

		JButton btnNeuesProjekt = new JButton("Neues Projekt");
		btnNeuesProjekt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblProjName.setVisible(true);
				txtFProjName.setVisible(true);
				btnOk.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNeuesProjekt = new GridBagConstraints();
		gbc_btnNeuesProjekt.anchor = GridBagConstraints.WEST;
		gbc_btnNeuesProjekt.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeuesProjekt.gridx = 0;
		gbc_btnNeuesProjekt.gridy = 1;
		contentPane.add(btnNeuesProjekt, gbc_btnNeuesProjekt);

		ArrayList<Kriterienkataloge> KatalogArray =New_KatalogSQL.get_Kataloge();
		Object[] Katalog_data = new Object[KatalogArray.size()];
		Katalog_id = new int[KatalogArray.size()];
		int i = 0;
		for (Kriterienkataloge ap1 : KatalogArray)
		{
			Katalog_data[i]=ap1.katalog_Name;
			Katalog_id[i]=ap1.idKriterienkataloge;
			++i;
		}

		JComboBox cBoxKatalog = new JComboBox(Katalog_data);
		/*cBoxKatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(cBoxKatalog.getSelectedItem());
				System.out.println(Katalog_id[cBoxKatalog.getSelectedIndex()]);
			}
		});*/
		GridBagConstraints gbc_cBoxKatalog = new GridBagConstraints();
		gbc_cBoxKatalog.insets = new Insets(0, 0, 5, 5);
		gbc_cBoxKatalog.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBoxKatalog.gridx = 1;
		gbc_cBoxKatalog.gridy = 1;
		contentPane.add(cBoxKatalog, gbc_cBoxKatalog);





		JButton btnKatalogAnzeigen = new JButton("Katalog anzeigen");
		btnKatalogAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (katalog.isVisible()){
					katalog.setVisible(false);
				}
				else{
					katalog.setVisible(true);
				}




			}
		});
		GridBagConstraints gbc_btnKatalogAnzeigen = new GridBagConstraints();
		gbc_btnKatalogAnzeigen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKatalogAnzeigen.gridx = 2;
		gbc_btnKatalogAnzeigen.gridy = 1;
		contentPane.add(btnKatalogAnzeigen, gbc_btnKatalogAnzeigen);

		JButton btnProjektLaden = new JButton("Projekt laden");
		btnProjektLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnProjektLaden = new GridBagConstraints();
		gbc_btnProjektLaden.insets = new Insets(0, 0, 5, 5);
		gbc_btnProjektLaden.gridx = 3;
		gbc_btnProjektLaden.gridy = 1;
		contentPane.add(btnProjektLaden, gbc_btnProjektLaden);
		
		
		ArrayList<Projekte> Projectsarray= list_projectsSQL.giveProjects();
		Object[] Project_data = new Object[Projectsarray.size()] ;
		int ind2 = 0;
		for (Projekte ap1 : Projectsarray)
		{
			Project_data[ind2]=ap1.Projekt_name;
			
			++ind2;
		}
		
		
		
		JComboBox cBoxProjekt = new JComboBox(Project_data);
		GridBagConstraints gbc_cBoxProjekt = new GridBagConstraints();
		gbc_cBoxProjekt.insets = new Insets(0, 0, 5, 0);
		gbc_cBoxProjekt.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBoxProjekt.gridx = 4;
		gbc_cBoxProjekt.gridy = 1;
		contentPane.add(cBoxProjekt, gbc_cBoxProjekt);

		lblProjName = new JLabel("Projektname:");
		GridBagConstraints gbc_lblProjName = new GridBagConstraints();
		gbc_lblProjName.insets = new Insets(0, 0, 5, 5);
		gbc_lblProjName.gridx = 0;
		gbc_lblProjName.gridy = 2;
		contentPane.add(lblProjName, gbc_lblProjName);
		lblProjName.setVisible(false);

		txtFProjName = new JTextField();
		GridBagConstraints gbc_txtFProjName = new GridBagConstraints();
		gbc_txtFProjName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFProjName.fill = GridBagConstraints.BOTH;
		gbc_txtFProjName.gridx = 1;
		gbc_txtFProjName.gridy = 2;
		contentPane.add(txtFProjName, gbc_txtFProjName);
		txtFProjName.setColumns(10);
		txtFProjName.setVisible(false);

		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_project_SQL.createProject(txtFProjName.getText());
				cBoxProjekt.addItem(txtFProjName.getText());
				
				GUI_MONTOP guiMO = new GUI_MONTOP();
				
				dispose();
				guiMO.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.WEST;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 2;
		btnOk.setVisible(false);
		contentPane.add(btnOk, gbc_btnOk);



		JPanel TablePanel = new JPanel();
		GridBagConstraints gbc_TablePanel = new GridBagConstraints();
		gbc_TablePanel.gridwidth = 3;

		gbc_TablePanel.insets = new Insets(0, 0, 0, 5);
		gbc_TablePanel.fill = GridBagConstraints.BOTH;
		gbc_TablePanel.gridx = 0;
		gbc_TablePanel.gridy = 3;
		contentPane.add(TablePanel, gbc_TablePanel);
		GridBagLayout gbl_TablePanel = new GridBagLayout();
		gbl_TablePanel.columnWidths = new int[]{150, 0};
		gbl_TablePanel.rowHeights = new int[]{0, 0};
		gbl_TablePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_TablePanel.rowWeights = new double[]{0.0, 0.0};
		TablePanel.setLayout(gbl_TablePanel);


		katalog = new TableRendererPanel(Katalog_id[cBoxKatalog.getSelectedIndex()]);
		GridBagConstraints gbc_katalog = new GridBagConstraints();
		gbc_katalog.anchor = GridBagConstraints.NORTHWEST;
		gbc_katalog.gridx = 0;
		gbc_katalog.gridy = 0;
		gbc_katalog.gridheight=3;
		TablePanel.add(katalog, gbc_katalog);

	}

}
