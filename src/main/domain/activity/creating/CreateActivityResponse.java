package main.domain.activity.creating;

import main.domain.event.creating.CreateEventResponse;

public class CreateActivityResponse extends CreateEventResponse{
	public boolean invalidSpots;
	public boolean invalidDuration;
	public boolean invalidPoints;
	public boolean invalidGroupDiscount;
	public boolean invalidVoucher;
}
