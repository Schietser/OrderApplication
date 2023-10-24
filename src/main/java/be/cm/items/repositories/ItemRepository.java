package be.cm.items.repositories;

import be.cm.items.entities.Item;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ItemRepository {

    private Map<String, Item> itemDB;

    public ItemRepository() {
        this.itemDB = new ConcurrentHashMap<>();
    }

    public void save(Item createdItem) {
        itemDB.put(createdItem.getId(), createdItem);
    }
}
