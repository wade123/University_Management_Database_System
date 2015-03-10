package databasePJ4;

import java.awt.*;									// import packages, including awt, swing, sql
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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class JFLargeClub extends JFrame implements ActionListener{

	private JPanel contentPane;									// Build up the user interface
	JButton btnNewButton = new JButton("Close");

	/**
	 * Create the frame.
	 */
	public JFLargeClub(Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Large Club Page");
		lblNewLabel.setBounds(115, 22, 230, 33);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 78, 400, 92);
		contentPane.add(textArea);
		
		btnNewButton.setBounds(170, 203, 117, 29);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		String str = new String(""); 
		Statement s;											// Create the SQL query and exec it
		try {
			s = conn.createStatement ();
		   s.executeQuery ("select Name,Capacity from club where Capacity >= ALL(select Capacity from club)");
		   ResultSet rs = s.getResultSet ();
		   int count = 0;
		   
		   while (rs.next ())									// get the result
		   {
		       String nameVal = rs.getString ("Name");
		       String capacityVal = rs.getString ("Capacity");
			   
		       str = str + 
		               "Name = " + nameVal
		               + ", Capacity = " + capacityVal + "\n";
		       ++count;
		   }
		   rs.close ();
		   s.close ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println ("Wrong");
		}
			textArea.setText("");						// set textarea as empty before every query
		   textArea.append(str);					// show the result
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnNewButton))
			this.dispose();								// Click the button to close
	}
}
