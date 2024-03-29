package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class BooksManage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField titlefield;
	private JTextField bookidfield;
	private JTextField textField_2;
	private JTextField searchfield;
	private JTextField totalitemsfield;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksManage frame = new BooksManage();
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
	public BooksManage() {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Books Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setBounds(50, 30, 1200, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.BOLD, 15));
		spinner.setBounds(115, 492, 50, 25);
		contentPane.add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 115, 770, 400);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		totalitemsfield = new JTextField();
		totalitemsfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalitemsfield.setHorizontalAlignment(SwingConstants.CENTER);
		totalitemsfield.setEditable(false);
		totalitemsfield.setBounds(1009, 80, 80, 25);
		contentPane.add(totalitemsfield);
		totalitemsfield.setColumns(10);
		
		JComboBox genre = new JComboBox();
		genre.setModel(new DefaultComboBoxModel(new String[] {"---Select---", "Adventure stories", "Classics", "Crime", "Fairy tales, fables", "Fantasy", "Historical fiction", "Horror", "Humour and satire", "Literary fiction", "Mystery", "Poetry", "Plays", "Romance", "Science fiction", "Short stories", "Thrillers", "War", "Women’s fiction", "Young adult", "Autobiography", "Biography", "Essays", "Non-fiction novel", "Self-help"}));
		genre.setFont(new Font("Tahoma", Font.BOLD, 15));
		genre.setBounds(115, 280, 220, 25);
		contentPane.add(genre);
		
		JComboBox viewby = new JComboBox();
		viewby.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "TextBooks", "Magazines", "Barrowed"}));
		viewby.setFont(new Font("Tahoma", Font.BOLD, 15));
		viewby.setBounds(400, 80, 140, 25);
		contentPane.add(viewby);
		
		JLabel lblNewLabel_2 = new JLabel("BOOKS MANAGEMENT");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(450, 12, 250, 35);
		contentPane.add(lblNewLabel_2);
		
		titlefield = new JTextField();
		titlefield.setFont(new Font("Tahoma", Font.BOLD, 15));
		titlefield.setBounds(115, 60, 220, 25);
		contentPane.add(titlefield);
		titlefield.setColumns(10);
		
		bookidfield = new JTextField();
		bookidfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		bookidfield.setBounds(115, 115, 220, 25);
		contentPane.add(bookidfield);
		bookidfield.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBounds(115, 170, 220, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox vol = new JComboBox();
		vol.setModel(new DefaultComboBoxModel(new String[] {"None", "Vol-I", "Vol-II", "Vol-III", "Vol-IV", "Vol-V", "Vol-VI", "Vol-VII", "Vol-VIII", "Vol-IX", "Vol-X"}));
		vol.setFont(new Font("Tahoma", Font.BOLD, 15));
		vol.setBounds(115, 225, 90, 25);
		contentPane.add(vol);
		
		JComboBox edition = new JComboBox();
		edition.setFont(new Font("Tahoma", Font.BOLD, 15));
		edition.setModel(new DefaultComboBoxModel(new String[] {"None", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th"}));
		edition.setBounds(267, 225, 68, 25);
		contentPane.add(edition);
		
		JComboBox year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"}));
		year.setFont(new Font("Tahoma", Font.BOLD, 15));
		year.setBounds(115, 335, 100, 25);
		contentPane.add(year);
		
		JComboBox rackno = new JComboBox();
		rackno.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15", "R16", "R17", "R18", "R19", "R20", "R21", "R22", "R23", "R24", "R25", "R26", "R27", "R28", "R29", "R30", "R31", "R32", "R33", "R34", "R35", "R36", "R37", "R38", "R39", "R40", "R41", "R42", "R43", "R44", "R45", "R46", "R47", "R48", "R49", "R50", "R51", "R52", "R53", "R54", "R55", "R56", "R57", "R58", "R59", "R60", "R61", "R62", "R63", "R64", "R65", "R66", "R67", "R68", "R69", "R70", "R71", "R72", "R73", "R74", "R75", "R76", "R77", "R78", "R79", "R80", "R81", "R82", "R83", "R84", "R85", "R86", "R87", "R88", "R89", "R90", "R91", "R92", "R93", "R94", "R95", "R96", "R97", "R98", "R99", "R100", "R101", "R102", "R103", "R104", "R105", "R106", "R107", "R108", "R109", "R110", "R111", "R112", "R113", "R114", "R115", "R116", "R117", "R118", "R119", "R120", "R121", "R122", "R123", "R124", "R125", "R126", "R127", "R128", "R129", "R130", "R131", "R132", "R133", "R134", "R135", "R136", "R137", "R138", "R139", "R140", "R141", "R142", "R143", "R144", "R145", "R146", "R147", "R148", "R149", "R150", "R151", "R152", "R153", "R154", "R155"}));
		rackno.setFont(new Font("Tahoma", Font.BOLD, 15));
		rackno.setBounds(115, 445, 100, 25);
		contentPane.add(rackno);
		
		JRadioButton textbookradiobutton = new JRadioButton("TextBook");
		textbookradiobutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		textbookradiobutton.setBounds(115, 390, 100, 25);
		contentPane.add(textbookradiobutton);
		
		JRadioButton magazineradiobutton = new JRadioButton("Magazine");
		magazineradiobutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		magazineradiobutton.setBounds(235, 390, 100, 25);
		contentPane.add(magazineradiobutton);
		
		searchfield = new JTextField();
		searchfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		searchfield.setBounds(570, 80, 400, 25);
		contentPane.add(searchfield);
		searchfield.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(230, 535, 100, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(70, 535, 100, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Barrow TextBook");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(390, 535, 165, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton = new JButton("Return TextBook");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(615, 535, 165, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(30, 60, 40, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Book ID");
		lblNewLabel_4.setForeground(new Color(0, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(30, 115, 70, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Author");
		lblNewLabel_5.setForeground(new Color(0, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(30, 170, 60, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Volume");
		lblNewLabel_6.setForeground(new Color(0, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(30, 225, 60, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Edition");
		lblNewLabel_7.setForeground(new Color(0, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(210, 225, 55, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Genre");
		lblNewLabel_8.setForeground(new Color(0, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(30, 280, 60, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Year");
		lblNewLabel_9.setForeground(new Color(0, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(30, 335, 50, 20);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Rack No");
		lblNewLabel_10.setForeground(new Color(0, 255, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(30, 445, 70, 20);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 390, 70, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_11 = new JLabel("Search");
		lblNewLabel_11.setForeground(new Color(0, 255, 255));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(570, 55, 60, 20);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("View By");
		lblNewLabel_12.setForeground(new Color(0, 255, 255));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(400, 55, 80, 20);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Total Items");
		lblNewLabel_13.setForeground(new Color(0, 255, 255));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(1009, 60, 100, 20);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setForeground(new Color(0, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(30, 490, 70, 20);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Remove Item");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(840, 535, 140, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Properties");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(1040, 535, 120, 40);
		contentPane.add(btnNewButton_4);
		
		JLabel authorfield = new JLabel("");
		authorfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		authorfield.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		authorfield.setBounds(0, 0, 1188, 605);
		contentPane.add(authorfield);
	}
}
