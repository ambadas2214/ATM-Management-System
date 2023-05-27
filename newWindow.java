package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class newWindow extends JFrame implements ActionListener
{
	Container cp;
	JButton btnWit,btnDep,btnCheck,btnAcc,btnLog,btnpin;
	JLabel lblB,lblwel,lblsy;
	 public newWindow(String t)
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
			
			lblwel=new JLabel("Welcome To Online ATM  Management System");
			lblwel.setForeground(Color.darkGray);
			lblwel.setBounds(90, 120, 270, 25);
			cp.add(lblwel);
			
		 btnAcc=new JButton("< ACCOUNT DETAILES >");
		 btnAcc.setBounds( 05, 170, 180, 35);
		 btnAcc.addActionListener( this);
		 
		 btnWit=new JButton("< WITHDRAW >");
		 btnWit.setBounds( 250, 170, 180, 35);
		 btnWit.addActionListener(this);
		 
		 btnCheck=new JButton("CHECK BALANCE");
		 btnCheck.setBounds( 05, 230, 180, 35);
		 btnCheck.addActionListener(this);
		 cp.add(btnCheck);
		 
		 btnpin=new JButton("< PIN GENERATE >");
		 btnpin.setBounds( 250, 290, 180, 35);
		 btnpin.addActionListener(this);
		 cp.add(btnpin);
		 
		 btnDep=new JButton("< DEPOSITE >");
		 btnDep.setBounds( 250, 230, 180, 35);
		 btnDep.addActionListener(this);
		
		 btnLog=new JButton("< LOGOUT >");
		 btnLog.setBounds( 05, 290, 180, 35);
		 btnLog.addActionListener(this);
		 cp.add(btnAcc);
		 cp.add(btnWit);
		 cp.add(btnDep);
 		 cp.add(btnLog);
		 
		 setSize(450,400);
		 setVisible(true);
		 
	 }

	public static void main(String[] args) 
	{
		new newWindow("ATM Management System");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?bank","root","Ambadas@1999");
			PreparedStatement pt;
			BankDao dao =new BankDao();
			AccountDet ac=new AccountDet("ATMS");

		if(e.getSource()==btnAcc)
		{
			AccountDet frame=new AccountDet("ATM");
			this.dispose();
				}
 
		else if(e.getSource()==btnWit)
		{
			Withdraw frame= new Withdraw("ATM");
 			this.dispose();
		}
		else if(e.getSource()==btnDep)
		{
		 Deposite frame=new Deposite("ATM");
 		this.dispose();

		}
		else if(e.getSource()==btnLog)
		{
			 Login frame=new Login("ATM");
 				this.dispose();
		}
		else if(e.getSource()==btnpin)
		{
			 PinGenerate frame=new PinGenerate("ATM");
 				this.dispose();
		}
		else if(e.getSource()==btnCheck)
		{
			CheckBal frame=new CheckBal("ATM");
			this.dispose();
		}
		}
		catch (ClassNotFoundException | SQLException e1) {
 			e1.printStackTrace();
		}
 		
	}

}
