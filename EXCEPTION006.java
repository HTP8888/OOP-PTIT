import java.util.*;                           

class NotContainVowelException extends Exception{
	public NotContainVowelException(String message) {
		super(message);
	}
}
public class Main {
	public static void checkNguyenAm(String s) throws NotContainVowelException {
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='a'||c=='e'||c=='o'||c=='i'||c=='u') {
				System.out.println("String has vowels");
				return;
			}
		}throw new NotContainVowelException("String not contain vowels");
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0) {
			String s = sc.nextLine();
			try {
				checkNguyenAm(s);
			}catch(NotContainVowelException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}
}
