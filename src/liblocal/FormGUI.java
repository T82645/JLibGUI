package liblocal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;

public class FormGUI {

	private JFrame frmEnrollmentForm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormGUI window = new FormGUI();
					window.frmEnrollmentForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrollmentForm = new JFrame();
		frmEnrollmentForm.setResizable(false);
		frmEnrollmentForm.getContentPane().setFont(new Font("SansSerif", Font.BOLD, 11));
		frmEnrollmentForm.setFont(new Font("Dialog", Font.BOLD, 14));
		frmEnrollmentForm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\NSDC.png"));
		frmEnrollmentForm.setTitle("NATIONAL SKILL DEVELOPMENT CORPORATION");
		frmEnrollmentForm.setBounds(100, 100, 557, 676);
		frmEnrollmentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrollmentForm.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ENROLLMENT FORM");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(190, 11, 195, 23);
		frmEnrollmentForm.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME*");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 75, 89, 15);
		frmEnrollmentForm.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setBounds(154, 72, 134, 20);
		frmEnrollmentForm.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(298, 75, 79, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setBounds(387, 70, 115, 20);
		frmEnrollmentForm.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FATHER NAME*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(39, 109, 102, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setBounds(154, 106, 159, 20);
		frmEnrollmentForm.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DATE OF BIRTH*");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(39, 142, 102, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER*");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(39, 176, 64, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("MALE");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(154, 172, 73, 23);
		frmEnrollmentForm.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("FEMALE");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_1.setBounds(234, 172, 79, 23);
		frmEnrollmentForm.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("CATOGERY");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(39, 211, 79, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("GENERAL");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_2.setBounds(154, 207, 89, 23);
		frmEnrollmentForm.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("BC");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_3.setBounds(248, 207, 41, 23);
		frmEnrollmentForm.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("OBC");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_4.setBounds(310, 207, 52, 23);
		frmEnrollmentForm.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("SC/ST");
		rdbtnNewRadioButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_5.setBounds(367, 207, 64, 23);
		frmEnrollmentForm.getContentPane().add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("ADDRESS LINE*");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(39, 250, 115, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(154, 248, 309, 20);
		frmEnrollmentForm.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("CITY*");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(39, 286, 102, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setBounds(154, 284, 135, 20);
		frmEnrollmentForm.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("STATE*");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(310, 286, 48, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5.setBounds(367, 283, 135, 20);
		frmEnrollmentForm.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("E-MAIL*");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(39, 323, 64, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setBounds(154, 321, 309, 20);
		frmEnrollmentForm.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("MOBILE NO*");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(39, 360, 89, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(154, 358, 147, 20);
		frmEnrollmentForm.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("STREAM OF STUDY*");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(39, 404, 134, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_11);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("HTML");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(175, 401, 64, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("CSS");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBounds(249, 401, 52, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("JAVA");
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_2.setBounds(310, 401, 64, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("PYTHON");
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_3.setBounds(380, 401, 79, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("I here by declare above information are as true and also accept T&C*");
		chckbxNewCheckBox_4.setToolTipText("");
		chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_4.setBounds(39, 498, 468, 30);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_4);
		
		JButton btnNewButton_1 = new JButton("RESET TO DEFAULTS");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(103, 571, 160, 23);
		frmEnrollmentForm.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SUBMIT");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(273, 571, 147, 23);
		frmEnrollmentForm.getContentPane().add(btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("FULL STACK");
		chckbxNewCheckBox_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_5.setBounds(175, 437, 102, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("SELENIUM");
		chckbxNewCheckBox_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_6.setBounds(279, 437, 102, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("CYBER SECURITY");
		chckbxNewCheckBox_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_7.setBounds(377, 438, 134, 23);
		frmEnrollmentForm.getContentPane().add(chckbxNewCheckBox_7);
		
		JLabel lblNewLabel_12 = new JLabel("*Mandatory Fields");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(39, 477, 134, 14);
		frmEnrollmentForm.getContentPane().add(lblNewLabel_12);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(154, 136, 134, 23);
		frmEnrollmentForm.getContentPane().add(dateChooser);
	}
}
