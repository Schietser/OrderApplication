package be.cm.customers.services;

import be.cm.customers.entities.RegisterCustomerDTO;
import be.cm.customers.repositories.CustomerRepository;
import be.cm.customers.entities.Customer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public Customer registerCustomer(RegisterCustomerDTO registerCustomerDTO) {

        Customer createdCustomer = new Customer(
                registerCustomerDTO.getFirstName(),
                registerCustomerDTO.getLastName(),
                registerCustomerDTO.getEmailAdress(),
                registerCustomerDTO.getPhoneNumber()
        );

        customerRepository.save(createdCustomer);

        return createdCustomer;

    }
}
