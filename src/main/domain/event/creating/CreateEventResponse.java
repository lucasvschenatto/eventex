package main.domain.event.creating;

import main.domain.AddressValidation;

public class CreateEventResponse {
    public boolean success;
    public boolean invalidName;
    public boolean invalidDescription;
    public boolean invalidDate;
    public boolean invalidTime;
    public boolean invalidPlace;
    public AddressValidation address;
}
