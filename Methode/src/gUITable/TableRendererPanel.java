package gUITable;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import Data.Auspraegungen;
import Data.Kriterien;
//import Test.TextAreaRenderer;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;

public class TableRendererPanel extends JFrame
{
    public TableRendererPanel()
    {
    	
    	String[] columnNames = { "Kh", "Kriterium","Ahg","Ausprägung"};
    	//String[] columnNames = { "Kh"};
    	 ArrayList<Kriterien> Kritarray=Krit_SQL.giveKrits();
       	Object[][] data_Krit= new Object[Kritarray.size()][4];
    	//Object[] data_Krit= new Object[Kritarray.size()];
       	//JTable[] innerArray1 = new JTable[Kritarray.size()]; 
       	//JTable[] innerArray2 = new JTable[Kritarray.size()]; 
       	int i=0;
       	for (Kriterien kr: Kritarray){
       		//data_Krit[i]=kr.Krit_Nr;
       		data_Krit[i][0]=kr.Krit_Nr;
       		data_Krit[i][1]=kr.Krit_Beschreibung;
       		//ArrayList<Auspraegungen> Ausparray= new ArrayList<Auspraegungen>();
       	
       		ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungenZuKrit(i + 1);
       		Object[][] data_Ausp1= new Object[Ausparray.size()][1];
       		Object[][] data_Ausp2= new Object[Ausparray.size()][1];
       		int n =  0;
       		for (Auspraegungen ap: Ausparray){
       			//
       			data_Ausp1[n][0]=ap.Auspr_Nr;
       			data_Ausp2[n][0]=ap.Auspr_Beschreibung;

       			++n;

       		}



       		JTable innerTabCol3 = new JTable(data_Ausp1, new String[]{"1"});
       		JTable innerTabCol4 = new JTable(data_Ausp2, new String[]{"1"});
       		data_Krit[i][2]=innerTabCol3;
       		data_Krit[i][3]=innerTabCol4;
       		
       		       		
       		++i;

       	}
    	
       JTable table = new JTable(data_Krit,columnNames);
    	
    	
    	
        //JTable table = new JTable(4, 2);
        table.setBounds(100,50,700,900);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
        
       // Object[][] data = {{1,3},{33,44}};
        //Object[] colnam = {"C1","C2"};
        	
        int x=1;

        table.setDefaultRenderer(Object.class, new ComponentInCellRenderer());
        TableColumnModel tcm = table.getColumnModel();
        
        tcm.getColumn(0).setCellRenderer(new ComponentInCellRenderer());
        //tcm.getColumn(0).setCellEditor(new TextAreaEditor());
        tcm.getColumn(1).setCellRenderer(new ComponentInCellRenderer());
        //tcm.getColumn(1).setCellEditor(new TextAreaEditor());  
        
       tcm.getColumn(0).setPreferredWidth(25);
        //tcm.getColumn(0).setMaxWidth(25);
       tcm.getColumn(1).setPreferredWidth(200);
       // tcm.getColumn(1).setMaxWidth(200);
       tcm.getColumn(2).setPreferredWidth(35);
       // tcm.getColumn(2).setMaxWidth(30);
       tcm.getColumn(3).setPreferredWidth(200);
       // tcm.getColumn(3).setMaxWidth(200);


    }

    public static void main(String[] args)
    {
        TableRendererPanel frame = new TableRendererPanel();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    class ComponentInCellRenderer extends JScrollPane implements TableCellRenderer
    {
        private JTextArea textarea;
     
        public ComponentInCellRenderer()
        {
            super();
            textarea = new JTextArea();
            //panel = new JPanel();
            textarea = new JTextArea();
            textarea.setLineWrap(true);
            textarea.setWrapStyleWord(true);
            getViewport().add(textarea);
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, final int row, final int column)
        {
            textarea.removeAll();



            if (isSelected)
                textarea.setBackground( table.getSelectionBackground() );
            else
                textarea.setBackground( table.getBackground() );

            this.add(textarea);
            if (value == null
                    ||  value.toString().length() == 0)
                return this;

            Component retComp;
            if (Component.class.isAssignableFrom(value.getClass()))
            {
                retComp = ((Component)value);

            }
            else
            {
                textarea.setText(value.toString());
                retComp = textarea;
            }    
            Dimension prefSize = retComp.getPreferredSize();
            if (prefSize.getHeight() > table.getRowHeight(row))
            {
                table.setRowHeight(row, (int) prefSize.getHeight());
            }
            retComp.setSize(table.getCellRect(row, column,false).getSize());
            return retComp;
        }
    }

}