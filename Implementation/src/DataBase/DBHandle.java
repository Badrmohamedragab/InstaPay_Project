package DataBase;
import User.User;
import java.util.List;

public class DBHandle {

	private static DBConnection dbConnecton;

	public static DBConnection getDbConnecton() {
		return dbConnecton;
	}

	/**
	 * 
	 * @param db
	 */
	public void setDB(DBConnection db) {
		// TODO - implement DBHandle.setDB
		throw new UnsupportedOperationException();
	}

	public DBConnection getDB() {
		// TODO - implement DBHandle.getDB
		throw new UnsupportedOperationException();
	}
	public List<User> fillUsersList(){
		return dbConnecton.fillUsersList();
	}



}