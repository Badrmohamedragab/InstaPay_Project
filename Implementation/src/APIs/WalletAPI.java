package APIs;
import DataBase.DBHandle;
import User.*;

public class WalletAPI extends API {

	/**
	 * 
	 * @param user
	 */
	public boolean validate(User user) {
        return DBHandle.ifWalletExist(user.getAccount().getMobileNumber());
    }
}