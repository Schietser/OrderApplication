package be.cm.orders.api;

import be.cm.orders.entities.AllOrdersDTO;
import be.cm.orders.entities.OrderDTO;
import be.cm.orders.entities.PlaceOrderDTO;
import be.cm.orders.services.OrderMapper;
import be.cm.orders.services.OrderService;
import io.quarkus.runtime.annotations.StaticInitSafe;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;

@Path("orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GET
    @ResponseStatus(200)
    public AllOrdersDTO getAllOrders(){
        return orderService.getAllOrders();
    }

    @POST
    @Path("/placeorder")
    public OrderDTO createOrder(PlaceOrderDTO placeOrderDTO){
        return orderMapper.mapToOrderDTO(orderService.CreateOrder(placeOrderDTO));
    }

}
