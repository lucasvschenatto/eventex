package main.domain.inscription;

import main.domain.Entity;
import main.domain.Text;

public class Inscription extends Entity {
    protected Text participantId;
    protected Text activityId;
    protected Text categoryId;
    protected Text associateCode;

    public Inscription() {
        this("", Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY);
    }

    protected Inscription(String id, Text participantId, Text activityId, Text categoryId, Text associateCode) {
        super(id);
        this.participantId = participantId;
        this.activityId = activityId;
        this.categoryId = categoryId;
        this.associateCode = associateCode;
    }

    public Entity copy() {
        return new Inscription(id, participantId, activityId, categoryId, associateCode);
    }

	public Text getParticipantId() {
		return participantId;
	}

	public Text getActivityId() {
		return activityId;
	}

	public Text getCategoryId() {
		return categoryId;
	}

	public Text getAssociateCode() {
		return associateCode;
	}

	public void setParticipantId(Text participantId) {
		this.participantId = participantId;
	}

	public void setActivityId(Text activityId) {
		this.activityId = activityId;
	}

	public void setCategoryId(Text categoryId) {
		this.categoryId = categoryId;
	}

	public void setAssociateCode(Text associateCode) {
		this.associateCode = associateCode;
	}
}
