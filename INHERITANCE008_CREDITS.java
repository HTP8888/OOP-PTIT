class Person{
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @Override
    public String toString(){
        return name + " - " + address;
    }
}
class Student extends Person{
    private int credits;

    public Student(String name, String address,int credits) {
        super(name, address);
        this.credits = 0;
    }
    public void Study(){
        credits++;
    }

    public int getCredits() {
        return credits;
    }
    
} 
public class INHERITANCE008_CREDITS {
    public static void main(String[] args) {
        Student st = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028", 0);
        System.out.println(st.toString());
        System.out.println("Study credits "+st.getCredits());
        st.Study();
        System.out.println("Study credits "+st.getCredits());
    }
}
