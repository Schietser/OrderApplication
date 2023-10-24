package be.cm.items.services;

import be.cm.items.entities.Item;
import be.cm.items.entities.ItemDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemMapper {
    public ItemDTO mapToItemDTO(Item item) {

        return new ItemDTO(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice()
        );

    }
}
