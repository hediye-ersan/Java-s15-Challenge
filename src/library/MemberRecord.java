package library;

import java.time.LocalDate;

public class MemberRecord {
    private int memberId;
    private String type;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(int memberId, String type, LocalDate dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0;
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public MemberRecord(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(LocalDate dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    //getMember() yerine toString kullandım.
    @Override
    public String toString() {
        return "Member ID: " + memberId + " Name: " + name + " Type: " + type +
                " Address: " + address + " Phone: " + phoneNo + " Books Issued: " + noBooksIssued;
    }


    public void incBookIssued(){
        if(noBooksIssued<maxBookLimit){
            noBooksIssued++;
        }else{
            System.out.println("Maksimum kitap limitine ulaştın!");
        }
    }

    public void decBookIssued(){
        if(noBooksIssued>0){
            noBooksIssued--;
        }else {
            System.out.println("İade edilecek kitap yok!");
        }
    }

    public void payBill(double amount){
        System.out.println( name + "İsimli kayıt için " + amount + "ödendi.");
    }
}
