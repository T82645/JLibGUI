package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;

public class AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setTitle("Add Student");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(169, 21, 121, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(68, 55, 75, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(153, 55, 163, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("D.O.B");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(68, 94, 75, 23);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 15));
		dateChooser.setBounds(153, 94, 100, 23);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(68, 135, 75, 23);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Select---", "B.A", "B.Sc", "B.com", "B.com(CA)", "M.A", "M.Sc", "MCA", "M.Com", "M.phil", "Ph.D"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(153, 135, 121, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Stream");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(68, 179, 75, 23);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"---Select---", "Tamil", "English", "Mathematics", "Physics", "Chemistry", "Botony", "Biology", "Commerce", "Commerce with CA", "Economics", "History", "Sociology", "Psychology", "Geography", "Computer Science", "Political Science", "Journalism", "LibraryScience", "Yoga", "Physical Education"}));
		comboBox_1.setBounds(153, 179, 188, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Batch");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(68, 222, 75, 23);
		contentPane.add(lblNewLabel_5);
		
				
		JLabel lblNewLabel_6 = new JLabel("RollNumber");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(52, 267, 90, 23);
		contentPane.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(153, 270, 100, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(84, 331, 121, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(254, 333, 100, 34);
		contentPane.add(btnNewButton_1);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Tahoma", Font.BOLD, 15));
		yearChooser.getSpinner().setBounds(0, 0, 49, 23);
		yearChooser.setMaximum(2023);
		yearChooser.setMinimum(2017);
		yearChooser.setStartYear(2017);
		yearChooser.setEndYear(2023);
		yearChooser.setBounds(155, 225, 50, 23);
		contentPane.add(yearChooser);
		yearChooser.setLayout(null);
		
		
		
		
	}
}
