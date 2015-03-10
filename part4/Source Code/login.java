 package databasePJ4;
 
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JPasswordField;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String username;
	public static String password;
	public Connection conn = null;  //  maintain the connection to the database

	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(138, 60, 207, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username=textField.getText();
				char[] temp=passwordField.getPassword();
				password=new String(temp);
				String url = "jdbc:mysql://localhost/project";  // the address of the local database; project is the database we create on our computer
				connect(url, username,password);                 // call the function to connect to the database
				
			}
		});
		btnConfirm.setBounds(89, 185, 89, 30);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(256, 185, 89, 30);
		contentPane.add(btnCancel);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(30, 62, 80, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(30, 122,80, 22);
		contentPane.add(lblPassword);
		
		JLabel lblWelcomToUniversity = new JLabel("Welcom to University Management System");
		lblWelcomToUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcomToUniversity.setBounds(40, 11, 400, 22);
		contentPane.add(lblWelcomToUniversity);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 120, 207, 30);
		contentPane.add(passwordField);
		
		
		this.setTitle("System Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setResizable(false);
	}
	
	public void connect(String url, String username, String password ) // the function to connect to the local database
	{
		  try
          {
			  Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			  conn = DriverManager.getConnection (url, username, password);
			  System.out.println ("Database connection established");
          }
		  catch (Exception e)
          {
              System.err.println ("Cannot connect to database server");//if some thing wrong happens with the connection, it will print "Cannot connect to database server"
          }
	}
	
	public Connection getConnection()  //obtain the connection to the local  database
	{
		return conn;
		
	}
}
