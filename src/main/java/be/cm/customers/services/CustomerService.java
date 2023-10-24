package be.cm.customers.services;

import be.cm.customers.entities.RegisterCustomerDTO;
import be.cm.customers.repositories.CustomerRepository;
import be.cm.customers.entities.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public Customer registerCustomer(RegisterCustomerDTO registerCustomerDTO) {

        checkIfNoValuesAreNull(registerCustomerDTO);
        checkIfNoValuesAreEmpty(registerCustomerDTO);

        Customer createdCustomer = new Customer(
                registerCustomerDTO.getFirstName(),
                registerCustomerDTO.getLastName(),
                customerRepository.validateEmail(registerCustomerDTO.getEmailAdress()),
                customerRepository.validatePhoneNumber(registerCustomerDTO.getPhoneNumber())
        );

        customerRepository.save(createdCustomer);

        return createdCustomer;

    }

    private static void checkIfNoValuesAreEmpty(RegisterCustomerDTO registerCustomerDTO) {
        if (registerCustomerDTO.getFirstName().isEmpty() || registerCustomerDTO.getLastName().isEmpty()) {
            throw new IllegalArgumentException("No field can be empty");
        }
    }

    private static void checkIfNoValuesAreNull(RegisterCustomerDTO registerCustomerDTO) {
        if ( registerCustomerDTO.getFirstName() == null || registerCustomerDTO.getLastName() == null || registerCustomerDTO.getEmailAdress() == null || registerCustomerDTO.getPhoneNumber() == null){
            throw new IllegalArgumentException("All fields must be filled in");
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }


}
