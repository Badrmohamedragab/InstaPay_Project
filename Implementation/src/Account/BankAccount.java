package Account;

public class BankAccount extends Account {

	private String accountNumber;
	@Override
	public String getAccountNumber() {
		// TODO - implement BankAccount.getAccountNumber
		return accountNumber;
	}

	/**
	 *
	 * @param accountNumber
	 */
	@Override
	public void setAccountNumber(String accountNumber) {
		// TODO - implement BankAccount.setAccountNumber
		this.accountNumber = accountNumber;
	}



}