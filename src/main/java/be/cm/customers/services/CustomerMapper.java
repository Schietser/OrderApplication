package be.cm.customers.services;

import be.cm.customers.entities.Customer;
import be.cm.customers.entities.CustomerDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerMapper {
    public CustomerDTO mapToCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailAdress(),
                customer.getPhoneNumber()
        );
    }
}
