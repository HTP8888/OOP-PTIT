import java.util.*;

public class BASIC021 {
    public static long Giaithua(int n){
        long giaithua = 1;
        for(int i = 1; i <= n; i++){
            giaithua *= i;
        }
        return giaithua;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long tonggiaithua = 0;
        System.out.println("Factorials of numbers from 1 to "+n+":");
        for(int i = 1; i <= n; i++){
            long gt = Giaithua(i);
            System.out.println(i+"! = "+gt);
            tonggiaithua += gt;
        }
        System.out.println("The sum of these factorials is: "+tonggiaithua);
    }
}
