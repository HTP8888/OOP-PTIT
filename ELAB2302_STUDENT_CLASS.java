import java.util.*;

class Student {
    private String name;
    private int age;
    public static int numberOfStudent = 0; // Đổi tên biến cho chuẩn Java

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfStudent++; // Tăng biến đếm mỗi khi tạo sinh viên mới
    }

    public void display() {
        if (this.age >= 18) { // Sửa điều kiện từ > thành >=
            System.out.println(this.name);
        }
    }
}

public class ELAB2302_STUDENT_CLASS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            if (!sc.hasNextInt()) break; // Kiểm tra nếu dòng tiếp theo không phải số thì thoát

            int age = Integer.parseInt(sc.nextLine());
            Student st = new Student(name, age);
            st.display();
        }

        System.out.println(Student.numberOfStudent); // Sử dụng tên biến mới
        sc.close();
    }
}
