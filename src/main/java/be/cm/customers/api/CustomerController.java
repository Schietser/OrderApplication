package be.cm.customers.api;

import be.cm.customers.entities.CustomerDTO;
import be.cm.customers.entities.RegisterCustomerDTO;
import be.cm.customers.services.CustomerMapper;
import be.cm.customers.services.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("customer")
public class CustomerController {

    private CustomerService customerService = new CustomerService();
    private CustomerMapper customerMapper = new CustomerMapper();

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @POST
    @Path("/register")
    @ResponseStatus(201)
    public CustomerDTO registerCustomer(RegisterCustomerDTO registerCustomerDTO){
        return customerMapper.mapToCustomerDTO(customerService.registerCustomer(registerCustomerDTO));
    }



}
