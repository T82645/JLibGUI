package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Comments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private String Name;
	private String Email;
	private String LibID;
	private boolean notrobot;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comments frame = new Comments();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public Comments() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Feedback/Enquiry");
		
		setBounds(100, 50, 525, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Feedback");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(265, 82, 125, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Select a topic*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(31, 205, 115, 22);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Library Cards", "Membership plans", "Fines", "Lost Items", "Renewals", "E-Books", "Download Magazines", "Other"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(30, 225, 205, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Name*");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 266, 70, 22);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.addActionListener(e -> this.Name = textField.getText());
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(30, 287, 205, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail*");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(280, 208, 70, 17);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(e -> this.Email = textField_1.getText());
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(279, 225, 205, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Library Card ID(Optional)");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(280, 266, 204, 22);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(e -> this.LibID = textField_3.getText());
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setBounds(280, 287, 205, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Your Comments* (200 Characters)");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(31, 331, 250, 22);
		contentPane.add(lblNewLabel_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 15));
		textArea.setLineWrap(true);
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			private String feedback;

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(e.getDocument().getLength()>200) {
					Object [] op = {"OK"};
					JOptionPane.showOptionDialog(textArea, "Please provide within 200 characters", "INFO", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, op, op[0]);
				   }else {
					this.feedback = textArea.getText();
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		textArea.setBounds(31, 355, 453, 79);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(e -> {
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(113, 513, 125, 37);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I am Not a Robot");
		chckbxNewCheckBox.addActionListener(e -> {this.notrobot = chckbxNewCheckBox.isSelected();
		if(notrobot==false) {
			btnNewButton.setEnabled(false);
		}else {
			btnNewButton.setEnabled(true);
		}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNewCheckBox.setBounds(31, 470, 157, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(e -> 	{
				String h ="";
				textField.setText(h);
				textField_1.setText(h);
				textField_3.setText(h);
				comboBox.setSelectedIndex(0);
				textArea.setText(h);
				chckbxNewCheckBox.setSelected(false);
				});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(280, 513, 125, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\library-icon.jpg"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(21, 11, 136, 142);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("ACADEMIC LIBRARY");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(182, 34, 303, 37);
		contentPane.add(lblNewLabel_8);
		
		JTextArea txtrUseTheForm = new JTextArea();
		txtrUseTheForm.setEditable(false);
		txtrUseTheForm.setBackground(new Color(128, 128, 255));
		txtrUseTheForm.setLineWrap(true);
		txtrUseTheForm.setText("Use the form below to general inquiries, comments that helps our communities.");
		txtrUseTheForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtrUseTheForm.setWrapStyleWord(true);
		txtrUseTheForm.setBounds(31, 164, 416, 34);
		contentPane.add(txtrUseTheForm);
		
		JLabel lblNewLabel_1 = new JLabel("* Mandatory Fields");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(31, 441, 125, 22);
		contentPane.add(lblNewLabel_1);
	}
}
