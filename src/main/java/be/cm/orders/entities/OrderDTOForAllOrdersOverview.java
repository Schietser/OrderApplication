package be.cm.orders.entities;

import be.cm.customers.entities.Customer;

import java.util.List;

public class OrderDTOForAllOrdersOverview {

    private final String id;
    private final List<ItemGroupDTO> itemGroup;
    private final double totalPrice;

    public OrderDTOForAllOrdersOverview(String id, List<ItemGroupDTO> itemGroup, double totalPrice) {
        this.id = id;
        this.itemGroup = itemGroup;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroupDTO> getItemGroup() {
        return itemGroup;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
