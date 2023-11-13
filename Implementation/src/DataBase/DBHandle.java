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
        dbConnecton=db;
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

    public void addUser(User user){
        dbConnecton.addUser(user);
    }public boolean ifPasswordCorrect(String userName, String Password){
        return dbConnecton.ifPasswordCorrect(userName,Password);
    }


}