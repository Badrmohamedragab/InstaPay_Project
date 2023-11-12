package Transfer;

import User.*;

public interface TransferProcess {

	/**
	 * 
	 * @param from
	 * @param to
	 * @param amount
	 */
	boolean transfer(User from, User to, double amount);

}