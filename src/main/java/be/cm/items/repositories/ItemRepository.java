package be.cm.items.repositories;

import be.cm.items.entities.Item;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ItemRepository {

    private static final ConcurrentHashMap<String, Item> ITEM_DB = new ConcurrentHashMap<>();
    public void save(Item createdItem) {
        ITEM_DB.put(createdItem.getId(), createdItem);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(ITEM_DB.values());
    }

    public Item getItemById(String id) {
        return ITEM_DB.get(id);
    }
}
