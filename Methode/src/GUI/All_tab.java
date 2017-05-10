package GUI;

import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

import Data.Auspraegungen;
import Data.Kriterien;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
   
public class All_tab extends JFrame {
  
  public All_tab() {
 
   
    DefaultTableModel dtm = new DefaultTableModel() {
       // make first cell uneditable
       public boolean isCellEditable(int row, int column)
       {
          return !(column == 0);
       }
    };
    
    
    
	 String[] columnNames = { "Kh", "Kriterium","Krit_id" ,"Krit_id"};
	    
	    ArrayList<Kriterien> Kritarray=Krit_SQL.giveKrits();
	  	Object[][] data= new Object[Kritarray.size()][4];
	  	
	  	Object[][] data2= {{2,1},{"tes1","uuu"}};
	  	JTable table_inner = new JTable(data,columnNames);
	    TableColumnModel tcm_inner = table_inner.getColumnModel();
	    int i=0;
	  	for (Kriterien kr: Kritarray){
	  		data[i][0]=kr.Krit_Nr;
	  		data[i][1]=kr.Krit_Beschreibung;
	  		data[i][2]=kr.Krit_id;
	  		data[i][3]="";
	  		++i;
	  	
	  	}	
	  
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
	 
	  	
	  	
    //JTable table = new JTable(data1,columnNames1,data,columnNames);
    JTable table = new JTable(data,columnNames);
    TableColumnModel tcm = table.getColumnModel();
   
    tcm.getColumn(0).setCellRenderer(new TextAreaRenderer());
    tcm.getColumn(0).setCellEditor(new TextAreaEditor());
    tcm.getColumn(1).setCellRenderer(new TextAreaRenderer());
    tcm.getColumn(1).setCellEditor(new TextAreaEditor());  
    

    /*tcm.getColumn(0).setPreferredWidth(25);
    tcm.getColumn(0).setMinWidth(25);
    tcm.getColumn(1).setPreferredWidth(400);
    tcm.getColumn(1).setMinWidth(400);
    */
    
    
   
    
    
    table.setRowHeight(80);
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
  
    setSize( 400, 250 );
    setVisible(true);
  }
  class TextAreaRenderer extends JScrollPane implements TableCellRenderer
  {
     JTextArea textarea;
    
     public TextAreaRenderer() {
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        getViewport().add(textarea);
     }
    
     public Component getTableCellRendererComponent(JTable table, Object value,
                                    boolean isSelected, boolean hasFocus,
                                    int row, int column)
     {
        if (isSelected) {
           setForeground(table.getSelectionForeground());
           setBackground(table.getSelectionBackground());
           textarea.setForeground(table.getSelectionForeground());
           textarea.setBackground(table.getSelectionBackground());
        } else {
           setForeground(table.getForeground());
           setBackground(table.getBackground());
           textarea.setForeground(table.getForeground());
           textarea.setBackground(table.getBackground());
        }
    
        textarea.setText((String) value);
        textarea.setCaretPosition(0);
        return this;
     }
  }
  public static void main(String[] args) {
    All_tab frame = new All_tab();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
   
