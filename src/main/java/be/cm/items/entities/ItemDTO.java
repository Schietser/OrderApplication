package be.cm.items.entities;

public class ItemDTO {

    private final String id;
    private String name;
    private String description;
    private double price;

    public ItemDTO(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
