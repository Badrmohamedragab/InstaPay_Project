package DataBase;
import User.User;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ListDB implements DBConnection{
    Users users ;
    WalletMobiles walletMobiles ;
    AccountNumbers accountNumbers ;

    public ListDB(){
        initializeDB();
    }

    @Override
    public List<User> fillUsersList() {
        Map<String, User> userMap = users.getUsers() ;
        List<User> userList = new Vector<>();

        for (Map.Entry<String, User> e :
                userMap.entrySet()) {
            userList.add(e.getValue()) ;
        }
        return userList ;
    }

    @Override
    public boolean ifUserExist(String userName) {
        return users.ifUserExist(userName) ;
    }

    @Override
    public boolean isWalletExist(String mobileNumber) {
        return walletMobiles.ifWalletExist(mobileNumber);
    }

    @Override
    public boolean ifMobileNumberLocateToAccount(String accountNumber, String mobileNumber) {
        return accountNumbers.ifMobileNumberLocateToAccount(accountNumber, mobileNumber);
    }

    @Override
    public boolean ifPasswordCorrect(String userName, String Password) {
        return users.ifPasswordCorrect(userName, Password);
    }

    @Override
    public User loadUser(String userName) {
        return users.getUsers().get(userName);
    }

    @Override
    public void initializeDB() {
        users = new Users() ;
        walletMobiles = new WalletMobiles() ;
        accountNumbers = new AccountNumbers() ;
    }

    @Override
    public String getProvider(String userName) {
        String provider = users.getUsers().get(userName).getAccount().getProvider().getClass().toString() ;
        return provider
                .substring(provider.indexOf('.')) ;
    }

    @Override
    public void addUser(User user) {
        users.addUser(user) ;
    }

    @Override
    public void decreaseBalance(User user, double amount) {
        User user1 = users.getUsers().get(user.getAccount().getUserName()) ;
        user1.getAccount().setBalance(user1.getAccount().getBalance() - amount);
        users.getUsers().replace(user.getAccount().getUserName(), user1) ;
    }

    @Override
    public void increaseBalance(User user, double amount) {
        User user1 = users.getUsers().get(user.getAccount().getUserName()) ;
        user1.getAccount().setBalance(user1.getAccount().getBalance() + amount);
        users.getUsers().replace(user.getAccount().getUserName(), user1) ;
    }
}
