package project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Withdraw extends JFrame implements ActionListener
{
	Container cp;
	JButton btnBack,btnWith;
	JLabel lblwel,lblsy,lblWith,lblAcc,lblsec;
	JTextField txtWith,txtAcc;
	 public Withdraw(String t)
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
			
			 
			
			lblsec=new JLabel("**Withdrwal Section**");
			lblsec.setBounds(10, 120, 200, 25);
			lblsec.setForeground(Color.magenta);
 			cp.add(lblsec);
			

			lblAcc=new JLabel("Account No:-");
			lblAcc.setBounds( 20, 150, 80, 50);
			cp.add(lblAcc);
			
			txtAcc=new JTextField();
			txtAcc.setBounds( 95, 165, 250, 25);
			cp.add(txtAcc); 
			
			lblWith=new JLabel("Enter Amount:-");
			lblWith.setBounds(20, 190, 150, 50);
			cp.add(lblWith);
			
			txtWith=new JTextField();
			txtWith.setBounds( 105, 205, 240, 25);
			cp.add(txtWith);
			
			 btnWith=new JButton("Withdraw");
			 btnWith.setBounds( 95, 280, 120, 25);
			 btnWith.addActionListener(this);
			 cp.add(btnWith);
			
		 btnBack=new JButton("Back");
		 btnBack.setBounds( 225, 280, 80, 25);
		 btnBack.addActionListener(this);
		 cp.add(btnBack);
 		 
		 setSize(450,400);
		 setVisible(true);
		 
	 }
	

	public static void main(String[] args)
	{
		new Withdraw("ATM");
	}
	 

	@Override
		public void actionPerformed(ActionEvent e)
	    {
		  try {
			  BankDao dao = new BankDao();
			  	if(e.getSource()==btnWith)    //w
		 		{
		 			int id=Integer.parseInt(txtAcc.getText());
		 			double sal=Double.parseDouble(txtWith.getText());
		 			BankPojo eobj=new BankPojo();
 		 			eobj.setBal(sal);
		 			eobj.setAccNo(id);
		 		

		 			boolean res = dao.Updatebank(eobj);
				if(res)
	 				JOptionPane.showMessageDialog(this, "Withdrawal Successfully");	
				else
	 				JOptionPane.showMessageDialog(this, "Record not found");	
		 		}
		 
		  	else if(e.getSource()==btnBack)
	 	   {
	 		  newWindow frame=new newWindow("ATM");
 	 			this.dispose();
	 	   }
		  } catch (ClassNotFoundException | SQLException e1) {
 				e1.printStackTrace();
		  } 
		}

}
