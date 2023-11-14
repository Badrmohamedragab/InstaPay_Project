package Transfer;
import Account.BankAccount;
import DataBase.DBHandle;
import User.User;

public class TransferToWalletAccount implements TransferToInstapayAccount {

	/**
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	public void transfer(User from, User to, double amount) {
		if(from.getAccount().getMobileNumber().equals(to.getAccount().getMobileNumber())){
			System.out.println("You cannot transfer to yourself");
			return;
		}
		if(!DBHandle.ifUserExist(to.getAccount().getUserName())){
			System.out.println("Transfer field: The mobile number doesn't exist");
			return;
		}
		if(from.getAccount().getBalance() >= amount){
			from.getAccount().getProvider().decreaseBalance(from,amount);
			to.getAccount().getProvider().increaseBalance(to,amount);
			System.out.println("Transfer process completed");
			return;
		}

		System.err.println("Transfer field: The amount doesn't enough");
	}
}