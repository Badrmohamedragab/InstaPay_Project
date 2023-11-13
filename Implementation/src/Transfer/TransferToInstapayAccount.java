package Transfer;
import User.User;

public interface TransferToInstapayAccount {
    boolean transfer(User from, User to, double amount);
}
