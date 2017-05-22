package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Color;

public class GUI_SOLUTION extends JFrame {

	private JPanel contentPane;
	private JTextField txtFMontOPName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_SOLUTION frame = new GUI_SOLUTION();
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
	public GUI_SOLUTION() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{25, 50, 25, 100, 100, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFM = new JLabel("<html> F<sub>M</sub>: </html>");
		GridBagConstraints gbc_lblFM = new GridBagConstraints();
		gbc_lblFM.insets = new Insets(0, 0, 5, 5);
		gbc_lblFM.gridx = 3;
		gbc_lblFM.gridy = 0;
		contentPane.add(lblFM, gbc_lblFM);
		
		JLabel lblFR = new JLabel("<html> F<sub>R</sub>: </html>");
		GridBagConstraints gbc_lblFR = new GridBagConstraints();
		gbc_lblFR.insets = new Insets(0, 0, 5, 0);
		gbc_lblFR.gridx = 4;
		gbc_lblFR.gridy = 0;
		contentPane.add(lblFR, gbc_lblFR);
		
		JLabel lblMontOP = new JLabel("01:");
		GridBagConstraints gbc_lblMontOP = new GridBagConstraints();
		gbc_lblMontOP.anchor = GridBagConstraints.EAST;
		gbc_lblMontOP.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontOP.gridx = 0;
		gbc_lblMontOP.gridy = 1;
		contentPane.add(lblMontOP, gbc_lblMontOP);
		
		txtFMontOPName = new JTextField();
		GridBagConstraints gbc_txtFMontOPName = new GridBagConstraints();
		gbc_txtFMontOPName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFMontOPName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFMontOPName.gridx = 1;
		gbc_txtFMontOPName.gridy = 1;
		contentPane.add(txtFMontOPName, gbc_txtFMontOPName);
		txtFMontOPName.setColumns(10);
		
		JProgressBar proBarFM = new JProgressBar();
		proBarFM.setStringPainted(true);
		GridBagConstraints gbc_proBarFM = new GridBagConstraints();
		gbc_proBarFM.fill = GridBagConstraints.BOTH;
		gbc_proBarFM.insets = new Insets(0, 0, 5, 5);
		gbc_proBarFM.gridx = 3;
		gbc_proBarFM.gridy = 1;
		contentPane.add(proBarFM, gbc_proBarFM);
		
		JProgressBar proBarFR = new JProgressBar();
		proBarFR.setStringPainted(true);
		GridBagConstraints gbc_proBarFR = new GridBagConstraints();
		gbc_proBarFR.insets = new Insets(0, 0, 5, 0);
		gbc_proBarFR.fill = GridBagConstraints.BOTH;
		gbc_proBarFR.gridx = 4;
		gbc_proBarFR.gridy = 1;
		contentPane.add(proBarFR, gbc_proBarFR);
		
		JLabel lblFM1 = new JLabel("<html> F<sub>M</sub>: </html>");
		GridBagConstraints gbc_lblFM1 = new GridBagConstraints();
		gbc_lblFM1.anchor = GridBagConstraints.WEST;
		gbc_lblFM1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFM1.gridx = 3;
		gbc_lblFM1.gridy = 2;
		contentPane.add(lblFM1, gbc_lblFM1);
		
		JLabel lblFR1 = new JLabel("<html> F<sub>R</sub>: </html>");
		GridBagConstraints gbc_lblFR1 = new GridBagConstraints();
		gbc_lblFR1.anchor = GridBagConstraints.EAST;
		gbc_lblFR1.insets = new Insets(0, 0, 5, 0);
		gbc_lblFR1.gridx = 4;
		gbc_lblFR1.gridy = 2;
		contentPane.add(lblFR1, gbc_lblFR1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBackground(Color.RED);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.gridwidth = 2;
		gbc_progressBar.gridx = 3;
		gbc_progressBar.gridy = 3;
		contentPane.add(progressBar, gbc_progressBar);
		
		double fm =(double)progressBar.getValue()/100;
		double fr = 1-fm;
		
		JLabel lblNewLabel = new JLabel("<html>"+ "F<sub>M</sub>= " +String.valueOf(fm)+"</html>");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 4;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>"+ "F<sub>R</sub>= " +String.valueOf(fr)+"</html>");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}

}
