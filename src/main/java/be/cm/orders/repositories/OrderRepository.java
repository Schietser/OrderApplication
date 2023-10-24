package be.cm.orders.repositories;

import be.cm.orders.entities.AllOrdersDTO;
import be.cm.orders.entities.Order;
import be.cm.orders.services.OrderMapper;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class OrderRepository {

    private final Map<String, Order> orderMap;
    private final OrderMapper orderMapper;

    public OrderRepository(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
        this.orderMap = new ConcurrentHashMap<>();
    }

    public void saveOrder(Order placedOrder) {
        orderMap.put(placedOrder.getId(), placedOrder);
    }

    public AllOrdersDTO getAllOrders() {

        return new AllOrdersDTO(
                orderMapper.mapToListOfOrderDTOForAllOrdersOverview(orderMap.values().stream().toList()),
                orderMap.values().stream().mapToDouble(Order::getTotalPrice).sum()
        );
    }
}
