package be.cm.orders.services;

import be.cm.customers.repositories.CustomerRepository;
import be.cm.items.repositories.ItemRepository;
import be.cm.orders.entities.AllOrdersDTO;
import be.cm.orders.entities.OrderDTO;
import be.cm.orders.repositories.OrderRepository;
import be.cm.orders.entities.Order;
import be.cm.orders.entities.PlaceOrderDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class OrderService {

    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    ItemRepository itemRepository;
    GroupItemMapper groupItemMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository, GroupItemMapper groupItemMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.groupItemMapper = groupItemMapper;
    }

    public Order CreateOrder(PlaceOrderDTO placeOrderDTO) {

        Order placedOrder = new Order(
                groupItemMapper.mapToEntity(placeOrderDTO.getItemGroup()),
                customerRepository.getCustomerById(placeOrderDTO.getCustomerId())
        );

        orderRepository.saveOrder(placedOrder);

        return placedOrder;
    }

    public AllOrdersDTO getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
