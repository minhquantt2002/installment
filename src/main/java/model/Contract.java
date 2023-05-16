package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Contract {
    private int id;
    private String name;
    private float totalAmount;
    private float interestRate;
    private String termLoan;
    private LocalDateTime createdDay;
    private String note;
    private Client client;
    private Partner partner;
    private User user;
    private ArrayList<ContractDetail> contractDetails;
    private ArrayList<PaymentSchedule> paymentSchedules;

    public Contract() {
        contractDetails = new ArrayList<>();
        paymentSchedules = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getTermLoan() {
        return termLoan;
    }

    public void setTermLoan(String termLoan) {
        this.termLoan = termLoan;
    }

    public LocalDateTime getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(LocalDateTime createdDay) {
        this.createdDay = createdDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(ArrayList<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public ArrayList<PaymentSchedule> getPaymentSchedules() {
        return paymentSchedules;
    }

    public void setPaymentSchedules(ArrayList<PaymentSchedule> paymentSchedules) {
        this.paymentSchedules = paymentSchedules;
    }
}
