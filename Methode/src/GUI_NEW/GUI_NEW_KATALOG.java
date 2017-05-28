package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Krit_LPS;
import Data.Kriterienkataloge;

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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class GUI_NEW_KATALOG extends JFrame {

	private JPanel contentPane;
	private JTextField txtFAnz_Krit;
	private JTextField txtFanzAusp;
	private JTextField txtFKatalogName;
	private JLabel lblKVonKn;
	private int i=0;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Anzahl der Auspr\u00E4gungen");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 168, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		contentPane.add(btnKatName, gbc_btnKatName);

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

				New_KatalogSQL.update_anzKrit(Integer.valueOf(txtFAnz_Krit.getText()));

				ArrayList<Kriterienkataloge> KritKatalogArray= new ArrayList<Kriterienkataloge>();
				KritKatalogArray =sql_connector.New_KatalogSQL.get_lastKatalog();
				Kriterienkataloge retKat = KritKatalogArray.get(0);

				for(int i=0; i<retKat.anz_Krit; i++){
					sql_connector.New_KatalogSQL.set_Kriterien("K"+(i+1));

				}

			}
		});
		GridBagConstraints gbc_btnAnz_Krit = new GridBagConstraints();
		gbc_btnAnz_Krit.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnz_Krit.gridx = 2;
		gbc_btnAnz_Krit.gridy = 1;
		contentPane.add(btnAnz_Krit, gbc_btnAnz_Krit);

		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 1;
		gbc_lblBeschreibung.gridy = 2;
		contentPane.add(lblBeschreibung, gbc_lblBeschreibung);

		

		JLabel lblKn = new JLabel("K_n:");
		GridBagConstraints gbc_lblKn = new GridBagConstraints();
		gbc_lblKn.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblKn.insets = new Insets(0, 0, 5, 5);
		gbc_lblKn.gridx = 0;
		gbc_lblKn.gridy = 3;
		contentPane.add(lblKn, gbc_lblKn);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);

		JTextArea txtAKritBesch = new JTextArea();
		scrollPane.setViewportView(txtAKritBesch);

		
		ArrayList<Krit_LPS> KritArray= New_KatalogSQL.get_KritstoKatID(New_KatalogSQL.get_lastKatalogID());

		
		lblKVonKn = new JLabel();
		GridBagConstraints gbc_lblKVonKn = new GridBagConstraints();
		gbc_lblKVonKn.insets = new Insets(0, 0, 5, 0);
		gbc_lblKVonKn.gridx = 3;
		gbc_lblKVonKn.gridy = 2;
		contentPane.add(lblKVonKn, gbc_lblKVonKn);
		
		
		


		JButton btnKritBesch = new JButton("OK");
		btnKritBesch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(i==KritArray.size()){
					System.out.println("Size erreicht");
				}
				else{
					lblKVonKn.setText("K"+(i+1)+" von K"+KritArray.size());
					Krit_LPS retKrit = KritArray.get(i);
					New_KatalogSQL.update_KritKatalog(txtAKritBesch.getText(),retKrit.idKrit_LPS);
					++i;
					
				}

			}
		});
		
		GridBagConstraints gbc_btnKritBesch = new GridBagConstraints();
		gbc_btnKritBesch.anchor = GridBagConstraints.NORTH;
		gbc_btnKritBesch.insets = new Insets(0, 0, 5, 5);
		gbc_btnKritBesch.gridx = 2;
		gbc_btnKritBesch.gridy = 3;
		contentPane.add(btnKritBesch, gbc_btnKritBesch);

		
	
		
		
		
		
		JLabel lblAnzAusp = new JLabel("Anz. Ausp:");
		GridBagConstraints gbc_lblAnzAusp = new GridBagConstraints();
		gbc_lblAnzAusp.anchor = GridBagConstraints.EAST;
		gbc_lblAnzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzAusp.gridx = 0;
		gbc_lblAnzAusp.gridy = 4;
		contentPane.add(lblAnzAusp, gbc_lblAnzAusp);

		txtFanzAusp = new JTextField();
		GridBagConstraints gbc_txtFanzAusp = new GridBagConstraints();
		gbc_txtFanzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_txtFanzAusp.fill = GridBagConstraints.BOTH;
		gbc_txtFanzAusp.gridx = 1;
		gbc_txtFanzAusp.gridy = 4;
		contentPane.add(txtFanzAusp, gbc_txtFanzAusp);
		txtFanzAusp.setColumns(10);

		JButton btnAnzAusp = new JButton("OK");
		btnAnzAusp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			New_KatalogSQL.update_anzAusp(Integer.valueOf(txtFanzAusp.getText()));
			}
		});
		GridBagConstraints gbc_btnAnzAusp = new GridBagConstraints();
		gbc_btnAnzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnzAusp.gridx = 2;
		gbc_btnAnzAusp.gridy = 4;
		contentPane.add(btnAnzAusp, gbc_btnAnzAusp);

		JLabel lblBeschreibung_1 = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung_1 = new GridBagConstraints();
		gbc_lblBeschreibung_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung_1.gridx = 1;
		gbc_lblBeschreibung_1.gridy = 5;
		contentPane.add(lblBeschreibung_1, gbc_lblBeschreibung_1);

		JLabel lblAVonAhg = new JLabel("A11 von Ahg");
		GridBagConstraints gbc_lblAVonAhg = new GridBagConstraints();
		gbc_lblAVonAhg.insets = new Insets(0, 0, 5, 0);
		gbc_lblAVonAhg.gridx = 3;
		gbc_lblAVonAhg.gridy = 5;
		contentPane.add(lblAVonAhg, gbc_lblAVonAhg);

		JLabel lblAhg = new JLabel("Ahg:");
		GridBagConstraints gbc_lblAhg = new GridBagConstraints();
		gbc_lblAhg.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAhg.insets = new Insets(0, 0, 0, 5);
		gbc_lblAhg.gridx = 0;
		gbc_lblAhg.gridy = 6;
		contentPane.add(lblAhg, gbc_lblAhg);

		JButton btnAauspBesch = new JButton("OK");
		btnAauspBesch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 6;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);

		JTextArea txtAauspBesch = new JTextArea();
		scrollPane_1.setViewportView(txtAauspBesch);
		GridBagConstraints gbc_btnAauspBesch = new GridBagConstraints();
		gbc_btnAauspBesch.anchor = GridBagConstraints.NORTH;
		gbc_btnAauspBesch.insets = new Insets(0, 0, 0, 5);
		gbc_btnAauspBesch.gridx = 2;
		gbc_btnAauspBesch.gridy = 6;
		contentPane.add(btnAauspBesch, gbc_btnAauspBesch);
	}

}
