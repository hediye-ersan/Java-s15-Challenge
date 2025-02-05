package people;

import library.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;


    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public void newBook(Book book) {
        this.books.add(book);
    }

    public void showBooks() {
        if(books.isEmpty()){
            System.out.println(getName() + "adlı Yazarın kitabı bulunmamaktadır.");
        }else{
            System.out.println(getName() + "adlı yazarın  kitapları:");
            for(Book book : books){
                System.out.println("- " + book.getName());
            }
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir yazarım ve adım: " + getName());
    }
}
