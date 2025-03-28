import java.util.*;
public class BASIC006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            int dem = 0;
            for(char c:s.toCharArray()){
                if(Character.isDigit(c)){
                    dem++;
                }
            }
            System.out.println(dem);
        }
    }
}
