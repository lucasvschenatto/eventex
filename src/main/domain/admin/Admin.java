package main.domain.admin;

import main.domain.Entity;
import main.domain.Text;

public class Admin extends Entity {
	protected Text userId;
    protected Text name;
    protected Text role;

    public Admin() {
        this("", Text.EMPTY, Text.EMPTY, Text.EMPTY);
    }

    protected Admin(String id, Text name, Text userId, Text role) {
        super(id);
        this.name   = name;
        this.userId = userId;
        this.role   = role;
    }

    public Entity copy() {
        return new Admin(id, name, userId, role);
    }

    public Text getName() {
    	return name;
    }

	public void setName(Text name) {
		this.name = name;
	}

	public Text getUserId() {
		return userId;
	}

	public Text getRole() {
		return role;
	}

	public void setUserId(Text userId) {
		this.userId = userId;
	}

	public void setRole(Text role) {
		this.role = role;
	}

}
