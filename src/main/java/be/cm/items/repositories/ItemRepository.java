package be.cm.items.repositories;

import be.cm.items.entities.Item;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ItemRepository {

    private final ConcurrentHashMap<String, Item> itemDB = new ConcurrentHashMap<>();
    public void save(Item createdItem) {
        itemDB.put(createdItem.getId(), createdItem);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(itemDB.values());
    }

    public Item getItemById(String id) {
        return itemDB.get(id);
    }
}
