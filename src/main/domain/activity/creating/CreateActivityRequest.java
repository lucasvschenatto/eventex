package main.domain.activity.creating;

import main.domain.event.creating.CreateEventRequest;

public class CreateActivityRequest extends CreateEventRequest{
	public String spots;
	public String duration;
	public String points;
}
