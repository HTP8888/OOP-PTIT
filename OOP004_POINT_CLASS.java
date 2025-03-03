import java.util.*;
class point{
    private int x;
    private int y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void move(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
    }

    public double distancetoPoint(point p){
        return Math.sqrt(Math.pow(this.x - p.x, 2)+Math.pow(this.y - p.y, 2));
    }
}
public class OOP004_POINT_CLASS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            point p1 = new point(x1, y1);
            point p2 = new point(x2, y2);
            
            p1.move(1, 1);
            System.out.printf("%.2f\n",p1.distancetoPoint(p2));
        }
        sc.close();
    }
}
