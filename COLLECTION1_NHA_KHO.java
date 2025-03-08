import java.util.*;
class WareHouse{
    String product;
    int price;
    int stock;
    public WareHouse(String product, int price, int stock) {
        this.price = price;
        this.product = product;
        this.stock = stock;
    }
    
}
public class COLLECTION1_NHA_KHO{
    private ArrayList<WareHouse> products;
    public COLLECTION1_NHA_KHO(){
        products = new ArrayList<>();
    }
    public void addProduct(String product, int price, int stock){
        products.add(new WareHouse(product, price, stock));
    }
    public int price(String product){
        for(WareHouse w:products){
            if(w.product.equals(product)){
                return w.price;
            }
        }
        return -99;
    }
    public static void main(String[] args) {
        COLLECTION1_NHA_KHO WH = new COLLECTION1_NHA_KHO();
        WH.addProduct("milk", 3, 10);
        WH.addProduct("coffe", 5, 7);
        System.out.println("prices:");
        System.out.println("milk: "+WH.price("milk"));
        System.out.println("coffee: "+WH.price("coffe"));
        System.out.println("sugar: "+WH.price("sugar"));
    }
}
