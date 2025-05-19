package COLLECTION;

import java.util.*;

class Item {
    final String product;
    int quantity;
    final int unitPrice;
    final int originalQuantity;

    public Item(String product, int quantity, int unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.originalQuantity = quantity;
    }

    public Item(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = 0;
        this.originalQuantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return quantity * unitPrice;
    }

    public void printItemInfo() {
        System.out.println("Product: " + product + " has quantity " + quantity + " with price: " + getTotalPrice());
    }
}

public class COLLECTION004 {
    HashMap<String, Item> items;

    public COLLECTION004() {
        items = new HashMap<>();
    }

    public void importProduct(String product, Item item) {
        items.put(product, item);
    }

    public Item getItem(String product) {
        return items.get(product);
    }

    public void removeProduct(String product, int quantity) {
        Item item = items.get(product);
        if (item != null) {
            int newQuantity = item.getQuantity() - quantity;
            if (newQuantity < 0) newQuantity = 0;
            item.setQuantity(newQuantity);
        }
    }

    public void decreaseQuantityInWarehouseByOne() {
        for (Item item : items.values()) {
            int newQuantity = item.getQuantity() - 1;
            if (newQuantity < 0) newQuantity = 0;
            item.setQuantity(newQuantity);
        }
    }

    public void takeFromItemToWarehouse(List<Item> itemsToCheck, String product, int quantity) {
        Item checkItem = null;
        for (Item item : itemsToCheck) {
            if (item.getProduct().equals(product)) {
                checkItem = item;
                break;
            }
        }

        if (checkItem != null) {
            Item warehouseItem = items.get(product);
            if (warehouseItem != null) {
                int availableQuantity = checkItem.getQuantity();
                int quantityToAdd = Math.min(quantity, availableQuantity);
                warehouseItem.setQuantity(warehouseItem.getQuantity() + quantityToAdd);
            }
        }
    }

    public void printWarehouseInfo() {
        for (Item item : items.values()) {
            item.printItemInfo();
        }
    }

    public static void main(String[] args) {
        COLLECTION004 warehouse = new COLLECTION004();
        Item milk = new Item("milk", 4, 2);
        Item buttermilk = new Item("buttermilk", 10, 2);
        milk.printItemInfo();
        buttermilk.printItemInfo();
        warehouse.importProduct("milk", milk);
        warehouse.importProduct("buttermilk", buttermilk);
        warehouse.removeProduct("milk", 1);
        warehouse.removeProduct("buttermilk", 3);
        warehouse.printWarehouseInfo();
        warehouse.decreaseQuantityInWarehouseByOne();
        warehouse.printWarehouseInfo();
        List<Item> itemsToCheck = new ArrayList<>();
        itemsToCheck.add(new Item("milk", 2));
        itemsToCheck.add(new Item("buttermilk", 6));
        warehouse.takeFromItemToWarehouse(itemsToCheck, "milk", 5);
        warehouse.takeFromItemToWarehouse(itemsToCheck, "buttermilk", 1);
        warehouse.printWarehouseInfo();
    }
}
