package APIs;

import User.*;

import java.util.Random;

public abstract class API {

	/**
	 * 
	 * @param user
	 */
	abstract public boolean validate(User user) ;

	/**
	 * 
	 * @param number
	 */

	public void sendOTP(String number) {
		Random random = new Random();
		int randomNumber = 1000 + random.nextInt(9000);
		System.out.print("Sending OTP to this Number : " + number + "\nOTP : " + randomNumber);

	}

}