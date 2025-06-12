package exception;
import java.util.*;

class Amount {
    private String currency;
    private int amount;

    public Amount(int amount, String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getAmount() {
        return this.amount;
    }

    public Amount add(Amount other) throws Exception {
        if (!this.currency.equals(other.currency)) {
            throw new Exception("Currency doesn't match");
        }
        return new Amount(this.amount + other.amount, this.currency);
    }

    @Override 
    public String toString() {
        return amount + "";
    }
}

public class EXCEPTION001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            if (parts.length != 4) {
                System.out.println("Invalid input format");
                continue;
            }
            String currency1 = parts[0];
            int amount1 = Integer.parseInt(parts[1]);
            String currency2 = parts[2];
            int amount2 = Integer.parseInt(parts[3]);

            Amount obj1 = new Amount(amount1, currency1);
            Amount obj2 = new Amount(amount2, currency2);
            try {
                Amount result = obj1.add(obj2);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
