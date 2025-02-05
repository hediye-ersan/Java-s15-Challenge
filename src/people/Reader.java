package people;

import library.Book;
import library.MemberRecord;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private MemberRecord memberRecord;
    private List<Book> barrowedBooks; //Ödünç alınanlar için liste
    private List<Book> purchasedBooks; //Satın alınanlar için liste
    private int maxBookLimit = 5;



    public Reader(String name,MemberRecord memberRecord, List<Book> barrowedBooks, List<Book> purchasedBooks, int maxBookLimit) {
        super(name);
        this.memberRecord = memberRecord;
        this.barrowedBooks = new ArrayList<>();
        this.purchasedBooks = new ArrayList<>();
        this.maxBookLimit = maxBookLimit;
    }
    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public List<Book> getBarrowedBooks() {
        return barrowedBooks;
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }
    public boolean barrowBook(Book book){
        if(barrowedBooks.size() < maxBookLimit){
            barrowedBooks.add(book);
            return true;
        }else{
            System.out.println("Kitap limitine ulaştını!");
            return false;
        }
    }
    public void showBarrowedBook(){
        if(barrowedBooks.isEmpty()){
            System.out.println(getName() + " adlı okuyucu henüz kitap ödünç almamıştır.");
        }else{
            System.out.println(getName() + " adlı kullanıcının ödünç aldığı kitaplar:");
            for(Book book : barrowedBooks){
                System.out.println("- " + book.getName());
            }
        }
    }

    public void purchaseBook(Book book) {
        if (purchasedBooks.size() < maxBookLimit) {
            purchasedBooks.add(book);
            System.out.println(getName() + " adlı kullanıcı " + book.getName() + " adlı kitabı satın aldı.");
        } else {
            System.out.println("Satın alınacak kitap limiti aşıldı.");
        }
    }

    public void showPurchasedBook(){
        if(purchasedBooks.isEmpty()){
            System.out.println(getName() + " adlı okuyucu henüz kitap satın almamıştır.");
        }else{
            System.out.println(getName() + " adlı okuyucunun satın aldığı kitaplar:");
            for(Book book : purchasedBooks){
                System.out.println("- " + book.getName());
            }
        }
    }
    public void returnBook(Book book){
        barrowedBooks.remove(book);
    }

    public void showBook(){
        System.out.println(getName() + " adlı okuyucunun almış olduğu kitaplar:");
        System.out.println("Ödünç aldığı kitaplar:");
        showBarrowedBook();
        System.out.println("Satın aldığı kitaplar:");
        showPurchasedBook();
        if(barrowedBooks.isEmpty() || purchasedBooks.isEmpty()){
            System.out.println(getName() + " adlı okuyucu henüz kitap almamıştır.");
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir okuyucuyum ve adım: " + getName());
    }
}
