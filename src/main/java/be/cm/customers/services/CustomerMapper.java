package be.cm.customers.services;

import be.cm.customers.entities.Customer;
import be.cm.customers.entities.CustomerDTO;
import be.cm.customers.repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CustomerDTO> mapToListOfCustomerDTO(List<Customer> allCustomers) {
        return allCustomers.stream().map(this::mapToCustomerDTO).collect(Collectors.toList());
    }
}
