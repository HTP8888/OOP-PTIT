import java.util.*;
class Work{
    private String name;
    private int priority;
    private int time;
    public Work(String name, int priority, int time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }
    public int getTime() {
        return time;
    }
    public String toString(){
        return name +" "+ priority +" "+ time;
    }
}
class BY_PRIORITY implements Comparator<Work>{
    public int compare(Work w1, Work w2){
        if(w1.getPriority() == w2.getPriority()&& w1.getTime() != w2.getTime()){
            return w1.getTime() - w2.getTime();
        }else if(w1.getPriority() == w2.getPriority() && w1.getTime() == w2.getTime()){
            return w1.getName().compareTo(w2.getName());
        }else{
            return w1.getPriority() - w2.getPriority();
        }
    }
}
public class COMPARATOR021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Work> list = new ArrayList<Work>();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split(" ");
            list.add(new Work(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        }
        Collections.sort(list,new BY_PRIORITY());
        System.out.println(list.get(0));
    }
}
