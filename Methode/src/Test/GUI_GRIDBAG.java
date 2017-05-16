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
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GUI_GRIDBAG extends JFrame {
	private int n=1;
	private ArrayList<Projekte> Projarray;
	private JRadioButton rdbtnAusp_1;
	private JLabel labelAus ;
	private JProgressBar progressBar;
	
	public GUI_GRIDBAG() {
		initGUI();
		
	}

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		Kriterien krit = Krit_SQL.giveKrit(n);
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);
		//this.add(panel);


		JLabel labelKritNR = new JLabel(krit.Krit_Nr+":");
		
		
		
		
		JLabel labelKh = new JLabel("Kh:");
		JLabel labelKbesch = new JLabel("Kriterium:");
		JLabel labelAhg = new JLabel("Ahg:");
		JLabel labelAbesch = new JLabel("Ausprägung:");
		
		
		JTextArea krit_Besch = new JTextArea(3,1);
		krit_Besch.setLineWrap(true);
		krit_Besch.setWrapStyleWord(true);
		krit_Besch.setText(krit.Krit_Beschreibung);
		krit_Besch.setBackground(new Color(240,240,240));

		JPanel rbtnPanel = new JPanel();
		rbtnPanel.setLayout(new BoxLayout(rbtnPanel, BoxLayout.Y_AXIS));
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

		
		

		ButtonGroup group = new ButtonGroup();
		ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungenZuKrit(n);
		for (int i = 0; i < Ausparray.size(); i++) {
			Auspraegungen retAus = Ausparray.get(i);
			rdbtnAusp_1 = new JRadioButton(retAus.Auspr_Beschreibung);
			rdbtnAusp_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			labelAus= new JLabel(retAus.Auspr_Nr+":");
			
			
			
			group.add(rdbtnAusp_1);
			labelPanel.add(labelAus);
			rbtnPanel.add(rdbtnAusp_1);
			//rdbtnAusp_1.addActionListener(l);
		}
		JRadioButton rdbtnNot_Rel = new JRadioButton("nicht relevant");
	     rdbtnNot_Rel.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     	}
	     });
	     group.add(rdbtnNot_Rel);
	     rbtnPanel.add(rdbtnNot_Rel);
		
		
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
				
				++n;
				//initGUI();
				//setVisible(false);
				/*while(n<100){
					 progressBar.setValue(n);	
				}*/
				//removeAll();
				 progressBar.setValue(n);
				initGUI();
				revalidate();
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
		
		
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.anchor = GridBagConstraints.EAST;
		
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(labelOPNR, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(opName, gbc);
		
		
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(labelKritNR, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(krit_Besch, gbc);


		

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(labelPanel , gbc);

		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(rbtnPanel , gbc);

		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(buttonPanel, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(progressBar, gbc);
	
	//this.setVisible(true);
	
	}

	public static void main(String[] args) {
		GUI_GRIDBAG frame = new GUI_GRIDBAG();
		//frame.pack();
		frame.setVisible(true);
		
	
	}
}
