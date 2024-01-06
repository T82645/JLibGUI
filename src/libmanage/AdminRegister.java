package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
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
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import java.sql.*;
public class AdminRegister extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup buttongrp;
	private JTextField namefield;
	private JTextField fathernamefield;
	private JTextField emailfield;
	private JDateChooser dateChooser;
	private JRadioButton malebutton;
	private JRadioButton femalebutton;
	private JTextField confirmpasswordfield;
	private JPasswordField createpasswordfield;
	
	private String Id="";
	
	String urlid = "jdbc:mysql://localhost:3306/TAM";
	String usname = "T82645";
	String passwd = "Tamil@82645";
	
	private String createAdmin_ID(String n) {
		Random rm = new Random();
		String f1 = n.substring(0, 2);
		int frm = rm.nextInt(1000,9999);
		return f1+frm;
	} 
	
	private void passwcreation(String k) {
		
		Pattern p1 = Pattern.compile("[A-Z]+");
		Pattern p2 = Pattern.compile("[a-z]+");
		Pattern p3 = Pattern.compile("[0-9]+");
		Pattern p4 = Pattern.compile("[\\W]+");
		Pattern p5 = Pattern.compile("[\\s]");
		
		Matcher m1 = p1.matcher(k);
		Matcher m2 = p2.matcher(k);
		Matcher m3 = p3.matcher(k);
		Matcher m4 = p4.matcher(k);
		Matcher m5 = p5.matcher(k);
		
		if(k.length()<8||k.length()>12) {
			JOptionPane.showMessageDialog(createpasswordfield, "* Password length must be minimum of 8 characters and maximum 12 characters"+'\n'
		+"* Spaces not allowed in Password Field..");
		}else {
		int i=0;
		while(m1.find()) {
			i++;
		}
		int j=0;
		while(m2.find()) {
			j++;
		}
		int h=0;
		while(m3.find()) {
			h++;
		}
		int l=0;
		while(m4.find()) {
			l++;
		}
		int m=0;
		while(m5.find()) {
			m++;
		}
		if(i==0|j==0|h==0|l==0|m>0) {
			JOptionPane.showMessageDialog(createpasswordfield, "* Password length must be minimum of 8 characters and maximum 12 characters"+'\n'
		+"* Password must Contain atleast one UpperCase Letter." +'\n'
		+"* Password must Contain atleast one LowerCase Letter."+'\n'
		+"* Password must Contain atleast one Numerical Letter."+'\n'
		+"* Password must Contain one Special Character."+'\n'
		+"* Space not allowed in password Field.");
		}
		if(k.length()>7&&k.length()<13){
		if(i>0&&j>0&&h>0&&l>0&&m==0) {
			 JOptionPane.showMessageDialog(createpasswordfield, "Password is Valid.");
			 confirmpasswordfield.setEditable(true);
			 
		}
	}
		}
	}
	
	private void setReset() {
		String j = "";
		namefield.setText(j);
		fathernamefield.setText(j);
		buttongrp.clearSelection();
		dateChooser.setCalendar(null);
		emailfield.setText(j);
		createpasswordfield.setText(j);
		confirmpasswordfield.setText(j);
		
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
		setBounds(100, 50, 570, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(230, 32, 270, 37);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATOR REGISTRATION");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 80, 323, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 145, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel namelabel = new JLabel("Name ");
		namelabel.setForeground(new Color(0, 255, 255));
		namelabel.setHorizontalAlignment(SwingConstants.TRAILING);
		namelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		namelabel.setBounds(135, 162, 61, 29);
		contentPane.add(namelabel);
		
		namefield = new JTextField();
		namefield.setFont(new Font("Tahoma", Font.BOLD, 15));
		namefield.setBounds(220, 165, 175, 25);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		JLabel fathernamelabel = new JLabel("Father Name");
		fathernamelabel.setForeground(new Color(0, 255, 255));
		fathernamelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		fathernamelabel.setBounds(95, 202, 97, 23);
		contentPane.add(fathernamelabel);
		
		fathernamefield = new JTextField();
		fathernamefield.setFont(new Font("Tahoma", Font.BOLD, 15));
		fathernamefield.setBounds(220, 203, 175, 25);
		contentPane.add(fathernamefield);
		fathernamefield.setColumns(10);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setForeground(new Color(0, 255, 255));
		genderLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		genderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		genderLabel.setBounds(120, 236, 72, 25);
		contentPane.add(genderLabel);
		
		buttongrp = new ButtonGroup();
		JRadioButton malebutton = new JRadioButton("M");
		buttongrp.add(malebutton);
		malebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		malebutton.setBounds(220, 237, 40, 23);
		contentPane.add(malebutton);
		
		
		JRadioButton femalebutton = new JRadioButton("F");
		buttongrp.add(femalebutton);
		femalebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		femalebutton.setBounds(290, 237, 40, 23);
		contentPane.add(femalebutton);
		
		
		JLabel DateofBirthlabel = new JLabel("Date Of Birth");
		DateofBirthlabel.setForeground(new Color(0, 255, 255));
		DateofBirthlabel.setHorizontalAlignment(SwingConstants.TRAILING);
		DateofBirthlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		DateofBirthlabel.setBounds(95, 272, 99, 26);
		contentPane.add(DateofBirthlabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 15));
		dateChooser.setDateFormatString("dd-MMM-yyyy");
		dateChooser.setBounds(220, 275, 97, 25);
		contentPane.add(dateChooser);
		
		JLabel emailLabel = new JLabel("E - Mail");
		emailLabel.setForeground(new Color(0, 255, 255));
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(130, 309, 61, 23);
		contentPane.add(emailLabel);
		
		emailfield = new JTextField();
		emailfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailfield.setBounds(220, 310, 175, 25);
		contentPane.add(emailfield);
		emailfield.setColumns(10);
		
		JLabel Createpasslabel = new JLabel("Create Password");
		Createpasslabel.setForeground(new Color(0, 255, 255));
		Createpasslabel.setHorizontalAlignment(SwingConstants.TRAILING);
		Createpasslabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Createpasslabel.setBounds(60, 343, 132, 23);
		contentPane.add(Createpasslabel);
		
		createpasswordfield = new JPasswordField(12);
		createpasswordfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		createpasswordfield.setBounds(220, 346, 175, 25);
		contentPane.add(createpasswordfield);
		
		JButton validatebutton = new JButton("Validate");
		validatebutton.addActionListener(e -> this.passwcreation(createpasswordfield.getText()));
		validatebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		validatebutton.setBounds(411, 345, 100, 25);
		contentPane.add(validatebutton);
		
		JLabel confirmpasslabel = new JLabel("Confirm Password");
		confirmpasslabel.setForeground(new Color(0, 255, 255));
		confirmpasslabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmpasslabel.setBounds(55, 385, 145, 23);
		contentPane.add(confirmpasslabel);
		
		confirmpasswordfield = new JTextField(12);
		confirmpasswordfield.setEditable(false);
		confirmpasswordfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmpasswordfield.setBounds(220, 385, 175, 25);
		contentPane.add(confirmpasswordfield);
		confirmpasswordfield.setColumns(10);
		
		JButton registerbutton = new JButton("Register");
		registerbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerbutton.setBounds(120, 445, 115, 35);
		contentPane.add(registerbutton);
		registerbutton.addActionListener(e -> {
				
				String adminId = this.createAdmin_ID(namefield.getText());
			    String gend ="";
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/YYYY");
				String dt = sdf.format(dateChooser.getJCalendar().getDate());
				
				if(malebutton.isSelected()) {
					gend = "Male";
				}else if(femalebutton.isSelected()) {
					gend = "Female";
				}
				if(namefield.getText().equals("")|fathernamefield.getText().equals("")|!buttongrp.isSelected(buttongrp.getSelection())|
						dateChooser.getJCalendar().getDate()==null|emailfield.getText().equals("")|createpasswordfield.getText().equals("")|
						confirmpasswordfield.getText().equals("")) {
					JOptionPane.showMessageDialog(registerbutton, "All Fields are Mandatory...");
				}
				
				if(createpasswordfield.getText().equals(confirmpasswordfield.getText())) {
				try {
						// Create Connection
						Connection conn = DriverManager.getConnection(urlid, usname, passwd);
						String qry = "Select count(*) from AdminInfo";
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(qry);
						int j=0;
						while(rs.next()) {
							j= rs.getInt(1);
						}
					if(j>0) {
						conn.close();
						JOptionPane.showMessageDialog(null, "Administrator Already Exists. Click OK to Update Admin");
						dispose();
						new RemAdmin().setVisible(true);
						}else{
							
					String qury = "Insert into AdminInfo values(?,?,?,?,?,?,?)";
					PreparedStatement pstmt = conn.prepareStatement(qury);
					pstmt.setString(1, namefield.getText());
					pstmt.setString(2, fathernamefield.getText());
					pstmt.setString(3, gend);
					pstmt.setString(4, dt);
					pstmt.setString(5, emailfield.getText());
					pstmt.setString(6, adminId);
					pstmt.setString(7, createpasswordfield.getText());
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Your Registration is Succesful."+'\n'
					+"> Please Click 'OK' if you noted it."+'\n'
							+"Your Admin ID is : "+adminId);
					
					String qr = "Insert into registered values(?,?)";
					PreparedStatement ps = conn.prepareStatement(qr);
					ps.setString(1, adminId);
					ps.setString(2, createpasswordfield.getText());
					ps.executeUpdate();
					conn.close();
					dispose();
					new LibHome().setVisible(true);
					
					}
					}
					catch(SQLException ioe ) {
						JOptionPane.showMessageDialog(null, "SQLException");
					}
				}});
				
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(e -> this.setReset());
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(320, 445, 115, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_15.setBounds(0, 0, 558, 525);
		contentPane.add(lblNewLabel_15);
		
	}
}