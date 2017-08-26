package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Data.Auspraegungen;

import Data.Kriterien;
import Data.Kriterienkataloge;
import Steuerung.HochTiefSteller;

import java.awt.GridBagLayout;
import sql_connector.New_KatalogSQL;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class GUI_NEW_KATALOG extends JFrame {

	private JPanel contentPane;
	private JTextField txtFAnz_Krit;
	private JTextField txtFanzAusp;
	private JTextField txtFKatalogName;
	private JTextArea txtAauspBesch;
	private JLabel lblKVonKn;
	private JLabel lblKn;
	private JLabel lblAhg;
	private int anzKrit = 0;
	private int i=0;
	private int z=0;
	private int k=0;
	private int x=0;
	private ArrayList<Kriterien> kritarray;
	private final ButtonGroup bGroupFM = new ButtonGroup();
	private final ButtonGroup bGroupFR = new ButtonGroup();
	
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
					GUI_NEW_KATALOG frame = new GUI_NEW_KATALOG();
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
	public GUI_NEW_KATALOG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 455);
		contentPane = new JPanel();
		contentPane.setToolTipText("Anzahl der Auspr\u00E4gungen");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 168, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 20, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblKatalogName = new JLabel("Name:");
		GridBagConstraints gbc_lblKatalogName = new GridBagConstraints();
		gbc_lblKatalogName.anchor = GridBagConstraints.EAST;
		gbc_lblKatalogName.insets = new Insets(0, 0, 5, 5);
		gbc_lblKatalogName.gridx = 0;
		gbc_lblKatalogName.gridy = 0;
		contentPane.add(lblKatalogName, gbc_lblKatalogName);

		txtFKatalogName = new JTextField();
		GridBagConstraints gbc_txtFKatalogName = new GridBagConstraints();
		gbc_txtFKatalogName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFKatalogName.fill = GridBagConstraints.BOTH;
		gbc_txtFKatalogName.gridx = 1;
		gbc_txtFKatalogName.gridy = 0;
		contentPane.add(txtFKatalogName, gbc_txtFKatalogName);
		txtFKatalogName.setColumns(10);

		JButton btnKatName = new JButton("OK");
		btnKatName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql_connector.New_KatalogSQL.set_KatalogName(txtFKatalogName.getText());
			}
		});
		GridBagConstraints gbc_btnKatName = new GridBagConstraints();
		gbc_btnKatName.insets = new Insets(0, 0, 5, 5);
		gbc_btnKatName.gridx = 2;
		gbc_btnKatName.gridy = 0;
		//contentPane.add(btnKatName, gbc_btnKatName);

		JLabel lblAnz_Krit = new JLabel("Anz. Krit:");
		lblAnz_Krit.setToolTipText("Anzahl der Kriterien");
		GridBagConstraints gbc_lblAnz_Krit = new GridBagConstraints();
		gbc_lblAnz_Krit.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnz_Krit.anchor = GridBagConstraints.EAST;
		gbc_lblAnz_Krit.gridx = 0;
		gbc_lblAnz_Krit.gridy = 1;
		contentPane.add(lblAnz_Krit, gbc_lblAnz_Krit);

		txtFAnz_Krit = new JTextField();
		GridBagConstraints gbc_txtFAnz_Krit = new GridBagConstraints();
		gbc_txtFAnz_Krit.fill = GridBagConstraints.BOTH;
		gbc_txtFAnz_Krit.insets = new Insets(0, 0, 5, 5);
		gbc_txtFAnz_Krit.gridx = 1;
		gbc_txtFAnz_Krit.gridy = 1;
		contentPane.add(txtFAnz_Krit, gbc_txtFAnz_Krit);
		txtFAnz_Krit.setColumns(10);

		JButton btnAnz_Krit = new JButton("OK");
		btnAnz_Krit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql_connector.New_KatalogSQL.set_KatalogName(txtFKatalogName.getText());
				anzKrit = Integer.valueOf(txtFAnz_Krit.getText());
				New_KatalogSQL.update_anzKrit(anzKrit);

				ArrayList<Kriterienkataloge> KritKatalogArray= new ArrayList<Kriterienkataloge>();
				KritKatalogArray =sql_connector.New_KatalogSQL.get_lastKatalog();
				Kriterienkataloge retKat = KritKatalogArray.get(0);
				//System.out.println(KritKatalogArray.size());
				for(int i=0; i<retKat.anz_Krit; i++){

					sql_connector.New_KatalogSQL.set_Kriterien("K"+(i+1));

				}
				if (anzKrit > 0)
				{
					txtFAnz_Krit.setEditable(false);
				}
			}
		});
		GridBagConstraints gbc_btnAnz_Krit = new GridBagConstraints();
		gbc_btnAnz_Krit.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnz_Krit.gridx = 2;
		gbc_btnAnz_Krit.gridy = 1;
		contentPane.add(btnAnz_Krit, gbc_btnAnz_Krit);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setPreferredSize(new Dimension(50,5));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 4;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.weightx = 1.0;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		contentPane.add(separator, gbc_separator);

		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 1;
		gbc_lblBeschreibung.gridy = 3;
		contentPane.add(lblBeschreibung, gbc_lblBeschreibung);



		lblKn = new JLabel(HochTiefSteller.stelleZiffernTief("K"+1+":"));
		GridBagConstraints gbc_lblKn = new GridBagConstraints();
		gbc_lblKn.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblKn.insets = new Insets(0, 0, 5, 5);
		gbc_lblKn.gridx = 0;
		gbc_lblKn.gridy = 4;
		contentPane.add(lblKn, gbc_lblKn);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);

		JTextArea txtAKritBesch = new JTextArea();

		scrollPane.setViewportView(txtAKritBesch);




		lblKVonKn = new JLabel();
		GridBagConstraints gbc_lblKVonKn = new GridBagConstraints();
		gbc_lblKVonKn.insets = new Insets(0, 0, 5, 0);
		gbc_lblKVonKn.gridx = 3;
		gbc_lblKVonKn.gridy = 3;
		contentPane.add(lblKVonKn, gbc_lblKVonKn);






		JButton btnKritBesch = new JButton("OK");
		btnKritBesch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setKrits(txtAKritBesch);

			}


		});


		GridBagConstraints gbc_btnKritBesch = new GridBagConstraints();
		gbc_btnKritBesch.anchor = GridBagConstraints.NORTH;
		gbc_btnKritBesch.insets = new Insets(0, 0, 5, 5);
		gbc_btnKritBesch.gridx = 2;
		gbc_btnKritBesch.gridy = 4;
		//contentPane.add(btnKritBesch, gbc_btnKritBesch);







		JLabel lblAnzAusp = new JLabel("Anz. Ausp:");
		GridBagConstraints gbc_lblAnzAusp = new GridBagConstraints();
		gbc_lblAnzAusp.anchor = GridBagConstraints.EAST;
		gbc_lblAnzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzAusp.gridx = 0;
		gbc_lblAnzAusp.gridy = 5;
		contentPane.add(lblAnzAusp, gbc_lblAnzAusp);

		txtFanzAusp = new JTextField();
		GridBagConstraints gbc_txtFanzAusp = new GridBagConstraints();
		gbc_txtFanzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_txtFanzAusp.fill = GridBagConstraints.BOTH;
		gbc_txtFanzAusp.gridx = 1;
		gbc_txtFanzAusp.gridy = 5;
		contentPane.add(txtFanzAusp, gbc_txtFanzAusp);
		txtFanzAusp.setColumns(10);


		JButton btnAnzAusp = new JButton("OK");
		btnAnzAusp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setKrits(txtAKritBesch);

				kritarray=New_KatalogSQL.get_KritsofKatID(New_KatalogSQL.get_lastKatalogID());
				Kriterien retKrit = kritarray.get(z);
				for(int k=0; k<Integer.valueOf(txtFanzAusp.getText());k++){

					New_KatalogSQL.set_Ausp(retKrit.idKrit,"A"+(z+1)+(k+1));

				}
				++z;
				
				
				txtAauspBesch.setEditable(true);
				txtAauspBesch.setBackground(txtFanzAusp.getBackground());
				txtFanzAusp.setEditable(false);
				txtAKritBesch.setEditable(false);
				txtAKritBesch.setBackground(txtFanzAusp.getBackground());
				scrollPane.setBorder(null);
				txtAKritBesch.setBorder(txtFanzAusp.getBorder());
			}
		});
		GridBagConstraints gbc_btnAnzAusp = new GridBagConstraints();
		gbc_btnAnzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnzAusp.gridx = 2;
		gbc_btnAnzAusp.gridy = 5;
		contentPane.add(btnAnzAusp, gbc_btnAnzAusp);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 4;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 6;
		contentPane.add(separator_1, gbc_separator_1);

		JLabel lblBeschreibung_1 = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung_1 = new GridBagConstraints();
		gbc_lblBeschreibung_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung_1.gridx = 1;
		gbc_lblBeschreibung_1.gridy = 7;
		contentPane.add(lblBeschreibung_1, gbc_lblBeschreibung_1);

		lblAhg = new JLabel(HochTiefSteller.stelleZiffernTief(("A"+1+1+":")));
		GridBagConstraints gbc_lblAhg = new GridBagConstraints();
		gbc_lblAhg.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAhg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAhg.gridx = 0;
		gbc_lblAhg.gridy = 8;
		contentPane.add(lblAhg, gbc_lblAhg);



		JScrollPane scrollPaneAuspBesch = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 8;
		contentPane.add(scrollPaneAuspBesch, gbc_scrollPane_1);

		txtAauspBesch = new JTextArea();
		scrollPaneAuspBesch.setViewportView(txtAauspBesch);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 10;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("<html> F<sub>M</sub>: </html>");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("<html> F<sub>R</sub>: </html>");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("1,0");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		rbtnFMBetter = new JRadioButton("+");
		rbtnFMBetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnFRWorse.setSelected(true);
			}
		});
		bGroupFM.add(rbtnFMBetter);
		rbtnFMBetter.setSelected(false);
		GridBagConstraints gbc_rbtnFMBetter = new GridBagConstraints();
		gbc_rbtnFMBetter.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMBetter.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFMBetter.gridx = 1;
		gbc_rbtnFMBetter.gridy = 1;
		panel.add(rbtnFMBetter, gbc_rbtnFMBetter);
		
		JLabel label_3 = new JLabel("besser");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		panel.add(label_3, gbc_label_3);
		
		rbtnFRBetter = new JRadioButton("+");
		rbtnFRBetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFMWorse.setSelected(true);
			}
		});
		bGroupFR.add(rbtnFRBetter);
		rbtnFRBetter.setSelected(false);
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
		
		JLabel label_5 = new JLabel("0,5");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		panel.add(label_5, gbc_label_5);
		
		rbtnFMEqual = new JRadioButton("=");
		rbtnFMEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFREqual.setSelected(true);
			}
		});
		bGroupFM.add(rbtnFMEqual);
		rbtnFMEqual.setVerticalAlignment(SwingConstants.TOP);
		rbtnFMEqual.setSelected(true);
		rbtnFMEqual.setHorizontalAlignment(SwingConstants.LEFT);
		rbtnFMEqual.setActionCommand("0.5");
		GridBagConstraints gbc_rbtnFMEqual = new GridBagConstraints();
		gbc_rbtnFMEqual.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMEqual.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFMEqual.gridx = 1;
		gbc_rbtnFMEqual.gridy = 2;
		panel.add(rbtnFMEqual, gbc_rbtnFMEqual);
		
		JLabel label_6 = new JLabel("gleich");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 2;
		panel.add(label_6, gbc_label_6);
		
		rbtnFREqual = new JRadioButton("=");
		rbtnFREqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFMEqual.setSelected(true);
			}
		});
		bGroupFR.add(rbtnFREqual);
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
		
		JLabel label_8 = new JLabel("0,0");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 3;
		panel.add(label_8, gbc_label_8);
		
		rbtnFMWorse = new JRadioButton("-");
		rbtnFMWorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFRBetter.setSelected(true);
			}
		});
		bGroupFM.add(rbtnFMWorse);
		rbtnFMWorse.setSelected(false);
		GridBagConstraints gbc_rbtnFMWorse = new GridBagConstraints();
		gbc_rbtnFMWorse.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMWorse.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnFMWorse.gridx = 1;
		gbc_rbtnFMWorse.gridy = 3;
		panel.add(rbtnFMWorse, gbc_rbtnFMWorse);
		
		JLabel label_9 = new JLabel("schlechter");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 2;
		gbc_label_9.gridy = 3;
		panel.add(label_9, gbc_label_9);
		
		rbtnFRWorse = new JRadioButton("-");
		rbtnFRWorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFMBetter.setSelected(true);
			}
		});
		bGroupFR.add(rbtnFRWorse);
		rbtnFRWorse.setSelected(false);
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
		
		JButton btnAauspBesch = new JButton("OK");
		btnAauspBesch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getSelectedBtnF();
			
				kritarray=New_KatalogSQL.get_KritsofKatID(New_KatalogSQL.get_lastKatalogID());
				Kriterien retKrit= kritarray.get(k);

				ArrayList<Auspraegungen> ausp_LPS_array = New_KatalogSQL.get_AuspofKatID(retKrit.idKrit);
				Auspraegungen retAusp = ausp_LPS_array.get(x);

			

				New_KatalogSQL.update_Ausp(txtAauspBesch.getText(), retAusp.idAuspr, ratingFM, ratingFR);
				x++;

				if(x==ausp_LPS_array.size()){
					k++;
					x = 0;
					lblKn.setText(HochTiefSteller.stelleZiffernTief("K"+(i+1)));
					scrollPaneAuspBesch.setBorder(null);
					txtAauspBesch.setBorder(txtFanzAusp.getBorder());
					txtAauspBesch.setEditable(false);
					if (i + 1 >= anzKrit)
					{
						txtAauspBesch.setBackground(txtFanzAusp.getBackground());
						txtFanzAusp.setEditable(true);
						txtAKritBesch.setEditable(true);
						txtAKritBesch.setBackground(txtFanzAusp.getBackground());
					}
				}
				lblAhg.setText(HochTiefSteller.stelleZiffernTief(("A"+(i)+(x+1))));
				

			
			
			
			}
		});
		GridBagConstraints gbc_btnAauspBesch = new GridBagConstraints();
		gbc_btnAauspBesch.insets = new Insets(0, 0, 5, 5);
		gbc_btnAauspBesch.gridx = 2;
		gbc_btnAauspBesch.gridy = 11;
		contentPane.add(btnAauspBesch, gbc_btnAauspBesch);
		
		
		
		
		
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_MAIN2 guiMain = new GUI_MAIN2();
				dispose();
				guiMain.setVisible(true);
			
			}
		});
		GridBagConstraints gbc_btnHauptmen = new GridBagConstraints();
		gbc_btnHauptmen.gridx = 3;
		gbc_btnHauptmen.gridy = 12;
		contentPane.add(btnHauptmen, gbc_btnHauptmen);

	}

	protected void setKrits(JTextArea txtAKritBesch) {
		ArrayList<Kriterien> KritArray= New_KatalogSQL.get_KritsofKatID(New_KatalogSQL.get_lastKatalogID());
		if(i==KritArray.size()){
			System.out.println("Size erreicht");
		}
		else{


			lblKVonKn.setText(HochTiefSteller.stelleZiffernTief("K"+(i+1)+" von K"+KritArray.size()));

			Kriterien retKrit = KritArray.get(i);

			New_KatalogSQL.update_KritKatalog(txtAKritBesch.getText(),retKrit.idKrit);
			++i;
			lblAhg.setText(HochTiefSteller.stelleZiffernTief(("A"+(i)+(x+1))));
			

		}
		
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
		
	}
}
