import java.util.*;
class stringSplosion{
    private String s;

    public stringSplosion(String s) {
        this.s = s;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i =1 ; i <= s.length();i++){
            sb.append(s.substring(0,i));
        }
        return sb.toString();
    }
}
public class STRING009 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            stringSplosion sS = new stringSplosion(s);
            System.out.println(sS);
        }
    }
}
