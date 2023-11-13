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

	public void setApi(API api) {
		this.api = api;
	}

	public API getApi() {
		return api;
	}


	/**
	 * 
	 * @param user
	 * @param amount
	 */
	 public void increaseBalance(User user, double amount)
	 {
//		 DBHandle.increaseBalance(user, amount);
		 user.getAccount().setBalance(user.getAccount().getBalance() + amount);
	 }


	/**
	 * 
	 * @param user
	 * @param amount
	 */
	 public void decreaseBalance(User user, double amount)
	 {
//		 DBHandle.decreaseBalance(user, amount);
		 user.getAccount().setBalance(user.getAccount().getBalance() - amount);

	 }

}