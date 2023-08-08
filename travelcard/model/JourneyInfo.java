package travelcard.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JourneyInfo {
	
public JourneyInfo(LocalDateTime journeyDateTime, Zones zoneFrom, Zones zoneTo) {
		super();
		this.journeyDateTime = journeyDateTime;
		this.zoneFrom = zoneFrom;
		this.zoneTo = zoneTo;
	}

private LocalDateTime journeyDateTime;
private Zones zoneFrom;
private Zones zoneTo;


public LocalDateTime getJourneyDateTime() {
	return journeyDateTime;
}
public void setJourneyDateTime(LocalDateTime journeyDateTime) {
	this.journeyDateTime = journeyDateTime;
}
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
public LocalTime getJourneyTimeOnly() {
    return journeyDateTime.toLocalTime();
}

public LocalDate getJourneyDateOnly() {
    return journeyDateTime.toLocalDate();
}


}
