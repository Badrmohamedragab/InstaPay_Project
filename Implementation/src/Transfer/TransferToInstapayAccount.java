package Transfer;
import User.User;

public interface TransferToInstapayAccount {
    void transfer(User from, User to, double amount);
}
