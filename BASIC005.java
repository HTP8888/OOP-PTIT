import java.util.*;
public class BASIC005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            int n4 = sc.nextInt();
            int n5 = sc.nextInt();
            int sum = n1 + n2 + n3 + n4 + n5;
            System.out.println(sum);
        }
        sc.close();
    }
}
