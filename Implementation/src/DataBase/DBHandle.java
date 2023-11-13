package DataBase;

import User.User;

import java.util.List;

public class DBHandle {

    private static DBConnection dbConnecton;

    public static DBConnection getDbConnecton() {
        return dbConnecton;
    }

    /**
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

    public List<User> fillUsersList() {
        return dbConnecton.fillUsersList();
    }

    public User ifUserExist(String userName) {
        return dbConnecton.ifUserExist(userName);
    }

    public void increaseBalance(User user, double amount) {
        dbConnecton.increaseBalance(user, amount);
    }

    public void decreaseBalance(User user, double amount) {
        dbConnecton.decreaseBalance(user, amount);
    }

    public boolean isWalletExist(String mobileNumber) {
        return dbConnecton.isWalletExist(mobileNumber);
    }

    public boolean ifMobileNumberLocateToAccount(String accountNumber, String mobileNumber) {
        return dbConnecton.ifMobileNumberLocateToAccount(accountNumber, mobileNumber);
    }


}