package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class PinGenerate extends JFrame implements ActionListener
{
	Container cp;
	JButton btnBack,btnGen;
	JLabel lblwel,lblsy,lblpin,lblAcc,lblsec;
	JTextField txtpin,txtAcc,txtpin1;
  
		 public PinGenerate(String t)
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
				
				 
				
				lblsec=new JLabel("**Pin Generate Section**");
				lblsec.setBounds(10, 120, 200, 25);
				lblsec.setForeground(Color.magenta);
	 			cp.add(lblsec);
				

				lblAcc=new JLabel("Account No:-");
				lblAcc.setBounds( 20, 150, 80, 50);
				cp.add(lblAcc);
				
				txtAcc=new JTextField();
				txtAcc.setBounds( 135, 165, 250, 25);
				cp.add(txtAcc); 
				
				lblpin=new JLabel("Set New Password:-");
				lblpin.setBounds(20, 190, 150, 50);
				cp.add(lblpin);
				
				txtpin=new JTextField();
				txtpin.setBounds( 135, 205, 250, 25);
				cp.add(txtpin);
				
				
				 btnGen=new JButton("Generate Pin");
				 btnGen.setBounds( 80, 300, 120, 25);
				 btnGen.addActionListener(this);
				 btnGen.setBackground(Color.blue);
				 btnGen.setForeground(Color.white);
				 cp.add(btnGen);
				
			 btnBack=new JButton("Back");
			 btnBack.setBounds( 240, 300, 90, 25);
			 btnBack.addActionListener(this);
			 cp.add(btnBack);
 			 
			 setSize(450,400);
			 setVisible(true);
			 
		 }
		 

		public static void main(String[] args)
		{
	    new PinGenerate("ATM");
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				BankDao dao=new BankDao();

			if(e.getSource()==btnBack)
		 	   {
		    	newWindow frame=new newWindow("AMT");
 		 			this.dispose();
		 	   }
			
			else if(e.getSource()==btnGen)
			{
				 int id=Integer.parseInt(txtAcc.getText());
				  BankPojo eobj=new BankPojo();
				    eobj.setAccNo(id);
				    eobj.setPass(txtpin.getText());
	 	
				    boolean res=dao.UpdatePin(eobj);
				    if(res)
		 				JOptionPane.showMessageDialog(this, "Generate Successfully");	
					else
		 				JOptionPane.showMessageDialog(this, "Invalid Account Number");	
	 	   }

				 
			
			    }  catch (ClassNotFoundException | SQLException e1) {
 					e1.printStackTrace();
			    }
				
			}
}
