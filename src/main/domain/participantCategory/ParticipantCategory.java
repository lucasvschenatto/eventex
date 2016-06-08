package main.domain.participantCategory;

import main.domain.Entity;
import main.domain.Percentage;
import main.domain.Text;

public class ParticipantCategory extends Entity {
    protected Text name;
    protected Text description;
    protected Percentage discount;

    public ParticipantCategory() {
        this("", Text.EMPTY, Text.EMPTY, Percentage.ZERO);
    }

    protected ParticipantCategory(String id, Text name, Text description, Percentage discount) {
        super(id);
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
    }

    public Entity copy() {
        return new ParticipantCategory(id, name, description, discount);
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
