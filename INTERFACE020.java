import java.util.*;
interface checkID{
   String getId();
}
class Human implements checkID{
    private String name;
    private int age;
    private String ID;
    public Human(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    @Override
    public String getId() {
        return this.ID;
    }
}
class Robot implements checkID{
    private String model;
    private String ID;
    public Robot(String model,String ID){
        this.model = model;
        this.ID = ID;
    }
    public String getModel(){
        return this.model;
    }
    @Override
    public String getId(){
        return this.ID;
    }
}

public class INTERFACE020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        List<checkID>list = new ArrayList<>();
        while(true){
            String s = sc.nextLine();
            if(s.equals("End")){
                break;
            }
            String[] parts = s.trim().split("\\s+");
            if(parts[0].equals("Human")){
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String ID = parts[3];
                list.add(new Human(name, age, ID));
            }else if(parts[0].equals("Robot")){
                String model = parts[1];
                String ID = parts[2];
                list.add(new Robot(model,ID));
            }
        }
        String checker = sc.nextLine();
        for(checkID i : list){
            if(i.getId().endsWith(checker)){
                System.out.println(i.getId());
            }
        }
    }
}
