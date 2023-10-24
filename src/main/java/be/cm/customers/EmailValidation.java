package be.cm.customers;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidation {

    private static final EmailValidator emailValidator = EmailValidator.getInstance();

    public static boolean isValidEmail(String email) {
        return emailValidator.isValid(email);
    }

}
