package libmanage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageStudent_Info extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namefield;
	private JTextField rollnumfield;
	private JTextField searchfield;
	String j = "";

	String urlId = "jdbc:mysql://localhost:3306/TAM";
	String usrname = "T82645";
	String Passwd = "Tamil@82645";
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudent_Info frame = new ManageStudent_Info();
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
	public ManageStudent_Info() {
		setResizable(false);
		setTitle("Add Student");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91812\\Downloads\\library-icon-png-20.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 837, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(180, 382, 120, 25);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "---Select---", "2014", "2015", "2016", "2017",
				"2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(comboBox_2);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(180, 250, 188, 25);
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "---Select---", "Tamil", "English", "Mathematics",
				"Physics", "Chemistry", "Botony", "Biology", "Commerce", "Commerce with CA", "Economics", "History",
				"Sociology", "Psychology", "Geography", "Computer Science", "Political Science", "Journalism",
				"LibraryScience", "Yoga", "Physical Education" }));
		contentPane.add(comboBox_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 185, 120, 25);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Select---", "B.A", "B.Sc", "B.com", "B.com(CA)", "M.A", "M.Sc", "MCA", "M.Com", "M.phil", "Ph.D"}));
		comboBox.setToolTipText("");
		contentPane.add(comboBox);
		
		JButton addbutton = new JButton("Add");
		addbutton.addActionListener(e -> {
		String d = "";
		String nm = "";
		String rollnum = "";
		String course = "---Select---";
		String stream = "---Select---";
		String year = "---Select---";
					
			nm = namefield.getText();
			rollnum = rollnumfield.getText();
			course = (String) comboBox.getSelectedItem();
			stream = (String) comboBox_1.getSelectedItem();
			year = (String) comboBox_2.getSelectedItem();
				
			if(nm.equals(d)|rollnum.equals(d)|course.equals("---Select---")|stream.equals("---Select---")|year.equals("---Select---")) {
						JOptionPane.showMessageDialog(null, "All Fields are Mandatory..");
				}else {
					Connection cn;
					// create Connection
				try {

					cn = DriverManager.getConnection(urlId, usrname, Passwd);
					String qr1 = "insert into librarystudents values(?,?,?,?,?)";
					PreparedStatement prepstm = cn.prepareStatement(qr1);
					prepstm.setString(1, nm);
					prepstm.setString(2, course);
					prepstm.setString(3, stream);
					prepstm.setString(4, rollnum);
					prepstm.setString(5, year);
					prepstm.executeUpdate();

					namefield.setText(j);
					rollnumfield.setText(j);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
						
					table.setModel(new DefaultTableModel());

					String qr2 = "select * from LibraryStudents";
					Statement pst = cn.createStatement();
					ResultSet rr = pst.executeQuery(qr2);
					ResultSetMetaData rsmd = rr.getMetaData();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					int colcount = rsmd.getColumnCount();
					String[] colnames = new String[colcount];
					for (int i = 0; i < colcount; i++) {
						colnames[i] = rsmd.getColumnName(i + 1);
						dtm.setColumnIdentifiers(colnames);
					}
					String n,c,st,rln,y;
					while(rr.next()) {
						n = rr.getString(1);
						c = rr.getString(2);
						st = rr.getString(3);
						rln = rr.getString(4);
						y =rr.getString(5);
						String [] obj = {n,c,st,rln,y};
						dtm.addRow(obj);
					}
					prepstm.close();
					pst.close();
					cn.close();
				} catch (SQLException s) {
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				}
				});
				addbutton.setBounds(64, 470, 120, 40);
				addbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
				contentPane.add(addbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 100, 405, 350);
		contentPane.add(scrollPane);
				
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				addbutton.setEnabled(false);
				int r = table.getSelectedRow();
				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				namefield.setText(mod.getValueAt(r, 0).toString());
				String coursefield = mod.getValueAt(r, 1).toString();
				switch(coursefield) {
				case "B.A":
					comboBox.setSelectedIndex(1);
					break;
				case "B.Sc":
					comboBox.setSelectedIndex(2);
					break;
				case "B.com":
					comboBox.setSelectedIndex(3);
					break;
				case "B.com(CA)":
					comboBox.setSelectedIndex(4);
					break;
				case "M.A":
					comboBox.setSelectedIndex(5);
					break;
				case "M.Sc":
					comboBox.setSelectedIndex(6);
					break;
				case "MCA":
					comboBox.setSelectedIndex(7);
					break;
				case "M.Com":
					comboBox.setSelectedIndex(8);
					break;
				case "M.phil":
					comboBox.setSelectedIndex(9);
					break;
				case "Ph.D":
					comboBox.setSelectedIndex(10);
					break;
				}
				
			String streamfield = mod.getValueAt(r, 2).toString();
			switch(streamfield) {
			case "Tamil":
				comboBox_1.setSelectedIndex(1);
				break;
			case "English":
				comboBox_1.setSelectedIndex(2);
				break;
			case "Mathematics":
				comboBox_1.setSelectedIndex(3);
				break;
			case "Physics":
				comboBox_1.setSelectedIndex(4);
				break;
			case "Chemistry":
				comboBox_1.setSelectedIndex(5);
				break;
			case "Botony":
				comboBox_1.setSelectedIndex(6);
				break;
			case "Biology":
				comboBox_1.setSelectedIndex(7);
				break;
			case "Commerce":
				comboBox_1.setSelectedIndex(8);
				break;
			case "Commerce with CA":
				comboBox_1.setSelectedIndex(9);
				break;
			case "Economics":
				comboBox_1.setSelectedIndex(10);
				break;
			case "History":
				comboBox_1.setSelectedIndex(11);
				break;
			case "Sociology":
				comboBox_1.setSelectedIndex(12);
				break;
			case "Psychology":
				comboBox_1.setSelectedIndex(13);
				break;
			case "Geography":
				comboBox_1.setSelectedIndex(14);
				break;
			case "Computer Science":
				comboBox_1.setSelectedIndex(15);
				break;
			case "Political Science":
				comboBox_1.setSelectedIndex(16);
				break;
			case "Journalism":
				comboBox_1.setSelectedIndex(17);
				break;
			case "LibraryScience":
				comboBox_1.setSelectedIndex(18);
				break;
			case "Yoga":
				comboBox_1.setSelectedIndex(19);
				break;
			case "Physical Education":
				comboBox_1.setSelectedIndex(20);
				break;
			}
			
		String rln = mod.getValueAt(r, 3).toString();
		rollnumfield.setText(rln);		
		rollnumfield.setEditable(false);
		
		String yearfield = mod.getValueAt(r, 4).toString();
		switch(yearfield) {
		case "2014":
			comboBox_2.setSelectedIndex(1);
			break;
		case "2015":
			comboBox_2.setSelectedIndex(2);
			break;
		case "2016":
			comboBox_2.setSelectedIndex(3);
			break;
		case "2017":
			comboBox_2.setSelectedIndex(4);
			break;
		case "2018":
			comboBox_2.setSelectedIndex(5);
			break;
		case "2019":
			comboBox_2.setSelectedIndex(6);
			break;
		case "2020":
			comboBox_2.setSelectedIndex(7);
			break;
		case "2021":
			comboBox_2.setSelectedIndex(8);
			break;
		case "2022":
			comboBox_2.setSelectedIndex(9);
			break;
		case "2023":
			comboBox_2.setSelectedIndex(10);
			break;
		case "2024":
			comboBox_2.setSelectedIndex(11);
			break;
		}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				addbutton.setEnabled(false);
				int r = table.getSelectedRow();
				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				namefield.setText(mod.getValueAt(r, 0).toString());
				String coursefield = mod.getValueAt(r, 1).toString();
				switch(coursefield) {
				case "B.A":
					comboBox.setSelectedIndex(1);
					break;
				case "B.Sc":
					comboBox.setSelectedIndex(2);
					break;
				case "B.com":
					comboBox.setSelectedIndex(3);
					break;
				case "B.com(CA)":
					comboBox.setSelectedIndex(4);
					break;
				case "M.A":
					comboBox.setSelectedIndex(5);
					break;
				case "M.Sc":
					comboBox.setSelectedIndex(6);
					break;
				case "MCA":
					comboBox.setSelectedIndex(7);
					break;
				case "M.Com":
					comboBox.setSelectedIndex(8);
					break;
				case "M.phil":
					comboBox.setSelectedIndex(9);
					break;
				case "Ph.D":
					comboBox.setSelectedIndex(10);
					break;
				}
				
			String streamfield = mod.getValueAt(r, 2).toString();
			switch(streamfield) {
			case "Tamil":
				comboBox_1.setSelectedIndex(1);
				break;
			case "English":
				comboBox_1.setSelectedIndex(2);
				break;
			case "Mathematics":
				comboBox_1.setSelectedIndex(3);
				break;
			case "Physics":
				comboBox_1.setSelectedIndex(4);
				break;
			case "Chemistry":
				comboBox_1.setSelectedIndex(5);
				break;
			case "Botony":
				comboBox_1.setSelectedIndex(6);
				break;
			case "Biology":
				comboBox_1.setSelectedIndex(7);
				break;
			case "Commerce":
				comboBox_1.setSelectedIndex(8);
				break;
			case "Commerce with CA":
				comboBox_1.setSelectedIndex(9);
				break;
			case "Economics":
				comboBox_1.setSelectedIndex(10);
				break;
			case "History":
				comboBox_1.setSelectedIndex(11);
				break;
			case "Sociology":
				comboBox_1.setSelectedIndex(12);
				break;
			case "Psychology":
				comboBox_1.setSelectedIndex(13);
				break;
			case "Geography":
				comboBox_1.setSelectedIndex(14);
				break;
			case "Computer Science":
				comboBox_1.setSelectedIndex(15);
				break;
			case "Political Science":
				comboBox_1.setSelectedIndex(16);
				break;
			case "Journalism":
				comboBox_1.setSelectedIndex(17);
				break;
			case "LibraryScience":
				comboBox_1.setSelectedIndex(18);
				break;
			case "Yoga":
				comboBox_1.setSelectedIndex(19);
				break;
			case "Physical Education":
				comboBox_1.setSelectedIndex(20);
				break;
			}
			
		String rln = mod.getValueAt(r, 3).toString();
		rollnumfield.setText(rln);		
		rollnumfield.setEditable(false);
		
		String yearfield = mod.getValueAt(r, 4).toString();
		switch(yearfield) {
		case "2014":
			comboBox_2.setSelectedIndex(1);
			break;
		case "2015":
			comboBox_2.setSelectedIndex(2);
			break;
		case "2016":
			comboBox_2.setSelectedIndex(3);
			break;
		case "2017":
			comboBox_2.setSelectedIndex(4);
			break;
		case "2018":
			comboBox_2.setSelectedIndex(5);
			break;
		case "2019":
			comboBox_2.setSelectedIndex(6);
			break;
		case "2020":
			comboBox_2.setSelectedIndex(7);
			break;
		case "2021":
			comboBox_2.setSelectedIndex(8);
			break;
		case "2022":
			comboBox_2.setSelectedIndex(9);
			break;
		case "2023":
			comboBox_2.setSelectedIndex(10);
			break;
		case "2024":
			comboBox_2.setSelectedIndex(11);
			break;
		}
			}
		});
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
				addbutton.setEnabled(false);
				int r = table.getSelectedRow();
				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				namefield.setText(mod.getValueAt(r, 0).toString());
				String coursefield = mod.getValueAt(r, 1).toString();
				switch(coursefield) {
				case "B.A":
					comboBox.setSelectedIndex(1);
					break;
				case "B.Sc":
					comboBox.setSelectedIndex(2);
					break;
				case "B.com":
					comboBox.setSelectedIndex(3);
					break;
				case "B.com(CA)":
					comboBox.setSelectedIndex(4);
					break;
				case "M.A":
					comboBox.setSelectedIndex(5);
					break;
				case "M.Sc":
					comboBox.setSelectedIndex(6);
					break;
				case "MCA":
					comboBox.setSelectedIndex(7);
					break;
				case "M.Com":
					comboBox.setSelectedIndex(8);
					break;
				case "M.phil":
					comboBox.setSelectedIndex(9);
					break;
				case "Ph.D":
					comboBox.setSelectedIndex(10);
					break;
				}
				
			String streamfield = mod.getValueAt(r, 2).toString();
			switch(streamfield) {
			case "Tamil":
				comboBox_1.setSelectedIndex(1);
				break;
			case "English":
				comboBox_1.setSelectedIndex(2);
				break;
			case "Mathematics":
				comboBox_1.setSelectedIndex(3);
				break;
			case "Physics":
				comboBox_1.setSelectedIndex(4);
				break;
			case "Chemistry":
				comboBox_1.setSelectedIndex(5);
				break;
			case "Botony":
				comboBox_1.setSelectedIndex(6);
				break;
			case "Biology":
				comboBox_1.setSelectedIndex(7);
				break;
			case "Commerce":
				comboBox_1.setSelectedIndex(8);
				break;
			case "Commerce with CA":
				comboBox_1.setSelectedIndex(9);
				break;
			case "Economics":
				comboBox_1.setSelectedIndex(10);
				break;
			case "History":
				comboBox_1.setSelectedIndex(11);
				break;
			case "Sociology":
				comboBox_1.setSelectedIndex(12);
				break;
			case "Psychology":
				comboBox_1.setSelectedIndex(13);
				break;
			case "Geography":
				comboBox_1.setSelectedIndex(14);
				break;
			case "Computer Science":
				comboBox_1.setSelectedIndex(15);
				break;
			case "Political Science":
				comboBox_1.setSelectedIndex(16);
				break;
			case "Journalism":
				comboBox_1.setSelectedIndex(17);
				break;
			case "LibraryScience":
				comboBox_1.setSelectedIndex(18);
				break;
			case "Yoga":
				comboBox_1.setSelectedIndex(19);
				break;
			case "Physical Education":
				comboBox_1.setSelectedIndex(20);
				break;
			}
			
		String rln = mod.getValueAt(r, 3).toString();
		rollnumfield.setText(rln);		
		rollnumfield.setEditable(false);
		
		String yearfield = mod.getValueAt(r, 4).toString();
		switch(yearfield) {
		case "2014":
			comboBox_2.setSelectedIndex(1);
			break;
		case "2015":
			comboBox_2.setSelectedIndex(2);
			break;
		case "2016":
			comboBox_2.setSelectedIndex(3);
			break;
		case "2017":
			comboBox_2.setSelectedIndex(4);
			break;
		case "2018":
			comboBox_2.setSelectedIndex(5);
			break;
		case "2019":
			comboBox_2.setSelectedIndex(6);
			break;
		case "2020":
			comboBox_2.setSelectedIndex(7);
			break;
		case "2021":
			comboBox_2.setSelectedIndex(8);
			break;
		case "2022":
			comboBox_2.setSelectedIndex(9);
			break;
		case "2023":
			comboBox_2.setSelectedIndex(10);
			break;
		case "2024":
			comboBox_2.setSelectedIndex(11);
			break;
		}
		
		
		}
		});
		scrollPane.setViewportView(table);

		searchfield = new JTextField();
		searchfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel dfm = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> mm = new TableRowSorter<DefaultTableModel>(dfm);
				table.setRowSorter(mm);
				mm.setRowFilter(RowFilter.regexFilter(searchfield.getText()));
			}
		});
		searchfield.setBounds(400, 64, 405, 25);
		searchfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(searchfield);
		searchfield.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Search");
		lblNewLabel_8.setBounds(401, 28, 58, 23);
		lblNewLabel_8.setForeground(new Color(0, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel = new JLabel("Manage Student Information");
		lblNewLabel.setBounds(30, 36, 280, 34);
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(85, 120, 58, 23);
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);

		namefield = new JTextField();
		namefield.setBounds(180, 120, 163, 25);
		namefield.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(namefield);
		namefield.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setBounds(78, 185, 63, 23);
		lblNewLabel_3.setForeground(new Color(0, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Stream");
		lblNewLabel_4.setBounds(78, 250, 63, 23);
		lblNewLabel_4.setForeground(new Color(0, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Year");
		lblNewLabel_5.setBounds(93, 380, 50, 23);
		lblNewLabel_5.setForeground(new Color(0, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("RollNumber");
		lblNewLabel_6.setBounds(45, 315, 90, 23);
		lblNewLabel_6.setForeground(new Color(0, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_6);

		rollnumfield = new JTextField();
		rollnumfield.setBounds(180, 315, 100, 25);
		rollnumfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(rollnumfield);
		rollnumfield.setColumns(10);

		JButton updatebutton = new JButton("Update");
		updatebutton.addActionListener(e -> {
			Connection cntn;
			try {
				cntn = DriverManager.getConnection(urlId, usrname, Passwd);
				String qr5 = "Select count(*) from librarystudents";
				Statement stm = cntn.createStatement();
				ResultSet rslset = stm.executeQuery(qr5);
				int x =0;
				while(rslset.next()) {
					x= rslset.getInt(1);
				}
				if(x>0) {
					if(table.isRowSelected(table.getSelectedRow())){
						DefaultTableModel defaultTab = (DefaultTableModel) table.getModel();
						String rolln = defaultTab.getValueAt(table.getSelectedRow(), 3).toString();
						int rowselect = table.getSelectedRow();
						String d ="";
						String nm = namefield.getText();
						String rlnum = rollnumfield.getText();
						String course = (String) comboBox.getSelectedItem();
						String stream = (String) comboBox_1.getSelectedItem();
						String year = (String) comboBox_2.getSelectedItem();
							
						if(nm.equals(d)|course.equals("---Select---")|stream.equals("---Select---")|year.equals("---Select---")) {
									JOptionPane.showMessageDialog(null, "All Fields are Mandatory..");
							}else {
								String qr6 = "UPDATE librarystudents SET Name=?, Course=?, Stream=?, Year=? WHERE Rollnumber=?";
								PreparedStatement prst = cntn.prepareStatement(qr6);
								prst.setString(1, nm);
								prst.setString(2, course);
								prst.setString(3, stream);
								prst.setString(4, year);
								prst.setString(5, rolln);
								prst.executeUpdate();
								
								namefield.setText(j);
								rollnumfield.setText(j);
								comboBox.setSelectedIndex(0);
								comboBox_1.setSelectedIndex(0);
								comboBox_2.setSelectedIndex(0);
								table.setModel(new DefaultTableModel());

								String qr2 = "select * from LibraryStudents";
								Statement pst = cntn.createStatement();
								ResultSet rr = pst.executeQuery(qr2);
								ResultSetMetaData rsmd = rr.getMetaData();
								DefaultTableModel dtm = (DefaultTableModel) table.getModel();
								int colcount = rsmd.getColumnCount();
								String[] colnames = new String[colcount];
								for (int i = 0; i < colcount; i++) {
									colnames[i] = rsmd.getColumnName(i + 1);
									dtm.setColumnIdentifiers(colnames);
								}
								String n,c,st,rln,y;
								while(rr.next()) {
									n = rr.getString(1);
									c = rr.getString(2);
									st = rr.getString(3);
									rln = rr.getString(4);
									y =rr.getString(5);
									String [] obj = {n,c,st,rln,y};
									dtm.addRow(obj);
								}
							}
						addbutton.setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Select any data to Update...");	
						}
				}else {
					JOptionPane.showMessageDialog(null, "No data found..");
				}
				stm.close();
				cntn.close();
			}
			catch(SQLException v) {
				JOptionPane.showMessageDialog(null, "Connection Error..");
			}
		});
		updatebutton.setBounds(242, 470, 100, 40);
		updatebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(updatebutton);
		
		JButton deleteallbutton = new JButton("Delete All");
		deleteallbutton.addActionListener(e -> {
			Connection cntn;
			try {
				Object [] op = {"Yes","No"};
				int c =JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete All Data ?");
				if(c==JOptionPane.YES_OPTION) {
				cntn = DriverManager.getConnection(urlId, usrname, Passwd);
				String qry = "truncate table librarystudents";
				Statement stmnt = cntn.createStatement();
				stmnt.executeUpdate(qry);
				table.setModel(new DefaultTableModel());
				stmnt.close();
				cntn.close();
				}
			}
			catch(SQLException s) {
				JOptionPane.showMessageDialog(null, "Connection Error..");
			}
		});
		deleteallbutton.setBounds(670, 470, 120, 40);
		deleteallbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(deleteallbutton);
		
		JButton deletebutton = new JButton("Delete");
		deletebutton.addActionListener(e -> {
			if(table.isRowSelected(table.getSelectedRow())) {
				Object [] opt = {"Yes","No"};
				int v = JOptionPane.showConfirmDialog(null, "Are You sure you want to Delete ?");
				if(v==JOptionPane.YES_OPTION) {
			DefaultTableModel dft = (DefaultTableModel)table.getModel();
			String rr = dft.getValueAt(table.getSelectedRow(), 3).toString();			
			//connection
			Connection conn;
			try {
				conn = DriverManager.getConnection(urlId, usrname, Passwd);
				String qry1 = "delete from librarystudents where Rollnumber="+"'"+rr+"'";
				PreparedStatement ps = conn.prepareStatement(qry1);
				ps.executeUpdate();
				dft.removeRow(table.getSelectedRow());
				ps.close();
				conn.close();
			}
			catch(SQLException s) {
				JOptionPane.showMessageDialog(null, "Connection Error...");
			}
			namefield.setText(j);
			comboBox.setSelectedIndex(0);
			comboBox_1.setSelectedIndex(0);
			rollnumfield.setText(j);
			comboBox_2.setSelectedIndex(0);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please select to Delete any Data..");
			}
			});
		deletebutton.setBounds(540, 470, 100, 40);
		deletebutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(deletebutton);
		
		JButton viewbutton = new JButton("View");
		viewbutton.addActionListener(e -> {
			Connection connec;
			try {
				connec = DriverManager.getConnection(urlId, usrname, Passwd);
				String qr4 = "Select count(*) from librarystudents";
				Statement sta = connec.createStatement();
				ResultSet reslt = sta.executeQuery(qr4);
				int a=0;
				while(reslt.next()) {
					a = reslt.getInt(1);
				}
				if(a>0) {
				table.setModel(new DefaultTableModel());

				String qr3 = "select * from LibraryStudents";
				Statement ps = connec.createStatement();
				ResultSet rst = ps.executeQuery(qr3);
				ResultSetMetaData resmd = rst.getMetaData();
				DefaultTableModel detm = (DefaultTableModel) table.getModel();
				int columncount = resmd.getColumnCount();
				String[] columnnames = new String[columncount];
				for (int i = 0; i < columncount; i++) {
					columnnames[i] = resmd.getColumnName(i + 1);
					detm.setColumnIdentifiers(columnnames);
				}
				String n,c,st,rln,y;
				while(rst.next()) {
					n = rst.getString(1);
					c = rst.getString(2);
					st = rst.getString(3);
					rln = rst.getString(4);
					y =rst.getString(5);
					String [] obj = {n,c,st,rln,y};
					detm.addRow(obj);
				}
				ps.close();
				connec.close();
			}else {
				JOptionPane.showMessageDialog(null, "No data found..");
			}
			}
			catch(SQLException s) {
				JOptionPane.showMessageDialog(null, "Connection Error...");
			}
			});
		viewbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		viewbutton.setBounds(414, 470, 100, 40);
		contentPane.add(viewbutton);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(0, 0, 825, 567);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\91812\\Downloads\\Lib1200x800_blurred.jpg"));
		contentPane.add(lblNewLabel_7);

	}
}
