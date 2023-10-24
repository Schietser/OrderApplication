package be.cm.orders.entities;

import be.cm.items.entities.Item;
import be.cm.items.entities.ItemDTO;

import java.time.LocalDate;

public class ItemGroupDTO {

    private ItemDTO item;

    private int amount;
    private LocalDate shippingDate;
    public ItemGroupDTO(ItemDTO item, int amount, LocalDate shippingDate) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public ItemDTO getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
