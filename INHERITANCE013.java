import java.util.*;

abstract class Teacher {
    private String name;
    private double baseSalary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void getInfo() {
        System.out.println("Họ tên: " + name);
    }
}

class PL extends Teacher {
    private double researchAllowance;

    public PL(String name, double baseSalary, double researchAllowance) {
        super(name, baseSalary);
        this.researchAllowance = researchAllowance;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + researchAllowance;
    }

    @Override
    public void getInfo() {
        System.out.println("Loại giảng viên: Permanent");
        System.out.println("Họ tên: " + getName());
        System.out.println("Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

class VL extends Teacher {
    private int teachingHours;
    private double paymentPerHour;

    public VL(String name, int teachingHours, double paymentPerHour) {
        super(name, 0);
        this.teachingHours = teachingHours;
        this.paymentPerHour = paymentPerHour;
    }

    @Override
    public double calculateSalary() {
        return teachingHours * paymentPerHour;
    }

    @Override
    public void getInfo() {
        System.out.println("Loại giảng viên: Visiting");
        System.out.println("Họ tên: " + getName());
        System.out.println("Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type1 = sc.nextLine();
        String name1 = sc.nextLine();
        double value1 = sc.nextDouble();
        double value2 = sc.nextDouble();
        sc.nextLine();
        String type2 = sc.nextLine();
        String name2 = sc.nextLine();
        double value3 = sc.nextDouble();
        double value4 = sc.nextDouble();

        System.out.println("--- Thông tin giảng viên ---");

        if (type1.equals("PermanentLecturer")) {
            PL gv1 = new PL(name1, value1, value2);
            gv1.getInfo();
        } else if (type1.equals("VisitingLecturer")) {
            VL gv1 = new VL(name1, (int) value1, value2);
            gv1.getInfo();
        }

        if (type2.equals("PermanentLecturer")) {
            PL gv2 = new PL(name2, value3, value4);
            gv2.getInfo();
        } else if (type2.equals("VisitingLecturer")) {
            VL gv2 = new VL(name2, (int) value3, value4);
            gv2.getInfo();
        }
    }
}

