package be.cm.items.services;

import be.cm.items.entities.AddItemDTO;
import be.cm.items.entities.Item;
import be.cm.items.repositories.ItemRepository;

public class ItemService {

    ItemRepository itemRepository;

    public ItemService() {
        this.itemRepository = new ItemRepository();
    }

    public Item addItem(AddItemDTO addItemDTO) {

        Item createdItem = new Item(
                addItemDTO.getName(),
                addItemDTO.getDescription(),
                addItemDTO.getPrice(),
                addItemDTO.getAmount()
        );

        itemRepository.save(createdItem);

        return createdItem;
    }
}
