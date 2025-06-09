package exception;
import java.util.*;

class UsedCarException extends Exception {
    public UsedCarException(String vin) {
        super(vin);
    }
}

class UsedCar {
    private String vin;
    private String make;
    private int year;
    private int mileage;
    private double price; 
    public UsedCar(String vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (!vin.matches("\\d{4}")) {
            throw new UsedCarException(vin);
        }
        if (!(make.equals("Ford") || make.equals("Honda") || make.equals("Toyota") || make.equals("Chrysler"))) {
            throw new UsedCarException(vin);
        }
        if (year < 1990 || year > 2014) {
            throw new UsedCarException(vin);
        }
        if (mileage < 0) {
            throw new UsedCarException(vin);
        }
        if (price < 0) {
            throw new UsedCarException(vin);
        }
        this.vin = vin;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "UsedCar{vin='%s', make='%s', year=%d, mileage=%d, price=%.1f}",
                vin, make, year, mileage, price
        );
    }
}

public class EXCEPTION003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		List<UsedCar>list = new ArrayList<>();
		while(t-- > 0) {
			String line = sc.nextLine();
			String[] parts = line.split(",");
			String VIN = parts[0].trim();
			String make = parts[1].trim();
			int year = Integer.parseInt(parts[2].trim());
			int mileage = Integer.parseInt(parts[3].trim());
			double price = Double.parseDouble(parts[4].trim());
			try {
				UsedCar car = new UsedCar(VIN,make,year,mileage,price);
				list.add(car);
			}catch(UsedCarException e) {
				System.out.println("Invalid UsedCar: VIN "+e.getMessage());
			}
		}
		System.out.println("List of successfully constructed UsedCar objects:");
		if(list.isEmpty()) {
			System.out.println("No used cars");
		}else {
			for(UsedCar car : list ) {
				System.out.println(car);
			}
		}
	}
}
