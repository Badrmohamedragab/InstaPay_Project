package User;
import Account.*;

public class User {
    private Account account;

    public User(Account account) {
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }
}