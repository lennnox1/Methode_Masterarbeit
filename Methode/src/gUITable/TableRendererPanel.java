package gUITable;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import Data.Ausp_LPS;
import Data.Auspraegungen;
import Data.Krit_LPS;
import Data.Kriterien;

import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import sql_connector.New_KatalogSQL;

public class TableRendererPanel extends JPanel
{
	public TableRendererPanel(int KatID)
	{
		
		DefaultTableModel dtm = new DefaultTableModel() {


			public boolean isCellEditable(int row, int column)
			{

				return false;

			}
		};
		String[] columnNames = { "Kh", "Kriterium","Ahg","Ausprägung"};

		
		ArrayList<Kriterien> Kritarray = New_KatalogSQL.get_KritsofKatID(KatID);
		Object[][] data_Krit= new Object[Kritarray.size()][4];

		int i=0;
		for (Kriterien kr: Kritarray){

			data_Krit[i][0]=kr.Krit_Nr;
			data_Krit[i][1]=kr.Krit_Beschreibung;

			ArrayList<Auspraegungen> Ausparray=New_KatalogSQL.get_AuspofKatID(i+1);
			Object[][] data_Ausp1= new Object[Ausparray.size()][1];
			Object[][] data_Ausp2= new Object[Ausparray.size()][1];
			int n =  0;
			for (Auspraegungen ap: Ausparray){
				
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
		 dtm.setDataVector(data_Krit,columnNames);
		
		
		JTable table = new JTable(dtm);


		table.setBounds(100,50,300,300);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scroll = new JScrollPane(table);
		//getContentPane().add(scroll);
		this.add(scroll);
	  // table.add(scroll);


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
		tcm.getColumn(2).setPreferredWidth(50);
		// tcm.getColumn(2).setMaxWidth(30);
		tcm.getColumn(3).setPreferredWidth(200);
		// tcm.getColumn(3).setMaxWidth(200);

		
		
		this.setVisible(false);
		//this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		//this.pack();
		//this.setLocationRelativeTo( null );
	}

	
	/* public static void main(String[] args)
    {
       TableRendererPanel frame = new TableRendererPanel();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);

    }*/

	class ComponentInCellRenderer extends JScrollPane implements TableCellRenderer
	{
		private JTextArea textarea;

		public ComponentInCellRenderer()
		{
			super();
			
		
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