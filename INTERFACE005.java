import java.util.*;
interface Identifiable{
    public String getID();
}
interface Birthable{
    public String getBirthDate();
}
class Citizen implements Identifiable ,Birthable{
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(int age, String birthDate, String id, String name) {
        this.age = age;
        this.birthDate = birthDate;
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public String getID(){
        return id;
    }

    @Override
    public String getBirthDate(){
        return birthDate;
    }
    
}
class Pet implements Birthable{
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate(){
        return birthDate;
    }
}
public class INTERFACE005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        List<Birthable> birthables = new ArrayList<>();
        
        while (true) {
            String line = sc.nextLine();
            if (line.equals("End")) {
                break;
            }
            
            String[] parts = line.split(" ");
            if (parts[0].equals("Citizen")) {
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String id = parts[3];
                String birthDate = parts[4];
                birthables.add(new Citizen(age, birthDate, id, name));
            } else if (parts[0].equals("Pet")) {
                String name = parts[1];
                String birthDate = parts[2];
                birthables.add(new Pet(name, birthDate));
            }
        }
        
        int year = Integer.parseInt(sc.nextLine());
        sc.close();
        
        boolean found = false;
        for (Birthable b : birthables) {
            if (b.getBirthDate().endsWith("/" + year)) {
                System.out.println(b.getBirthDate());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("");
        }
    }
}
