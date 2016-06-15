package main.domain.profession;

import main.domain.Entity;
import main.domain.Text;

public class Profession extends Entity {
	public static final Profession EMPTY = new Profession();
    protected Text name;
    protected Text description;

    public Profession() {
        this("", Text.EMPTY, Text.EMPTY);
    }

    protected Profession(String id, Text name, Text description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public Profession copy() {
        return new Profession(id, name, description);
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

}
