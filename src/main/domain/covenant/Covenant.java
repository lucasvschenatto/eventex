package main.domain.covenant;

import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Entity;
import main.domain.Text;

public class Covenant extends Entity {
	protected Text categoryId;
	protected Text code;
    protected Text name;
    protected Date updateDate;
    protected Booleanic active;

    public Covenant() {
        this("", Text.EMPTY, Text.EMPTY, Text.EMPTY, Date.MIN, Booleanic.FALSE);
    }

    protected Covenant(String id, Text categoryId, Text code, Text name, Date updateDate, Booleanic active) {
        super(id);
        this.categoryId = categoryId;
        this.code = code;
        this.name = name;
        this.updateDate = updateDate;
        this.active = active;
    }

    public Entity copy() {
        return new Covenant(id, categoryId, code, name, updateDate, active);
    }

    public Text getCategoryId() {
    	return categoryId;
    }

	public void setCategoryId(Text categoryId) {
		this.categoryId = categoryId;
	}
	
	public Text getCode() {
		return code;
	}
	
	public void setCode(Text code) {
		this.code = code;
	}
	
	public Text getName() {
		return name;
	}
	
	public void setName(Text name) {
		this.name = name;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Booleanic getActive() {
		return active;
	}

	public void setActive(Booleanic active) {
		this.active = active;
	}
}
