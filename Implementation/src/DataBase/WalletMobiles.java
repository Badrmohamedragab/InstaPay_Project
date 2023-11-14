package DataBase;
import java.util.List;
import java.util.Vector;

public class WalletMobiles {
	private final List<String> walletMobiles;

	public WalletMobiles(){
		walletMobiles = new Vector<>(){{
			add("01134567890");
			add("01011223344");
			add("01134567892");
			add("01256843365");
			add("01112354596");
			add("01020215169");
			add("01256256651");
			add("01115156106");
			add("01020291569");
			add("01051556849");
		}};
	}

	public List<String> getMobiles() {
		return walletMobiles ;
	}

	/**
	 * 
	 * @param mobileNumber
	 */
	public boolean ifWalletExist(String mobileNumber) {
		return walletMobiles.contains(mobileNumber) ;
	}
}