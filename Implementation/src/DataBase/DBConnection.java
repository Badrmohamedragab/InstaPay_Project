package DataBase;

import User.User;

import java.util.List;

public interface DBConnection {
	public List<User> fillUsersList();
	public User ifUserExist(String userName);

	void initializeDB();

}