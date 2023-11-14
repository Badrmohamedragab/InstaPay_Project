package DataBase;
import java.util.HashMap;
import java.util.Map;

public class AccountNumbers {
	private final Map<String, String> accounts;

	public AccountNumbers(){
		accounts = new HashMap<>(){{
			put("11111111111", "01123456789");
			put("22222222222", "01098765432");
			put("66666666666", "01234567891");
			put("77777777777", "01122334455");
			put("00000000000", "01112233445");
		}};
	}
	public boolean ifMobileNumberLocateToAccount(String accountNumber, String mobileNumber) {
		return accounts.containsKey(accountNumber) && accounts.get(accountNumber).equals(mobileNumber);
	}
}