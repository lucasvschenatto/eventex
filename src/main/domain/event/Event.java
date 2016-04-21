package main.domain.event;

import main.domain.Entity;
import main.domain.Text;

public class Event extends Entity {
    private Text name;
    private Text description;
    private Price price;
    private Quantity unitsInStock;

    public Event() {
        this("", Text.EMPTY, Text.EMPTY, Price.ZERO, Quantity.ZERO);
    }

    private Event(String id, Text name, Text description, Price price, Quantity unitsInStock) {
        super(id);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.unitsInStock = unitsInStock;
    }

    public Entity copy() {
        return new Event(id, name, description, price, unitsInStock);
    }

    public void setName(Text name) {
        this.name = name;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setUnitsInStock(Quantity unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Text getName() {
        return name;
    }

    public Text getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public Quantity getUnitsInStock() {
        return unitsInStock;
    }
}
