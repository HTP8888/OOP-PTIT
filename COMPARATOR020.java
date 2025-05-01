import java.util.*;
class Product{
    public String name;
    public int price;
    public int stock;
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public String toString(){
        return name + " " + price + " " + stock;
    }

}
class BY_NAME implements Comparator<Product>{
    public int compare(Product p1, Product p2){
        int nameCompare = p1.getName().compareTo(p2.getName());
        return nameCompare;
    }
}
class BY_PRICE implements Comparator<Product>{
    public int compare(Product p1, Product p2){
        if(p1.getPrice()!=p2.getPrice()){
            return p1.getPrice()-p2.getPrice();
        }else{
            return p1.getName().compareTo(p2.getName()); //up
        }
    }
}
class BY_STOCK implements Comparator<Product>{
    public int compare(Product p1, Product p2){
        if(p1.getStock()!=p2.getStock()){
            return p2.getStock()-p1.getStock();//down
        }else{
            return p1.getName().compareTo(p2.getName());
        }
    }
}
public class COMPARATOR020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Product> list = new ArrayList<Product>();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split(" ");
            list.add(new Product(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        }
        String type = sc.nextLine();
        if(type.equals("BY_NAME")){
            Collections.sort(list,new BY_NAME());
        }else if(type.equals("BY_PRICE")){
            Collections.sort(list,new BY_PRICE());
        }else{
            Collections.sort(list,new BY_STOCK());
        }
        for(Product p : list){
            System.out.println(p);
        }
    }
}
