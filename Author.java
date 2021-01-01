// ID: 150119761
// Name: Cem Anaral
// Purpose of this program is to define a Person class for a library management system.

public class Author extends Person {
    private String publisher; // Publisher: A company that publishes an author's books.

    public Author(String name, String publisher, Integer birthDate) throws Exception {
        super(name, birthDate);
        setPublisher(publisher);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws Exception {
        if (publisher.length() < 3)
            throw new Exception("Publisher can not be less than 3");

        this.publisher = publisher;
    }

    public String toString() {
        return "Author is " + this.getName();
    }
}
