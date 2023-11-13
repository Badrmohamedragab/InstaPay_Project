package Transfer;
import User.User;

public class TransferToBankAccount implements TransferToInstapayAccount{

    /**
     *
     * @param from
     * @param to
     * @param amount
     * @return
     */
    @Override
    public boolean transfer(User from, User to, double amount) {
        return false;
    }
}
