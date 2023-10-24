package be.cm.items.services;

import be.cm.items.entities.Item;
import be.cm.items.entities.ItemDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ItemDTO> mapToListOfItemDTO(List<Item> allItems) {
        return allItems.stream().map(this::mapToItemDTO).collect(Collectors.toList());
    }
}
