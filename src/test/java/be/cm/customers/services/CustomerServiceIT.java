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
        RegisterCustomerDTO validCustomerDTO = new RegisterCustomerDTO(
                "John","Doe","john.doe@example.com","0470123456");

        Customer createdCustomer = customerService.registerCustomer(validCustomerDTO);

        assertEquals("John", createdCustomer.getFirstName());
        assertEquals("Doe", createdCustomer.getLastName());
        assertEquals("john.doe@example.com", createdCustomer.getEmailAdress());
        assertEquals("0470123456", createdCustomer.getPhoneNumber());
    }

    @Test
    public void testInvalidEmail() {
        RegisterCustomerDTO invalidCustomerDTO = new RegisterCustomerDTO(
                "Jane","Smith","invalid-email","0470123456");

        // Ensure that an invalid email address results in an exception
        assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(invalidCustomerDTO));
    }

    @Test
    public void testInvalidPhoneNumber() {
        RegisterCustomerDTO invalidCustomerDTO = new RegisterCustomerDTO(
                "Alice","Johnson","alice@example.com","invalid-phone-number");

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
        RegisterCustomerDTO customerDTO = new RegisterCustomerDTO("","","originalmail@example.com","0488556633");

        // Attempt to register a customer with empty fields
        assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customerDTO));
    }

    @Test
    public void testGettingAllCustomers(){

        assertEquals(1, customerService.getAllCustomers().size());

    }
}
