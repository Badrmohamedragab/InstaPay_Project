package DataBase;

import Account.Account;
import User.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Users {

	public Users() throws SQLException {
		users=DBHandle.getDbConnecton().fillUsersList();

	}
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}

	/**
	 *
	 * @param userName
	 */


}




