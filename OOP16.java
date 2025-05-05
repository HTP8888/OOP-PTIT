

import java.util.*;

interface Callable {
    void call();
}

interface Browsable {
    void browse();
}

class SmartPhone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public SmartPhone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public void call() {
        for (String number : numbers) {
            if (isValidNumber(number)) {
                System.out.println("Calling... " + number);
            } else {
                System.out.println("Invalid number!");
            }
        }
    }

    @Override
    public void browse() {
        for (String url : urls) {
            if (containsDigit(url)) {
                System.out.println("Invalid URL!");
            } else {
                System.out.println("Browsing: " + url + "!");
            }
        }
    }

    private boolean isValidNumber(String number) {
        for (char c : number.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean containsDigit(String url) {
        for (char c : url.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
}

public class OOP16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String [] PhoneNumbers = sc.nextLine().split(" ");
            List<String> numbers = new ArrayList<>(Arrays.asList(PhoneNumbers));
            String [] URLS = sc.nextLine().split(" ");
            List<String> urls = new ArrayList<>(Arrays.asList(URLS));
            SmartPhone smp = new SmartPhone(numbers, urls);
            smp.call();
            smp.browse();
        }
    }
}
