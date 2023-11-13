package APIs;

import DataBase.DBHandle;
import User.*;

public class WalletAPI extends API {

	/**
	 * 
	 * @param user
	 */
	public boolean validate(User user) {
//		if(DBHandle.ifWalletExist(user.getAccount().getMobileNumber()))
//		{
//			return true;
//		}
		return false;

	}

}