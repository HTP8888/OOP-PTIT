import java.util.*;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[name=" + name + ", " + author.toString() + ", price=" + price + ", qty=" + qty + "]";
    }
}

public class OOP12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String type = sc.nextLine();

            if (type.equals("Book")) {
                String bookName = sc.nextLine();
                double price = Double.parseDouble(sc.nextLine());
                int qty = Integer.parseInt(sc.nextLine());

                String authorType = sc.nextLine();
                if (!authorType.equals("Author")) {
                    System.out.println("Invalid input!");
                    return;
                }

                String authorName = sc.nextLine();
                String authorEmail = sc.nextLine();
                char gender = sc.nextLine().charAt(0);

                try {
                    Author author = new Author(authorName, authorEmail, gender);
                    Book book = new Book(bookName, author, price, qty);
                    System.out.println(book);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (type.equals("End")) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
        sc.close();
    }
}
