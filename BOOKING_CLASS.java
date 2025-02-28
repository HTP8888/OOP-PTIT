import java.util.*;
class flightbooking {
    private static int seatAvailable = 180;
    
    public static int GSA() { // Get Seat AVailable
        return seatAvailable;
    }
    
    public static void SSA(int seatAvailable) { // Set Seat AVailable
        flightbooking.seatAvailable = seatAvailable;
    }
}
public class BOOKING_CLASS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        while (t-- > 0) {
            flightbooking.SSA(180);
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            
            for (int i = 0; i < arr.length; i += 2) {
                String userId = arr[i];
                String action = arr[i + 1];
                
                if ("Booking".equals(action)) {
                    flightbooking.SSA(flightbooking.GSA() - 1);
                    System.out.printf("[Seat Available: %d]", flightbooking.GSA());
                } else if ("Confirmed".equals(action)) {
                    System.out.printf("--User %s Confirmed--[Seat Available: %d]", userId, flightbooking.GSA());
                } else if ("Cancel".equals(action)) {
                    flightbooking.SSA(flightbooking.GSA() + 1);
                    System.out.printf("[Seat Available: %d]", flightbooking.GSA());
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
}
