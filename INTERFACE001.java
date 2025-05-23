interface Packable {
    double weight();
}

class Book implements Packable {
    private String author;
    private String name;
    private double weight;

    public Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return author + ": " + name;
    }
}

class CD implements Packable {
    private String artist;
    private String name;
    private int publicationYear;
    private static final double CD_WEIGHT = 0.1;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        return CD_WEIGHT;
    }

    @Override
    public String toString() {
        return artist + ": " + name + " (" + publicationYear + ")";
    }
}

public class INTERFACE001 {
    public static void main(String[] args) {
        Packable[] items = {
            new Book("Fyodor Dostoevsky", "Crime and Punishment", 2.0),
            new Book("Robert Martin", "Clean Code", 1.0),
            new Book("Kent Beck", "Test Driven Development", 0.5),
            new CD("Pink Floyd", "Dark Side of the Moon", 1973),
            new CD("Wigwam", "Nuclear Nightclub", 1975),
            new CD("Rendezvous Park", "Closer to Being Here", 2012)
        };
        
        for (Packable item : items) {
            System.out.println(item);
        }
    }
}
