package people;

import library.Book;
import library.Library;
import util.Bill;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Librarian extends Person{
    private List<Bill> bills = new ArrayList<>();
    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void searchBook(Library library, String bookName){
        System.out.println("Kütüphanede" + bookName + "adlı kitabı arıyorum.");
        boolean arama = false;
        for(Book book : library.getBooks()){
            if(book.getName().equalsIgnoreCase(bookName)){
                //equalsIgnoreCase ile küçük büyük harf hassasiyeti ortadan kalkar hepsini büyük harf olarak okur.
                System.out.println(bookName + " adlı kitap bulundu.");
                arama = true;
                break;
            }
        }
        if(!arama){
            System.out.println(bookName + " adlı kitap kütüphanede bulunamadı.");
        }
    }
    //Üyeyi doğrularız.
    public boolean verifyMember(Library library, int memberId){
        System.out.println("Üye Id: " + memberId + "doğrulanıyor.");
        for(Reader reader : library.getReaders()){
            if(reader.getName().equalsIgnoreCase(String.valueOf(memberId))){
                System.out.println("Okuyucu bulundu: " + reader.getName());
                return true;
            }
        }
        System.out.println("Okuyucu bulunamadı.");
        return false;
    }

    public boolean issueBook(Library library, Reader reader, Book book){
        System.out.println(reader.getName() + "adlı kullanıcıya" + book.getName() + "adlı kitabı ödünç veriyorum.");
        return library.lendBook(reader,book);
    }

    //gecikme cezası hesabı
    public double calculateFine(Book book){
        double gunlukGecikmeFiyat = 1.5;
        LocalDate today = LocalDate.now();
        LocalDate borrowDate = book.getDateOfPurchase().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        long overdueDays = ChronoUnit.DAYS.between(borrowDate, today) - 14; //14 günlük gecikme süresi
        if (overdueDays > 0) {
            double totalFine = overdueDays * gunlukGecikmeFiyat;
            System.out.println("Toplam gecikme cezası: " + totalFine + " TL (" + overdueDays + " gün gecikme)");
            return totalFine;
        } else {
            System.out.println("Gecikme bulunmamaktadır.");
            return 0.0;
        }
    }

    public void createBill(Reader reader, double amount){
        Bill bill = new Bill(reader, amount);
        bills.add(bill);
        System.out.println(reader.getName() + " adlı kullanıcı için fatura oluşturuldu: " + amount + " TL");
        bill.displayBill();
    }

    public void returnBook(Library library, Reader reader, Book book){
        System.out.println(reader.getName() + "adlı kullanıcıdan " + book.getName() + "adlı kitabı geri alıyorum.");
        library.takeBackBook(reader, book);
    }

    public void updateBook(Library library, int bookId, String newName, String newAuthor, double newPrice, String newEdition) {
        Book bookToUpdate = null;
        for (Book book : library.getBooks()) {
            if (book.getId() == bookId) {
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate != null) {
            bookToUpdate.setName(newName);
            bookToUpdate.setAuthor(newAuthor);
            bookToUpdate.setPrice(newPrice);
            bookToUpdate.setEdition(newEdition);
            System.out.println("Kitap bilgileri güncellendi.");
        } else {
            System.out.println("Kitap bulunamadı!");
        }
    }

    public void removeBook(Library library, int bookId) {
        Book bookToRemove = null;
        for (Book book : library.getBooks()) {
            if (book.getId() == bookId) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            library.getBooks().remove(bookToRemove);
            System.out.println("Kitap silindi.");
        } else {
            System.out.println("Kitap bulunamadı!");
        }
    }

    public void listBooksByAuthor(Library library, String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                booksByAuthor.add(book);
            }
        }

        if (!booksByAuthor.isEmpty()) {
            System.out.println(authorName + " adlı yazarın kitapları:");
            for (Book book : booksByAuthor) {
                book.display();
                System.out.println("---");
            }
        } else {
            System.out.println(authorName + " adlı yazarın kitabı bulunamadı!");
        }
    }


    @Override
    public void whoYouAre() {
        System.out.println("Ben bir kütüphaneciym ve adım: " + getName());
    }
}
