package databasePJ4;

import java.awt.*;			// import packages, including awt, swing, sql
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFProfInterests extends JFrame implements ActionListener{

	private JPanel contentPane;		// Build up the user interface
	JButton jb1 = new JButton("ECEN");		// Each button represents an department
	JButton jb2 = new JButton("CSCE"); 
	JButton jb3 = new JButton("CE");
	JButton jb4 = new JButton("ChE");
	JButton jb5 = new JButton("MBS");
	JButton jb6 = new JButton("Close");
	JScrollPane jsp;
	public Connection conn;
	JTextArea textArea = new JTextArea();
	
	public JFProfInterests(Connection conn1) {
		conn = conn1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
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
		
		JLabel lblNewLabel = new JLabel("Welcome to Professors Interests Page");
		lblNewLabel.setBounds(50, 24, 300, 34);
		contentPane.add(lblNewLabel);
		textArea.setBounds(80, 166, 278, 122);
		contentPane.add(textArea);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		// The action about the listener
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)){
			String str = new String(""); 
			String dep = " \'ECEN\' ";
			try{
			Statement s = conn.createStatement ();		// Exec the SQL statement and return the result
            Statement p = conn.createStatement ();
            
            p.executeUpdate ("create view Department_Prof as select * from facultyof"
                             + " where Department = " + dep);
            
            s.executeQuery ("select DISTINCT Interest from professor, Department_Prof"
                             + " where Prof_UIN = UIN");
                             
            ResultSet rs = s.getResultSet ();
                             
            while (rs.next())
            {
                 String Interest = rs.getString("Interest");
                 str =  str + "  *  ResearchArea " + Interest + "\n";
                 //System.out.println("  *  " + ResearchArea);
            }

            p.executeUpdate ("drop view Department_Prof");
            rs.close();
            s.close();
            p.close();
		}
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");
		   textArea.append(str);
		   
		}
		if(e.getSource().equals(jb2)){  // the code for jb2 to jb5 is similiar with jb1, but represents for different department
			String str = new String(""); 
			String dep = " \'CSCE\' ";
			try{
			Statement s = conn.createStatement ();
            Statement p = conn.createStatement ();
            
            p.executeUpdate ("create view Department_Prof as select * from facultyof"
                             + " where Department = " + dep);
            
            s.executeQuery ("select DISTINCT Interest from professor, Department_Prof"
                             + " where Prof_UIN = UIN");
                             
            ResultSet rs = s.getResultSet ();
                             
            while (rs.next())
            {
                 String Interest = rs.getString("Interest");
                 str =  str + "  *  ResearchArea " + Interest + "\n";
                 //System.out.println("  *  " + ResearchArea);
            }

            p.executeUpdate ("drop view Department_Prof");
            rs.close();
            s.close();
            p.close();
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
			String dep = " \'CE\' ";
			try{
			Statement s = conn.createStatement ();
            Statement p = conn.createStatement ();
            
            p.executeUpdate ("create view Department_Prof as select * from facultyof"
                             + " where Department = " + dep);
            
            s.executeQuery ("select DISTINCT Interest from professor, Department_Prof"
                             + " where Prof_UIN = UIN");
                             
            ResultSet rs = s.getResultSet ();
                             
            while (rs.next())
            {
                 String Interest = rs.getString("Interest");
                 str =  str + "  *  ResearchArea " + Interest + "\n";
                 //System.out.println("  *  " + ResearchArea);
            }

            p.executeUpdate ("drop view Department_Prof");
            rs.close();
            s.close();
            p.close();
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
			String dep = " \'ChE\' ";
			try{
			Statement s = conn.createStatement ();
            Statement p = conn.createStatement ();
            
            p.executeUpdate ("create view Department_Prof as select * from facultyof"
                             + " where Department = " + dep);
            
            s.executeQuery ("select DISTINCT Interest from professor, Department_Prof"
                             + " where Prof_UIN = UIN");
                             
            ResultSet rs = s.getResultSet ();
                             
            while (rs.next())
            {
                 String Interest = rs.getString("Interest");
                 str =  str + "  *  ResearchArea " + Interest + "\n";
                 //System.out.println("  *  " + ResearchArea);
            }

            p.executeUpdate ("drop view Department_Prof");
            rs.close();
            s.close();
            p.close();
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
			String dep = " \'MBS\' ";
			try{
			Statement s = conn.createStatement ();
            Statement p = conn.createStatement ();
            
            p.executeUpdate ("create view Department_Prof as select * from facultyof"
                             + " where Department = " + dep);
            
            s.executeQuery ("select DISTINCT Interest from professor, Department_Prof"
                             + " where Prof_UIN = UIN");
                             
            ResultSet rs = s.getResultSet ();
                             
            while (rs.next())
            {
                 String Interest = rs.getString("Interest");
                 str =  str + "  *  ResearchArea " + Interest + "\n";
                 //System.out.println("  *  " + ResearchArea);
            }

            p.executeUpdate ("drop view Department_Prof");
            rs.close();
            s.close();
            p.close();
		}
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");		// set textarea as empty before every query
		   textArea.append(str);	// show the result
		}
		if(e.getSource().equals(jb6)){
			this.dispose();					// close the window
		}
	}
}
