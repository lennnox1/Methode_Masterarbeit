package GUI_NEW;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Mont_OP;
import Data.Projekte;
import sql_connector.Mont_OPSQL;
import sql_connector.New_project_SQL;
import sql_connector.Used_AuspSQL;
import sql_connector.list_projectsSQL;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class GUI_MONTOP extends JFrame {

	private JPanel contentPane;
	public ArrayList<Projekte> Projarray;
	private int i=0;
	private JTextField txtMon_Nr;
	private int nMontOP=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MONTOP frame = new GUI_MONTOP();
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
	public GUI_MONTOP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setMont_OP_Panel();
		//setMont_OP_Names();
	}
	
	protected void setMont_OP_Names(){
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{160, 100, 47, 0, 0};
		gbl_contentPane.rowHeights = new int[]{23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		//this.setBounds(100, 100, 450, 300);
		JLabel mont_OP_Name = new JLabel("Namen der Montageoperationen:");
		GridBagConstraints gbc_mont_OP_Name = new GridBagConstraints();
		gbc_mont_OP_Name.anchor = GridBagConstraints.WEST;
		gbc_mont_OP_Name.insets = new Insets(0, 0, 0, 5);
		gbc_mont_OP_Name.gridx = 0;
		gbc_mont_OP_Name.gridy = 0;
		getContentPane().add(mont_OP_Name, gbc_mont_OP_Name);
		JTextField txtMon_Name = new JTextField("TEST");
		txtMon_Name.setBounds(10, 219, 86, 20);
		GridBagConstraints gbc_txtMon_Name = new GridBagConstraints();
		gbc_txtMon_Name.fill = GridBagConstraints.BOTH;
		gbc_txtMon_Name.insets = new Insets(0, 0, 0, 5);
		gbc_txtMon_Name.gridx = 1;
		gbc_txtMon_Name.gridy = 0;
		getContentPane().add(txtMon_Name, gbc_txtMon_Name);
		txtMon_Name.setColumns(10);
		JButton btn_mont_OP_Name = new JButton("OK");
		GridBagConstraints gbc_btn_mont_OP_Name = new GridBagConstraints();
		gbc_btn_mont_OP_Name.fill = GridBagConstraints.VERTICAL;
		gbc_btn_mont_OP_Name.insets = new Insets(0, 0, 0, 5);
		gbc_btn_mont_OP_Name.anchor = GridBagConstraints.WEST;
		gbc_btn_mont_OP_Name.gridx = 2;
		gbc_btn_mont_OP_Name.gridy = 0;
		getContentPane().add(btn_mont_OP_Name, gbc_btn_mont_OP_Name);
		
		
		//ArrayList<Mont_OP> Mont_OParray = sql_connector.Mont_OPSQL.get_lastMontOP();
		Projarray = New_project_SQL.giveAnzMOPZuLastID();
		Projekte test = Projarray.get(0);
		int k=test.Anz_Montageop;
		
		
		
		JLabel lblNewLabel = new JLabel("O"+(nMontOP+1)+ " von O"+k);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);	
		
			
		btn_mont_OP_Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++nMontOP;
				
				
				++i;
				System.out.println("k:"+k);
				System.out.println("i:"+i);
				Mont_OPSQL.set_Montage_Name(txtMon_Name.getText());
				
				ArrayList<Mont_OP> Mont_OParray= new ArrayList<Mont_OP>();
				
				Mont_OParray =sql_connector.Mont_OPSQL.get_lastMontOP();
				int maxOpId = 0;
				int projId = 0;
				for (Mont_OP retMont_OP : Mont_OParray)
					{
					    if (maxOpId < retMont_OP.idmontOP)
					    {
					    	maxOpId = retMont_OP.idmontOP;
					    	projId  = retMont_OP.idProjekte;
					    }
					}
				ArrayList<Projekte> Projektarray = list_projectsSQL.get_lastProject();
				Projekte retProj = Projektarray.get(0);
				
				ArrayList<Kriterien> kritArray = sql_connector.Krit_SQL.giveKrits(retProj.idKriterienkataloge);
				
				for (Kriterien krit : kritArray)
				{
					int kritId = krit.idKrit;
					ArrayList<Auspraegungen> auspArray = sql_connector.Ausp_SQL.giveAuspraegungenZuKrit(kritId);
					int auspr_id = auspArray.get(0).idAuspr;
					
					Used_AuspSQL.set_usedAusp(auspr_id, maxOpId);
					
				}
				
 				if(i==k){
					
				
					dispose();
					GUI_KRIT guiKrit = new GUI_KRIT();
					guiKrit.setVisible(true);
		    	}


			}
		});
		
	
	
	}
	
	protected void setMont_OP_Panel(){
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{161, 424, 0};
		gbl_contentPane.rowHeights = new int[]{1, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JLabel mont_OP = new JLabel("Anzahl der Montageoperationen:");
		GridBagConstraints gbc_mont_OP = new GridBagConstraints();
		gbc_mont_OP.anchor = GridBagConstraints.WEST;
		gbc_mont_OP.fill = GridBagConstraints.VERTICAL;
		gbc_mont_OP.insets = new Insets(0, 0, 5, 5);
		gbc_mont_OP.gridx = 0;
		gbc_mont_OP.gridy = 0;
		getContentPane().add(mont_OP, gbc_mont_OP);
		
		txtMon_Nr = new JTextField("2");
		txtMon_Nr.setColumns(10);
		GridBagConstraints gbc_txtMon_Nr = new GridBagConstraints();
		gbc_txtMon_Nr.insets = new Insets(0, 0, 5, 5);
		gbc_txtMon_Nr.fill = GridBagConstraints.BOTH;
		gbc_txtMon_Nr.gridx = 1;
		gbc_txtMon_Nr.gridy = 0;
		contentPane.add(txtMon_Nr, gbc_txtMon_Nr);
		
		JButton btn_mont_OP = new JButton("OK");
		btn_mont_OP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_project_SQL.set_Montage_Nr(Integer.valueOf(txtMon_Nr.getText()));
				Projarray=sql_connector.New_project_SQL.giveAnzMOPZuLastID();
				
				mont_OP.setVisible(false);
				txtMon_Nr.setVisible(false);
				btn_mont_OP.setVisible(false);
				setMont_OP_Names();
			}
		});
		GridBagConstraints gbc_btn_mont_OP = new GridBagConstraints();
		gbc_btn_mont_OP.insets = new Insets(0, 0, 5, 0);
		gbc_btn_mont_OP.gridx = 2;
		gbc_btn_mont_OP.gridy = 0;
		contentPane.add(btn_mont_OP, gbc_btn_mont_OP);
		
	}
	
}


