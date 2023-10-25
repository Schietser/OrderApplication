package be.cm.items.api;

import be.cm.items.entities.AddItemDTO;
import be.cm.items.entities.Item;
import be.cm.items.entities.ItemDTO;
import be.cm.items.services.ItemMapper;
import be.cm.items.services.ItemService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GET
    @ResponseStatus(200)
    public List<ItemDTO> getAllItems(){
        return itemMapper.mapToListOfItemDTO(itemService.getAllItems());
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(200)
    public Item getItemById(@PathParam("id") String id){
        return itemService.getItemById(id);
    }

    @POST
    @Path("/add")
    @ResponseStatus(201)
    public ItemDTO addItem(AddItemDTO addItemDTO){
        return itemMapper.mapToItemDTO(itemService.addItem(addItemDTO));

    }

}



