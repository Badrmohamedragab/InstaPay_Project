package Bills;
import User.*;

/**
 *<pre>
 *The {@code BillPayment} class
 *it's role is paying the bill
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.0</strong>
 */
public class BillPayment {

	/**
	 <pre>
	 *The method {@code payBill}
	 *it's role is decrease the user balance
	 *and pay the bill
	 *</pre>
	 * @param bill <strong style="color:'white'"> The bill which be payed</strong>
	 * @param user <strong style="color:'white'"> The user who pay the bill</strong>
	 */
	public static void payBill(Bill bill, User user) {
		if (user.getAccount().getBalance() > bill.getAmount()){
			user.getAccount().getProvider().decreaseBalance(user, bill.getAmount());
			bill.showBill();
			bill.setStatus(PaymentStatus.PAYED);
			System.out.println("\nYour balance -> " + user.getAccount().getBalance());
		}

		System.err.println("You cannot pay for this bill: your balance doesn't enough");
	}
}