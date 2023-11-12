package User;

import Account.*;

public class User {
	private Account account;

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

}