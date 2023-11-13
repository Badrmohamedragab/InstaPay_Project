package Transfer;
import APIs.API;
import APIs.WalletAPI;
import DataBase.DBHandle;
import User.User;

public class TransferToWallet implements TransferTo {

	/**
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	public boolean transfer(User from, String to, double amount) {
		if(!DBHandle.ifWalletExist(to)){
			return false;
		}
		if(from.getAccount().getBalance() >= amount){
			from.getAccount().getProvider().decreaseBalance(from,amount);
			return true;
		}
		return false;

	}

}