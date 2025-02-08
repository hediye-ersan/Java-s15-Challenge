import library.Book;
import library.Library;
import library.MemberRecord;
import people.Author;
import people.Librarian;
import people.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Kütüphane oluştur
        Library library = new Library();

        // Yazarlar oluştur
        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("George Orwell");

        // Kitapları oluştur ve yazarlara ekle
        Book book1 = new Book("Harry Potter", author1.getName());
        Book book2 = new Book("1984", author1.getName());
        Book book3 = new Book("Animal Farm", author2.getName());
        Book book4 = new Book("Anna Karanina1", author2.getName());
        Book book5 = new Book("Anna Karanina2", author2.getName());
        Book book6 = new Book("Harry Potter2", author1.getName());

        author1.newBook(book1);
        author1.newBook(book2);
        author2.newBook(book3);
        author2.newBook(book4);
        author2.newBook(book5);
        author1.newBook(book6);

        // Kütüphaneye kitapları ekler
        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);
        library.newBook(book4);
        library.newBook(book5);
        library.newBook(book6);

        // Kütüphaneci oluşturur
        Librarian librarian = new Librarian("Ahmet", "1234");

        // Üye oluşturur ve iki kitap ödünç almasını sağlar
        MemberRecord memberRecord = new MemberRecord(1);
        Reader reader = new Reader("Hediye", memberRecord, new ArrayList<>(), new ArrayList<>(), 5);
        library.lendBook(reader, book1);
        library.lendBook(reader, book2);



        while(true){
            System.out.println("\nKütüphane Yönetim Sistemine Hoşgeldiniz!");
            System.out.println("1. Kütüphaneci Girişi");
            System.out.println("2. Okuyucu Girişi");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    librarianMenu(scanner, librarian, library);
                    break;
                case 2:
                    readerMenu(scanner, reader, library);
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }
    public static void librarianMenu(Scanner scanner, Librarian librarian, Library library) {
        System.out.print("Şifreyi giriniz: ");
        String password = scanner.nextLine();
        if (!password.equals(librarian.getPassword())) {
            System.out.println("Yanlış şifre! Menüye geri dönülüyor...");
            return;
        }
        while (true) {
            System.out.println("\nKütüphaneci Menüsü");
            System.out.println("1. Kitap Ara");
            System.out.println("2. Kitap Ödünç Ver");
            System.out.println("3. Kitap İade Al");
            System.out.println("4. Yeni Kitap Ekle");
            System.out.println("5. Kitap Bilgilerini Güncelle");
            System.out.println("6. Kitap Sil");
            System.out.println("7. Yazarın Tüm Kitaplarını Listele");
            System.out.println("8. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Aramak istediğiniz kitabın adını giriniz: ");
                    String bookName = scanner.nextLine();
                    librarian.searchBook(library, bookName);
                    break;
                case 2:
                    System.out.print("Okuyucunun adını girin: ");
                    String readerName = scanner.nextLine();
                    Reader reader = library.findReader(readerName); // Okuyucuyu bul
                    if (reader == null) {
                        System.out.println("Okuyucu bulunamadı.");
                        break; // Okuyucu bulunamazsa, ödünç verme işlemine devam etmeyin.
                    }

                    System.out.print("Ödünç verilecek kitabın adını girin: ");
                    String bookToLendName = scanner.nextLine();
                    Book bookToLend = library.findBook(bookToLendName); // Kitabı bul
                    if (bookToLend == null) {
                        System.out.println("Kitap bulunamadı.");
                        break; // Kitap bulunamazsa, ödünç verme işlemine devam etmeyin.
                    }

                    boolean success = librarian.issueBook(library, reader, bookToLend); // Doğru kitap nesnesini verin.
                    if (success) {
                        System.out.println("Kitap başarıyla ödünç verildi.");
                    } else {
                        System.out.println("Kitap ödünç verme işlemi başarısız oldu.");
                    }
                    break;
                case 3:
                    System.out.print("Okuyucunun adını girin: "); // Okuyucu adını alın
                    String returnReaderName = scanner.nextLine();
                    Reader returnReader = library.findReader(returnReaderName); // Okuyucuyu bulun
                    if (returnReader == null) {
                        System.out.println("Okuyucu bulunamadı.");
                        break;
                    }

                    System.out.print("İade edilecek kitabın adını girin: ");
                    String returnBookName = scanner.nextLine();
                    Book returnBook = library.findBook(returnBookName);
                    if (returnBook == null) {
                        System.out.println("Kitap bulunamadı!");
                        break;
                    }

                    librarian.returnBook(library, returnReader, returnBook); // Okuyucu nesnesini kullanın.
                    break;
                case 4:
                    System.out.print("Yeni kitabın adını girin: ");
                    String newBookName = scanner.nextLine();
                    System.out.print("Yazarın adını girin: ");
                    String author = scanner.nextLine();
                    library.newBook(new Book(newBookName, author));
                    System.out.println("Kitap başarıyla eklendi!");
                    break;
                case 5: // Kitap Güncelle
                    System.out.print("Güncellenecek kitabın ID'sini girin: ");
                    int updateBookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Yeni Kitap Adı: ");
                    String updateBookName = scanner.nextLine();

                    System.out.print("Yeni Yazar: ");
                    String newBookAuthor = scanner.nextLine();

                    System.out.print("Yeni Fiyat: ");
                    double newBookPrice = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Yeni Edisyon: ");
                    String newBookEdition = scanner.nextLine();

                    librarian.updateBook(library, updateBookId, updateBookName, newBookAuthor, newBookPrice, newBookEdition);
                    break;
                case 6: // Kitap Sil
                    System.out.print("Silinecek kitabın ID'sini girin: ");
                    int deleteBookId = scanner.nextInt();
                    librarian.removeBook(library, deleteBookId);
                    break;
                case 7:
                    System.out.print("Yazarın adını girin: ");
                    String authorName = scanner.nextLine();
                    librarian.listBooksByAuthor(library, authorName);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    public static void readerMenu(Scanner scanner, Reader reader, Library library) {
        while (true) {
            System.out.println("\nOkuyucu Menüsü");
            System.out.println("1. Ödünç Aldığım Kitapları Göster");
            System.out.println("2. Satın Aldığım Kitapları Göster");
            System.out.println("3. Kitap Ödünç Al");
            System.out.println("4. Kitap İade Et");
            System.out.println("5. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reader.showBarrowedBook();
                    break;
                case 2:
                    reader.showPurchasedBook();
                    break;
                case 3:
                    System.out.print("Ödünç almak istediğiniz kitabın adını girin: ");
                    String borrowBookName = scanner.nextLine();
                    Book bookToBorrow = library.findBook(borrowBookName); // Kitap nesnesini bul
                    if (bookToBorrow != null) { // Kitap bulunduysa
                        reader.barrowBook(bookToBorrow); // Kitap nesnesini metoda geçir
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;
                case 4:
                    System.out.print("İade edilecek kitabın adını girin: ");
                    String returnBookName = scanner.nextLine();
                    Book bookToReturn = library.findBook(returnBookName); // Kitap nesnesini bul
                    if (bookToReturn != null) { // Kitap bulunduysa
                        reader.returnBook(bookToReturn); // Kitap nesnesini metoda geçir
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}