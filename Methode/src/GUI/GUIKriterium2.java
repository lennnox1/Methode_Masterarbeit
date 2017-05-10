package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIKriterium2 extends JFrame {
	private int n=1;
	private GridBagConstraints gbc;
	private final int hGap = 5;
    private final int vGap = 5;
    
	 public GUIKriterium2() {
		 	
		    gbc = new GridBagConstraints ();
		    gbc.anchor = GridBagConstraints.FIRST_LINE_START;   
		    gbc.insets = new Insets( hGap, vGap, hGap, vGap );
			 
			
		 
		 displayGUI();

		}

	 public void displayGUI () {
	        JFrame frame = new JFrame ( );
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
	        
	        
	        GridBagConstraints d = new GridBagConstraints();
	        d.fill = GridBagConstraints.BOTH;
	        d.anchor= GridBagConstraints.NORTHWEST;;
	        d.gridx = 0;
	        d.gridy = 0;
	        d.weightx = 0;
	        d.weighty = 0;
	        
	        
	        
	        JButton btn_prev = new JButton("Previous");
	        grayPanel.add(btn_prev, d);
	        JButton btn_next = new JButton("Next");
	        grayPanel.add(btn_next, d);
	        
	 
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
	   
	   
}