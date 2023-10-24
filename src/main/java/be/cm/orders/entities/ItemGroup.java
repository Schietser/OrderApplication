package be.cm.orders.entities;

import be.cm.items.entities.Item;

import java.time.LocalDate;

public class ItemGroup {

    private Item item;
    private final Item copyOfItem;
    private final int amount;
    private final LocalDate shippingDate;
    private final double totalPrice;

    public ItemGroup(Item item, int amount) {
        this.copyOfItem = new Item(item.getName(), item.getDescription(), item.getPrice(), item.getAmount()); // Create a new Item object
        this.amount = amount;

        if (copyOfItem.getAmount() >= amount){
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusWeeks(1);
        }

        this.totalPrice = copyOfItem.getPrice()*amount;
    }

    public Item getCopyOfItem() {
        return copyOfItem;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
