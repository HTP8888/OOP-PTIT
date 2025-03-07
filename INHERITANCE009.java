import java.util.*;

class Item {
    private String name;
    private double price;
    private double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f (-$%.2f)", name, price, discount);
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class GroceryBill {
    private Employee clerk;
    private  List<Item> receipt;
        private double total;
    
        public GroceryBill(Employee clerk) {
            this.clerk = clerk;
            this.receipt = new ArrayList<>();
            this.total = 0.0;
        }
    
        public void add(Item i) {
            receipt.add(i);
            total += i.getPrice();
        }
    
        public List<Item> getReceipt() {
            return receipt;
        }

        public double getTotal() {
            return total;
        }
    
        public Employee getClerk() {
            return clerk;
        }
    
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("items:\n");
            for (Item i : receipt) {
                sb.append("   ").append(i).append("\n");
            }
            sb.append(String.format("total: $%.2f\n", total));
            sb.append("Clerk: ").append(clerk.getName()).append("\n");
            return sb.toString();
        }
    }
    
    class DiscountBill extends GroceryBill {
        private double discountAmount;
    
        public DiscountBill(Employee clerk) {
            super(clerk);
            this.discountAmount = 0.0;
        }
    
        @Override
        public void add(Item i) {
            super.add(i);
            discountAmount += i.getDiscount();
        }
    
        @Override
        public String toString() {
            double subTotal = getTotal();
            double totalWithDiscount = subTotal - discountAmount;
    
            StringBuilder sb = new StringBuilder("items:\n");
            for (Item i : getReceipt()) {
            sb.append("   ").append(i).append("\n");
        }
        sb.append(String.format("sub-total: $%.2f\n", subTotal));
        sb.append(String.format("discount: $%.2f\n", discountAmount));
        sb.append(String.format("total: $%.2f\n", totalWithDiscount));
        sb.append("Clerk: ").append(super.getClerk().getName()).append("\n");
        return sb.toString();
    }
}

public class INHERITANCE009 {
    public static void main(String[] args) {
        // Clerk 1: Grocery Bill
        Employee clerk1 = new Employee("Grocery Bill");
        GroceryBill groceryBill = new GroceryBill(clerk1);
        groceryBill.add(new Item("item 1", 2.3, 0));
        groceryBill.add(new Item("item 2", 3.45, 0));
        System.out.println(groceryBill);
        // Clerk 2: Discount Bill
        Employee clerk2 = new Employee("Discount Bill");
        DiscountBill discountBill = new DiscountBill(clerk2);
        discountBill.add(new Item("item 3", 20, 15));
        discountBill.add(new Item("item 4", 40, 35));
        discountBill.add(new Item("item 5", 50, 35));
        System.out.println(discountBill);
    }
}
