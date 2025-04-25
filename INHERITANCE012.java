import java.util.*;
abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void getInfo() {
        System.out.println(this.getName());
    }

    public double calculateSalary() {
        return salary;
    }
}

class FTE extends Employee {
    private double bonus;

    public FTE(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getSalary() + bonus;
    }

    public void getInfo() {
        System.out.println("Loại: FullTime");
        System.out.println("Họ tên: " + getName());
        System.out.println("Lương cơ bản: " + String.format("%.1f", getSalary()));
        System.out.println("Thưởng: " + String.format("%.1f", bonus));
        System.out.println("=> Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

class PTE extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PTE(String name, int hoursWorked, double hourlyRate) {
        super(name, 0); 
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public void getInfo() {
        System.out.println("Loại: PartTime");
        System.out.println("Họ tên: " + getName());
        System.out.println("Số giờ làm việc: " + hoursWorked + " giờ");
        System.out.println("Tiền công mỗi giờ: " + String.format("%.1f", hourlyRate));
        System.out.println("=> Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

public class INHERITANCE012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type1 = sc.nextLine();
        String name1 = sc.nextLine();
        double val1 = sc.nextDouble();
        double val2 = sc.nextDouble();
        sc.nextLine(); 
        String type2 = sc.nextLine();
        String name2 = sc.nextLine();
        double val3 = sc.nextDouble();
        double val4 = sc.nextDouble();

        System.out.println("--- Thông tin nhân viên ---");

        if (type1.equals("FullTime")) {
            FTE e1 = new FTE(name1, val1, val2);
            e1.getInfo();
        } else if (type1.equals("PartTime")) {
            PTE e1 = new PTE(name1, (int) val1, val2);
            e1.getInfo();
        }

        System.out.println();

        if (type2.equals("FullTime")) {
            FTE e2 = new FTE(name2, val3, val4);
            e2.getInfo();
        } else if (type2.equals("PartTime")) {
            PTE e2 = new PTE(name2, (int) val3, val4);
            e2.getInfo();
        }
    }
}
