package Bills;
import java.util.Date;

public class Bill {

	private double billId;
	private double amount;
	private Date date;
	private PaymentStatus status;

	public void setBillid(double billid) {
		this.billId = billid;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public double getBillid() {
		return billId;
	}

	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public PaymentStatus getStatus() {
		return status;
	}
}