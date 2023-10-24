package be.cm.orders.entities;

import be.cm.customers.entities.Customer;

import java.util.List;

public class OrderDTO {

    private final String id;
    private final List<ItemGroupDTO> itemGroup;
    private final double totalPrice;
    private final Customer customer;

    public OrderDTO(String id, List<ItemGroupDTO> itemGroup, double totalPrice, Customer customer) {
        this.id = id;
        this.itemGroup = itemGroup;
        this.totalPrice = totalPrice;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }
}
