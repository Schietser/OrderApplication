package be.cm.customers.repositories;

import be.cm.customers.entities.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static be.cm.customers.EmailValidation.isValidEmail;
import static be.cm.customers.PhoneValidator.isValidBelgianPhoneNumber;

@ApplicationScoped
public class CustomerRepository {

       private final Map<String, Customer> customerDB = new ConcurrentHashMap<>();

    public void save(Customer createdCustomer) {
        customerDB.put(createdCustomer.getId(), createdCustomer);
    }

    public Customer getCustomerById(String customerId) {
        return customerDB.get(customerId);
    }

    public String validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email not filled in");
        }
        Optional<Map.Entry<String, Customer>> result =
                customerDB.entrySet()
                        .stream()
                        .filter(e -> e.getValue().getEmailAdress().equals(email.toLowerCase()))
                        .findFirst();
        if (result.isPresent()) {
            throw new IllegalArgumentException("Email " + email + " not unique");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email " + email + " not valid");
        }
        return email;
    }

    public String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number not filled in");
        }
        Optional<Map.Entry<String, Customer>> result =
                customerDB.entrySet()
                        .stream()
                        .filter(e -> e.getValue().getPhoneNumber().equals(phoneNumber.toLowerCase()))
                        .findFirst();
        if (result.isPresent()) {
            throw new IllegalArgumentException("Phone number " + phoneNumber + " not unique");
        }
        if (!isValidBelgianPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Phone number " + phoneNumber + " not valid");
        }
        return phoneNumber;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerDB.values());
    }
}
