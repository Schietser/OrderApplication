package be.cm.customers.api;

import be.cm.customers.entities.CustomerDTO;
import be.cm.customers.entities.RegisterCustomerDTO;
import be.cm.customers.services.CustomerMapper;
import be.cm.customers.services.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.NOT_FOUND;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("customers")
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

    @ServerExceptionMapper(IllegalArgumentException.class)
    protected Response illegalArgument(IllegalArgumentException exception) {
        return Response.status(BAD_REQUEST).entity(exception.getMessage()).build();
    }




}
