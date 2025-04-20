import java.util.*;

class Product {
	private String productID;
	private String name;
	private double price;

	public Product(String productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}

	public String getProductID() {
		return productID;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}

class Order {
	private String orderID;
	private Product product;
	private int quantity;

	public Order(String orderID, Product product, int quantity) {
		this.orderID = orderID;
		this.product = product;
		this.quantity = quantity;
	}

	public double calculateTotal() {
		return product.getPrice() * quantity;
	}

	public void display() {
		System.out.println("--- Thông tin đơn hàng ---");
		System.out.println("Đơn hàng: " + orderID);
		System.out.println("Sản phẩm: " + product.getName() + " (Mã: " + product.getProductID() + ")");
		System.out.printf("Giá: %.1f\n", product.getPrice());
		System.out.println("Số lượng: " + quantity);
		System.out.printf("Tổng tiền: %.1f\n", calculateTotal());
	}
}

public class OOP011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String productId = sc.nextLine();
		String name = sc.nextLine();
		double price = Double.parseDouble(sc.nextLine());
		Product product = new Product(productId, name, price);
		String orderId = sc.nextLine();
		int quantity = Integer.parseInt(sc.nextLine());
		Order order = new Order(orderId, product, quantity);
		order.display();
		sc.close();
	}
}
