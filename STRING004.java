import java.util.*;
public class STRING004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer(s);
            int m = sb.length();
            System.out.println(m);
        }
        sc.close();
    }
}
