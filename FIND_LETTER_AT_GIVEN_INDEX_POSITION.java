import java.util.*;
public class FIND_LETTER_AT_GIVEN_INDEX_POSITION {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String [] input = sc.nextLine().split(" ");
            // Tach chuoi bang dau cach;
            // Example : Hello 1
            // input[0] = Hello
            // input[1] = 1
            String s = input[0];
            int i = Integer.parseInt(input[1]);// chuyen sang interger
            char c = s.charAt(i);
            System.out.println("The character at position "+ i +" is "+c);      
        }
        sc.close();
    }
}
