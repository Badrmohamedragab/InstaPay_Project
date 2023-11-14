package Transfer;
import DataBase.DBHandle;
import User.User;

public class TransferToWallet implements TransferTo {

	/**
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	public void transfer(User from, String to, double amount) {
		if(!DBHandle.ifWalletExist(to)){
			System.out.println("Transfer field: The mobile number doesn't exist");
			return;
		}
		if(from.getAccount().getBalance() >= amount){
			from.getAccount().getProvider().decreaseBalance(from, amount);
			System.out.println("Transfer process completed");
			return;
		}
		System.out.println("Transfer field: The amount doesn't enough");
	}
}