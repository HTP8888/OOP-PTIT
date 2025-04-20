import java.util.*;
import java.util.regex.*;

interface Identifiable {
	String getId();
}

interface Payable {
	double calculateMonthlyPay();
}

class Fulltime implements Identifiable, Payable {
	private String name;
	private String id;
	private double monthlySalary;

	public Fulltime(String name, String id, double monthlySalary) {
		this.name = name;
		this.id = id;
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public double calculateMonthlyPay() {
		return this.monthlySalary;
	}
}

class PartTime implements Identifiable, Payable {
	private String name;
	private String id;
	private double hourlyRate;
	private int hoursWorked;

	public PartTime(String name, String id, double hourlyRate, int hoursWorked) {
		this.name = name;
		this.id = id;
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public double calculateMonthlyPay() {
		return this.hourlyRate * this.hoursWorked;
	}
}

public class INTERFACE022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		List<Payable> employeeList = new ArrayList<>();

		while (t-- > 0) {
			String line = sc.nextLine().trim();
			if (line.equals("Calculate")) break;
			Pattern pattern = Pattern.compile("^(FullTime|PartTime)\\s+\"([^\"]+)\"\\s+(\\S+)\\s+(\\S+)(\\s+(\\S+))?");
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				String type = matcher.group(1);
				String name = matcher.group(2);
				String id = matcher.group(3);

				if (type.equals("FullTime")) {
					double salary = Double.parseDouble(matcher.group(4));
					employeeList.add(new Fulltime(name, id, salary));
				} else if (type.equals("PartTime")) {
					double hourlyRate = Double.parseDouble(matcher.group(4));
					int hoursWorked = Integer.parseInt(matcher.group(6));
					employeeList.add(new PartTime(name, id, hourlyRate, hoursWorked));
				}
			}
		}

		double total = 0.0;
		for (Payable p : employeeList) {
			total += p.calculateMonthlyPay();
		}

		System.out.printf("Total Monthly Payroll: %.2f\n", total);
	}
}
