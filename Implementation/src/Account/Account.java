package Account;
import Provider.*;

public abstract class Account {
	private double balance;
	private String password;
	private String userName;
	private String mobileNumber;
	private Provider provider;

	public Account() {}
	public Account(double balance, String password, String userName, String mobileNumber, Provider provider) {
		this.balance = balance;
		this.password = password;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.provider = provider;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setBalance(double amount) {
		this.balance = amount;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * 
	 * @param mobileNumber
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 *
	 * @param accountNumber
	 */

	public void setAccountNumber(String accountNumber){
		throw new UnsupportedOperationException();
	}

	public double getBalance() {
		return this.balance;
	}

	public String getPassword() {
		return password;
	}


	public String getAccountNumber() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param provider
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public String getUsername() {
		return userName ;
	}
}