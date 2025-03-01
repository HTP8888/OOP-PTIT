import java.text.DecimalFormat;
import java.util.Scanner;

abstract class CAR {
    protected double price;
    protected int year;
    protected static double maxsaleprice = 0;

    public CAR(double price, int year) {
        this.price = price;
        this.year = year;
    }

    public abstract double calculatesaleprice();

    @Override
    public String toString() {
        double saleprice = calculatesaleprice();
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "Price: " + df.format(saleprice) + " VND | Year: " + year;
    }

    public static String getmaxsaleprice() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "Most Expensive: " + df.format(maxsaleprice) + " VND";
    }
}

class SPORT_CAR extends CAR {
    public SPORT_CAR(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculatesaleprice() {
        double saleprice;
        if (year > 2018) {
            saleprice = price * 0.8;
        } else if (year > 2010) {
            saleprice = price * 0.5;
        } else {
            saleprice = price * 0.1;
        }
        if (saleprice > maxsaleprice) {
            maxsaleprice = saleprice;
        }
        return saleprice;
    }
}

class CLASSIC_CAR extends CAR {
    public CLASSIC_CAR(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculatesaleprice() {
        double saleprice = price * 1.12 + 20000000;
        if (saleprice > maxsaleprice) {
            maxsaleprice = saleprice;
        }
        return saleprice;
    }
}

public class CLASS_CAR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            double price = Double.parseDouble(input[1]);
            int year = Integer.parseInt(input[2]);

            CAR car;
            if (type.equals("SC")) {
                car = new SPORT_CAR(price, year);
            } else {
                car = new CLASSIC_CAR(price, year);
            }
            System.out.println(car);
        }
        System.out.println(CAR.getmaxsaleprice());
        sc.close();
    }
}
