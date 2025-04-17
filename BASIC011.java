import java.util.Scanner;
public class BASIC011 {

    public static int minGap(int[] a) {
        if (a.length < 2) return 0;
        int min = a[1] - a[0];
        for (int i = 1; i < a.length - 1; i++) {
            int diff = a[i + 1] - a[i];
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < numberOfTestCases; t++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
            System.out.println(minGap(numbers));
        }
    }
}
