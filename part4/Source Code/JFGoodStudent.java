package databasePJ4;

import java.awt.*;								// import packages, including awt, swing, sql
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JFGoodStudent extends JFrame implements ActionListener{		// Moniter the action through action listener

	private JPanel contentPane;										// This part is to build the main view
	JButton jb1 = new JButton("ECEN");						// Each button represents an department
	JButton jb2 = new JButton("CSCE");
	JButton jb3 = new JButton("CE");
	JButton jb4 = new JButton("ChE");
	JButton jb5 = new JButton("MBS");
	JButton jb6 = new JButton("Close");
	public Connection conn;
	JTextArea textArea = new JTextArea();
	public JFGoodStudent(Connection conn1 ){
		conn = conn1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jb1.setBounds(19, 70, 131, 36);
		jb1.addActionListener(this);
		contentPane.add(jb1);
		
		jb2.setBounds(162, 70, 131, 36);
		jb2.addActionListener(this);
		contentPane.add(jb2);
		
		jb3.setBounds(305, 70, 131, 36);
		jb3.addActionListener(this);
		contentPane.add(jb3);
		
		jb4.setBounds(19, 118, 131, 36);
		jb4.addActionListener(this);
		contentPane.add(jb4);
		
		jb5.setBounds(162, 118, 131, 36);
		jb5.addActionListener(this);
		contentPane.add(jb5);
		
		jb6.setBounds(305, 118, 131, 36);
		jb6.addActionListener(this);
		contentPane.add(jb6);
		
		JLabel lblNewLabel = new JLabel("Welcome to Good Student Page");
		lblNewLabel.setBounds(50, 18, 300, 34);
		contentPane.add(lblNewLabel);
		
		
		textArea.setBounds(20, 166, 400, 122);
		contentPane.add(textArea);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {					// The action about Listener
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)){											
			String str = new String(""); 
			try{
			Statement s =conn.createStatement ();							// Exec the SQL statement and return the result
			   s.executeQuery ("select * from (select * from studyof where (CourseID = 'ECEN01')) as s1 where Score >= all(select Score from (select * from studyof where (CourseID = 'ECEN01')) as s1)");
			   ResultSet rs = s.getResultSet ();
			   int count = 0;																	// use 'count' to record how many results you get
			   while (rs.next ())
			   {
			       int uinVal = rs.getInt ("UIN");
			       String courseIDVal = rs.getString ("CourseID");
			       double scoreVal = rs.getDouble ("Score");
			       str = str + 
			               "UIN = " + uinVal 
			               + ", CourseID = " + courseIDVal
			               + ", Score = " + scoreVal + "\n";
			       ++count;																		
			   }
			   rs.close ();
			   s.close ();
			}
			catch (SQLException e1) {
			System.err.println ("Wrong");
		}
			textArea.setText("");									// Set textarea as empty before every new query
		   textArea.append(str);								// Show results in textarea
		}
		if(e.getSource().equals(jb2)){					// The code for jb1 to jb5 are similiar. Get query, exec query, and return result
			String str = new String(""); 					// You can get good students for every different department
			try{
				Statement s = conn.createStatement ();
				   s.executeQuery ("select * from (select * from studyof where (CourseID = 'CSCE01')) as s1 where Score >= all(select Score from (select * from studyof where (CourseID = 'CSCE01')) as s1)");
				   ResultSet rs = s.getResultSet ();
				   int count = 0;
				   while (rs.next ())
				   {
				       int uinVal = rs.getInt ("UIN");
				       String courseIDVal = rs.getString ("CourseID");
				       double scoreVal = rs.getDouble ("Score");
				       str = str + 
				               "UIN = " + uinVal 
				               + ", CourseID = " + courseIDVal
				               + ", Score = " + scoreVal + "\n";
				       ++count;
				   }
				   rs.close ();
				   s.close ();
			}
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");
		   textArea.append(str);
			
		}
		if(e.getSource().equals(jb3)){
			String str = new String(""); 
			try{
				Statement s = conn.createStatement ();
				   s.executeQuery ("select * from (select * from studyof where (CourseID = 'CE01')) as s1 where Score >= all(select Score from (select * from studyof where (CourseID = 'CE01')) as s1)");
				   ResultSet rs = s.getResultSet ();
				   int count = 0;
				   while (rs.next ())
				   {
				       int uinVal = rs.getInt ("UIN");
				       String courseIDVal = rs.getString ("CourseID");
				       double scoreVal = rs.getDouble ("Score");
				       str = str + 
				               "UIN = " + uinVal 
				               + ", CourseID = " + courseIDVal
				               + ", Score = " + scoreVal + "\n";
				       ++count;
				   }
				   rs.close ();
				   s.close ();
			}
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");
		   textArea.append(str);
		}
		if(e.getSource().equals(jb4)){
			String str = new String(""); 
			try{
				Statement s = conn.createStatement ();
				   s.executeQuery ("select * from (select * from studyof where (CourseID = 'ChE01')) as s1 where Score >= all(select Score from (select * from studyof where (CourseID = 'ChE01')) as s1)");
				   ResultSet rs = s.getResultSet ();
				   int count = 0;
				   while (rs.next ())
				   {
				       int uinVal = rs.getInt ("UIN");
				       String courseIDVal = rs.getString ("CourseID");
				       double scoreVal = rs.getDouble ("Score");
				       str = str + 
				               "UIN = " + uinVal 
				               + ", CourseID = " + courseIDVal
				               + ", Score = " + scoreVal + "\n";
				       ++count;
				   }
				   rs.close ();
				   s.close ();
			}
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");
		   textArea.append(str);
		}
		if(e.getSource().equals(jb5)){
			String str = new String(""); 
			try{
				Statement s = conn.createStatement ();
				   s.executeQuery ("select * from (select * from studyof where (CourseID = 'MBS01')) as s1 where Score >= all(select Score from (select * from studyof where (CourseID = 'MBS01')) as s1)");
				   ResultSet rs = s.getResultSet ();
				   int count = 0;
				   while (rs.next ())
				   {
				       int uinVal = rs.getInt ("UIN");
				       String courseIDVal = rs.getString ("CourseID");
				       double scoreVal = rs.getDouble ("Score");
				       str = str + 
				               "UIN = " + uinVal 
				               + ", CourseID = " + courseIDVal
				               + ", Score = " + scoreVal + "\n";
				       ++count;
				   }
				   rs.close ();
				   s.close ();
			}
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");
		   textArea.append(str);
		}
		if(e.getSource().equals(jb6)){					// Click the close, the user interface will close
			this.dispose();
		}
	}
}
