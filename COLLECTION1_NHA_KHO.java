// import java.util.*;
// class WareHouse{
//     String product;
//     int price;
//     int stock;
//     public WareHouse(String product, int price, int stock) {
//         this.price = price;
//         this.product = product;
//         this.stock = stock;
//     }
    
// }
// public class COLLECTION1_NHA_KHO{
//     private ArrayList<WareHouse> products;
//     public COLLECTION1_NHA_KHO(){
//         products = new ArrayList<>();
//     }
//     public void addProduct(String product, int price, int stock){
//         products.add(new WareHouse(product, price, stock));
//     }
//     public int stock(String product){
//         for(WareHouse w:products){
//             if(w.product.equals(product)){
//                 return w.stock;
//             }
//         }
//         return -99;
//     }
//     public static void main(String[] args) {
//         COLLECTION1_NHA_KHO WH = new COLLECTION1_NHA_KHO();
//         WH.addProduct("milk", 3, 10);
//         WH.addProduct("coffe", 5, 7);
//         System.out.println("prices:");
//         System.out.println("milk: "+WH.stock("milk"));
//         System.out.println("coffe: "+WH.stock("coffe"));
//         System.out.println("sugar: "+WH.stock("sugar"));
//     }
// }
import java.util.*;
class Product{
  private String name;
  private int price,stock;
  public Product(String name, int price, int stock) {
    this.name = name;
    this.price = price;
    this.stock = stock;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getStock() {
    return stock;
  }
  public void setStok(int stock) {
    this.stock = stock;
  }
  public String toString(){
    return String.format("%s: %d",this.name,this.stock);
  }
  
}
class Warehouse{
   ArrayList<Product>products;
   public Warehouse(){
       products=new ArrayList<>();
   }
   public void addProduct(String product,int price,int stock){
      products.add(new Product(product, price, stock));
   }
   public String price(String product){
    for(int i=0;i<products.size();i++){
      if(this.products.get(i).getName().equals(product)){
        return this.products.get(i).toString();
      }
    }
    return String.format("%s: %d",product,-99);
   }
}
public class COLLECTION1_NHA_KHO {
  public static void main(String[] args) {
    
    Warehouse x=new Warehouse();
    x.addProduct("milk", 3, 10);
    x.addProduct("coffee", 5, 7);
    System.out.println("prices:");
    System.out.println(x.price("milk"));
    System.out.println(x.price("coffee"));
    System.out.println(x.price("sugar"));
  }
}