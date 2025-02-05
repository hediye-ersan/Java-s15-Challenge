package library;

import people.Author;

import java.util.Date;

public class Book {
    private int id;
    private String author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private Date dateOfPurchase;


    public Book(String name ,String author) {
        this.name = name;
        this.author = author;

    }



    public Book(int id, String author, String name, double price, String status,
                String edition, Date dateOfPurchase){
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = "Kütüphanede Mevcut";
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getTitle(){
        return getName();
    }

    public String getOwner(){
        if(getStatus().equals("Ödünç Alındı")){
            return "Ödünç Alınmış";
        }else {
            return "Kütüphane";
        }
    }

    public void updateStatus(String newStatus){
        this.status = newStatus;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Status: " + status);
        System.out.println("Edition: " + edition);
        System.out.println("Date of Purchase: " + dateOfPurchase);
    }
}

