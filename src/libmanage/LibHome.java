package libmanage;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class LibHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	String urlid = "jdbc:mysql://localhost:3306/TAM";
	String userid = "T82645";
	String passw = "Tamil@82645";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibHome frame = new LibHome();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() {
						Object [] options = {"Yes", "No", "Cancel"};
						public void windowClosing(WindowEvent e) {
							int c =JOptionPane.showOptionDialog(frame, "Are you sure want to exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
							if(c==JOptionPane.YES_OPTION) {
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
	public LibHome() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel.setBounds(10, 11, 141, 136);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(203, 11, 309, 48);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Administrator Login");
		btnNewButton.addActionListener(e -> {
			try {
				//Connection creation
				Connection cont = DriverManager.getConnection(urlid, userid, passw);
				Statement st1 = cont.createStatement();
				String qry = "Select count(*) from registered";
				ResultSet rst1 = st1.executeQuery(qry);
				int c=0;
				while(rst1.next()) {
				 c = rst1.getInt(1);
				}
				if(c==0) {
					Object [] op = {"Yes","Cancel"};
					int t = JOptionPane.showConfirmDialog(null, "No Administrator Registered.. Click 'Yes' to Register..");
					if(t==JOptionPane.YES_OPTION) {
						dispose();
						cont.close();
						new AdminRegister().setVisible(true);
					}
				}else {
					dispose();
					cont.close();
					new AdminLog().setVisible(true);
				}
			}
			catch(SQLException a) {
				JOptionPane.showMessageDialog(null, "Connection Error Occured..");
			}
			});
		
		JTextPane txtpnAboutSince = new JTextPane();
		txtpnAboutSince.setBackground(new Color(255, 128, 255));
		txtpnAboutSince.setForeground(new Color(0, 255, 255));
		txtpnAboutSince.setText("ABOUT\r\nSince 1990, a well equiped Library for who are Students,Researchers, and other geniune Readers.\r\nWe encourage every student to acquire more knowledge as possible by well study.");
		txtpnAboutSince.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnAboutSince.setBounds(10, 313, 526, 93);
		getContentPane().add(txtpnAboutSince);
		
		JTextPane txtpnQuotes = new JTextPane();
		txtpnQuotes.setBackground(new Color(255, 128, 255));
		txtpnQuotes.setText("Quotes :\r\n\" A Room\r\nWithout Books\r\nis A Man\r\nWithout\r\nSoul\" ...");
		txtpnQuotes.setForeground(new Color(0, 255, 255));
		txtpnQuotes.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnQuotes.setBounds(10, 176, 141, 126);
		getContentPane().add(txtpnQuotes);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(213, 70, 250, 48);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change Administrator");
		btnNewButton_1.addActionListener(e -> {
			try {
				//Connection creation
				Connection cnt = DriverManager.getConnection(urlid, userid, passw);
				Statement st = cnt.createStatement();
				String qry = "Select count(*) from registered";
				ResultSet rst = st.executeQuery(qry);
				int n=0;
				while(rst.next()) {
				 n = rst.getInt(1);
				}
				if(n==0) {
					Object [] sd = {"Yes","No","Cancel"};
					int vv = JOptionPane.showConfirmDialog(null, "No Administrator found.. Click OK to Register..");
					if(vv==JOptionPane.YES_OPTION) {
					dispose();
					cnt.close();
					new AdminRegister().setVisible(true);
					}
				}else {
					dispose();
					cnt.close();
					new RemAdmin().setVisible(true);
				}
			}
			catch(SQLException j) {
				JOptionPane.showMessageDialog(null, "Connection Error Occured..");
			}
		}
		);
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(213, 146, 250, 48);
		getContentPane().add(btnNewButton_1);
		
		JButton registerbutton = new JButton("Register");
		registerbutton.addActionListener(e -> {
			try {
				Connection cndb = DriverManager.getConnection(urlid, userid, passw);
				Statement stmt = cndb.createStatement();
				String qurey = "Select count(*) from registered";
				ResultSet result = stmt.executeQuery(qurey);
				int x=0;
				while(result.next()) {
				 x = result.getInt(1);
				}
				if(x==0) {
					dispose();
					cndb.close();
					new AdminRegister().setVisible(true);
				}else {
					Object [] ob = { "OK","Cancel"};
					int q =JOptionPane.showOptionDialog(null, "Admin already Registered.. "+'\n'+"-> Click 'OK' if you want Change Administrator", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ob, ob[0]);
					if(q==JOptionPane.OK_OPTION) {
						dispose();
						cndb.close();
						new RemAdmin().setVisible(true);
					}
				}
			}
			catch(SQLException s) {
				JOptionPane.showMessageDialog(null, "Connection Error Occured...");
			}
		});
		registerbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerbutton.setBounds(213, 229, 250, 48);
		getContentPane().add(registerbutton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_2.setBounds(0, 0, 588, 417);
		getContentPane().add(lblNewLabel_2);
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("ACADEMIC LIBRARY");
		setBounds(100, 100, 558, 452);
		
		
	}
}

