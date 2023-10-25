package be.cm.customers.api;

import be.cm.customers.entities.RegisterCustomerDTO;
import be.cm.customers.services.CustomerService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
@TestHTTPEndpoint(CustomerController.class)
public class CustomerControllerTest {

    @Inject
    CustomerService customerService;

    @Test
    public void testRegisterCustomer() {
        given()
                .body("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"emailAdress\": \"john.doe@example.com\", \"phoneNumber\": \"0470123456\"}")
                .contentType(ContentType.JSON)
                .when()
                .post("register")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("firstName", equalTo("John"))
                .body("lastName", equalTo("Doe"))
                .body("emailAdress", equalTo("john.doe@example.com"))
                .body("phoneNumber", equalTo("0470123456"));
    }

    @Test
    public void testGetAllCustomers() {
        customerService.registerCustomer(new RegisterCustomerDTO("test", "test","test@test.be","0488996655"));

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", equalTo(2));
    }

    @Test
    public void testInvalidRegisterCustomer() {
        given()
                .body("{\"firstName\": \"Jane\", \"lastName\": \"Smith\", \"emailAdress\": \"invalid-email\", \"phoneNumber\": \"0470123456\"}")
                .contentType(ContentType.JSON)
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .body(containsString("Email invalid-email not valid"));
    }
}
