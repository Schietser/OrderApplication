package be.cm.orders.services;

import be.cm.items.entities.Item;
import be.cm.items.repositories.ItemRepository;
import be.cm.items.services.ItemMapper;
import be.cm.orders.entities.ItemGroup;
import be.cm.orders.entities.CreateItemGroupDTO;
import be.cm.orders.entities.ItemGroupDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GroupItemMapper {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public GroupItemMapper(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemGroup> mapToEntity(List<CreateItemGroupDTO> itemGroup) {

        return itemGroup.stream().map(this::mapToSingleEntity).collect(Collectors.toList());
    }

    private ItemGroup mapToSingleEntity(CreateItemGroupDTO createItemGroupDTO){
        Item item = itemRepository.getItemById(createItemGroupDTO.getId());

        ItemGroup group = new ItemGroup(item, createItemGroupDTO.getAmount());

        return group;

    }

    private ItemGroupDTO mapToSingleDTO(ItemGroup itemGroup){
        return new ItemGroupDTO(itemMapper.mapToItemDTO(itemGroup.getCopyOfItem()), itemGroup.getAmount(), itemGroup.getShippingDate());
    }

    public List<ItemGroupDTO> mapToListOfDTO(List<ItemGroup> itemGroupList) {
        return itemGroupList.stream().map(this::mapToSingleDTO).collect(Collectors.toList());
    }
}
