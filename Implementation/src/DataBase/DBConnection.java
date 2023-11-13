package DataBase;

import User.User;

import java.util.List;

public interface DBConnection {
	public List<User> fillUsersList();
	public boolean ifUserExist(String userName);
	public void increaseBalance(User user,double amount);
	public void decreaseBalance(User user,double amount);
	public boolean isWalletExist(String mobileNumber);
	public boolean ifMobileNumberLocateToAccount(String accountNumber,String mobileNumber);
	public void addUser(User user);
	public boolean ifPasswordCorrect(String userName, String Password);
	public User loadUser(String userName);
	void initializeDB();
}