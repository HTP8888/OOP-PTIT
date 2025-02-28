import java.util.Scanner;

public class STRING005_LONGESTSTRING {
    public static String dainhat(String s){
        if(s == null || s.trim().isEmpty()){
            return "";
        }
        String []words = s.split("\\s+");
        String longestString = "";
        for(String word : words){
            if(word.length() >= longestString.length()){
                longestString = word;
            }
        }
        return longestString;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String sen = sc.nextLine();
            System.out.println(dainhat(sen));
        }
        sc.close();
    }
}
