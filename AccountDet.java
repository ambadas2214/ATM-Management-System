package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class AccountDet extends JFrame implements ActionListener
{ 
		Container cp;
		JLabel lblFn,lblLn,lblAge,lblAcc,lblF,lblM,lblD,lblPass,lblGen,lblwel,lblsy,lblsec;
		JPasswordField txtPass;
		JTextField txtFn,txtLn,txtAge,txtAcc,txtM,txtD,txtGen;
		JButton btnRegi,btnback;
		JRadioButton rbtnF,rbtnM;
		ButtonGroup bgrp;
		
		public AccountDet(String t)
		{
			super(t);
			cp=getContentPane();
			cp.setLayout(null);
			cp.setBackground(Color.lightGray);
			Font f=new Font("Courier",Font.BOLD,16);
			
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
			
				lblsec=new JLabel("**Account Detailes Section**");
				lblsec.setBounds(10, 120, 200, 25);
				lblsec.setForeground(Color.magenta);
	 			cp.add(lblsec);
				
			
			lblAcc=new JLabel("Account No:-");
			lblAcc.setBounds( 20, 160, 80, 50);
			cp.add(lblAcc);
			
			txtAcc=new JTextField();
			txtAcc.setBounds( 95, 175, 250, 25);
			cp.add(txtAcc); 
		 
			btnRegi=new JButton("Generate Detailes");
			btnRegi.setForeground(Color.white);
			btnRegi.setBackground(Color.blue);
			btnRegi.setFont(f);
			btnRegi.setBounds(40, 250, 180, 25);
			cp.add(btnRegi); 
			btnRegi.addActionListener(this);
			
			btnback=new JButton("BAck");
			btnback.setBounds(260, 250, 80, 25);
			cp.add(btnback);
			btnback.addActionListener(this);
		     setSize(450,400);
		     setVisible(true);
				 
		}

		public static void main(String[] args)
		{
	    new AccountDet("Account Detailes");
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				BankDao dao=new BankDao();

			if(e.getSource()==btnback)
		 	   {
		    	newWindow frame=new newWindow("BANK OF INDIA");
 		 			this.dispose();
		 	   }
			
			else if(e.getSource()==btnRegi)
			{
 			   int id=Integer.parseInt(txtAcc.getText());
	 			BankPojo eobj=dao.Search(id);
	 			if(eobj!=null)
	 				JOptionPane.showMessageDialog(this, "Account Detailes \n"+eobj);	
				else
	 				JOptionPane.showMessageDialog(this, "Record not found");	
			}

			    }  catch (ClassNotFoundException | SQLException e1) 
					{
 					e1.printStackTrace();
					}
				
			}
}
