package Provider;

import APIs.*;
import User.*;

public abstract class Bank extends Provider {

	public API getAPI() {
		// TODO - implement Bank.getAPI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param api
	 */
	public void setAPI(API api) {
		// TODO - implement Bank.setAPI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param amount
	 */
	public void increaseBalance(User user, double amount) {
		// TODO - implement Bank.increaseBalance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param amount
	 */
	public void decreaseBalance(User user, double amount) {
		// TODO - implement Bank.decreaseBalance
		throw new UnsupportedOperationException();
	}

}