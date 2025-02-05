package library;

public class Magazines extends Book{
    private String publisher;


    public Magazines(String name, String author, String publisher) {
        super(name, author);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Publisher: " + publisher);
    }
}
