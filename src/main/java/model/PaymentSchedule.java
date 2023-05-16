package  model;

import java.util.Date;

public class PaymentSchedule {
    private int id;
    private Date paymentDate;
    private float amount;
    private float remainAmount;
    private boolean isPaid;
    private Contract contract;

    public PaymentSchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(float remainAmount) {
        this.remainAmount = remainAmount;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
