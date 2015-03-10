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

public class JFWelcome extends JFrame implements ActionListener{

	private JPanel contentPane;		// This part is to build the main view

	JButton jbConn = new JButton("Connect SQL");		// seven buttons. Five buttons for exec queries or modifications, one button to connect SQL, one button to close the window
	JButton jb1 = new JButton("Update");
	JButton jb2 = new JButton("Large Club");
	JButton jb3 = new JButton("Good Stu.");
	JButton jb4 = new JButton("Prof Names");
	JButton jb5 = new JButton("Interests");
	JButton jb6 = new JButton("Close");
	/**
	 * Launch the application.
	 */
	public Connection conn = null;
	public login loginConn = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFWelcome frame = new JFWelcome();
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
	public JFWelcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		jb4.setBounds(19, 138, 131, 36);
		jb4.addActionListener(this);
		contentPane.add(jb4);
		
		jb5.setBounds(162, 138, 131, 36);
		jb5.addActionListener(this);
		contentPane.add(jb5);
		
		jb6.setBounds(305, 138, 131, 36);
		jb6.addActionListener(this);
		contentPane.add(jb6);
		
		jbConn.setBounds(162, 206, 131, 36);
		jbConn.addActionListener(this);
		contentPane.add(jbConn);
		
		JLabel lblNewLabel = new JLabel("Welcome to University Management System");
		lblNewLabel.setBounds(95, 21, 350, 34);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		// actions for listeners
		// TODO Auto-generated method stub
		if(e.getSource().equals(jbConn)){
			 loginConn = new login();
			if(conn != null)   System.out.println ( " rows were retrieved");
		}
		
		if(e.getSource().equals(jb1)){
			conn  = loginConn.getConnection();
		  new  JFUpdate(conn);
		}
		if(e.getSource().equals(jb2)){
			conn  = loginConn.getConnection();
			new JFLargeClub(conn);
		}
		if(e.getSource().equals(jb3)){
			conn  = loginConn.getConnection();
			new JFGoodStudent(conn);
		}
		if(e.getSource().equals(jb4)){
			conn  = loginConn.getConnection();
			new JFProfName(conn);
		}
		if(e.getSource().equals(jb5)){
			conn  = loginConn.getConnection();
			new JFProfInterests(conn);
		}
		if(e.getSource().equals(jb6)){
			this.dispose();
		}
	}
}
