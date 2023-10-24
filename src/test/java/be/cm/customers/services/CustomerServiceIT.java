package be.cm.customers.services;

import be.cm.customers.entities.Customer;
import be.cm.customers.entities.RegisterCustomerDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerServiceIT {

    @Inject
    CustomerService customerService;

    @Test
    public void testRegisterCustomer() {
        RegisterCustomerDTO validCustomerDTO = new RegisterCustomerDTO();
        validCustomerDTO.setFirstName("John");
        validCustomerDTO.setLastName("Doe");
        validCustomerDTO.setEmailAdress("john.doe@example.com");
        validCustomerDTO.setPhoneNumber("0470123456");

        Customer createdCustomer = customerService.registerCustomer(validCustomerDTO);

        assertEquals("John", createdCustomer.getFirstName());
        assertEquals("Doe", createdCustomer.getLastName());
        assertEquals("john.doe@example.com", createdCustomer.getEmailAdress());
        assertEquals("0470123456", createdCustomer.getPhoneNumber());
    }

    @Test
    public void testInvalidEmail() {
        RegisterCustomerDTO invalidCustomerDTO = new RegisterCustomerDTO();
        invalidCustomerDTO.setFirstName("Jane");
        invalidCustomerDTO.setLastName("Smith");
        invalidCustomerDTO.setEmailAdress("invalid-email");
        invalidCustomerDTO.setPhoneNumber("0470123456");

        // Ensure that an invalid email address results in an exception
        assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(invalidCustomerDTO));
    }

    @Test
    public void testInvalidPhoneNumber() {
        RegisterCustomerDTO invalidCustomerDTO = new RegisterCustomerDTO();
        invalidCustomerDTO.setFirstName("Alice");
        invalidCustomerDTO.setLastName("Johnson");
        invalidCustomerDTO.setEmailAdress("alice@example.com");
        invalidCustomerDTO.setPhoneNumber("invalid-phone-number");

        // Ensure that an invalid phone number results in an exception
        assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(invalidCustomerDTO));
    }

    @Test
    public void testRegisterCustomerWithMissingFields() {
        RegisterCustomerDTO customerDTO = new RegisterCustomerDTO();

        // Attempt to register a customer with missing required fields
        assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customerDTO));
    }

    @Test
    public void testRegisterCustomerWithEmptyFieldsButValidPhoneAndEmail() {
        RegisterCustomerDTO customerDTO = new RegisterCustomerDTO();
        customerDTO.setFirstName("");
        customerDTO.setLastName("");
        customerDTO.setEmailAdress("originalmail@example.com");
        customerDTO.setPhoneNumber("0488556633");

        // Attempt to register a customer with empty fields
        assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customerDTO));
    }

    @Test
    public void testGettingAllCustomers(){

        assertEquals(1, customerService.getAllCustomers().size());

    }
}
