package Transfer;
import Account.BankAccount;
import Account.WalletAccount;
import DataBase.DBHandle;
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
    public void transfer(User from, User to, double amount) {
        if(!DBHandle.ifUserExist(to.getAccount().getUserName())){
            System.out.println("Transfer field: The user doesn't exist");
            return;
        }

        if (from.getAccount() instanceof WalletAccount){
            System.out.println("Transfer field: You cannot transfer money to Bank Account using Wallet Account");
            return;
        }

        if(from.getAccount().getBalance() >= amount){
            from.getAccount().getProvider().decreaseBalance(from,amount);
            to.getAccount().getProvider().increaseBalance(to,amount);
            System.out.println("Transfer process completed");
            return;
        }

        System.out.println("Transfer field: The amount doesn't enough");
    }
}
