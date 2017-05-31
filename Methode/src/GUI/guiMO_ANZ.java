package GUI;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Projekte;
import Test.GUI_GRIDBAG;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import sql_connector.New_project_SQL;
import sql_connector.Used_AuspSQL;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class guiMO_ANZ extends JPanel {
	private int n=1;
	private int i= 0;
	private JPanel contPanel;
	public ArrayList<Projekte> Projarray;
    private Auspraegungen retAus;
	 public guiMO_ANZ() {
		 	
		//setMont_OP_Panel();
			 //fillPanel(); 
			
		//contPanel =this;

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
		btn_mont_OP.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		New_project_SQL.set_Montage_Nr(Integer.valueOf(txtMon_Nr.getText()));
		 		 Projarray=sql_connector.New_project_SQL.giveAnzMOPZuLastID();
		 		removeAll();
		 		montOPNames();
		 		//fillPanel();
		 		
		 		
		 	}
		 });
		this.add(btn_mont_OP);
	}
	 

	protected void montOPNames(){
		
		this.setBounds(100, 100, 450, 300);
		//this.setLayout(new GridBagLayout());
		JLabel lmontOPNames = new JLabel("Name:");
		JTextArea txtmontOPNames = new JTextArea("test");
		this.add(lmontOPNames);
		this.add(txtmontOPNames);
		JButton btn_mont_OP = new JButton("OK");
		
		btn_mont_OP.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ArrayList<Projekte> Projarray=sql_connector.New_project_SQL.giveAnzMOPZuLastID();
				int k=0;
				
				
				
				for (Projekte kr : Projarray)
				{
					k = kr.Anz_Montageop;
				}
		 		 
		 		++i;
	    		System.out.println(i);
	    		//sql_connector.New_project_SQL.set_Montage_Name(txtmontOPNames.getText());
		 		 
			    	if(i==k){
			    		
			    		//(new GUI_GRIDBAG());
			    		//test.setVisible(true);
			    	//contPanel.removeAll();
			    	//scontPanel.setVisible(false);
			    		contPanel.setVisible(true);
			    
				 		
			    	}
			    	
			    		
			    	
			    
		 		
		 		
		 		
		 		
		 		//removeAll();
		 		//montOPNames();
		 		//fillPanel();
		 		
		 	}
		 });
		this.add(btn_mont_OP);
		/*GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		gbc.weightx=1;
		gbc.weighty=1;
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(lmontOPNames, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(txtmontOPNames, gbc);*/
		
		//this.setVisible(true);
		
	}
	
	
	
/*	protected void fillPanel() {
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
			 		Used_AuspSQL.set_usedAusp(Integer.valueOf(group.getSelection().getActionCommand()));
			 	}
			 });
			 
			 
			 this.add(btnNext);
			 JButton btnPrev = new JButton("Previous");
			 btnPrev.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 	
			    --n;
			 	removeAll();
		 		fillPanel();
		 		Used_AuspSQL.delete_lastRow();
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