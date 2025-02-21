import java.util.*;

public class BASIC007 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                int SUM = 0;
                for (int i = L; i <= R; i++) {
                    SUM += i;
                }
                System.out.println(SUM);
            }
        }
    }
}
