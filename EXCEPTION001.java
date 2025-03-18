import java.util.*;

class Amount {
    private String currency;
    private int amount;

    public Amount(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
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
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String currency1 = sc.next();
            int amount1 = sc.nextInt();
            String currency2 = sc.next();
            int amount2 = sc.nextInt();
            sc.nextLine(); 
            Amount amountObj1 = new Amount(amount1, currency1);
            Amount amountObj2 = new Amount(amount2, currency2);
            try {
                Amount result = amountObj1.add(amountObj2);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}