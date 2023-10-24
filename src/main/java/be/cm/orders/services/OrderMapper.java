package be.cm.orders.services;

import be.cm.orders.entities.Order;
import be.cm.orders.entities.OrderDTO;
import be.cm.orders.entities.OrderDTOForAllOrdersOverview;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderMapper {

    GroupItemMapper groupItemMapper;

    public OrderMapper(GroupItemMapper groupItemMapper) {
        this.groupItemMapper = groupItemMapper;
    }

    public OrderDTO mapToOrderDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                groupItemMapper.mapToListOfDTO(order.getItemGroup()),
                order.getTotalPrice(),
                order.getCustomer()
        );
    }

    public List<OrderDTO> mapToListOfOrderDTO(List<Order> allOrders) {
        return allOrders.stream().map(this::mapToOrderDTO).collect(Collectors.toList());
    }

    public OrderDTOForAllOrdersOverview mapToOrderDTOForAllOrdersOverview(Order order) {
        return new OrderDTOForAllOrdersOverview(
                order.getId(),
                groupItemMapper.mapToListOfDTO(order.getItemGroup()),
                order.getTotalPrice()
        );
    }

    public List<OrderDTOForAllOrdersOverview> mapToListOfOrderDTOForAllOrdersOverview(List<Order> list) {
        return list.stream().map(this::mapToOrderDTOForAllOrdersOverview).collect(Collectors.toList());

    }
}
