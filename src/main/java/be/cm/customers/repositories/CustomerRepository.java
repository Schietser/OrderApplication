package be.cm.customers.repositories;

import be.cm.customers.entities.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class CustomerRepository {

    Map<String, Customer> customerDB;

    public CustomerRepository() {
        this.customerDB = new ConcurrentHashMap<>();
    }

    public void save(Customer createdCustomer) {
        customerDB.put(createdCustomer.getId(), createdCustomer);
    }
}
