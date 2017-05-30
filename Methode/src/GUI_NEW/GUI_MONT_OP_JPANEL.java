package GUI_NEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Mont_OP;
import Data.Projekte;
import GUI.GUI;
import GUI.guiMO_ANZ;
import Test.GUIKRIT_JPANEL;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import sql_connector.New_project_SQL;
import sql_connector.Used_AuspSQL;

public class GUI_MONT_OP_JPANEL extends JPanel {
	public ArrayList<Projekte> Projarray;
	private int i=0;
	private int n=1;
	private Auspraegungen retAus;
	public boolean update=false;
	public GUI_MONT_OP_JPANEL() {
		
	
		
		setMont_OP_Panel();
		

	}

	protected void setMont_OP_Panel(){
		this.setBounds(100, 100, 450, 300);
		JLabel mont_OP = new JLabel("Anzahl der Montageoperationen:");
		this.add(mont_OP);
		JTextField txtMon_Nr = new JTextField("2");
		txtMon_Nr.setBounds(10, 219, 86, 20);
		this.add(txtMon_Nr);
		txtMon_Nr.setColumns(10);
		JButton btn_mont_OP = new JButton("OK");
		this.add(btn_mont_OP);
		btn_mont_OP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_project_SQL.set_Montage_Nr(Integer.valueOf(txtMon_Nr.getText()));
				Projarray=sql_connector.New_project_SQL.giveAnzMOPZuLastID();
				
				mont_OP.setVisible(false);
				txtMon_Nr.setVisible(false);
				btn_mont_OP.setVisible(false);
				setMont_OP_Names();
				
				//fillPanel();


			}
		});
		
	}
	protected void setMont_OP_Names(){
		this.setBounds(100, 100, 450, 300);
		JLabel mont_OP_Name = new JLabel("Namen der Montageoperationen:");
		this.add(mont_OP_Name);
		JTextField txtMon_Name = new JTextField("TEST");
		txtMon_Name.setBounds(10, 219, 86, 20);
		this.add(txtMon_Name);
		txtMon_Name.setColumns(10);
		JButton btn_mont_OP_Name = new JButton("OK");
		this.add(btn_mont_OP_Name);
		btn_mont_OP_Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Projarray = New_project_SQL.giveAnzMOPZuLastID();
				Projekte test = Projarray.get(0);
				int k=test.Anz_Montageop;
				
				++i;
				System.out.println("k:"+k);
				System.out.println("i:"+i);
				sql_connector.New_project_SQL.set_Montage_Name(txtMon_Name.getText());
				
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
				
				ArrayList<Kriterien> kritArray = sql_connector.Krit_SQL.giveKrits();
				
				for (Kriterien krit : kritArray)
				{
					int kritId = krit.idKrit;
					ArrayList<Auspraegungen> auspArray = sql_connector.Ausp_SQL.giveAuspraegungenZuKrit(kritId);
					int auspr_id = auspArray.get(0).idAuspr;
					
					Used_AuspSQL.set_usedAusp(auspr_id, maxOpId);
					
				}
				
 				if(i==k){
					
					mont_OP_Name.setVisible(false);
					txtMon_Name.setVisible(false);
					btn_mont_OP_Name.setVisible(false);
					//fillPanel();
					removeAll();
					revalidate();
					
					//GUIKRIT_JPANEL guiKrit = new GUIKRIT_JPANEL();
					GUI_KRIT guiKrit = new GUI_KRIT();
					guiKrit.setVisible(true);
		    	}


			}
		});
		
	}
	/*protected void fillPanel() {
		this.setBounds(100, 100, 450, 300);
		 
		 JTextPane krit_beschreibung= new JTextPane();
		 
		 this.add(krit_beschreibung);
		 
		 JPanel rbtnPanel = new JPanel();
		 rbtnPanel.setBounds(100, 100, 450, 300);
		 rbtnPanel.setLayout(new BoxLayout(rbtnPanel, BoxLayout.Y_AXIS));
		 this.add(rbtnPanel);
		
		 ButtonGroup group = new ButtonGroup();
	

			 Kriterien krit = Krit_SQL.giveKrit(n);
		     krit_beschreibung.setText(krit.Krit_Beschreibung);
		     ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungenZuKrit(n);
		     for (int i = 0; i < Ausparray.size(); i++) {
		    	 retAus = Ausparray.get(i);
		    	 JRadioButton rdbtnAusp_1 = new JRadioButton(retAus.Auspr_Beschreibung);
		    	 rdbtnAusp_1.setActionCommand(String.valueOf(retAus.Auspr_id));
		    	 rdbtnAusp_1.addActionListener(new ActionListener() {
				     	public void actionPerformed(ActionEvent arg0) {
				     		System.out.println(group.getSelection().getActionCommand());
				     	}
				     });
		    	 group.add(rdbtnAusp_1);
		    	
		    	 rbtnPanel.add(rdbtnAusp_1);
		     }
		     JRadioButton rdbtnNot_Rel = new JRadioButton("nicht relevant");
		     rdbtnNot_Rel.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent arg0) {
		     	}
		     });
		     group.add(rdbtnNot_Rel);
	    	 rbtnPanel.add(rdbtnNot_Rel);
		     JButton btnNext = new JButton("Next");
			 btnNext.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		++n;
			 		removeAll();
			 		fillPanel();
			 		System.out.println(n);
			 		if(update==false){
			 		Used_AuspSQL.set_usedAusp(Integer.valueOf(group.getSelection().getActionCommand()));
			 		System.out.println(update);
			 		update=false;
			 		}
			 		else{
			 			System.out.println("Update muss durchgeführt werden");
			 			Used_AuspSQL.update_usedAusp(Integer.valueOf(group.getSelection().getActionCommand()));
			 		}
			 	}
			 });
			 
			 
			 this.add(btnNext);
			 JButton btnPrev = new JButton("Previous");
			 btnPrev.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 	
			    --n;
			 	removeAll();
		 		fillPanel();
		 		//Used_AuspSQL.delete_lastRow();
		 		update=true;
			 	System.out.println(n);
			 	};
			 });
			 this.add(btnPrev);
	
			 	ArrayList<Projekte> Projarray=sql_connector.New_project_SQL.giveAnzMOPZuLastID();
				int test=0;
				for (Projekte kr : Projarray)
				{
					test = kr.Anz_Montageop;
				}
				ButtonGroup group1 = new ButtonGroup();
				
				for (int i = 1; i <= test; i++) {
						
					
					
					
					
					JRadioButton rdbtnAusp_2 = new JRadioButton("O"+i);
				   	rdbtnAusp_2.setVerticalTextPosition(SwingConstants.TOP);
					rdbtnAusp_2.setHorizontalTextPosition(SwingConstants.CENTER);
				   	group1.add(rdbtnAusp_2);
				   
				   int e = group1.getButtonCount();
				   System.out.println(""+e);
				   
				   	group1.setSelected(rdbtnAusp_2.getModel(), true);
				   	this.add(rdbtnAusp_2);
			   	    
			    }
	}*/
}
