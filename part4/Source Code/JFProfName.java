package databasePJ4;

import java.awt.*;					// import packages, including awt, swing, sql
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

public class JFProfName extends JFrame implements ActionListener{

	private JPanel contentPane;		// This part is to build the main view
	JButton jb1 = new JButton("ECEN");		// Each button represents an department
	JButton jb2 = new JButton("CSCE");
	JButton jb3 = new JButton("CE");
	JButton jb4 = new JButton("ChE");
	JButton jb5 = new JButton("MBS");
	JButton jb6 = new JButton("Close");
	public Connection conn;
	JTextArea textArea = new JTextArea();
	public JFProfName(Connection conn1) {
		conn = conn1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
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
		
		JLabel lblNewLabel = new JLabel("Welcome to Professors Names Page");
		lblNewLabel.setBounds(50, 17, 300, 34);
		contentPane.add(lblNewLabel);
		textArea.setBounds(20, 177, 400, 200);
		
		contentPane.add(textArea);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)){
			String str = new String(""); 
			String dep ="\'ECEN\'";
                try{
                	Statement s = conn.createStatement ();			//  reate query sql and exec it 
                	s.executeQuery ("select UIN, Name from professor where UIN IN (select Prof_UIN as UIN from facultyof where Department = "+dep+")");
                	ResultSet rs = s.getResultSet ();
                while (rs.next())										// get result
                {			
                     int CochairUIN = rs.getInt("UIN");
                     String Name = rs.getString("Name");
                     str =  str+ "UIN = " + CochairUIN+ ", names = " + Name + "\n";
                }
                rs.close();
                s.close();
            }
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println ("Wrong");
			}
             textArea.setText("");
			textArea.append(str);
		}
		if(e.getSource().equals(jb2)){
			String str = new String(""); 
			String dep ="\'CSCE\'";
                try{
                	Statement s = conn.createStatement ();
                	s.executeQuery ("select UIN, Name from professor where UIN IN (select Prof_UIN as UIN from facultyof where Department = "+dep+")");
                ResultSet rs = s.getResultSet ();
                while (rs.next())
                {
                     int CochairUIN = rs.getInt("UIN");
                     String Name = rs.getString("Name");
                     str =  str+ "UIN = " + CochairUIN+ ", names = " + Name + "\n";
                }
                rs.close();
                s.close();
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
			String dep ="\'CE\'";
                try{
                	Statement s = conn.createStatement ();
                	s.executeQuery ("select UIN, Name from professor where UIN IN (select Prof_UIN as UIN from facultyof where Department = "+dep+")");
                ResultSet rs = s.getResultSet ();
                while (rs.next())
                {
                     int CochairUIN = rs.getInt("UIN");
                     String Name = rs.getString("Name");
                     str =  str+ "UIN = " + CochairUIN+ ", names = " + Name + "\n";
                }
                rs.close();
                s.close();
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
			String dep ="\'ChE\'";
                try{
                	Statement s = conn.createStatement ();
                	s.executeQuery ("select UIN, Name from professor where UIN IN (select Prof_UIN as UIN from facultyof where Department = "+dep+")");
                	ResultSet rs = s.getResultSet ();
                while (rs.next())
                {
                     int CochairUIN = rs.getInt("UIN");
                     String Name = rs.getString("Name");
                     str =  str+ "UIN = " + CochairUIN+ ", names = " + Name + "\n";
                }
                rs.close();
                s.close();
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
			String dep ="\'MBS\'";
                try{
                	Statement s = conn.createStatement ();
                	s.executeQuery ("select UIN, Name from professor where UIN IN (select Prof_UIN as UIN from facultyof where Department = "+dep+")");
                	ResultSet rs = s.getResultSet ();
                while (rs.next())
                {
                     int CochairUIN = rs.getInt("UIN");
                     String Name = rs.getString("Name");
                     str =  str+ "UIN = " + CochairUIN+ ", names = " + Name + "\n";
                }
                rs.close();
                s.close();
            }
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println ("Wrong");
			}
            textArea.setText("");		// set textarea as empty before every new query
			textArea.append(str);					// show result
		}		
		if(e.getSource().equals(jb6)){
			this.dispose();		// close window
		}
	}
}
