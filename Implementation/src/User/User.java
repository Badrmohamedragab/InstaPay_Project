package User;

import Account.*;

public class User {

	private Account account;

	public User(Account account) {
		this.account = account;
	}

	public User(String username, String password, double balance, String mobileNumber) {

		account.setBalance(balance);
		account.setMobileNumber(mobileNumber);
		account.setPassword(password);
		account.setUserName(username);
	}

	/**
	 * 
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return this.account;
	}
	public String getUsername() {
		return this.account.getUsername();
	}public String getMobileNumber() {
		return this.account.getMobileNumber();
	}public double getBalance() {
		return this.account.getBalance();
	}public String getPassword() {
		return this.account.getPassword();
	}public String getProvider() {
		return this.account.getProvider();
	}public String accountNumber() {
		return this.account.getAccountNumber();
	}

}