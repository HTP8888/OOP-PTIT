import java.util.*;
public class BASIC010_SWAP_DES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            char[] arr = sc.next().toCharArray();
            for(int i = (arr.length %2 ==0)?0:1; i< arr.length -1 ; i+=2){
                char temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            System.out.println(new String(arr));

        }
        sc.close();
    }
}
