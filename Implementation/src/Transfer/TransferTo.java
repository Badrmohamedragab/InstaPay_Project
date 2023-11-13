package Transfer;
import User.User;

public interface TransferTo {
    public boolean transfer(User from, String to, double amount) ;
}
