package Bills;
import java.util.Date;

/**
 *<pre>
 *The {@code Electricity} class it extends {@code Bill} abstract class
 *it's role is represent the Electricity bill
 *and the information of it
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.0</strong>
 */
public class Electricity extends Bill {
	public Electricity(double billId, double amount, String meterNumber, Date date, PaymentStatus status) {
		super(billId, amount, meterNumber, date, status);
	}

	/**
	 *<pre>
	 *abstract method to show the {@code bill}
	 *</pre>
	 */
	@Override
	public void showBill() {
		System.out.println("You just paid the a Electricity bill #" + getBillId() + "\n" +
				"The Amount -> " + getAmount() +
				"\nThe meter -> " + getMeterNumber() +
				"\nThe Date -> " + getDate().toString());
	}

}