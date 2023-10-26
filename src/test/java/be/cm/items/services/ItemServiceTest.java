package be.cm.items.services;

import be.cm.items.entities.AddItemDTO;
import be.cm.items.entities.Item;
import be.cm.items.repositories.ItemRepository;
import be.cm.items.services.ItemService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ItemServiceTest {

    @Inject
    ItemService itemService;

    @Inject
    ItemRepository itemRepository;

    @AfterEach
    public void resetDB(){
        itemRepository.resetDatabase();
    }

    @Test
    public void testAddItem() {
        AddItemDTO addItemDTO = new AddItemDTO("Test Item", "Test Description", 10.0, 5);
        Item createdItem = itemService.addItem(addItemDTO);

        List<Item> allItems = itemRepository.getAllItems();
        assertEquals(1, allItems.size());
        assertEquals(createdItem, allItems.get(0));
    }

    @Test
    public void testGetAllItems() {
        itemRepository.save(new Item("Item 1", "Description 1", 10.0, 5));
        itemRepository.save(new Item("Item 2", "Description 2", 15.0, 3));

        List<Item> allItems = itemService.getAllItems();
        assertEquals(2, allItems.size());
    }

    @Test
    public void testGetItemById() {
        Item item = new Item("Test Item", "Test Description", 10.0, 5);
        itemRepository.save(item);

        String itemId = item.getId();

        Item retrievedItem = itemService.getItemById(itemId);

        assertEquals(item, retrievedItem);
    }
}
