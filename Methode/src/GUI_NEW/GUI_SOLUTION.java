package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Algorithmus.Eignungsgrade;
import Data.Mont_OP;
//import GUI.GUI;
import sql_connector.Mont_OPSQL;
import sql_connector.Solution_SQL;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI_SOLUTION extends JFrame {

	private JPanel contentPane;
	private JProgressBar proBar;

	private int i =0;
	private ArrayList<Mont_OP> Mont_OParray;
	private Mont_OP retMont_OP;
	private JTextField txtFMontOPName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_SOLUTION frame = new GUI_SOLUTION(39);
					frame.setVisible(true);
					//frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_SOLUTION(int projektID) {
		initGUI(projektID);
	}

	protected void initGUI(int projektID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{25, 150, 40, 40, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 30, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);




		
		Mont_OParray =sql_connector.Mont_OPSQL.get_MontOPzuProjekt(projektID);
			

		//Mont_OParray = sql_connector.Mont_OPSQL.get_lastMontOP();
		
		
		Eignungsgrade eigGrade = new Eignungsgrade(projektID);

		for(i =0; i<Mont_OParray.size();i++){
			
			
			
			retMont_OP = Mont_OParray.get(i);
			JPanel contentPane1 = new JPanel();
			GridBagConstraints gbc_contentPane1 = new GridBagConstraints();
			gbc_contentPane1.fill = GridBagConstraints.BOTH;
			gbc_contentPane1.gridwidth = 4;
			gbc_contentPane1.gridx = 0;
			gbc_contentPane1.gridy = i;
			contentPane.add(contentPane1, gbc_contentPane1);
			GridBagLayout gbl_contentPane1 = new GridBagLayout();
			gbl_contentPane1.columnWidths = new int[]{35, 65, 100, 100, 0};
			gbl_contentPane1.rowHeights = new int[]{25, 0, 25, 0};
			gbl_contentPane1.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_contentPane1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			contentPane1.setLayout(gbl_contentPane1);

			JLabel lblFM = new JLabel("<html>F<sub>M</sub>=" +eigGrade.RatingFM[i]+"</html>");
			GridBagConstraints gbc_lblFM = new GridBagConstraints();
			gbc_lblFM.anchor = GridBagConstraints.WEST;
			gbc_lblFM.insets = new Insets(0, 0, 5, 5);
			gbc_lblFM.gridx = 2;
			gbc_lblFM.gridy = 1;
			contentPane1.add(lblFM, gbc_lblFM);

			JLabel lblFR = new JLabel("<html>F<sub>R</sub>="+eigGrade.RatingFR[i]+"</html>");
			GridBagConstraints gbc_lblFR = new GridBagConstraints();
			gbc_lblFR.anchor = GridBagConstraints.EAST;
			gbc_lblFR.insets = new Insets(0, 0, 5, 0);
			gbc_lblFR.gridx = 3;
			gbc_lblFR.gridy = 1;
			contentPane1.add(lblFR, gbc_lblFR);

			JLabel lblMontOP = new JLabel("O"+(i+1)+":");
			GridBagConstraints gbc_lblMontOP = new GridBagConstraints();
			gbc_lblMontOP.anchor = GridBagConstraints.WEST;
			gbc_lblMontOP.insets = new Insets(0, 0, 0, 5);
			gbc_lblMontOP.gridx = 0;
			gbc_lblMontOP.gridy = 2;
			contentPane1.add(lblMontOP, gbc_lblMontOP);

			txtFMontOPName = new JTextField(retMont_OP.montOP_name);
			GridBagConstraints gbc_txtFMontOPName = new GridBagConstraints();
			gbc_txtFMontOPName.fill = GridBagConstraints.BOTH;
			gbc_txtFMontOPName.insets = new Insets(0, 0, 0, 5);
			gbc_txtFMontOPName.gridx = 1;
			gbc_txtFMontOPName.gridy = 2;
			contentPane1.add(txtFMontOPName, gbc_txtFMontOPName);
			txtFMontOPName.setColumns(10);

			proBar = new JProgressBar();
			proBar.setForeground(Color.RED);
			proBar.setValue(eigGrade.RatingFM[i].multiply(new BigDecimal(100.0)).intValue());
			GridBagConstraints gbc_proBar = new GridBagConstraints();
			gbc_proBar.fill = GridBagConstraints.BOTH;
			gbc_proBar.gridwidth = 2;
			gbc_proBar.insets = new Insets(0, 0, 0, 5);
			gbc_proBar.gridx = 2;
			gbc_proBar.gridy = 2;
			contentPane1.add(proBar, gbc_proBar);
		
			if(eigGrade.RatingFM[i].equals(new BigDecimal(0.0)) 
					&& eigGrade.RatingFR[i].equals(new BigDecimal(0.0))){
				proBar.setBackground(Color.GRAY);
			}
			else{
				proBar.setBackground(Color.GREEN);
			}
		
		}
		//ArrayList<Mont_OP> Mont_OParray= Mont_OPSQL.get_lastMontOP();
		
		for(int i=0; i< Mont_OParray.size();i++){
			Mont_OP retMontOP=Mont_OParray.get(i);
			
			Solution_SQL.update_FMFR(eigGrade.RatingFM[i],eigGrade.RatingFR[i],retMontOP.idmontOP);
		}

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_KRIT guiKrit = new GUI_KRIT(projektID);
				dispose();
				guiKrit.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrevious.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrevious.gridx = 2;
		gbc_btnPrevious.gridy = 3+i;
		contentPane.add(btnPrevious, gbc_btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GUI_MAIN guiMain = new GUI_MAIN();
				dispose();
				guiMain.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.gridx = 3;
		gbc_btnNext.gridy = 3+i;
		contentPane.add(btnNext, gbc_btnNext);
	}
}
