package Bills;
import java.util.Date;

/**
 *<pre>
 *The {@code Bill} abstract class
 *it's role is represent the bill
 *and the information of it
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.0</strong>
 */

public abstract class Bill {
	private final double billId;
	private double amount;
	private final String meterNumber;
	private final Date date;
	private PaymentStatus status;

	/**
	 * constructor to initialize the attributes
	 * <blockquote></blockquote>
	 *
	 * @param billId <strong style="color:'white'"> The id of the bill</strong>
	 * @param amount <strong style="color:'white'"> The amount of the bill</strong>
	 * @param meterNumber <strong style="color:'white'"> The meter number of the bill</strong>
	 * @param date <strong style="color:'white'"> The date of the bill</strong>
	 * @param status <strong style="color:'white'"> The status of the bill</strong>
	 */
	public Bill(double billId, double amount, String meterNumber, Date date, PaymentStatus status) {
		this.billId = billId;
		this.amount = amount;
		this.meterNumber = meterNumber;
		this.date = date;
		this.status = status;
	}

	/**
	 *<pre>
	 *setter to initialize the {@code status} attributes
	 *</pre>
	 * @param status <strong style="color:'white'"> The new status</strong>
	 */
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	/**
	 *<pre>
	 *setter to initialize the {@code amount} attributes
	 *</pre>
	 * @param amount <strong style="color:'white'"> The new amount</strong>
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 *<pre>
	 *getter to get the {@code status} attributes
	 *</pre>
	 * @return <strong style="color:'white'"> The status of the bill</strong>
	 */
	public PaymentStatus getStatus() {
		return status;
	}

	/**
	 *<pre>
	 *getter to get the {@code billId} attributes
	 *</pre>
	 * @return <strong style="color:'white'"> The Id of the bill</strong>
	 */
	public double getBillId() {
		return billId;
	}

	/**
	 *<pre>
	 *getter to get the {@code Amount} attributes
	 *</pre>
	 *  @return <strong style="color:'white'"> The amount of the bill</strong>
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 *<pre>
	 *getter to get the {@code Date} attributes
	 *</pre>
	 * @return <strong style="color:'white'"> The date of the bill</strong>
	 */
	public Date getDate() {
		return date;
	}

	/**
	 *<pre>
	 *getter to get the {@code MeterNumber} attributes
	 *</pre>
	 * @return <strong style="color:'white'"> The meter number of the bill</strong>
	 */
	public String getMeterNumber() {
		return meterNumber;
	}

	/**
	 *<pre>
	 *abstract method to show the {@code bill}
	 *</pre>
	 */
	public abstract void showBill() ;
}