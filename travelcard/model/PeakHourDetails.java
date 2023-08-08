package travelcard.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeakHourDetails {
private DayOfWeek day;
private LocalTime from;
private LocalTime to;

public PeakHourDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public PeakHourDetails(DayOfWeek day, LocalTime from, LocalTime to) {
	this.day=day;
	this.from=from;
	this.to=to;
}
public DayOfWeek getDay() {
	return day;
}
public void setDay(DayOfWeek day) {
	this.day = day;
}
public LocalTime getFrom() {
	return from;
}
public void setFrom(LocalTime from) {
	this.from = from;
}
public LocalTime getTo() {
	return to;
}
public void setTo(LocalTime to) {
	this.to = to;
}
@Override
public String toString() {
    return "PeakHourDetails : Day: " + day + ", From: " + from + ", To: " + to;
}
}
