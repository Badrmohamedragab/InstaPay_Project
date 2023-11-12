package Provider;

import APIs.*;
import User.*;

public abstract class Wallet extends Provider {

	public API getAPI() {
		// TODO - implement Wallet.getAPI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param api
	 */
	public void setAPI(API api) {
		// TODO - implement Wallet.setAPI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param amount
	 */
	public void increaseBalance(User user, double amount) {
		// TODO - implement Wallet.increaseBalance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param amount
	 */
	public void decreaseBalance(User user, double amount) {
		// TODO - implement Wallet.decreaseBalance
		throw new UnsupportedOperationException();
	}

}