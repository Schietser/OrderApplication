package be.cm.customers.entities;

import be.cm.customers.EmailValidation;
import be.cm.customers.PhoneValidator;

import java.util.UUID;

public class Customer {

    private final String id;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String  phoneNumber;

    public Customer(String firstName, String lastName, String emailAdress, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        if (!EmailValidation.isValidEmail(emailAdress)){
            throw new IllegalArgumentException("Invalid email address");
        }
        this.emailAdress = emailAdress;
        if (!PhoneValidator.isValidBelgianPhoneNumber(phoneNumber)){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
