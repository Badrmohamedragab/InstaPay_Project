package Account;

import Provider.Provider;

public class WalletAccount extends Account{

    public WalletAccount() {}
    public WalletAccount(double balance, String password, String userName, String mobileNumber, Provider provider) {
        super(balance, password, userName, mobileNumber, provider);
    }
}
