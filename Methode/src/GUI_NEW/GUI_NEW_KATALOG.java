package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class GUI_NEW_KATALOG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 168, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPane.add(lblName, gbc_lblName);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Anz. Krit:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 1;
		contentPane.add(btnOk, gbc_btnOk);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 1;
		gbc_lblBeschreibung.gridy = 2;
		contentPane.add(lblBeschreibung, gbc_lblBeschreibung);
		
		JLabel lblKVonKn = new JLabel("K1 von KN");
		GridBagConstraints gbc_lblKVonKn = new GridBagConstraints();
		gbc_lblKVonKn.insets = new Insets(0, 0, 5, 0);
		gbc_lblKVonKn.gridx = 3;
		gbc_lblKVonKn.gridy = 2;
		contentPane.add(lblKVonKn, gbc_lblKVonKn);
		
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnOk_1 = new GridBagConstraints();
		gbc_btnOk_1.anchor = GridBagConstraints.NORTH;
		gbc_btnOk_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk_1.gridx = 2;
		gbc_btnOk_1.gridy = 3;
		contentPane.add(btnOk_1, gbc_btnOk_1);
		
		JLabel lblAnzAusp = new JLabel("Anz. Ausp:");
		GridBagConstraints gbc_lblAnzAusp = new GridBagConstraints();
		gbc_lblAnzAusp.anchor = GridBagConstraints.EAST;
		gbc_lblAnzAusp.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzAusp.gridx = 0;
		gbc_lblAnzAusp.gridy = 4;
		contentPane.add(lblAnzAusp, gbc_lblAnzAusp);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnOk_2 = new JButton("OK");
		GridBagConstraints gbc_btnOk_2 = new GridBagConstraints();
		gbc_btnOk_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk_2.gridx = 2;
		gbc_btnOk_2.gridy = 4;
		contentPane.add(btnOk_2, gbc_btnOk_2);
		
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
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
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
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
