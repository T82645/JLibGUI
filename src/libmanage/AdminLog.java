package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLog frame = new AdminLog();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLog() {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Administrator Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		//setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATOR LOGIN");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(186, 84, 247, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin ID  :");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(98, 164, 99, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(207, 164, 177, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(98, 213, 99, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.addActionListener(e -> {
			try {
				String username = textField.getText();
				String passw = passwordField.getText();
				
				String urlsql = "jdbc:mysql://localhost:3306/TAM";
				String usname = "T82645";
				String pwd = "Tamil@82645";
				Connection co = DriverManager.getConnection(urlsql,usname,pwd);
				String qry1 = "Select count(*) from registered";
				Statement st1 = co.createStatement();
				ResultSet resu = st1.executeQuery(qry1);
				int z=0;
				while(resu.next()) {
					z = resu.getInt(1);
				}
				if(z>0) {
				String st = "Select * from registered";
				Statement stm = co.createStatement();
				ResultSet rst = stm.executeQuery(st);
				String uname ="";
				String passwrd = "";
				while(rst.next()) {
				 uname = rst.getString(1);
				 passwrd = rst.getString(2);
				}
				if(username.equals(uname)&&(passw.equals(passwrd))) {
					dispose();
					new AdminHome().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Please check Admin ID and password");
					textField.setText("");
					passwordField.setText("");	
				}
				}else {
					JOptionPane.showMessageDialog(null,"No Administrator found.. Click OK to Register");
					dispose();
					new AdminRegister().setVisible(true);
				}
				co.close();
		}catch(Exception f ) {
			System.out.println(f.getMessage());
		}});
		loginbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginbutton.setBounds(106, 266, 134, 43);
		contentPane.add(loginbutton);
		
		JButton resetbutton = new JButton("Reset");
		resetbutton.addActionListener(e -> {
			textField.setText("");
			passwordField.setText("");
		});
		resetbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		resetbutton.setBounds(271, 266, 134, 43);
		contentPane.add(resetbutton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 9, 141, 136);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_4.setForeground(new Color(0, 255, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(191, 28, 231, 34);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(207, 212, 177, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_5.setBounds(0, 0, 490, 368);
		contentPane.add(lblNewLabel_5);
	}
}
