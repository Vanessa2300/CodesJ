import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;




public class Student extends JFrame {
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtAddress;
	
	public Student() {
		// TODO Auto-generated constructor stub
		setTitle("Student Records");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 2));
		JLabel lblName = new JLabel("Name:");
		txtName = new JTextField(20);
		JLabel lblID = new JLabel("ID:");
		txtID = new JTextField(10);
		JLabel lblAddress = new JLabel("Address:");
		txtAddress = new JTextField(20);
		JButton btnFirst = new JButton("First");
		JButton btnLast = new JButton("Last");
		JButton btnNext = new JButton("Next");
		JButton btnPrevious = new JButton("Previous");
		
		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showFirstRecord();
			}
			
		});
		
		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showLastRecord();
			}
			
		});
		
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showNextRecord();
				
			}
			
		});
		
		btnPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPreviousRecord();
			}
			
		});
		
		add(lblName);
		add(txtName);
		add(lblID);
		add(txtID);
		add(lblAddress);
		add(txtAddress);
		add(btnFirst);
		add(btnLast);
		add(btnNext);
		add(btnPrevious);

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "system";
			String password = "oracle";
			
			con = DriverManager.getConnection(url,username,password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * FROM jdbc_students");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}		
		
		showFirstRecord();
		setVisible(true);
	}

	
	protected void showLastRecord() {
		// TODO Auto-generated method stub
		try {
			if(rs.last()) {
				displayCurrentRecord();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void showFirstRecord() {
		// TODO Auto-generated method stub
		try {
			if(rs.first()) {
				displayCurrentRecord();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private void showPreviousRecord() {
		// TODO Auto-generated method stub
		try {
			if(rs.previous()) {
				displayCurrentRecord();
			}else {
				rs.next();
				JOptionPane.showMessageDialog(null, "Start of records");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	
	private void showNextRecord() {
		// TODO Auto-generated method stub
		try {
			if(rs.next()) {
				displayCurrentRecord();
			}else {
				rs.previous();
				JOptionPane.showMessageDialog(null, "End of records");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}

	private void displayCurrentRecord() {
		// TODO Auto-generated method stub
		try {
			String name = rs.getString("name");
			int id = rs.getInt("id");
			String address = rs.getString("addr");
			txtName.setText(name);
			txtID.setText(String.valueOf(id));
			txtAddress.setText(address);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Student();
			}
		});
		
	}

}
