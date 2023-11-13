package Account;

import Provider.Provider;

public class BankAccount extends Account {

	private String accountNumber;

	public BankAccount(double balance, String password, String userName, String mobileNumber, Provider provider, String accountNumber) {
		super(balance, password, userName, mobileNumber, provider);
		this.accountNumber = accountNumber ;
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 *
	 * @param accountNumber
	 */
	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}