package COMPARATOR;
import java.util.*;

class Student {
    private String name;
    private int year;
    private double GPA;
    private int credits;

    public Student(String name, int year, double GPA, int credits) {
        this.name = name;
        this.year = year;
        this.GPA = GPA;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getGPA() {
        return GPA;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return String.format("%s %d %.1f %d", name, year, GPA, credits);
    }
}

class BY_GPA_CREDIT_NAME implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (Double.compare(s2.getGPA(), s1.getGPA()) != 0) {
            return Double.compare(s2.getGPA(), s1.getGPA());
        } else if (s2.getCredits() != s1.getCredits()) {
            return s2.getCredits() - s1.getCredits();
        } else {
            return s1.getName().compareTo(s2.getName()); 
        }
    }
}

class BY_BIRTH_GPA_NAME implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getYear() != s2.getYear()) {
            return s1.getYear() - s2.getYear(); // Tăng dần năm sinh
        } else if (Double.compare(s2.getGPA(), s1.getGPA()) != 0) {
            return Double.compare(s2.getGPA(), s1.getGPA()); // Giảm dần GPA
        } else {
            return s1.getName().compareTo(s2.getName()); // Tăng dần tên
        }
    }
}

public class COMPARATOR022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String name = tokens[0];
            int year = Integer.parseInt(tokens[1]);
            double gpa = Double.parseDouble(tokens[2]);
            int credit = Integer.parseInt(tokens[3]);
            list.add(new Student(name, year, gpa, credit));
        }

        String mode = sc.nextLine();

        if (mode.equals("BY_GPA_CREDIT_NAME")) {
            Collections.sort(list, new BY_GPA_CREDIT_NAME());
        } else if (mode.equals("BY_BIRTH_GPA_NAME")) {
            Collections.sort(list, new BY_BIRTH_GPA_NAME());
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
