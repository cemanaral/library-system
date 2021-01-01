// ID: 150119761
// Name: Cem Anaral
// Purpose of this program is to define a Person class for Author and Customer subclasses
// (and to leverage a library management system)

public class Person {
    private String name;
    private String birthDate;
    private String birthPlace;

    public Person(String name, Integer birthDate, String birthPlace) throws Exception {
        setName(name);
        setBirthDate(birthDate); // Stores as String
        setBirthPlace(birthPlace);
    }

    public Person(String name, Integer birthDate) throws Exception {
        setName(name);
        setBirthDate(birthDate);
    }

    public Person(String name) throws Exception {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() < 3)
            throw new Exception("Name lenght must be bigger than 3");
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) throws Exception {
        if (birthDate < 0)
            throw new Exception("birthDate must be positive");

        // Must be stored in String type.
        this.birthDate = Integer.toString(birthDate);
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String toString() {
        return "Name: " + getName() + ", Birth date: " + getBirthDate() + ", Birth Place: " + getBirthPlace();
    }
}
