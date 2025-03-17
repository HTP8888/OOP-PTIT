import java.util.*;
interface Movable{
    void move(int dx,int dy);
}
class Organism implements Movable{
    private int x;
    private int y;
    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public void move(int dx,int dy){
        x+=dx;
        y+=dy;
    }
    @Override
    public String toString(){
        return "x:"+x+";"+"y:"+y;
    }
}
class Herd{
    private ArrayList<Movable>organisms;
    public Herd(){
        organisms = new ArrayList<>();
    }
    public void addtoHerd(Movable mvb){
        organisms.add(mvb);
    }
    public void move(int dx, int dy){
        for(Movable mvb: organisms){
            mvb.move(dx, dy);
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Movable mvb : organisms){
            sb.append(mvb.toString()).append("\n");
        }
        return sb.toString();
    }
}
public class INTERFACE002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Herd herd = new Herd();
        while(t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            herd.addtoHerd(new Organism(x, y));
        }
        herd.move(1, 1);
        System.out.println(herd.toString());
    }
}
