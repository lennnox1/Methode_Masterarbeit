package GUI_NEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_RATING extends JFrame {

	private JPanel contentPane;

	private final ButtonGroup bGroupFR = new ButtonGroup();
	private final ButtonGroup bGroupFM = new ButtonGroup();

	private JRadioButton rbtnFMBetter;
	private JRadioButton rbtnFMEqual;
	private JRadioButton rbtnFMWorse;


	private JRadioButton rbtnFRBetter;
	private JRadioButton rbtnFREqual;
	private JRadioButton rbtnFRWorse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_RATING frame = new GUI_RATING();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_RATING() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 25, 0, 70, 0, 25, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);


		


		initRating();






	}

	protected void initRating() {
		JLabel lblFM = new JLabel("FM:");
		GridBagConstraints gbc_lblFM = new GridBagConstraints();
		gbc_lblFM.insets = new Insets(0, 0, 5, 5);
		gbc_lblFM.gridx = 6;
		gbc_lblFM.gridy = 0;
		contentPane.add(lblFM, gbc_lblFM);

		JLabel lblFR = new JLabel("FR:");
		GridBagConstraints gbc_lblFR = new GridBagConstraints();
		gbc_lblFR.insets = new Insets(0, 0, 5, 5);
		gbc_lblFR.gridx = 8;
		gbc_lblFR.gridy = 0;
		contentPane.add(lblFR, gbc_lblFR);

		JLabel lblFMBetter = new JLabel("1,0");
		GridBagConstraints gbc_lblFMBetter = new GridBagConstraints();
		gbc_lblFMBetter.insets = new Insets(0, 0, 5, 5);
		gbc_lblFMBetter.gridx = 5;
		gbc_lblFMBetter.gridy = 1;
		contentPane.add(lblFMBetter, gbc_lblFMBetter);

		rbtnFMBetter = new JRadioButton("+");
		rbtnFMBetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnFRWorse.setSelected(true);
			}
		});
		bGroupFM.add(rbtnFMBetter);
		GridBagConstraints gbc_rbtnFMBetter = new GridBagConstraints();
		gbc_rbtnFMBetter.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMBetter.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFMBetter.gridx = 6;
		gbc_rbtnFMBetter.gridy = 1;
		contentPane.add(rbtnFMBetter, gbc_rbtnFMBetter);

		JLabel lblBetter = new JLabel("besser");
		GridBagConstraints gbc_lblBetter = new GridBagConstraints();
		gbc_lblBetter.insets = new Insets(0, 0, 5, 5);
		gbc_lblBetter.gridx = 7;
		gbc_lblBetter.gridy = 1;
		contentPane.add(lblBetter, gbc_lblBetter);

		rbtnFRBetter = new JRadioButton("+");
		rbtnFRBetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFMWorse.setSelected(true);
			}
		});
		bGroupFR.add(rbtnFRBetter);
		GridBagConstraints gbc_rbtnFRBetter = new GridBagConstraints();
		gbc_rbtnFRBetter.anchor = GridBagConstraints.WEST;
		gbc_rbtnFRBetter.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFRBetter.gridx = 8;
		gbc_rbtnFRBetter.gridy = 1;
		contentPane.add(rbtnFRBetter, gbc_rbtnFRBetter);

		JLabel lblFRBetter = new JLabel("1,0");
		GridBagConstraints gbc_lblFRBetter = new GridBagConstraints();
		gbc_lblFRBetter.insets = new Insets(0, 0, 5, 0);
		gbc_lblFRBetter.gridx = 9;
		gbc_lblFRBetter.gridy = 1;
		contentPane.add(lblFRBetter, gbc_lblFRBetter);

		JLabel lblFMEqual = new JLabel("0,5");
		GridBagConstraints gbc_lblFMEqual = new GridBagConstraints();
		gbc_lblFMEqual.insets = new Insets(0, 0, 5, 5);
		gbc_lblFMEqual.gridx = 5;
		gbc_lblFMEqual.gridy = 2;
		contentPane.add(lblFMEqual, gbc_lblFMEqual);

		rbtnFMEqual = new JRadioButton("=");
		rbtnFMEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFREqual.setSelected(true);
			}
		});
		bGroupFM.add(rbtnFMEqual);
		rbtnFMEqual.setHorizontalAlignment(SwingConstants.LEFT);
		rbtnFMEqual.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_rbtnFMEqual = new GridBagConstraints();
		gbc_rbtnFMEqual.anchor = GridBagConstraints.WEST;
		gbc_rbtnFMEqual.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFMEqual.gridx = 6;
		gbc_rbtnFMEqual.gridy = 2;
		contentPane.add(rbtnFMEqual, gbc_rbtnFMEqual);

		JLabel lblEqual = new JLabel("gleich");
		GridBagConstraints gbc_lblEqual = new GridBagConstraints();
		gbc_lblEqual.insets = new Insets(0, 0, 5, 5);
		gbc_lblEqual.gridx = 7;
		gbc_lblEqual.gridy = 2;
		contentPane.add(lblEqual, gbc_lblEqual);

		rbtnFREqual = new JRadioButton("=");
		rbtnFREqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFMEqual.setSelected(true);
			}
		});
		bGroupFR.add(rbtnFREqual);
		GridBagConstraints gbc_rbtnFREqual = new GridBagConstraints();
		gbc_rbtnFREqual.anchor = GridBagConstraints.WEST;
		gbc_rbtnFREqual.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnFREqual.gridx = 8;
		gbc_rbtnFREqual.gridy = 2;
		contentPane.add(rbtnFREqual, gbc_rbtnFREqual);

		JLabel label = new JLabel("0,5");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 9;
		gbc_label.gridy = 2;
		contentPane.add(label, gbc_label);

		JLabel lblFMWorse = new JLabel("0,0");
		GridBagConstraints gbc_lblFMWorse = new GridBagConstraints();
		gbc_lblFMWorse.insets = new Insets(0, 0, 0, 5);
		gbc_lblFMWorse.gridx = 5;
		gbc_lblFMWorse.gridy = 3;
		contentPane.add(lblFMWorse, gbc_lblFMWorse);

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
		gbc_rbtnFMWorse.gridx = 6;
		gbc_rbtnFMWorse.gridy = 3;
		contentPane.add(rbtnFMWorse, gbc_rbtnFMWorse);

		JLabel lblWorse = new JLabel("schlechter");
		GridBagConstraints gbc_lblWorse = new GridBagConstraints();
		gbc_lblWorse.insets = new Insets(0, 0, 0, 5);
		gbc_lblWorse.gridx = 7;
		gbc_lblWorse.gridy = 3;
		contentPane.add(lblWorse, gbc_lblWorse);

		rbtnFRWorse = new JRadioButton("-");
		rbtnFRWorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnFMBetter.setSelected(true);
			}
		});
		bGroupFR.add(rbtnFRWorse);
		GridBagConstraints gbc_rbtnFRWorse = new GridBagConstraints();
		gbc_rbtnFRWorse.anchor = GridBagConstraints.WEST;
		gbc_rbtnFRWorse.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnFRWorse.gridx = 8;
		gbc_rbtnFRWorse.gridy = 3;
		contentPane.add(rbtnFRWorse, gbc_rbtnFRWorse);

		JLabel lblFRWorse = new JLabel("0,0");
		GridBagConstraints gbc_lblFRWorse = new GridBagConstraints();
		gbc_lblFRWorse.gridx = 9;
		gbc_lblFRWorse.gridy = 3;
		contentPane.add(lblFRWorse, gbc_lblFRWorse);



		// Default JRadioButton Selection

		rbtnFMEqual.setSelected(true);
		rbtnFREqual.setSelected(true);
	}

}
