package be.cm.orders.entities;

import java.util.List;

public class PlaceOrderDTO {

    String customerId;
    List<CreateItemGroupDTO> itemGroup;

    public List<CreateItemGroupDTO> getItemGroup() {
        return itemGroup;
    }
    public String getCustomerId() {
        return customerId;
    }
}
