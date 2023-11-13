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
	public boolean transfer(User from, User to, double amount) {
		if(!DBHandle.ifUserExist(to.getAccount().getUserName())){
			return false;
		}
		if(from.getAccount().getBalance() >= amount){
			from.getAccount().getProvider().decreaseBalance(from,amount);
			to.getAccount().getProvider().increaseBalance(to,amount);
			return true;
		}
		return false;

	}


}