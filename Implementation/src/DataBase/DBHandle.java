package DataBase;
import User.User;
import java.util.List;

public class DBHandle {
    private static DBConnection dbConnecton;

    public static DBConnection getDbConnecton() {
        return dbConnecton;
    }

    public static void setDB(DBConnection db) {
        dbConnecton=db;
    }

    public static List<User> fillUsersList() {
        return dbConnecton.fillUsersList();
    }

    public static boolean ifUserExist(String userName) {
        return dbConnecton.ifUserExist(userName);
    }

    public static void increaseBalance(User user, double amount) {
        dbConnecton.increaseBalance(user, amount);
    }

    public static void decreaseBalance(User user, double amount) {
        dbConnecton.decreaseBalance(user, amount);
    }

    public static boolean ifWalletExist(String mobileNumber) {
        return dbConnecton.isWalletExist(mobileNumber);
    }

    public static boolean ifMobileNumberLocateToAccount(String accountNumber, String mobileNumber) {
        return dbConnecton.ifMobileNumberLocateToAccount(accountNumber, mobileNumber);
    }

    public static void addUser(User user){
        dbConnecton.addUser(user);
    }

    public static boolean ifPasswordCorrect(String userName, String Password){
        return dbConnecton.ifPasswordCorrect(userName,Password);
    }

    public static User loadUser(String userName){
        return dbConnecton.loadUser(userName);
    }

    public static String getProvider(String userName) {
        return dbConnecton.getProvider(userName) ;
    }
}