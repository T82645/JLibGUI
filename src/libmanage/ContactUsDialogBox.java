package libmanage;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class ContactUsDialogBox extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUsDialogBox dialog = new ContactUsDialogBox();
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
	public ContactUsDialogBox() {
		setResizable(false);
		getContentPane().setBackground(new Color(128, 128, 255));
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Contact Library");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setBounds(100, 100, 487, 369);
		getContentPane().setLayout(null);
		
		JTextArea txtrAddressNo = new JTextArea();
		txtrAddressNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrAddressNo.setBackground(new Color(255, 128, 255));
		txtrAddressNo.setText("ADDRESS:                                HOURS:\r\nNo. 210,                                     Monday–Friday : 9am–7pm\r\nDr.Radhakrishnan Street,        Saturday : 9am–3pm\r\nChennai -600021.                     Sunday : Holiday\r\nTel : 00101-279851\r\n\r\nMail Us : academiclib1990@gmail.com \r\nVisit Official Site : http://www.academiclibraraychennai.org ");
		txtrAddressNo.setBounds(20, 167, 434, 159);
		getContentPane().add(txtrAddressNo);
		
		JLabel lblNewLabel = new JLabel("Contact us");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(203, 91, 218, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 136, 142);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(184, 35, 283, 41);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_3.setBounds(0, 0, 475, 334);
		getContentPane().add(lblNewLabel_3);

	}
}
