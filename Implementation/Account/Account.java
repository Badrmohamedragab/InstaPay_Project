package Account;

public class Account {

	private double balance;
	private String password;
	private String userName;
	private String mobileNumber;

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
}