package entity;

import java.sql.Time;
import java.time.*;

public class Transaction {
	private int tranid;
	private String numcardacc;
	private String numcardtrans;
	private int amount;
	private LocalDate dispatchDate;
	private LocalTime deliveryTime;

	public Transaction() {
	}


	public Transaction(int tranid, String numcardacc, String numcardtrans, int amount, LocalDate dispatchDate,
			LocalTime deliveryTime) {
		this.tranid = tranid;
		this.numcardacc = numcardacc;
		this.numcardtrans = numcardtrans;
		this.amount = amount;
		this.dispatchDate = dispatchDate;
		this.deliveryTime = deliveryTime;
	}


	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public String getNumcardacc() {
		return numcardacc;
	}

	public void setNumcardacc(String numcardacc) {
		this.numcardacc = numcardacc;
	}

	public String getNumcardtrans() {
		return numcardtrans;
	}

	public void setNumcardtrans(String numcardtrans) {
		this.numcardtrans = numcardtrans;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	@Override
	public String toString() {
		return "Transaction [tranid=" + tranid + ", numcardacc=" + numcardacc + ", numcardtrans=" + numcardtrans
				+ ", amount=" + amount + ", dispatchDate=" + dispatchDate + ", deliveryTime=" + deliveryTime + "]";
	}

}
