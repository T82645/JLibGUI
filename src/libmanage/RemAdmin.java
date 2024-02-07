package libmanage;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JPasswordField;

public class RemAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	String urlid = "jdbc:mysql://localhost:3306/TAM";
	String userid = "T82645";
	String passw = "Tamil@82645";
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemAdmin dialog = new RemAdmin();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public RemAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(128, 128, 255));
		setTitle("Remove Administrator");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setBounds(100, 100, 408, 367);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(59, 28, 280, 28);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("REMOVE ADMINISTRATOR");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(59, 67, 280, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Existing Admin's ID");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 128, 155, 26);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(186, 129, 172, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(51, 182, 112, 26);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(186, 184, 172, 26);
		getContentPane().add(passwordField);
		
		JButton removebutton = new JButton("Remove");
		removebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		removebutton.setBounds(74, 247, 117, 37);
		getContentPane().add(removebutton);
		removebutton.addActionListener(e -> {
			try {
				String Id = textField.getText();
				String pass = passwordField.getText();
				// create connection 
				Connection cnnt = DriverManager.getConnection(urlid, userid, passw);
				Statement pstm = cnnt.createStatement();
				String qury = "Select count(*) from registered";
				ResultSet rsst = pstm.executeQuery(qury);
				int a=0;
				while(rsst.next()) {
					a=rsst.getInt(1);
				}
				if(a>0){
					String qr1 = "Select * from registered";
					Statement st1 = cnnt.createStatement();
					ResultSet re = st1.executeQuery(qr1);
					String admId="";
					String pwd="";
					while(re.next()) {
					admId = re.getString("adminId");
					pwd = re.getString("password");
					}
					if(Id.equals(admId)&&pass.equals(pwd)) {
						String qurey = "truncate table AdminInfo";
						Statement st2 = cnnt.createStatement();
						st2.executeUpdate(qurey);
						String qr2 = "truncate table registered";
						Statement st3 = cnnt.createStatement();
						st3.executeUpdate(qr2);
						cnnt.close();
						JOptionPane.showMessageDialog(null, "Administrator Removed Successfully..."+'\n'
						+"Click OK to Register as Administrator..");
						dispose();
						new AdminRegister().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect details..Please Check Id or Password..");
						textField.setText("");
						passwordField.setText("");
					}
				}else {
						JOptionPane.showMessageDialog(null, "No Administrator Found.."+'\n'
					+"Click OK to Register as Administrator");
						dispose();
						new AdminRegister().setVisible(true);
						cnnt.close();
					}
					cnnt.close();
			}catch(SQLException k) {
				JOptionPane.showMessageDialog(null, "Remove Failed..");
			}
	});
		
		JButton cancelbuttton = new JButton("Cancel");
		cancelbuttton.addActionListener(e -> {
			dispose();
		});
		cancelbuttton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelbuttton.setBounds(245, 247, 100, 37);
		getContentPane().add(cancelbuttton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_4.setBounds(0, 0, 396, 332);
		getContentPane().add(lblNewLabel_4);

	}
}
