// ID: 150119761
// Name: Cem Anaral
// The most important class in this project.
// Purpose is to manage booking, returning, adding books and customers.


import java.util.ArrayList;

public class Library {
    private String address;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Library(String address) throws Exception {
        setAddress(address);
    }

    public static void printOpeningHours() {
        System.out.println("9 AM to 5 PM");
    }

    public void printAddress() {
        System.out.println(getAddress());
    }

    public Boolean addBook(Book book) {
        // If book id is unique, adds it
        Integer book_id = book.getId();
        for (Book obj: books) {
            if (book_id.equals(obj.getId()))
                return false;
        }
        books.add(book);
        return true;
    }

    public void addCustomer(Customer customer) {
        // If customer is not already added, adds it.
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public void borrowBook(String bookName, String personName) {
        // finds Customer by personName
        Customer customer = null;
        for (Customer obj : customers) {
            if (obj.getName().equals(personName)) {
                customer = obj;
                break;
            }
        }

        // finds all Books which are equal to bookName
        Book book = null;
        ArrayList<Book> bookQuery = new ArrayList<>();
        for (Book obj : books) {
            if (obj.getTitle().equals(bookName)) {
                bookQuery.add(obj);
            }
        }

        // get the book from query
        if (bookQuery.size() > 0) {
            book = bookQuery.get(0);
            for (Book book_queried : bookQuery) {
                if (!book_queried.isBorrowed())
                    book = book_queried;
            }
        }

        // if book or customer could not be found, prints warning
        if (customer == null) {
            System.out.println("Sorry, " + personName + " is not a customer.");
            return;
        } else if (book == null) {
            System.out.println("Sorry, this book is not in our catalog");
            return;
        }

        // if customer has already borrowed a book, prints warning
        if (customer.getBorrowABook()) {
            System.out.println("Customer has already borrowed a book!");
            return;
        }

        // change book's state to borrowed if it is not already been borrowed
        // .borrowed() method also performs check
        if (!book.borrowed()) {
            System.out.println("Book is borrowed by someone else.");
            return;
        }

        // add book to the customer
        customer.setBorrowedBook(book);
        customer.setBorrowABook(true);

        // prints successful message
        System.out.println(customer.getName() + " has successfully borrowed " + book.getTitle());
    }

    public void returnBook(String personName) {
        // find Customer obj by personName
        Customer customer = null;
        for (Customer obj : customers) {
            if (obj.getName().equals(personName)) {
                customer = obj;
                break;
            }
        }

        // if customer does not exists, prints warning
        if (customer == null) {
            System.out.println("Sorry, " + personName + " is not a customer.");
            return;
        }

        // gets the book object
        Book book = customer.getBorrowedBook();

        // if customer did not borrow a book, print message
        if (book == null) {
            System.out.println("Sorry, " + personName + " did not borrow a book.");
            return;
        }

        // return the book from book obj itself
        book.returned();


        // return the book from customer obj
        customer.setBorrowedBook(null);
        customer.setBorrowABook(false);

        // print successful message
        System.out.println(customer.getName() + " has successfully returned " + book.getTitle());
    }

    public void printAvailableBooks() {
        // traverses the books list and prints book credentials if it is available
        int c = 0;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
                c += 1;
            }
        }
        if (c == 0)
            System.out.println("No book in catalog.");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (address.length() < 3)
            throw new Exception("Address length must be bigger than 3");

        this.address = address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
