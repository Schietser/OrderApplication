package be.cm.items.api;

import be.cm.items.entities.AddItemDTO;
import be.cm.items.entities.ItemDTO;
import be.cm.items.repositories.ItemRepository;
import be.cm.items.services.ItemMapper;
import be.cm.items.services.ItemService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(ItemController.class)
class ItemControllerTest {

    @Inject
    ItemMapper itemMapper;
    @Inject
    ItemService itemService;
    @Inject
    ItemRepository itemRepository;

    @AfterEach
    public void resetDB(){
        itemRepository.resetDatabase();
    }

    @Test
    public void testGetAllItems() {
        ItemDTO expected = itemMapper.mapToItemDTO(itemService.addItem(new AddItemDTO("Test", "Test", 15.0, 10)));

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalTo("[{\"id\":\"" + expected.getId() + "\",\"name\":\"Test\",\"description\":\"Test\",\"price\":15.0}]"));
    }

    @Test
    public void testCreateItem() {
        String requestBody = "{\"name\":\"productname\",\"description\":\"product description\",\"price\":10.0,\"amount\":10}";

        given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post("/add")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("name", equalTo("productname"))
                .body("description", equalTo("product description"))
                .body("price", equalTo(10.0f));
    }

    @Test
    public void testGetItemById() {
        // Create an item to retrieve by ID
        AddItemDTO addItemDTO = new AddItemDTO("Test", "Test", 15.0, 10);
        ItemDTO addedItem = itemMapper.mapToItemDTO(itemService.addItem(addItemDTO));

        given()
                .pathParam("id", addedItem.getId())
                .when()
                .get("/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(addedItem.getId()))
                .body("name", equalTo("Test"))
                .body("description", equalTo("Test"))
                .body("price", equalTo(15.0f));
    }

    @Test
    public void testGetAllItemsWithNoItems() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", hasSize(0)); // Ensure there are no items in the response
    }

    @Test
    public void testAddItemWithMissingField() {
        // Missing the "name" field in the request
        String requestBody = "{\"description\":\"Test Description\",\"price\":15.0,\"amount\":10}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/add")
                .then()
                .statusCode(400); // Expecting a bad request status code
    }


}