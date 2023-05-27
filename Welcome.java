package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener 
{
	Container cp;
	JLabel lblwel,lblsy;
	JButton btnNext;
	
	public Welcome(String t)
	{
		cp=getContentPane();
		cp.setLayout(null);
		cp.setBackground(Color.lightGray);
		
		lblwel=new JLabel("ATM");
		lblwel.setBounds(110, 40, 300, 100);
		 Font f=new Font("Times New Roman",Font.BOLD,90);
		 lblwel.setFont(f);
		 lblwel.setForeground(Color.blue);
		 cp.add(lblwel);
		 
		 lblsy=new JLabel("Management System");
			lblsy.setBounds(110, 78, 350, 100);
			 Font f1=new Font("Times New Roman",Font.BOLD,24);
			 lblsy.setFont(f1);
			 lblsy.setForeground(Color.blue);
			 cp.add(lblsy);
		 
		 btnNext=new JButton("<<..Next..>>");
		 btnNext.setBounds(150, 220, 110, 35);
		 btnNext.addActionListener(this);
		 
 		 cp.add(btnNext);
		 
		 setSize(450,400);
		 setVisible(true); 
	}

	public static void main(String[] args) 
	{
       new Welcome ("Welcome"); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNext)
		{
			Login frame=new Login("ATM");
				this.dispose();
		}
	}

}
