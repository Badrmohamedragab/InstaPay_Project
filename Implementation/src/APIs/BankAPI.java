package APIs;
import DataBase.DBHandle;
import User.*;

public class BankAPI extends API {

	/**
	 * 
	 * @param user
	 */
	public boolean validate(User user) {
        return DBHandle.ifMobileNumberLocateToAccount(user.getAccount().getAccountNumber(), user.getAccount().getMobileNumber());
    }
}