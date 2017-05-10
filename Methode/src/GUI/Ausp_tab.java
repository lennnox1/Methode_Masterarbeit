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
   
public class Ausp_tab extends JFrame {
  
  public Ausp_tab() {
    super( "JTextAreaTableExample Example" );
   
    DefaultTableModel dtm = new DefaultTableModel() {
       // make first cell uneditable
       public boolean isCellEditable(int row, int column)
       {
          return !(column == 0);
       }
    };
    
    
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
 

                      
    JTable table = new JTable(data1,columnNames1);
    
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
  
  public static void main(String[] args) {
    Ausp_tab frame = new Ausp_tab();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
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
  
class TextAreaEditor extends DefaultCellEditor {
   protected JScrollPane scrollpane;
   protected JTextArea textarea;
  
   public TextAreaEditor() {
      super(new JCheckBox());
      scrollpane = new JScrollPane();
      textarea = new JTextArea(); 
      textarea.setLineWrap(true);
      textarea.setWrapStyleWord(true);
      scrollpane.getViewport().add(textarea);
   }
  
   public Component getTableCellEditorComponent(JTable table, Object value,
                                   boolean isSelected, int row, int column) {
      textarea.setText((String) value);
  
      return scrollpane;
   }
  
   public Object getCellEditorValue() {
      return textarea.getText();
   }
}