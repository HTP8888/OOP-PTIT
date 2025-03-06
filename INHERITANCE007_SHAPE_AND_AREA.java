import java.util.*;

abstract class Shape{
    private String name;

    public Shape(String name) {
        this.name = name;
    }
    abstract public double calculateArea();
    public void displayInfor(){
       System.out.printf("Shape:%s|Area:%.2f\n",this.name,this.calculateArea());
    }
}
class Rectange extends Shape{
    private double width,length;

    public Rectange(double length, double width, String name) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double  calculateArea(){
        return this.length*this.width;
    }
}
class Circle extends Shape{
   private double radius;

    public Circle(double radius, String name) {
        super(name);
        this.radius = radius;
    }
    @Override
    public double  calculateArea(){
        return Math.PI*this.radius*this.radius;
    }

}
public class INHERITANCE007_SHAPE_AND_AREA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            if(s.equals("Rectangle")){
                double x=sc.nextDouble();
                double y=sc.nextDouble();
                Rectange rec=new Rectange(x, y, s);
                rec.displayInfor();
            }
            else{
                double x=sc.nextDouble();
                Circle cir=new Circle(x, s);
                cir.displayInfor();
            }
        }
        sc.close();
    }
}
