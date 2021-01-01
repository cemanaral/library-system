// ID: 150119761
// Name: Cem Anaral
// Purpose of this program is to define a Customer class (which is a subclass for Person class) for a library management system.

public class Customer extends Person {
    private String address;
    private Book borrowedBook; // Stores borrowed book
    private Boolean borrowABook = false; // Tells that if the customer borrows a book

    public Customer(String name, String birthPlace, Integer birthDate, String address) throws Exception {
        super(name, birthDate, birthPlace);
        setAddress(address);
    }

    public Customer(String name, Integer birthDate, String address) throws Exception {
        super(name, birthDate);
        setAddress(address);
    }

    public Customer(String name, String address) throws Exception {
        super(name);
        setAddress(address);
    }

    public Customer(String name, Integer birthDate) throws Exception {
        super(name, birthDate);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (address.length() < 3)
            throw new Exception("Address lenght can not me smaller than 3");

        this.address = address;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public Boolean getBorrowABook() {
        return borrowABook;
    }

    public void setBorrowABook(Boolean borrowABook) {
        this.borrowABook = borrowABook;
    }

    public String toString() {
        return "Name: " + getName() + ", Birthdate: " + getBirthDate() + ", Birth Place: " + getBirthPlace()
                + "\n\tAddress: " + getAddress() + ".";
    }
}
