import java.util.*;

public class PANGRAM {
    public boolean isPangram(String s) {
        if (s.length() < 26) {
            return false;
        }
        Set<Character> charset = new HashSet<>();
        for (char c : s.toCharArray()) {
            charset.add(c);
        }
        return charset.size() == 26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        PANGRAM checker = new PANGRAM();
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println(checker.isPangram(s));
        }
        sc.close();
    }
}
