package be.cm.orders.entities;

import java.util.List;

public class AllOrdersDTO {

    List<OrderDTOForAllOrdersOverview> orders;
    double totalPriceForAllOrders;

    public AllOrdersDTO(List<OrderDTOForAllOrdersOverview> orders, double totalPriceForAllOrders) {
        this.orders = orders;
        this.totalPriceForAllOrders = totalPriceForAllOrders;
    }

    public List<OrderDTOForAllOrdersOverview> getOrders() {
        return orders;
    }

    public double getTotalPriceForAllOrders() {
        return totalPriceForAllOrders;
    }
}
