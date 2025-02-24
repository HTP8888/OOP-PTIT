
import java.util.Scanner;

public class BASIC009 {
    public static int xacDinhGocPhanTu(double  x,double  y){
        if(x==0||y==0)return 0;
        if(x>0&&y>0) return 1;
        if(x<0&&y>0) return 2;
        if(x<0&&y<0) return 3;
        return 4;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            double x=sc.nextDouble();
            double y=sc.nextDouble();
            System.out.println(xacDinhGocPhanTu(x, y));
        }
        sc.close();
    }
}
