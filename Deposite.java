package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Deposite extends JFrame implements ActionListener
{
	Container cp;
	JButton btnBack,btnDep;
	JLabel lblwel,lblsy,lblDep,lblsec,lblAcc;
	JTextField txtDep,txtAcc;
	 public Deposite(String t)
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
			
			 
			
			lblsec=new JLabel("**Deposite Section**");
			lblsec.setBounds(10, 120, 200, 25);
			lblsec.setForeground(Color.magenta);
			cp.add(lblsec);
			

			lblAcc=new JLabel("Account No:-");
			lblAcc.setBounds( 20, 150, 80, 50);
			cp.add(lblAcc);
			
			txtAcc=new JTextField();
			txtAcc.setBounds( 95, 165, 250, 25);
			cp.add(txtAcc); 
			
			lblDep=new JLabel("Enter Amount:-");
			lblDep.setBounds(20, 190, 150, 50);
			cp.add(lblDep);
			
			txtDep=new JTextField();
			txtDep.setBounds( 105, 205, 240, 25);
			cp.add(txtDep);
			
		 btnDep=new JButton("Deposite");
		 btnDep.setBounds( 95, 270, 120, 25);
		 btnDep.addActionListener(this);
		 cp.add(btnDep);
				
		 btnBack=new JButton("Back");
		 btnBack.setBounds( 225, 270, 80, 25);
		 btnBack.addActionListener(this);
		 cp.add(btnBack);
		 
		 
		 setSize(450,400);
		 setVisible(true);
		 
	 }

	public static void main(String[] args)
	{
		new Deposite("ATM");
	}
	 @Override
		public void actionPerformed(ActionEvent e)
	    {
		 try {
				BankDao	dao = new BankDao(); 
		  if(e.getSource()==btnDep)
		  {
			  int acc=Integer.parseInt(txtAcc.getText());
 	          double dep=Double.parseDouble( txtDep.getText());
			  BankPojo eobj=new BankPojo();
			  eobj.setAccNo(acc);
			  eobj.setBal(dep);
			
			  boolean ans=dao.UpdateDeposite(eobj);
			  if(ans)
	 				JOptionPane.showMessageDialog(this, "Deposite Successfully");	
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

}}
