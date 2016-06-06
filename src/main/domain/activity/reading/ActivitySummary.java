package main.domain.activity.reading;

import main.domain.event.reading.EventSummary;

public class ActivitySummary extends EventSummary{
	public String eventId;
	public int spots;
	public int duration;
	public int points;
	public boolean groupDiscount;
	public boolean voucher;
}
