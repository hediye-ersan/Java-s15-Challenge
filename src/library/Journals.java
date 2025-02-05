package library;

public class Journals extends Book{
    private String topic;


    public Journals(String name, String author, String topic) {
        super(name, author);
        this.topic = topic;
    }

    public String getTopic(){
        return topic;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Topic: " + topic);
    }
}
