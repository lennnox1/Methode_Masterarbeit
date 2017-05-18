package Test;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Projekte;
import GUI.GUI;

import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import sql_connector.New_project_SQL;
import sql_connector.list_projectsSQL;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GUI_GRIDBAG extends JFrame {
	private int n=1;
	private ArrayList<Projekte> Projarray;
	private JRadioButton rdbtnAusp_1;
	private JRadioButton rdbtnAusp_2;
	private JLabel labelAus ;
	private JProgressBar progressBar;
	private JRadioButton[] buttons;
	
	public GUI_GRIDBAG() {
		initGUI();

	}

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 500);
		Kriterien krit = Krit_SQL.giveKrit(n);
		JScrollPane scroll = new JScrollPane();
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		scroll.setViewportView(panel);
		this.getContentPane().add(panel);
		//this.add(panel);

		TablePanel Tab1 = new TablePanel();
		
		//Tab1.setBounds(100,50,700,900);
		JScrollPane scroll1 = new JScrollPane(Tab1);
				//scroll.setPreferredSize(new Dimension(100, 100));
				//getContentPane().add(scroll);
		scroll1.add(Tab1);
		Tab1.setVisible(true);
		
		
		JLabel labelKritNR = new JLabel(krit.Krit_Nr+":");


		   

		JLabel labelKh = new JLabel("Kh:");
		JLabel labelKbesch = new JLabel("Kriterium:");
		JLabel labelAhg = new JLabel("Ahg:");
		JLabel labelAbesch = new JLabel("Ausprägung:");


		JTextArea krit_Besch = new JTextArea();
		krit_Besch.setLineWrap(true);
		krit_Besch.setWrapStyleWord(true);
		krit_Besch.setText(krit.Krit_Beschreibung);
		//krit_Besch.setBackground(new Color(240,240,240));

		JPanel rbtnPanel = new JPanel(new GridLayout());
		//rbtnPanel.setLayout(new BoxLayout(rbtnPanel, BoxLayout.Y_AXIS));
		//rbtnPanel.setLayout();
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));




		ButtonGroup group = new ButtonGroup();
		ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungenZuKrit(n);
		buttons = new JRadioButton[Ausparray.size() + 1];
		GridBagLayout gridl = new GridBagLayout();
		rbtnPanel.setLayout(gridl);
		rbtnPanel.setPreferredSize(new Dimension(400,1 * Ausparray.size() + 1));
		GridBagConstraints gbc = new GridBagConstraints();
		
		for (int i = 0; i < Ausparray.size(); i++) {
			Auspraegungen retAus = Ausparray.get(i);
			rdbtnAusp_1 = new JRadioButton(retAus.Auspr_Beschreibung);
			rdbtnAusp_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			labelAus= new JLabel(retAus.Auspr_Nr+":");
			buttons[i] = rdbtnAusp_1;
			//Dimension minsize = buttons[i].getSize();
			//minsize.setSize(10, minsize.getHeight());
			//labelAus.setMinimumSize(minsize);
			group.add(rdbtnAusp_1);
		
			//labelPanel.add(labelAus);
			gbc.gridx = 0;
			gbc.gridy = i;
			rbtnPanel.add(labelAus, gbc);
			gbc.gridx = 1;
			gbc.gridy= i;
			rbtnPanel.add(rdbtnAusp_1, gbc);

			
			//rdbtnAusp_1.addActionListener(l);
		}
		JRadioButton rdbtnNot_Rel = new JRadioButton("nicht relevant");
		rdbtnNot_Rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttons[buttons.length - 1] = rdbtnNot_Rel;
		group.add(rdbtnNot_Rel);
		gbc.gridy ++;
		gbc.gridx = 0;
	    rbtnPanel.add(new JLabel(""), gbc);
	    gbc.anchor= GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    rbtnPanel.add(rdbtnNot_Rel, gbc);

		buttons[0].setSelected(true);
		JPanel buttonPanel = new JPanel();
		JButton btnPrev = new JButton("Previous");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				--n;
				//removeAll();
				//initGUI();
				progressBar.setValue(n);
				System.out.println(n);
			}
		});
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//removeAll();
				//setVisible(false);
				
				//initGUI();

				/*while(n<100){
					 progressBar.setValue(n);	
				}*/

				progressBar.setValue(n);
				++n;
				panel.removeAll();
				panel.revalidate();
				//panel.repaint();
				
				initGUI();
				
				
				System.out.println(n);


			}
		});
		buttonPanel.add(btnPrev);
		buttonPanel.add(btnNext);

		Projarray=sql_connector.New_project_SQL.giveAnzMOPZuLastID();
		int anz=0;
		for (Projekte kr : Projarray)
		{
			anz = kr.Anz_Montageop;
		}

		JLabel labelOPNR = new JLabel("O"+anz+":");


		JTextArea opName = new JTextArea("Test");
		opName.setBackground(new Color(240,240,240));


		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		
		
		

		
		
		
	
		gbc.insets = new Insets(5,5,5,5);
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx=0;
		gbc.weighty=1;
		panel.add(rbtnPanel , gbc);
		
		
		
		
		
		//gbc.weighty=1;
		//gbc.anchor = GridBagConstraints.CENTER;


		//gbc.gridx = 0;
		//gbc.gridy = 0;
		//gbc.weightx=1;
		//gbc.weighty=1;
	
		//gbc.ipadx= 200;
        //gbc.ipady= 200;
		//panel.add(labelOPNR, gbc);
		//panel.add(Tab1, gbc);
		
		//gbc.gridx = 1;
		//gbc.gridy = 0;
		//gbc.anchor = GridBagConstraints.WEST;
		//gbc.weightx=0.4;
		//gbc.weighty=0;
		//panel.add(opName, gbc);




		//gbc.gridx = 0;
		//gbc.gridy = 1;
		//gbc.anchor = GridBagConstraints.WEST;
		//gbc.weightx=0;
		//gbc.weighty=1;
		//panel.add(labelKritNR, gbc);

		//gbc.gridx = 1;
		//gbc.gridy = 1;
		//gbc.anchor = GridBagConstraints.WEST;
		//gbc.weightx=0;
		//gbc.weighty=1;
		gbc.fill = GridBagConstraints.VERTICAL;
		//panel.add(krit_Besch, gbc);
		



		//gbc.gridx = 3;
		//gbc.gridy = 1;
		//gbc.gridwidth = 2;
		//gbc.anchor = GridBagConstraints.;
		//gbc.weightx=0;
		//gbc.weighty=1;
		//panel.add(labelPanel , gbc);

		
		
		
	

		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.weightx=0;
		gbc.weighty=1;
		//panel.add(buttonPanel, gbc);


		//gbc.gridx = 0;
		//gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.weightx=0;
		gbc.weighty=1;
		//panel.add(progressBar, gbc); 

		panel.setVisible(true); 

	}

	public static void main(String[] args) {
		GUI_GRIDBAG frame = new GUI_GRIDBAG();
		//frame.pack();
		frame.setVisible(true);


	}
}
