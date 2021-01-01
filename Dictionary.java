// ID: 150119761
// Name: Cem Anaral
// Purpose of this program is to define a Dictionary class for a library management system.

public class Dictionary extends Book {
    private Integer definitions; // It is the count of defined words in the dictionary.

    public Dictionary(Integer id, String title, Author author, Integer definitions) throws Exception {
        super(id, title, author);
        this.setDefinitions(definitions);
    }

    public Dictionary(Integer id, String title, Integer definitions) throws Exception {
        super(id, title);
        this.setDefinitions(definitions);
    }

    public Integer getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Integer definitions) throws Exception {
        if (definitions<0)
            throw new Exception("Definitions must be positive");

        this.definitions = definitions;
    }

    public String toString() {
        return "Dictionary Name is " + this.getTitle() + ", definitions: " + this.getDefinitions();
    }
}
