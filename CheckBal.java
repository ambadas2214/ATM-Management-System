package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class CheckBal extends JFrame implements ActionListener
{
	Container cp;
	JButton btnBack,btnCheck;
	JLabel lblwel,lblsy,lblWith,lblAcc,lblsec;
	JTextField txtAcc1;
	 public CheckBal(String t)
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
			
			 
			
			lblsec=new JLabel("**Check Balance Section**");
			lblsec.setBounds(10, 120, 200, 25);
			lblsec.setForeground(Color.magenta);
 			cp.add(lblsec);
			

			lblAcc=new JLabel("Account No:-");
			lblAcc.setBounds( 20, 150, 80, 50);
			cp.add(lblAcc);
			
			txtAcc1=new JTextField();
			txtAcc1.setBounds( 95, 165, 250, 25);
			cp.add(txtAcc1); 
			
		 
			btnCheck=new JButton("Check Balance");
			btnCheck.setBounds( 40, 280, 150, 25);
			btnCheck.addActionListener(this);
			btnCheck.setForeground(Color.white);
			btnCheck.setBackground(Color.blue);
			btnCheck.setFont(f);
			 cp.add(btnCheck);
			
			
		 btnBack=new JButton("Back");
		 btnBack.setBounds( 205, 280, 110, 25);
		 btnBack.addActionListener(this);
		 cp.add(btnBack);
		 
		 setSize(450,400);
		 setVisible(true);
		 
	 }
public static void main(String[] args)
	{
      new CheckBal("ATM");
      
	}
    @Override
	public void actionPerformed(ActionEvent e)
    {
    	try
    	{
    		BankDao dao=new BankDao();
 	   if(e.getSource()==btnBack)
 	   {
 		  newWindow frame=new newWindow("ATM");
  			this.dispose();
 	   }
 	   else if(e.getSource()==btnCheck)
 	   {
 		  int id=Integer.parseInt(txtAcc1.getText());
			double b=dao.SearchBal(id);
			if(b!=0)
				JOptionPane.showMessageDialog(this, "Available Balance \n"+b);	
			else
				JOptionPane.showMessageDialog(this, "Record not found");	
 	   }
    	}catch(ClassNotFoundException | SQLException e1 )
    	{
    	e1.printStackTrace();	
    	}
	}

}
