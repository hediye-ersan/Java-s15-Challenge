package util;

import people.Reader;

import java.util.Date;

public class Bill {
    private Reader reader;
    private double amount;
    private Date issueDate;

    public Bill(Reader reader, double amount) {
        this.reader = reader;
        this.amount = amount;
        this.issueDate = new Date();
    }

    public Reader getReader(){
        return reader;
    }
    public void setReader(Reader reader){
        this.reader = reader;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void displayBill(){
        System.out.println("Fatura Detayları:");
        System.out.println("Kullanıcı: " + reader.getName());
        System.out.println("Tutar: " + amount + " TL");
        System.out.println("Fatura Tarihi: " + issueDate);
    }
}
