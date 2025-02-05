package library;

public class StudyBooks extends Book{
    private String lesson;

    public StudyBooks(String name, String author, String lesson) {
        super(name, author);
        this.lesson = lesson;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Lesson: " + lesson);
    }
}
