import java.util.*;
public class FIRST_CHARACTER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] s = sc.nextLine().split(" ");
            String i = "";
            for(String words:s){
                for(char c : words.toCharArray()){
                    if(Character.isUpperCase(c)){
                        i+=c;
                    }
                }
            }
            System.out.println("My initials are: "+i);
        }
    }
}
