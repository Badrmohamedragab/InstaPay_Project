package DataBase;
import Account.*;
import Provider.*;
import User.*;
import java.util.HashMap;
import java.util.Map;

public class Users {
	private final Map<String, User> users;

	public Users() {
		users = new HashMap<>() {{
            put("Ahmed_Said", new User(new BankAccount(1500, "Pass123", "Ahmed_Said",
                    "01123456789", new MasrBank(), "11111111111")));
            put("Fatma_Mohamed", new User(new BankAccount(2000, "SecurePwd", "Fatma_Mohamed",
                    "01098765432", new CIBBank(), "22222222222")));
            put("Omar_Khaled", new User(new WalletAccount(3000, "SecretPass", "Omar_Khaled",
                    "01134567890", new EtisalatWallet())));
            put("Laila_Mostafa", new User(new WalletAccount(2500, "Pwd12345", "Laila_Mostafa",
                    "01011223344", new VodafoneWallet())));
            put("Aya_Ahmed", new User(new BankAccount(3500, "Secure123", "Aya_Ahmed",
                    "01234567891", new MasrBank(), "66666666666")));
            put("Mohamed_Youssef", new User(new BankAccount(2800, "MyPwd987", "Mohamed_Youssef",
                    "01122334455", new ElahlyBank(), "77777777777")));
            put("Sara_Hassan", new User(new BankAccount(4000, "PassWord123", "Sara_Hassan",
                    "01011223344", new CIBBank(), "88888888888")));
            put("Amr_Ali", new User(new WalletAccount(3200, "SecretKey", "Amr_Ali",
                    "01134567892", new EtisalatWallet())));
            put("Hala_Mohammed", new User(new BankAccount(2700, "PwdSecure", "Hala_Mohammed",
                    "01112233445", new ElahlyBank(), "00000000000")));
        }};
	}

	public Map<String, User> getUsers() {
		return users;
	}

    public boolean ifUserExist(String userName){
        return users.containsKey(userName) ;
    }

    public boolean ifPasswordCorrect(String userName, String Password){
        return users.get(userName).getAccount().getPassword().equals(Password) ;
    }

    public void addUser(User user) {
        users.put(user.getAccount().getUserName(), user) ;
    }
}




