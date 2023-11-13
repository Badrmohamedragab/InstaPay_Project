package APIs;

import DataBase.DBHandle;
import User.*;

public class BankAPI extends API {

	/**
	 * 
	 * @param user
	 */
	public boolean validate(User user) {
		DBHandle DB = new DBHandle();
//		if(DB.ifMobileNumberLocateToAccount(user.getAccount().getAccountNumber()),user.getAccount().getMobileNumber())
//		{
//			return true;
//		}
		return false;

	}

}