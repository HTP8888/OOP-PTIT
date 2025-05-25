import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] s = line.trim().split("\\s+");
            HashMap<Integer, Integer> valueCount = new HashMap<>();
            for (int i = 1; i < s.length; i += 2) {
                int value = Integer.parseInt(s[i]);
                valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
            }
            int minFrequency = Collections.min(valueCount.values());
            int minValue = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
                if (entry.getValue() == minFrequency) {
                    minValue = Math.min(minValue, entry.getKey());
                }
            }
            System.out.println(minValue);
        }
        sc.close();
    }
}
