package library;

import people.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private Map<Integer, Reader> barrowedBooksMap;
    // hangi kitabın hangi okuyucuda olduğunu bulabilmek için map kullanırız.


    public Library() {
        this.books = new ArrayList<>(); // Kitap listesini oluştur
        this.readers = new ArrayList<>(); // Okuyucu listesini oluştur
        this.barrowedBooksMap = new HashMap<>(); // Ödünç kitaplar map'ini oluştur
    }

    public Library(List<Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
        this.barrowedBooksMap = new HashMap<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void newBook(Book book){
        books.add(book);
    }

    public boolean lendBook(Reader reader, Book book) {
        if (books.contains(book) && !barrowedBooksMap.containsKey(book.getId()) && reader.getBarrowedBooks().size() < reader.getMaxBookLimit()) {
            barrowedBooksMap.put(book.getId(), reader);
            book.updateStatus("Ödünç Alındı");
            reader.barrowBook(book);
            System.out.println(reader.getName() + " adlı okuyucu " + book.getName() + " adlı kitabı ödünç aldı.");
            return true;
        } else if (reader.getBarrowedBooks().size() >= reader.getMaxBookLimit()) {
            System.out.println(reader.getName() + "adlı okuyucu kitap limitine ulaştığı için ödünç alamıyor.");
            return false;
        } else if (barrowedBooksMap.containsKey(book.getId())) {
            System.out.println(book.getName() + " adlı kitap zaten ödünç alınmış.");
            return false;
        } else {
            System.out.println("Kitap kütüphanede bulunamadı.");
            return false;
        }
    }

    public void takeBackBook(Reader reader, Book book){
        if(barrowedBooksMap.containsKey(book.getId()) && barrowedBooksMap.get(book.getId()).equals(reader)){
            barrowedBooksMap.remove(book.getId());
            book.updateStatus("Kütüphanede Mevcut");
            reader.returnBook(book);
            System.out.println(reader.getName() + " adlı okuyucu " + book.getName() + " adlı kitabı iade etti.");
        }else{
            System.out.println(book.getName() + " adlı kitap " + reader.getName() + " tarafından ödünç alınmamış.");
        }
    }

    public void showBook(){
        if(books.isEmpty()){
            System.out.println("Kütüphanede hiç kitap bulunmamaktadır.");
        }else{
            System.out.println("Kütüphanedeki Kitaplar:");
            for(Book book : books){
                book.display();
                System.out.println("---");
            }
        }
    }

    public void addReader(Reader reader){
        readers.add(reader);
    }
    public Reader findReader(String readerName) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(readerName)) {
                return reader;
            }
        }
        return null; // Okuyucu bulunamazsa null döndür.
    }

    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null; // Kitap bulunamazsa null döndür.
    }
}
