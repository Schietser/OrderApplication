package be.cm.customers.entities;

public class CustomerDTO {

    private final String id;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String  phoneNumber;

    public CustomerDTO(String id, String firstName, String lastName, String emailAdress, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
