package travelcard.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CrossZonePeakHourDetails extends PeakHourDetails{
	
public CrossZonePeakHourDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CrossZonePeakHourDetails(DayOfWeek day, LocalTime from, LocalTime to) {
		super(day, from, to);
		// TODO Auto-generated constructor stub
	}
public CrossZonePeakHourDetails(DayOfWeek day, LocalTime from, LocalTime to, Zones zone1) {
		super(day, from, to);
		this.zoneTo=zone1;
	}
private Zones zoneFrom;
private Zones zoneTo;

public Zones getZoneFrom() {
	return zoneFrom;
}
public void setZoneFrom(Zones zoneFrom) {
	this.zoneFrom = zoneFrom;
}
public Zones getZoneTo() {
	return zoneTo;
}
public void setZoneTo(Zones zoneTo) {
	this.zoneTo = zoneTo;
}

}
