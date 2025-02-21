import java.util.Scanner;

public class BASIC003{
    public static boolean nam_nhuan (int n){
        return (n%400==0 || n%4==0 && n%100!=0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            if(nam_nhuan(n)){
                System.out.println(n +" : Leap-year");
            }else{
                System.out.println(n +" : Non Leap-year");
            }
        }
        sc.close();
    }
}