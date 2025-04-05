package eduptit;
import java.util.*;
import java.math.*;
public class LAB01_Bigint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		sc.nextLine();
		while(t-- >0) {
			String[] s = sc.nextLine().trim().split(" ");
			BigInteger a = new BigInteger(s[0]);
			String dau = s[1];
			BigInteger b = new BigInteger(s[2]);
			BigInteger ans;
			if(dau.equals("+")) {
				ans = a.add(b);
			}else if(dau.equals("-")) {
				ans = a.subtract(b);
			}else if (dau.equals("*")) {
				ans = a.multiply(b);
			}else {
				continue;
			}
			System.out.println(ans);
		}
		sc.close();
	}
	
}
