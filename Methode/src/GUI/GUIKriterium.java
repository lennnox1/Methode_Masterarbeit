package GUI;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Data.Auspraegungen;
import Data.Kriterien;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GUIKriterium extends JPanel {
	private int n=1;

	
	 
	 public GUIKriterium() {
			 
			 fillPanel(); 
			
			 
		}



	protected void fillPanel() {
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
		    	 Auspraegungen retAus = Ausparray.get(i);
		    	 JRadioButton rdbtnAusp_1 = new JRadioButton(retAus.Auspr_Beschreibung);
		    	 group.add(rdbtnAusp_1);
		    	 rbtnPanel.add(rdbtnAusp_1);
		     }
		     JButton btnNext = new JButton("Next");
			 btnNext.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		++n;
			 		removeAll();
			 		fillPanel();
			 		System.out.println(n);
			 	}
			 });
			 
			 
			 this.add(btnNext);
			 JButton btnPrev = new JButton("Previous");
			 btnPrev.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 	--n;
			 	removeAll();
		 		fillPanel();
			 	System.out.println(n);
			 	}
			 });
			 this.add(btnPrev);
	}

	
	
	
}
