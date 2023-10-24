package be.cm.items.api;

import be.cm.items.entities.AddItemDTO;
import be.cm.items.entities.ItemDTO;
import be.cm.items.services.ItemMapper;
import be.cm.items.services.ItemService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @POST
    @Path("/add")
    @ResponseStatus(201)
    public ItemDTO addItem(AddItemDTO addItemDTO){
        return itemMapper.mapToItemDTO(itemService.addItem(addItemDTO));

    }

}



