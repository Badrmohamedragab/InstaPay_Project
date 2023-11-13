package Transfer;
import User.User;

public interface TransferToInstapayAccount {

	/**
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	boolean transfer(User from, User to, double amount);
}