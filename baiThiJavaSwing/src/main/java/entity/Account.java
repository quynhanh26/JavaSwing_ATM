package entity;

import java.time.LocalDate;

public class Account {
	private int accid;
	private String numcardacc;
	private String fullname;
	private String gender;
	private LocalDate dob;
	private String pinNum;
	private int balance;
	private String isAdmin;

	public Account() {
	}


	public Account(int accid, String numcardacc, String fullname, String gender, LocalDate dob, String pinNum,
			int balance, String isAdmin) {
		this.accid = accid;
		this.numcardacc = numcardacc;
		this.fullname = fullname;
		this.gender = gender;
		this.dob = dob;
		this.pinNum = pinNum;
		this.balance = balance;
		this.isAdmin = isAdmin;
	}


	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public String getNumcardacc() {
		return numcardacc;
	}

	public void setNumcardacc(String numcardacc) {
		this.numcardacc = numcardacc;
	}


	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPinNum() {
		return pinNum;
	}

	public void setPinNum(String pinNum) {
		this.pinNum = pinNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getBalance() {
		return balance;
	}


	public int credit(int amount) {
		return this.balance += amount;
	}
	
	public int debit(int amount) {
		if(amount <= this.balance) {
			this.balance -= amount;
		}else {
			System.out.println("Failt");
		}
		return this.balance;
	}
	
	public int transferTo(Account account1 , int amount) {
		if(amount <= this.balance) {
			int balance1 = account1.getBalance() + amount;
			account1.setBalance(balance1);
			this.balance -= amount;
		}
		else{
			System.out.println("failed transferTo");
		}
		return this.balance;
	}


	@Override
	public String toString() {
		return "Account [accid=" + accid + ", numcardacc=" + numcardacc + ", fullname=" + fullname + ", gender="
				+ gender + ", dob=" + dob + ", pinNum=" + pinNum + ", balance=" + balance + ", isAdmin=" + isAdmin
				+ "]";
	}
	
}
