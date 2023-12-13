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
import java.awt.event.ActionEvent;

public class LibHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		getContentPane().setBackground(new Color(128, 128, 255));
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel.setBounds(10, 11, 141, 136);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(148, 11, 402, 48);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea txtrAbout = new JTextArea();
		txtrAbout.setBackground(new Color(128, 128, 255));
		txtrAbout.setFont(new Font("Dialog", Font.BOLD, 12));
		txtrAbout.setText("About\r\nSince 1990, a well equiped Library for who are Students,Researchers, and other geniune Readers.\r\nWe encourage every student to acquire more knowledge as possible by well study.");
		txtrAbout.setEditable(false);
		txtrAbout.setBounds(10, 326, 567, 91);
		getContentPane().add(txtrAbout);
		
		JTextArea txtrQuoteseducation = new JTextArea();
		txtrQuoteseducation.setBackground(new Color(128, 128, 255));
		txtrQuoteseducation.setText("\r\nQuotes : \r\n\r\n\"A Room without\r\n Books is a body\r\n without Soul\" .");
		txtrQuoteseducation.setEditable(false);
		txtrQuoteseducation.setFont(new Font("Dialog", Font.BOLD, 13));
		txtrQuoteseducation.setBounds(10, 156, 128, 170);
		getContentPane().add(txtrQuoteseducation);
		
		JButton btnNewButton = new JButton("Administrator Login");
		btnNewButton.addActionListener(e -> new AdminLog().setVisible(true));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(215, 75, 250, 33);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Administrator");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(215, 150, 250, 33);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Contact Us");
		btnNewButton_3.addActionListener(e -> new ContactUsDialogBox().setVisible(true));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(179, 243, 132, 40);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Feedback");
		btnNewButton_4.addActionListener(e -> new Comments().setVisible(true));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(364, 243, 141, 40);
		getContentPane().add(btnNewButton_4);
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("ACADEMIC LIBRARY");
		setBounds(100, 100, 589, 452);
		
		
	}
}
