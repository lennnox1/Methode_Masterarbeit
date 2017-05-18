package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXLabel;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Mont_OP;
import sql_connector.Ausp_SQL;
import sql_connector.Krit_SQL;
import sql_connector.Used_AuspSQL;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class GUIKRIT_JPANEL extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	private JTextField txtFMontOPName;
	private int n =1;
	private static int k=0;
	private int nMontOP =0;
	private boolean update=false;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Mont_OP retMont_OP;
	private ArrayList<Mont_OP> Mont_OParray;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKRIT frame = new GUIKRIT();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GUIKRIT_JPANEL() {
		initGUI();

	}
	protected void initGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 55, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.2, 0.2, 0.2, 0.6, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);



		Kriterien krit = Krit_SQL.giveKrit(n);

		ArrayList<Kriterien> Kritarray = sql_connector.Krit_SQL.giveKrits();
		ArrayList<Mont_OP> Mont_OParray= new ArrayList<Mont_OP>();
		Mont_OParray =sql_connector.Mont_OPSQL.get_lastMontOP();
		retMont_OP=Mont_OParray.get(nMontOP);



		JLabel lblMontOP = new JLabel("O"+(nMontOP+1)+":");
		GridBagConstraints gbc_lblMontOP = new GridBagConstraints();
		gbc_lblMontOP.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontOP.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMontOP.gridx = 0;
		gbc_lblMontOP.gridy = 0;
		contentPane.add(lblMontOP, gbc_lblMontOP);


		txtFMontOPName = new JTextField(retMont_OP.montOP_name);
		GridBagConstraints gbc_txtFMontOPName = new GridBagConstraints();
		gbc_txtFMontOPName.gridwidth = 2;
		gbc_txtFMontOPName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFMontOPName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFMontOPName.anchor = GridBagConstraints.NORTH;
		gbc_txtFMontOPName.gridx = 1;
		gbc_txtFMontOPName.gridy = 0;

		contentPane.add(txtFMontOPName, gbc_txtFMontOPName);
		txtFMontOPName.setColumns(10);

		JLabel lblKritNR = new JLabel(krit.Krit_Nr+":");
		GridBagConstraints gbc_lblKritNR = new GridBagConstraints();
		gbc_lblKritNR.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblKritNR.insets = new Insets(0, 0, 5, 5);
		gbc_lblKritNR.gridx = 0;
		gbc_lblKritNR.gridy = 1;
		contentPane.add(lblKritNR, gbc_lblKritNR);

		JTextArea txtArkrit_Besch = new JTextArea();
		txtArkrit_Besch.setLineWrap(true);
		txtArkrit_Besch.setWrapStyleWord(true);
		txtArkrit_Besch.setText(krit.Krit_Beschreibung);
		GridBagConstraints gbc_txtArkrit_Besch = new GridBagConstraints();
		gbc_txtArkrit_Besch.fill = GridBagConstraints.BOTH;
		gbc_txtArkrit_Besch.gridwidth = 2;
		gbc_txtArkrit_Besch.gridheight = 2;
		gbc_txtArkrit_Besch.insets = new Insets(0, 0, 5, 5);
		gbc_txtArkrit_Besch.gridx = 1;
		gbc_txtArkrit_Besch.gridy = 1;
		gbc_txtArkrit_Besch.weighty=0.9;
		contentPane.add(txtArkrit_Besch, gbc_txtArkrit_Besch);




		ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungenZuKrit(n);

		for (int i = 0; i < Ausparray.size(); i++) {
			Auspraegungen retAus = Ausparray.get(i);
			JRadioButton rdbtnAuspBesch = new JRadioButton(retAus.Auspr_Beschreibung);
			rdbtnAuspBesch.setActionCommand(String.valueOf(retAus.Auspr_id));
			rdbtnAuspBesch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			buttonGroup.add(rdbtnAuspBesch);
			GridBagConstraints gbc_rdbtnAuspBesch = new GridBagConstraints();
			gbc_rdbtnAuspBesch.anchor = GridBagConstraints.NORTHWEST;
			gbc_rdbtnAuspBesch.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnAuspBesch.gridx = 4;
			gbc_rdbtnAuspBesch.gridy = i+1;
			//contentPane.add(rdbtnAuspBesch, gbc_rdbtnAuspBesch);
			JLabel lblAuspNR = new JLabel(retAus.Auspr_Nr+":");
			GridBagConstraints gbc_lblAuspNR = new GridBagConstraints();
			gbc_lblAuspNR.anchor = GridBagConstraints.NORTH;
			gbc_lblAuspNR.insets = new Insets(0, 0, 5, 5);
			gbc_lblAuspNR.gridx = 3;
			gbc_lblAuspNR.gridy = i+1;
			//contentPane.add(lblAuspNR, gbc_lblAuspNR);

		}








		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++n;
				++k;
				contentPane.setVisible(false);
				initGUI();
				System.out.println(n);
				if(update==false){
					Used_AuspSQL.set_usedAusp(Integer.valueOf(buttonGroup.getSelection().getActionCommand()),retMont_OP.idmontOP);
					System.out.println(update);
					update=false;
				}
				else{
					System.out.println("Update muss durchgeführt werden");
					Used_AuspSQL.update_usedAusp(Integer.valueOf(buttonGroup.getSelection().getActionCommand()));
				}
				//while(nMontOP+1<=Mont_OParray.size()){
				if(n==Kritarray.size()){
					++nMontOP;
					contentPane.setVisible(false);
					initGUI();
					n=0;
					k=0;
					//}
				}
			}
		});



		JButton btnPREV = new JButton("PREVIOUS");
		btnPREV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				--n;
				contentPane.setVisible(false);
				initGUI();
				update=true;
			}
		});


		GridBagConstraints gbc_btnPREV = new GridBagConstraints();
		gbc_btnPREV.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnPREV.insets = new Insets(0, 0, 0, 5);
		gbc_btnPREV.gridx = 3;
		gbc_btnPREV.gridy = Ausparray.size()+1;
		contentPane.add(btnPREV, gbc_btnPREV);

		GridBagConstraints gbc_btnNEXT = new GridBagConstraints();
		gbc_btnNEXT.insets = new Insets(0, 0, 0, 5);
		gbc_btnNEXT.anchor = GridBagConstraints.EAST;
		gbc_btnNEXT.gridx = 4;
		gbc_btnNEXT.gridy = Ausparray.size()+1;
		contentPane.add(btnNEXT, gbc_btnNEXT);


		
		
		
		ButtonGroup btnGroupRating = new ButtonGroup();


		JButton btnPlus = new JButton("+");
		GridBagConstraints gbc_btnPlus = new GridBagConstraints();
		gbc_btnPlus.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlus.gridx = 5;
		gbc_btnPlus.gridy = 2;
		btnGroupRating.add(btnPlus);
		//contentPane.add(btnPlus, gbc_btnPlus);



		JButton btnEqual = new JButton("=");
		GridBagConstraints gbc_btnEqual = new GridBagConstraints();
		gbc_btnEqual.insets = new Insets(0, 0, 5, 0);
		gbc_btnEqual.gridx = 5;
		gbc_btnEqual.gridy = 3;
		btnGroupRating.add(btnEqual);
		//contentPane.add(btnEqual, gbc_btnEqual);

		JButton btnMinus = new JButton("-");
		GridBagConstraints gbc_btnMinus = new GridBagConstraints();
		gbc_btnMinus.insets = new Insets(0, 0, 5, 0);
		gbc_btnMinus.gridx = 5;
		gbc_btnMinus.gridy = 4;
		btnGroupRating.add(btnMinus);
		//contentPane.add(btnMinus, gbc_btnMinus);


		// JPanel mit eigenem Gridbaglayout




		contentPane1 = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		contentPane.add(contentPane1, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane1.setLayout(gbl_panel);

		for (int i = 0; i < Ausparray.size(); i++) {
			Auspraegungen retAus = Ausparray.get(i);
			JRadioButton rdbtnAuspBesch = new JRadioButton(retAus.Auspr_Beschreibung);
			rdbtnAuspBesch.setActionCommand(String.valueOf(retAus.Auspr_id));
			rdbtnAuspBesch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			buttonGroup.add(rdbtnAuspBesch);
			GridBagConstraints gbc_rdbtnAuspBesch = new GridBagConstraints();
			gbc_rdbtnAuspBesch.anchor = GridBagConstraints.NORTHWEST;
			gbc_rdbtnAuspBesch.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnAuspBesch.gridx = 1;
			gbc_rdbtnAuspBesch.gridy = i+1;
			contentPane1.add(rdbtnAuspBesch, gbc_rdbtnAuspBesch);
			JLabel lblAuspNR = new JLabel(retAus.Auspr_Nr+":");
			GridBagConstraints gbc_lblAuspNR = new GridBagConstraints();
			gbc_lblAuspNR.anchor = GridBagConstraints.NORTH;
			gbc_lblAuspNR.insets = new Insets(0, 0, 5, 5);
			gbc_lblAuspNR.gridx = 0;
			gbc_lblAuspNR.gridy = i+1;
			contentPane1.add(lblAuspNR, gbc_lblAuspNR);

		}







		JButton btnPREV1 = new JButton("1");
		GridBagConstraints gbc_btnPREV1 = new GridBagConstraints();
		gbc_btnPREV1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnPREV1.insets = new Insets(0, 0, 0, 5);
		gbc_btnPREV1.gridx = 0;
		gbc_btnPREV1.gridy = 0;
		//contentPane1.add(btnPREV1, gbc_btnPREV1);


		JButton btnPREV2 = new JButton("2");
		GridBagConstraints gbc_btnPREV2 = new GridBagConstraints();
		gbc_btnPREV2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnPREV2.insets = new Insets(0, 0, 0, 5);
		gbc_btnPREV2.gridx = 1;
		gbc_btnPREV2.gridy = 1;
		//contentPane1.add(btnPREV2, gbc_btnPREV2);

	}
}
