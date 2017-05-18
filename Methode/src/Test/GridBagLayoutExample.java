package Test;
import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample {

    private final int hGap = 2;
    private final int vGap = 2;
    private GridBagConstraints gbc;

    public GridBagLayoutExample () {
        gbc = new GridBagConstraints ();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;   
        gbc.insets = new Insets( hGap, vGap, hGap, vGap ); 
    }

    private void displayGUI () {
        JFrame frame = new JFrame ( "GridBagLayout Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = getPanel ( Color.WHITE );
        contentPane.setLayout ( new GridBagLayout () );

        JPanel blackPanel = getPanel ( Color.BLACK );
        addComp ( contentPane, blackPanel, 0, 1, 1, 1
                            , GridBagConstraints.VERTICAL, 0, 1 ,400,0);
        
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
        
        
        GridBagConstraints d = new GridBagConstraints();
        //d.fill = GridBagConstraints.BOTH;
        d.anchor= GridBagConstraints.EAST;;
        d.gridx = 0;
        d.gridy = 0;
       // d.weightx = 0.4;
       // d.weighty = 0;
       
        
        
        grayPanel.setLayout(new GridBagLayout ());
        JButton btn_prev = new JButton("Previous");
        d.anchor = GridBagConstraints.SOUTHEAST;
        grayPanel.add(btn_prev, d);
        
        JButton btn_next = new JButton("Next");
        d.anchor = GridBagConstraints.SOUTHEAST;
        d.gridx = 1;
        d.gridy = 0;
        grayPanel.add(btn_next, d);

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
        
    }

    private void addComp(JPanel panel, JComponent comp
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

    private JPanel getPanel ( Color bColor ) {
        JPanel panel = new JPanel();
        panel.setOpaque ( true );
        panel.setBackground ( bColor );

        return panel;
    }

    public static void main ( String [] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new GridBagLayoutExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}