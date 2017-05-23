package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Auspraegungen;
import Data.Kriterien;
import Data.Mont_OP;
import Data.Used_auspr;
import sql_connector.Krit_SQL;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class GUI_WEIGHTING extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	private JTextField txtFMontOPName;


	private Mont_OP retMont_OP;
	private Used_auspr retUsed_auspr;
	private Kriterien retKrit;
	private Auspraegungen retAus;
	private int nMontOP=0;
	private int i = 0;
	private int k = 0;
	private ArrayList<Mont_OP> Mont_OParray;
	private final ButtonGroup bgroupRating1 = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_WEIGHTING frame = new GUI_WEIGHTING();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_WEIGHTING() {
		initGUI();

	}

	protected void initGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 150, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 35, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);





		Mont_OParray =sql_connector.Mont_OPSQL.get_lastMontOP();
		retMont_OP=Mont_OParray.get(nMontOP);

		//System.out.println(Mont_OParray.size());


		JLabel lblMontOP = new JLabel("O"+(nMontOP+1)+":");
		GridBagConstraints gbc_lblMontOP = new GridBagConstraints();
		gbc_lblMontOP.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontOP.anchor = GridBagConstraints.EAST;
		gbc_lblMontOP.gridx = 0;
		gbc_lblMontOP.gridy = 0;
		contentPane.add(lblMontOP, gbc_lblMontOP);

		txtFMontOPName = new JTextField(retMont_OP.montOP_name);
		GridBagConstraints gbc_txtFMontOPName = new GridBagConstraints();
		gbc_txtFMontOPName.gridwidth = 2;
		gbc_txtFMontOPName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFMontOPName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFMontOPName.gridx = 1;
		gbc_txtFMontOPName.gridy = 0;
		contentPane.add(txtFMontOPName, gbc_txtFMontOPName);
		txtFMontOPName.setColumns(10);

		JLabel lblOiVonOn = new JLabel("O"+(nMontOP+1)+" von O"+Mont_OParray.size());
		GridBagConstraints gbc_lblOiVonOn = new GridBagConstraints();
		gbc_lblOiVonOn.anchor = GridBagConstraints.WEST;
		gbc_lblOiVonOn.gridwidth = 2;
		gbc_lblOiVonOn.insets = new Insets(0, 0, 5, 5);
		gbc_lblOiVonOn.gridx = 3;
		gbc_lblOiVonOn.gridy = 0;
		contentPane.add(lblOiVonOn, gbc_lblOiVonOn);

		JLabel lblKh = new JLabel("<html> K<sub>h</sub>: </html>");
		GridBagConstraints gbc_lblKh = new GridBagConstraints();
		gbc_lblKh.insets = new Insets(0, 0, 5, 5);
		gbc_lblKh.gridx = 0;
		gbc_lblKh.gridy = 2;
		contentPane.add(lblKh, gbc_lblKh);

		JLabel lblAhg = new JLabel("<html> A<sub>hg</sub>: </html>");
		GridBagConstraints gbc_lblAhg = new GridBagConstraints();
		gbc_lblAhg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAhg.gridx = 1;
		gbc_lblAhg.gridy = 2;
		contentPane.add(lblAhg, gbc_lblAhg);

		JLabel lblGewichtung = new JLabel("Gewichtung:");
		GridBagConstraints gbc_lblGewichtung = new GridBagConstraints();
		gbc_lblGewichtung.anchor = GridBagConstraints.NORTH;
		gbc_lblGewichtung.insets = new Insets(0, 0, 5, 5);
		gbc_lblGewichtung.gridx = 2;
		gbc_lblGewichtung.gridy = 2;
		contentPane.add(lblGewichtung, gbc_lblGewichtung);




		contentPane1 = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		//gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(contentPane1, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane1.setLayout(gbl_panel);



		ArrayList<Used_auspr> Used_ausprArray= sql_connector.Used_AuspSQL.giveRelevant(retMont_OP.idmontOP);



		ButtonGroup[] bgroupRating = new ButtonGroup[Used_ausprArray.size()];




		for(i = 0; i < Used_ausprArray.size(); i++) {
			bgroupRating[i]= new ButtonGroup(); // Warum hier die nochmal erstellen??
			retUsed_auspr=Used_ausprArray.get(i); 
			retAus = sql_connector.Ausp_SQL.giveAusp(retUsed_auspr.Auspr_id);
			retKrit = sql_connector.Krit_SQL.giveKrit(retAus.Krit_id);



			JLabel lblK = new JLabel(retKrit.Krit_Nr+":");
			GridBagConstraints gbc_lblK = new GridBagConstraints();
			gbc_lblK.insets = new Insets(0, 0, 0, 5);
			gbc_lblK.gridx = 0;
			gbc_lblK.gridy = i;
			contentPane1.add(lblK, gbc_lblK);
			lblK.setToolTipText(retKrit.Krit_Beschreibung);

			JLabel lblA = new JLabel(retAus.Auspr_Nr+":");
			GridBagConstraints gbc_lblA = new GridBagConstraints();
			gbc_lblA.insets = new Insets(0, 0, 0, 5);
			gbc_lblA.gridx = 1;
			gbc_lblA.gridy = i;
			contentPane1.add(lblA, gbc_lblA);
			lblA.setToolTipText(retAus.Auspr_Beschreibung);

			JRadioButton rdbtn1 = new JRadioButton("1");
			rdbtn1.setActionCommand("1");
			bgroupRating[i].add(rdbtn1);
			GridBagConstraints gbc_rdbtn1 = new GridBagConstraints();
			gbc_rdbtn1.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtn1.gridx = 2;
			gbc_rdbtn1.gridy = i;
			contentPane1.add(rdbtn1, gbc_rdbtn1);

			JRadioButton rdbtn2 = new JRadioButton("2");
			rdbtn2.setActionCommand("2");
			bgroupRating[i].add(rdbtn2);
			GridBagConstraints gbc_rdbtn2 = new GridBagConstraints();
			gbc_rdbtn2.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtn2.gridx = 3;
			gbc_rdbtn2.gridy = i;
			contentPane1.add(rdbtn2, gbc_rdbtn2);

			JRadioButton rdbtn3 = new JRadioButton("3");
			rdbtn3.setActionCommand("3");
			bgroupRating[i].add(rdbtn3);
			GridBagConstraints gbc_rdbtn3 = new GridBagConstraints();
			gbc_rdbtn3.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtn3.gridx = 4;
			gbc_rdbtn3.gridy = i;
			contentPane1.add(rdbtn3, gbc_rdbtn3);


			//Default RadioButton Selection
			rdbtn3.setSelected(true);

			JRadioButton rdbtn4 = new JRadioButton("4");
			rdbtn4.setActionCommand("4");
			bgroupRating[i].add(rdbtn4);
			GridBagConstraints gbc_rdbtn4 = new GridBagConstraints();
			gbc_rdbtn4.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtn4.gridx = 5;
			gbc_rdbtn4.gridy = i;
			contentPane1.add(rdbtn4, gbc_rdbtn4);

			JRadioButton rdbtn5 = new JRadioButton("5");
			rdbtn5.setActionCommand("5");
			bgroupRating[i].add(rdbtn5);
			GridBagConstraints gbc_rdbtn5 = new GridBagConstraints();
			gbc_rdbtn5.gridx = 6;
			gbc_rdbtn5.gridy = i;
			contentPane1.add(rdbtn5, gbc_rdbtn5);


		}

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				--nMontOP;
				contentPane.setVisible(false);
				initGUI();
			}
		});
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.anchor = GridBagConstraints.SOUTH;
		gbc_btnPrevious.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrevious.gridx = 4;
		gbc_btnPrevious.gridy = 4;
		contentPane.add(btnPrevious, gbc_btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				++nMontOP;
				//System.out.println(nMontOP);
				for(i = 0; i < Used_ausprArray.size(); i++) {
					int usedAusp_id = sql_connector.Used_AuspSQL.get_minAuspID(retMont_OP.idmontOP);
				sql_connector.Used_AuspSQL.update_Gewichtung(Integer.valueOf(bgroupRating[i].getSelection().getActionCommand()), usedAusp_id);
				++usedAusp_id;
				}
				if(nMontOP==Mont_OParray.size()){

					dispose();
					GUI_SOLUTION test = new GUI_SOLUTION();
					test.setVisible(true);

				}else{

					contentPane.setVisible(false);	
					initGUI();
				}

			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.anchor = GridBagConstraints.SOUTH;
		gbc_btnNext.gridx = 5;
		gbc_btnNext.gridy = 4;
		contentPane.add(btnNext, gbc_btnNext);
	}

}
