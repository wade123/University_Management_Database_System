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
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class JFUpdate extends JFrame implements ActionListener{

	private JPanel contentPane;// This part is to build the main view
	JButton jbRun = new JButton("Run");
	JButton jbClose = new JButton("Close");
	JTextArea textArea = new JTextArea();		// use textarea to get the command from user
	JTextArea textArea_1 = new JTextArea();		// use textarea_1 to show that whether the command is executed successfully
	ArrayList <String> al=new ArrayList<String>();
	public Connection conn;
	
	public JFUpdate(Connection conn1) {
		conn = conn1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Update Page");
		lblNewLabel.setBounds(132, 20, 200, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Entry Your Update Command:");
		lblNewLabel_1.setBounds(10, 58, 300, 16);
		contentPane.add(lblNewLabel_1);
		
		textArea.setBounds(16, 84, 334, 45);
		contentPane.add(textArea);
		
		jbRun.setBounds(373, 94, 70, 29);
		jbRun.addActionListener(this);
		contentPane.add(jbRun);
		
		JLabel lblNewLabel_2 = new JLabel("Your Result:");
		lblNewLabel_2.setBounds(16, 151, 102, 16);
		contentPane.add(lblNewLabel_2);
		
		textArea_1.setBounds(16, 179, 334, 44);
		contentPane.add(textArea_1);
		
		jbClose.setBounds(170, 245, 117, 29);
		jbClose.addActionListener(this);
		contentPane.add(jbClose);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(jbRun)){
			String sql_string =textArea.getText();		// get user's command to update/delete/create/insert
			String str = new String("");
					try
			        {
			            Statement s = conn.createStatement ();
			            int count;
			            count = s.executeUpdate (sql_string);			// if the command is executed successfully, return successed, otherwise return failed
			            str =  " Update Seccessed";
			        }
			        catch (Exception e1) {str =  " Update Failed";}
					textArea_1.setText("");		// set the textarea as empty
					textArea_1.append(str);		// show result

		}
		if (e.getSource().equals(jbClose)){
			this.dispose();		// close window
		}	
	}

}
