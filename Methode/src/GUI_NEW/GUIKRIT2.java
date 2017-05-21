package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.SwingConstants;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class GUIKRIT2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int n =1;
	private int i = 0;
	private int usedAusp_id = 0;
	private static int k=0;
	private int nMontOP =0;
	private int anzMomtOp = 0;
	private Mont_OP retMont_OP;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private final ButtonGroup bGroupFR = new ButtonGroup();
	private final ButtonGroup bGroupFM = new ButtonGroup();

	
	private JRadioButton rbtnFMBetter;
	private JRadioButton rbtnFMEqual;
	private JRadioButton rbtnFMWorse;


	private JRadioButton rbtnFRBetter;
	private JRadioButton rbtnFREqual;
	private JRadioButton rbtnFRWorse;

	private double ratingFR;
	private double ratingFM;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKRIT2 frame = new GUIKRIT2();
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
	public GUIKRIT2() {
		initGUI();








	}

	protected void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 53, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);



		Kriterien krit = Krit_SQL.giveKrit(n);

		ArrayList<Kriterien> Kritarray = sql_connector.Krit_SQL.giveKrits();
		ArrayList<Mont_OP> Mont_OParray= new ArrayList<Mont_OP>();
		Mont_OParray =sql_connector.Mont_OPSQL.get_lastMontOP();
		retMont_OP=Mont_OParray.get(nMontOP);
		anzMomtOp = Mont_OParray.size();



		JLabel lblMontOP = new JLabel("O"+(nMontOP+1)+":");
		GridBagConstraints gbc_lblMontOP = new GridBagConstraints();
		gbc_lblMontOP.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontOP.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMontOP.gridx = 0;
		gbc_lblMontOP.gridy = 0;
		contentPane.add(lblMontOP, gbc_lblMontOP);

		JTextField txtFMontOPName = new JTextField(retMont_OP.montOP_name);
		GridBagConstraints gbc_txtFMontOPName = new GridBagConstraints();
		gbc_txtFMontOPName.gridwidth = 4;
		gbc_txtFMontOPName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFMontOPName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFMontOPName.anchor = GridBagConstraints.NORTH;
		gbc_txtFMontOPName.gridx = 1;
		gbc_txtFMontOPName.gridy = 0;

		contentPane.add(txtFMontOPName, gbc_txtFMontOPName);
		txtFMontOPName.setColumns(10);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.gridwidth = 5;
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 0);
		gbc_lblBeschreibung.gridx = 0;
		gbc_lblBeschreibung.gridy = 1;
		contentPane.add(lblBeschreibung, gbc_lblBeschreibung);

		JLabel lblKritNR = new JLabel(krit.Krit_Nr+":");
		GridBagConstraints gbc_lblKritNR = new GridBagConstraints();
		gbc_lblKritNR.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblKritNR.insets = new Insets(0, 0, 5, 5);
		gbc_lblKritNR.gridx = 0;
		gbc_lblKritNR.gridy = 2;
		contentPane.add(lblKritNR, gbc_lblKritNR);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

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

		scrollPane.setViewportView(txtArkrit_Besch);


		ArrayList<Auspraegungen> Ausparray=Ausp_SQL.giveAuspraegungenZuKrit(n);

		for (i = 0; i < Ausparray.size(); i++) {
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
			gbc_rdbtnAuspBesch.gridy = i+4;
			contentPane.add(rdbtnAuspBesch, gbc_rdbtnAuspBesch);
			JLabel lblAuspNR = new JLabel(retAus.Auspr_Nr+":");
			GridBagConstraints gbc_lblAuspNR = new GridBagConstraints();
			gbc_lblAuspNR.anchor = GridBagConstraints.NORTH;
			gbc_lblAuspNR.insets = new Insets(0, 0, 5, 5);
			gbc_lblAuspNR.gridx = 0;
			gbc_lblAuspNR.gridy = i+4;
			contentPane.add(lblAuspNR, gbc_lblAuspNR);

		}
		
		JButton btnPrevious = new JButton("PREVIOUS");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				--n;
				contentPane.setVisible(false);
				initGUI();
			}
		});
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnPrevious.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrevious.gridx = 3;
		gbc_btnPrevious.gridy = i+6;
		contentPane.add(btnPrevious, gbc_btnPrevious);
		
		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++usedAusp_id;
				if (n==1)
				{
					usedAusp_id = sql_connector.Used_AuspSQL.get_minAuspID(retMont_OP.idmontOP);
				}
				++n;
				System.out.println("n= " + n);
				
				getSelectedBtnF();

				
				contentPane.setVisible(false);
				initGUI();
				System.out.println(n);
		
					System.out.println("ratingFM:"+ ratingFM);
					Used_AuspSQL.update_usedAusp(Integer.valueOf(buttonGroup.getSelection().getActionCommand()), ratingFM,ratingFR, usedAusp_id);
		
				if(n==Kritarray.size()){
					
					contentPane.setVisible(false);
					initGUI();
					
					n=0;
					++nMontOP;
					}

				
			}
			
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = i+6;
		contentPane.add(btnNEXT, gbc_btnNext);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = i+5;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("FM:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("FR:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		JLabel lblFMBetter = new JLabel("1,0");
		GridBagConstraints gbc_lblFMBetter = new GridBagConstraints();
		gbc_lblFMBetter.insets = new Insets(0, 0, 5, 5);
		gbc_lblFMBetter.gridx = 0;
		gbc_lblFMBetter.gridy = 1;
		panel.add(lblFMBetter, gbc_lblFMBetter);
		
		rbtnFMBetter = new JRadioButton("+");
		bGroupFM.add(rbtnFMBetter);
		rbtnFMBetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rbtnFRWorse.setSelected(true);
			}
		});
		GridBagConstraints gbc_rbtnFMBetter = new GridBagConstraints();
		gbc_rbtnFMBetter.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMBetter.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFMBetter.gridx = 1;
		gbc_rbtnFMBetter.gridy = 1;
		panel.add(rbtnFMBetter, gbc_rbtnFMBetter);
		
		JLabel lblBetter = new JLabel("besser");
		GridBagConstraints gbc_lblBetter = new GridBagConstraints();
		gbc_lblBetter.insets = new Insets(0, 0, 5, 5);
		gbc_lblBetter.gridx = 2;
		gbc_lblBetter.gridy = 1;
		panel.add(lblBetter, gbc_lblBetter);
		
		rbtnFRBetter = new JRadioButton("+");
		bGroupFR.add(rbtnFRBetter);
		rbtnFRBetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rbtnFMWorse.setSelected(true);
			}
		});
		GridBagConstraints gbc_rbtnFRBetter = new GridBagConstraints();
		gbc_rbtnFRBetter.anchor = GridBagConstraints.WEST;
		gbc_rbtnFRBetter.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFRBetter.gridx = 3;
		gbc_rbtnFRBetter.gridy = 1;
		panel.add(rbtnFRBetter, gbc_rbtnFRBetter);
		
		JLabel label_4 = new JLabel("1,0");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 1;
		panel.add(label_4, gbc_label_4);
		
		JLabel lblFMEqual = new JLabel("0,5");
		GridBagConstraints gbc_lblFMEqual = new GridBagConstraints();
		gbc_lblFMEqual.insets = new Insets(0, 0, 5, 5);
		gbc_lblFMEqual.gridx = 0;
		gbc_lblFMEqual.gridy = 2;
		panel.add(lblFMEqual, gbc_lblFMEqual);
		
		rbtnFMEqual = new JRadioButton("=");
		bGroupFM.add(rbtnFMEqual);
		rbtnFMEqual.setActionCommand(String.valueOf(0.5));
		rbtnFMEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rbtnFREqual.setSelected(true);
			}
		});
		rbtnFMEqual.setVerticalAlignment(SwingConstants.TOP);
		rbtnFMEqual.setSelected(true);
		rbtnFMEqual.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rbtnFMEqual = new GridBagConstraints();
		gbc_rbtnFMEqual.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMEqual.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFMEqual.gridx = 1;
		gbc_rbtnFMEqual.gridy = 2;
		panel.add(rbtnFMEqual, gbc_rbtnFMEqual);
		
		JLabel lblEqual = new JLabel("gleich");
		GridBagConstraints gbc_lblEqual = new GridBagConstraints();
		gbc_lblEqual.insets = new Insets(0, 0, 5, 5);
		gbc_lblEqual.gridx = 2;
		gbc_lblEqual.gridy = 2;
		panel.add(lblEqual, gbc_lblEqual);
		
		rbtnFREqual = new JRadioButton("=");
		bGroupFR.add(rbtnFREqual);
		rbtnFREqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rbtnFMEqual.setSelected(true);
			}
		});
		rbtnFREqual.setSelected(true);
		GridBagConstraints gbc_rbtnFREqual = new GridBagConstraints();
		gbc_rbtnFREqual.anchor = GridBagConstraints.WEST;
		gbc_rbtnFREqual.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFREqual.gridx = 3;
		gbc_rbtnFREqual.gridy = 2;
		panel.add(rbtnFREqual, gbc_rbtnFREqual);
		
		JLabel label_7 = new JLabel("0,5");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 4;
		gbc_label_7.gridy = 2;
		panel.add(label_7, gbc_label_7);
		
		JLabel lblFMWorse = new JLabel("0,0");
		GridBagConstraints gbc_lblFMWorse = new GridBagConstraints();
		gbc_lblFMWorse.insets = new Insets(0, 0, 0, 5);
		gbc_lblFMWorse.gridx = 0;
		gbc_lblFMWorse.gridy = 3;
		panel.add(lblFMWorse, gbc_lblFMWorse);
		
		rbtnFMWorse = new JRadioButton("-");
		bGroupFM.add(rbtnFMWorse);
		rbtnFMWorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rbtnFRBetter.setSelected(true);
			}
		});
		GridBagConstraints gbc_rbtnFMWorse = new GridBagConstraints();
		gbc_rbtnFMWorse.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMWorse.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnFMWorse.gridx = 1;
		gbc_rbtnFMWorse.gridy = 3;
		panel.add(rbtnFMWorse, gbc_rbtnFMWorse);
		
		JLabel lblWorse = new JLabel("schlechter");
		GridBagConstraints gbc_lblWorse = new GridBagConstraints();
		gbc_lblWorse.insets = new Insets(0, 0, 0, 5);
		gbc_lblWorse.gridx = 2;
		gbc_lblWorse.gridy = 3;
		panel.add(lblWorse, gbc_lblWorse);
		
		rbtnFRWorse = new JRadioButton("-");
		bGroupFR.add(rbtnFRWorse);
		rbtnFRWorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rbtnFMBetter.setSelected(true);
			}
		});
		GridBagConstraints gbc_rbtnFRWorse = new GridBagConstraints();
		gbc_rbtnFRWorse.anchor = GridBagConstraints.WEST;
		gbc_rbtnFRWorse.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnFRWorse.gridx = 3;
		gbc_rbtnFRWorse.gridy = 3;
		panel.add(rbtnFRWorse, gbc_rbtnFRWorse);

		JLabel label_10 = new JLabel("0,0");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.gridx = 4;
		gbc_label_10.gridy = 3;
		panel.add(label_10, gbc_label_10);

	
	}

	protected void getSelectedBtnF() {
		if(rbtnFMBetter.isSelected()){
			ratingFM=1.0;
		}
		if(rbtnFRBetter.isSelected()){
			ratingFR=1.0;
		}



		if(rbtnFMEqual.isSelected()){
			ratingFM=0.5;
		}

		if(rbtnFREqual.isSelected()){
			ratingFR=0.5;
		}

		if(rbtnFMWorse.isSelected()){
			ratingFM=0.0;
		}
		if(rbtnFRWorse.isSelected()){
			ratingFR=0.0;
		}
		System.out.println("ratingFR:"+ratingFR+"ratingFM:" + ratingFM);
	}
	
}
