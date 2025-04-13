import java.util.*;

public class BASIC022 {
    public static boolean prime_num(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        System.out.println("Primes in the range 2 to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (prime_num(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("Total number of primes in the range: " + count);
        if(!prime_num(count)) {
            System.out.println("The prime count "+count+" is not a prime number.");
        }else{
            System.out.println("The prime count "+count+" is a prime number.");
        }
    }
}
