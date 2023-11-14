package Bills;
import java.util.Date;

/**
 *<pre>
 *The {@code Water} class it extends {@code Bill} abstract class
 *it's role is represent the Water bill
 *and the information of it
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.0</strong>
 */
public class Water extends Bill {
	public Water(double billId, double amount, String meterNumber, Date date, PaymentStatus status) {
		super(billId, amount, meterNumber, date, status);
	}

	/**
	 *<pre>
	 *abstract method to show the {@code bill}
	 *</pre>
	 */
	@Override
	public void showBill() {
		System.out.println("You just paid the a Water bill #" + getBillId() + "\n" +
				"The Amount -> " + getAmount() +
				"\nThe meter -> " + getMeterNumber() +
				"\nThe Date -> " + getDate().toString());
	}
}