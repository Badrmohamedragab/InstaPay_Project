package Provider;

import APIs.*;
import User.*;

public abstract class Provider {

	private API api;

	public API getAPI() {
		// TODO - implement Provider.getAPI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param api
	 */
	public void setAPI(API api) {
		// TODO - implement Provider.setAPI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param amount
	 */
	public void increaseBalance(User user, double amount) {
		// TODO - implement Provider.increaseBalance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param amount
	 */
	public void decreaseBalance(User user, double amount) {
		// TODO - implement Provider.decreaseBalance
		throw new UnsupportedOperationException();
	}

}