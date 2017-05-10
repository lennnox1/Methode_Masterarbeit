package GUI;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Data.Auspraegungen;
import Data.Kriterien;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import javax.swing.AbstractAction;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GUIKriterium extends JPanel {
	private int n=1;
	private GridBagConstraints gbc;
	private final int hGap = 5;
    private final int vGap = 5;
	 
	 public GUIKriterium() {
			 
			 //fillPanel(); 
			
		 gbc = new GridBagConstraints ();
	        gbc.anchor = GridBagConstraints.FIRST_LINE_START;   
	        gbc.insets = new Insets( hGap, vGap, hGap, vGap ); 
		 displayGUI ();

		}

	 public void displayGUI () {
	        JFrame frame = new JFrame ( "GridBagLayout Example" );
	        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

	        JPanel contentPane = getPanel ( Color.WHITE );
	        contentPane.setLayout ( new GridBagLayout () );

	        JPanel blackPanel = getPanel ( Color.BLACK );
	        addComp ( contentPane, blackPanel, 0, 1, 1, 1
	                            , GridBagConstraints.VERTICAL, 0, 1 ,300,0);
	        
	        JPanel blackPanel1 = getPanel ( Color.GREEN );
	        addComp ( contentPane, blackPanel1, 1, 1, 1, 1
	                            , GridBagConstraints.VERTICAL, 0, 1 ,200,0);
	        
	        JPanel blackPanel2 = getPanel ( Color.RED );
	        addComp ( contentPane, blackPanel2, 2, 1, 1, 1
	                            , GridBagConstraints.VERTICAL, 0, 1 ,200,0);
	        
	        JPanel blackPanel3 = getPanel ( Color.BLUE );
	        addComp ( contentPane, blackPanel3, 3, 1, 1, 1
	                            , GridBagConstraints.VERTICAL, 0, 0 ,200,0);
	        
	        JPanel blackPanel4 = getPanel ( Color.MAGENTA );
	        addComp ( contentPane, blackPanel4, 4, 1, 1, 1
	                            , GridBagConstraints.BOTH, 1, 1 ,200,0);

	       JPanel grayPanel = getPanel ( Color.GRAY );
	        addComp ( contentPane, grayPanel, 0, 2, 5, 1
	                            , GridBagConstraints.BOTH, 0.7, 0.3 ,0,0);
	        
	        JPanel grayPanel1 = getPanel ( Color.CYAN );
	        addComp ( contentPane, grayPanel1, 0, 0, 5, 1
	                            , GridBagConstraints.BOTH, 0.7, 0.3 ,0,0);
	       
	        

	        frame.setContentPane ( contentPane );
	        frame.pack ();
	        frame.setLocationByPlatform ( true );
	        frame.setVisible ( true );
	        
	    }
	   public JPanel getPanel ( Color bColor ) {
	        JPanel panel = new JPanel();
	        panel.setOpaque ( true );
	        panel.setBackground ( bColor );

	        return panel;
	    }
	   public void addComp(JPanel panel, JComponent comp
               , int x, int y, int gWidth
                   , int gHeight, int fill
                       , double weightx, double weighty, int ipadx,int ipady) {
gbc.gridx = x;
gbc.gridy = y;
gbc.gridwidth = gWidth;
gbc.gridheight = gHeight;
gbc.fill = fill;
gbc.weightx = weightx;
gbc.weighty = weighty;      

gbc.ipadx= ipadx;
gbc.ipady= ipady;
panel.add(comp, gbc);
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
