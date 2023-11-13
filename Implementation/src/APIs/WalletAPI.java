package APIs;

import DataBase.DBHandle;
import User.*;

public class WalletAPI extends API {

	/**
	 * 
	 * @param user
	 */
	public boolean validate(User user) {
		DBHandle DB = new DBHandle();
//		if(DB.ifWalletExist(user.getAccount().getMobileNumber()))
//		{
//			return true;
//		}
		return false;

	}

}