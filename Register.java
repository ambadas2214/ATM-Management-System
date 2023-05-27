package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Register extends JFrame implements ActionListener
{
	Container cp;
	JLabel lblFn,lblLn,lblAge,lblAcc,lblWel,lblF,lblM,lblD,lblPass,lblBal;
	JPasswordField txtPass;
	JTextField txtFn,txtLn,txtAge,txtAcc,txtM,txtD,txtBal;
	JButton btnRegi,btnback;
	JRadioButton rbtnF,rbtnM;
	ButtonGroup bgrp;
	
	public Register(String t)
	{
		super(t);
		cp=getContentPane();
		cp.setLayout(null);
		cp.setBackground(Color.lightGray);
		
		lblWel=new JLabel("Welcome To ATM Management System");
		Font f=new Font("Courier",Font.BOLD,16);
		lblWel.setFont(f);
		lblWel.setForeground(Color.blue);
		lblWel.setBounds( 60, 0, 330, 50);
		cp.add(lblWel);
		
		lblF=new JLabel("Fill the all detailes Compulsary");
		lblF.setBounds( 20, 40, 250, 50);
		cp.add(lblF);
		
		lblFn=new JLabel("First Name");
		lblFn.setBounds( 20, 70, 120, 50);
		cp.add(lblFn);
		
		
		txtFn=new JTextField();
		txtFn.setBounds( 95, 85, 110, 25);
		cp.add(txtFn);
		
		lblLn=new JLabel("Last Name");
		lblLn.setBounds( 210, 70, 120, 50);
		cp.add(lblLn);
		
		txtLn=new JTextField();
		txtLn.setBounds( 270, 85, 110, 25);
		cp.add(txtLn);
		
		lblM=new JLabel("Mobile No.");
		lblM.setBounds( 20, 105, 110, 50);
		cp.add(lblM);
		
		txtM=new JTextField();
		txtM.setBounds( 95, 120, 250, 25);
		cp.add(txtM);
		
		lblD=new JLabel("DOB");
		lblD.setBounds( 20, 135, 120, 50);
		cp.add(lblD);
		
		txtD=new JTextField();
		txtD.setBounds( 95, 150, 80, 25);
		cp.add(txtD);
		
		rbtnM=new JRadioButton("Male");
        rbtnM.setBounds( 190,150,60, 30);
		rbtnF=new JRadioButton("Female");
		rbtnF.setBounds( 265, 150, 80, 30);
		cp.add(rbtnM);
		cp.add(rbtnF);
		
		bgrp=new ButtonGroup();
		bgrp.add( rbtnM);
		bgrp.add(rbtnF);
		
		lblAcc=new JLabel("Account No");
		lblAcc.setBounds( 20, 170, 80, 50);
		cp.add(lblAcc);
		
		txtAcc=new JTextField();
		txtAcc.setBounds( 95, 185, 250, 25);
		cp.add(txtAcc);
		

		lblBal=new JLabel("Balance");
		lblBal.setBounds(20, 205, 180, 50);
		cp.add(lblBal);
		
		txtBal=new JTextField();
		txtBal.setBounds( 95, 220, 170, 25);
		cp.add(txtBal);
		
		lblPass=new JLabel("Create Password");
		lblPass.setBounds( 20, 240, 180, 50);
		cp.add(lblPass);
		
		txtPass=new JPasswordField();
		txtPass.setBounds( 130, 255, 170, 25);
		cp.add(txtPass);
		 
		btnRegi=new JButton("Register...");
		btnRegi.setForeground(Color.white);
		btnRegi.setBackground(Color.orange);
		btnRegi.setFont(f);
		btnRegi.setBounds(80, 295, 115, 25);
		cp.add(btnRegi); 
		btnRegi.addActionListener(this);
		
		btnback=new JButton("BAck");
		btnback.setBounds(220, 295, 80, 25);
		cp.add(btnback);
		btnback.addActionListener(this);
		
	     setSize(450,400);
	     setVisible(true);
			 
	}

	public static void main(String[] args)
	{
    new Register("BIO");
	}
	@SuppressWarnings("deprecation")
	@Override
 	public void actionPerformed(ActionEvent e)
 	{
		try {
			BankDao dao =new BankDao();
			if(e.getSource()==btnRegi)
	 		{
  	 			 int accNo=Integer.parseInt(txtAcc.getText());
  	 			 double bal1=Double.parseDouble(txtBal.getText());
	 			BankPojo bobj=new BankPojo();
	 			bobj.setfName(txtFn.getText());
	 			bobj.setlName(txtLn.getText());
	 			bobj.setMobile_No(txtM.getText());
	 			bobj.setDOB(txtD.getText());
	 			bobj.setOpGender(rbtnM.getText());
 	 			bobj.setAccNo(accNo);
	 			bobj.setPass(txtPass.getText());
	 			bobj.setBal(bal1);

	 			boolean res;
			    res = dao.insertBank(bobj);
			    if(res)
					JOptionPane.showMessageDialog(this, "Register Successfully");
	 		}
			else if(e.getSource()==btnback)
		 	   {
				Login frame=new Login("ATM");
 		 			this.dispose();
		 	   }
		}
		catch (  SQLException | ClassNotFoundException e1) {
 			e1.printStackTrace();
		}  
 		
			
	}

}
