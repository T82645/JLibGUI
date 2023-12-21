package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.InputMethodListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Random;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class AdminRegister extends JFrame {
	
	private String Name = "";
	private String FatherName = "";  
	private String Gender = "";
	private String Dob ="";
	public String Email ="";
	private int Mobno ;
	private String addressLine; 
	private String addressLine1;
	private String City ;
	private int postalCode ;
	private String Education = "";
	private String Department ;
	String id;


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup buttongrp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	String urlid = "jdbc:mysql://localhost:3306/TAM";
	String usname = "T82645";
	String passwd = "Tamil@82645";
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String st) {
		this.Name = st;
	}
	
	private String createAdmin_ID(String n) {
		Random rm = new Random();
		String f1 = n.substring(0, 2);
		//String f2 = m.substring(9, m.length());
		int frm = rm.nextInt(1000,9999);
		return f1+frm;
	} 
	
	private void setReset() {
		String j = "";
		textField.setText(j);
		textField_1.setText(j);
		buttongrp.clearSelection();
		textField_2.setText(j);
		textField_3.setText(j);
		textField_4.setText(j);
		textField_5.setText(j);
		textField_6.setText(j);
		textField_7.setText(j);
		textField_8.setText(j);
		textField_9.setText(j);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister frame = new AdminRegister();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() {
						Object [] opt = {"YES","NO"};
						public void windowClosing(WindowEvent a) {
							int s = JOptionPane.showOptionDialog(frame, "Are you sure want to Leave ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[1]);
							if(s==JOptionPane.YES_OPTION) {
								frame.dispose();
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	/**
	 * Create the frame.
	 */
	public AdminRegister() {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Admin Registeration");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setBounds(100, 50, 753, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATOR REGISTRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(278, 80, 323, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 145, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Name ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(94, 162, 61, 29);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(194, 165, 175, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Father Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(58, 202, 97, 23);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(194, 203, 175, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(83, 236, 72, 25);
		contentPane.add(lblNewLabel_5);
		
		buttongrp = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttongrp.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(e ->{ if(rdbtnNewRadioButton.isEnabled()) {
			this.Gender = "Male";
		}});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(194, 237, 61, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		buttongrp.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(e -> {if(rdbtnNewRadioButton_1.isEnabled()) {
			this.Gender = "Female";}});
		
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(278, 237, 81, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Date Of Birth");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(56, 272, 99, 26);
		contentPane.add(lblNewLabel_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 15));
		dateChooser.setDateFormatString("dd-MMM-yyyy");
		dateChooser.setBounds(194, 275, 97, 23);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_7 = new JLabel("E - Mail");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(94, 309, 61, 23);
		contentPane.add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBounds(194, 310, 175, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile (+91)");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(54, 343, 101, 23);
		contentPane.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
	    textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setBounds(193, 344, 175, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Address Line");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(416, 165, 97, 23);
		contentPane.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setBounds(541, 166, 156, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Address Line1");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(416, 200, 106, 27);
		contentPane.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_5.setBounds(541, 203, 156, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("City");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(474, 237, 48, 23);
		contentPane.add(lblNewLabel_11);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_6.setBounds(541, 238, 156, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Postal Code");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(425, 273, 97, 24);
		contentPane.add(lblNewLabel_12);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_7.setBounds(541, 275, 156, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Education");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(435, 309, 87, 23);
		contentPane.add(lblNewLabel_13);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_8.setBounds(541, 310, 156, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Department");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(425, 341, 97, 26);
		contentPane.add(lblNewLabel_14);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_9.setBounds(541, 344, 156, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(	e -> {
			try {
				
				
				
				
				
			 id =this.createAdmin_ID(textField.getText());
			}
		catch(Exception ioe ) {
			System.out.println("Please enter Valid input");
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(278, 405, 115, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(e ->{ this.setReset();
		dateChooser.setDate(null);
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(474, 405, 106, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(263, 32, 349, 37);
		contentPane.add(lblNewLabel_2);
		
		
	}
}