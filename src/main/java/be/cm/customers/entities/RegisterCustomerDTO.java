package be.cm.customers.entities;

public class RegisterCustomerDTO {

    private String firstName;
    private String lastName;
    private String emailAdress;
    private String  phoneNumber;

    public RegisterCustomerDTO() {
    }

    public RegisterCustomerDTO(String firstName, String lastName, String emailAdress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
