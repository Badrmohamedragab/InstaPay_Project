package Provider;

import APIs.*;
import DataBase.DBHandle;
import User.*;

public abstract class Provider {
	private API api;

	/**
	 *
	 * @param api
	 */

	public void setAPI(API api) {
		this.api = api;
	}

	public API getAPI() {
		return api;
	}


	/**
	 * 
	 * @param user
	 * @param amount
	 */
	 public void increaseBalance(User user, double amount)
	 {
		 DBHandle.increaseBalance(user, amount);
		 user.getAccount().setBalance(user.getAccount().getBalance() + amount);
	 }


	/**
	 * 
	 * @param user
	 * @param amount
	 */
	 public void decreaseBalance(User user, double amount)
	 {
		 DBHandle.decreaseBalance(user, amount);
		 user.getAccount().setBalance(user.getAccount().getBalance() - amount);
	 }
}