package project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login extends JFrame implements ActionListener
{
	Container cp;
	JLabel lblUser,lblPass,lblwel,lblsy;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogin,btnReset,btnRegi;
	
	
	public Login(String t)
	{
		super(t);
		cp=getContentPane();
		cp.setLayout(null);
		Font f=new Font("Times New Roman",Font.BOLD,18);
		cp.setBackground(Color.lightGray);

		lblwel=new JLabel("ATM");
		lblwel.setBounds(110, 10, 300, 100);
		 Font f3=new Font("Times New Roman",Font.BOLD,90);
		 lblwel.setFont(f3);
		 lblwel.setForeground(Color.blue);
		 cp.add(lblwel);
		 
		 lblsy=new JLabel("Management System");
			lblsy.setBounds(110, 48, 350, 100);
			 Font f1=new Font("Times New Roman",Font.BOLD,24);
			 lblsy.setFont(f1);
			 lblsy.setForeground(Color.blue);
			 cp.add(lblsy);
		
		lblUser=new JLabel("Account.No");
		lblUser.setBounds( 70, 130, 100, 30);
		lblUser.setFont(f);
 		txtUser=new JTextField();
		txtUser.setBounds( 170, 130, 180, 30);
		cp.add(lblUser);
		cp.add( txtUser);
		
		lblPass=new JLabel("Password");
		lblPass.setBounds( 70, 190, 100, 30);
		lblPass.setFont(f);
		txtPass=new JPasswordField();
		txtPass.setBounds( 170, 190, 180, 30);
		cp.add( lblPass);
		cp.add( txtPass);
		
		btnLogin=new JButton("Login");
		btnLogin.setBounds( 70, 280, 80, 30);
		btnLogin.setForeground(Color.white);
		btnLogin.setBackground(Color.blue);
		btnLogin.setFont(f);
		btnLogin.addActionListener( this);
		btnReset=new JButton("Reset");
		btnReset.setBounds( 170, 280, 80, 30);
		btnReset.addActionListener( this);
		btnRegi=new JButton("Register");
		btnRegi.setBounds( 270, 280, 100, 30);
		btnRegi.setForeground(Color.white);
		btnRegi.setBackground(Color.orange);
		btnRegi.setFont(f);
		btnRegi.addActionListener( this);
		cp.add(btnLogin);
		cp.add(btnReset);
		cp.add(btnRegi);
		
		setSize(450,400);
		setVisible(true);	
	}

	public static void main(String[] args)
	{
		new Login("Mini Project:- ATM Machine");
 
	}
	 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try {

			String url="jdbc:mysql://localhost:3306/bank",
					user="root",Pass="Ambadas@1999";
			PreparedStatement pt;
			Connection con=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,user,Pass);
		if(e.getSource()==btnLogin)
		{
			 
	 	     int accNo=Integer.parseInt(txtUser.getText());

				pt=con.prepareStatement("select * from register where Account_no=? and Password=?");
				pt.setInt(1, accNo);
				pt.setString(2, txtPass.getText());
				
				ResultSet rs=pt.executeQuery();
				if(rs.next())
				{
			    	newWindow frame=new newWindow("ATM");
			    	this.dispose();
				}
			else
			{
				JOptionPane.showMessageDialog(this, "Invalid ");
			}
		}
		 
		else if(e.getSource()==btnReset)
		{
			txtUser.setText("");
			txtPass.setText("");
		}
		else if(e.getSource()==btnRegi)
		{
			Register frame=new Register("BOI");
			this.dispose();
		}
		} catch (ClassNotFoundException | SQLException e1) {
 			e1.printStackTrace();
		}
	}}	

