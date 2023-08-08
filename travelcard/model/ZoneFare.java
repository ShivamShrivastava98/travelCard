package travelcard.model;

public class ZoneFare {

private Zones from;
private Zones to;
private int peakHourFare;
private int offPeakHourFare;
private int dailyCap;
private int weeklyCap;

public ZoneFare(Zones from, Zones to, int peakHourFare, int offPeakHourFare, int dailyCap, int weeklyCap) {
	// TODO Auto-generated constructor stub
	this.from=from;
	this.to=to;
	this.peakHourFare=peakHourFare;
	this.offPeakHourFare=offPeakHourFare;
	this.dailyCap=dailyCap;
	this.weeklyCap=weeklyCap;
}
public Zones getFrom() {
	return from;
}
public void setFrom(Zones from) {
	this.from = from;
}
public Zones getTo() {
	return to;
}
public void setTo(Zones to) {
	this.to = to;
}
public int getPeakHourFare() {
	return peakHourFare;
}
public void setPeakHourFare(int peakHourFare) {
	this.peakHourFare = peakHourFare;
}
public int getOffPeakHourFare() {
	return offPeakHourFare;
}
public void setOffPeakHourFare(int offPeakHourFare) {
	this.offPeakHourFare = offPeakHourFare;
}
public int getDailyCap() {
	return dailyCap;
}
public void setDailyCap(int dailyCap) {
	this.dailyCap = dailyCap;
}
public int getWeeklyCap() {
	return weeklyCap;
}
public void setWeeklyCap(int weeklyCap) {
	this.weeklyCap = weeklyCap;
}

}
