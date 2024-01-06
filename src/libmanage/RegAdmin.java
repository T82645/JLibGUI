package libmanage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RegAdmin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegAdmin dialog = new RegAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegAdmin() {
		setFont(new Font("Tahoma", Font.BOLD, 15));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Done");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\Right logo.png"));
		setBounds(100, 100, 413, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 128, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			okButton.setBounds(169, 212, 74, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblNewLabel = new JLabel("Your Registration is Successful.. Click \"OK\" if you noted it.");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 58, 400, 32);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Admin ID : ");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 111, 127, 23);
		contentPanel.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPane.setBounds(163, 101, 171, 33);
		contentPanel.add(textPane);
		
		JLabel lblNewLabel_2 = new JLabel("Your Password : ");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 158, 143, 30);
		contentPanel.add(lblNewLabel_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPane_1.setBounds(163, 158, 171, 30);
		contentPanel.add(textPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_3.setForeground(new Color(0, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(63, 17, 260, 30);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		lblNewLabel_4.setBounds(0, 0, 401, 269);
		contentPanel.add(lblNewLabel_4);
	}
}
