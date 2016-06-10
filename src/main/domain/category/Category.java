package main.domain.category;

import main.domain.Entity;
import main.domain.Percentage;
import main.domain.Text;

public class Category extends Entity {
    protected Text name;
    protected Text description;
    protected Percentage discount;

    public Category() {
        this("", Text.EMPTY, Text.EMPTY, Percentage.ZERO);
    }

    protected Category(String id, Text name, Text description, Percentage discount) {
        super(id);
        this.name = name;
        this.description = description;
        this.discount = discount;
    }

    public Entity copy() {
        return new Category(id, name, description, discount);
    }

    public Text getName() {
    	return name;
    }

	public void setName(Text name) {
		this.name = name;
	}

	public Text getDescription() {
		return description;
	}

	public void setDescription(Text description) {
		this.description = description;
	}

	public Percentage getDiscount() {
		return discount;
	}

	public void setDiscount(Percentage discount) {
		this.discount = discount;
	}
}
