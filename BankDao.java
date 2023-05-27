package project;
import java.sql.*;


import javax.swing.JOptionPane;
public class BankDao 
{
		String url="jdbc:mysql://localhost:3306/bank",
				user="root",pass="Ambadas@1999";
		PreparedStatement pt;
		Connection con=null;
		
		
		public BankDao() throws ClassNotFoundException, SQLException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
		}
		public boolean insertBank (BankPojo e) throws SQLException  
		{
			pt=con.prepareStatement("Insert into register values(?,?,?,?,?,?,?,?)");
			
			pt.setString(1, e.getfName());
			pt.setString(2, e.getlName());
			pt.setString(3, e.getMobile_No());
			pt.setString(4, e.getDOB());			//register
			pt.setString(5, e.getOpGender());
			pt.setInt(6, e.getAccNo());
			pt.setString(7, e.getPass());
			pt.setDouble(8, e.getBal());

			int rows=pt.executeUpdate();
			if(rows>0)
				return true;
			else
				return false;
		}
		public boolean SelectBank (BankPojo e) throws SQLException
		{
			pt=con.prepareStatement("select * from register where Account_no=?,Password=?");
			pt.setInt(1, e.getAccNo());
			pt.setString(2, e.getPass());
			
			ResultSet rs=pt.executeQuery();		
			if(rs.next())
				return true;
			else
				return false;
		}
		public BankPojo Search(int id) throws SQLException
		{
 			pt=con.prepareStatement("select * from register where Account_no=?");
			pt.setInt(1,id);
			BankPojo p=null;
			
			ResultSet res=pt.executeQuery();    //AcountDetailes
			if(res.next())
			{
	          p=new BankPojo( res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getInt(6),res.getString(7),res.getDouble(8));
	         }
				return p;
		}
		public boolean Updatebank(BankPojo e) throws SQLException
		{
			pt=con.prepareStatement("update register set Avail_Balance=Avail_Balance-? where Account_no=?");
			pt.setDouble(1, e.getBal());
			pt.setInt(2, e.getAccNo());
			
			int rows=pt.executeUpdate();             //Deposit 
			if(rows>0)
				return true;
			else
				return false;
		}
		public boolean UpdateDeposite(BankPojo e) throws SQLException
		{			
 			pt=con.prepareStatement("update register set Avail_Balance=Avail_Balance+? where Account_no=?");
			pt.setDouble(1, e.getBal());
			pt.setInt(2, e.getAccNo());
			
			int rows=pt.executeUpdate();          //Withdraw
	          if(rows>0)
	        return true; 
	          else
			return false;
		}
		public double  SearchBal(int id1) throws SQLException
		{	
			pt=con.prepareStatement("select  * from register where Account_no=?");
			pt.setInt( 1, id1);
			 
			double b=0;
			
			ResultSet res=pt.executeQuery();    //checkbal
			if(res.next())
			{
	          b=res.getDouble(8);
	         }
				return b;
		}
		
		public boolean UpdatePin(BankPojo e) throws SQLException
		{
			pt=con.prepareStatement(" update register set Password=? where Account_no=?");
			pt.setString(1, e.getPass());
			pt.setInt(2, e.getAccNo());
													//pin generate
			int rows=pt.executeUpdate();
	          if(rows>0)
	        	  return true; 
	          else
			return false;
		}
		
	  
}

