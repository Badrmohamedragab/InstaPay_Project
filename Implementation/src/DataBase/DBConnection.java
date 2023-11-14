package DataBase;

import User.User;

import java.util.List;

public interface DBConnection {
	List<User> fillUsersList();
	boolean ifUserExist(String userName);
	void increaseBalance(User user, double amount);
	void decreaseBalance(User user, double amount);
	boolean isWalletExist(String mobileNumber);
	boolean ifMobileNumberLocateToAccount(String accountNumber, String mobileNumber);
	void addUser(User user);
	boolean ifPasswordCorrect(String userName, String Password);
	User loadUser(String userName);
	void initializeDB();
	String getProvider(String userName);
}