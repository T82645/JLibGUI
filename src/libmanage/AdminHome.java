package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private void lgout() {
		Object [] opt = { "Yes","No"};
		int a = JOptionPane.showOptionDialog(this,"Are you Sure want to Logout and Leave ?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opt, opt[1]);
		if(a==JOptionPane.YES_OPTION) {this.dispose();;}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() { 
					public void windowClosing(WindowEvent e ) {
					  JOptionPane.showMessageDialog(frame, "Please Logout Before Leaving this page", "INFO", JOptionPane.PLAIN_MESSAGE);
					  }});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public AdminHome() {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Admin-Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setBounds(100, 100, 488, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel_1.setBounds(21, 11, 136, 141);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(170, 37, 262, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATOR HOME");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(175, 93, 257, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Books Management");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(21, 168, 205, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Collect Donate");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(21, 245, 205, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Events");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(21, 321, 205, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Manage Students");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(270, 169, 194, 43);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Manage Membership");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(270, 246, 194, 43);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Files");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(270, 321, 194, 42);
		contentPane.add(btnNewButton_5);

		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.addActionListener(e -> this.lgout());
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setBounds(170, 385, 151, 44);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_3.setBounds(0, 0, 478, 450);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
