// ID: 150119761
// Name: Cem Anaral
// Purpose of this program is to define a Book class for Dictionary subclass and to create a library management system.

public class Book {
    private Integer id; // id uniqueness is handled in Library class since it has a list of books
    private String title;
    private Author author;
    private Boolean borrowed = false;

    public Book(Integer id, String title, Author author) throws Exception {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
    }

    public Book(Integer id, String title) throws Exception {
        this.setId(id);
        this.setTitle(title);
    }

    public boolean isBorrowed() {
        // If borrowed, returns true, if it is available returns false
        return this.borrowed;
    }

    public boolean borrowed() {
        // borrows the book. if successful, returns true; returns false if not.
        if (this.isBorrowed())
            return false;
        else {
            this.borrowed = true;
            return true;
        }

    }

    public boolean returned() {
        // returns the book, if successful returns true. if not, returns false
        if (this.isBorrowed()) {
            this.borrowed = false;
            return true;
        }
        else
            return false;
    }

    public String toString() {
        return "Book name is " + this.getTitle() + ", Author is " + this.getAuthor() + ".";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws Exception {
        // ! I handled id uniqueness in Library class since I have an list of books there
        if (id < 0)
            throw new Exception("id must be positive");

        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if (title.length() < 3)
            throw new Exception("Title lenght can not be smaller than 3");
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
