package project;
 

public class BankPojo 
{
	private String fName,DOB,opGender,pass,mobile_No;
	private String lName ;
	private int accNo;
	private double bal;
	
	

	public BankPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public BankPojo(double bal) {
		super();
		this.bal = bal;
	}



	public BankPojo(String fName, String lName,String mobile_No,String DOB,String opGender,int accNo,String pass, double bal) {
		super();
		this.opGender = opGender;
		this.fName = fName;
		this.lName = lName;
		this.pass = pass;
		this.mobile_No = mobile_No;
		this.accNo = accNo;
		this.DOB =DOB;
		this.bal=bal;
	}

	 
	public String toString() {
		return "Fist Name= " + fName +"\n"+ "Last Name= " + lName +"\n"+ "Mobile_No= " + mobile_No
				+ "\n"+" Account No= " + accNo +"\n"+"Available Balance= "+bal+"\n"+"Gender= "+opGender+"\n"+"	DOB= " + DOB+"\n";
	}

	public String getfName() {
		return fName;
	}
	
	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getMobile_No() {
		return mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		  this.DOB=DOB;
	}

	public String getOpGender() {
		return opGender;
	}

	public void setOpGender(String opGender) {
		this.opGender = opGender;
	}

	public String getPass() {
		return pass;
	}

	public String setPass(String pass) {
		return this.pass = pass;
	}
	
	public int getAccNo() {
		return accNo;
	}

	public int setAccNo(int accNo) {
		this.accNo = accNo;
		return accNo;
	}
	 
	
	
}
