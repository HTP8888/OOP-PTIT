class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " - " + address;
    }
}

class Student extends Person {
    private int credits;
    private String studentID;

    public Student(String name, String address, String studentID) {
        super(name, address);
        this.studentID = studentID;
        this.credits = 0;
    }

    public void study() {
        credits++;
    }

    public int getCredits() {
        return credits;
    }
}

public class INHERITANCE003_PEOPLE{
    public static void main(String[] args) {
        Student student = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028", "S12345");
        System.out.println(student);
        System.out.println("Study credits " + student.getCredits());
        student.study();
        System.out.println("Study credits " + student.getCredits());
    }
}