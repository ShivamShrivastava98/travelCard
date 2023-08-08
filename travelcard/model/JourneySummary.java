package travelcard.model;

public class JourneySummary {
	
private ZoneFare fare;
private boolean isPeakHour;
private int calculatedFare;
private JourneyInfo journeyInfo;
private String explanation;


public ZoneFare getFare() {
	return fare;
}
public void setFare(ZoneFare fare) {
	this.fare = fare;
}
public boolean isPeakHour() {
	return isPeakHour;
}
public void setPeakHour(boolean isPeakHour) {
	this.isPeakHour = isPeakHour;
}
public int getCalculatedFare() {
	return calculatedFare;
}
public void setCalculatedFare(int calculatedFare) {
	this.calculatedFare = calculatedFare;
}
public JourneyInfo getJourneyInfo() {
	return journeyInfo;
}
public void setJourneyInfo(JourneyInfo journeyInfo) {
	this.journeyInfo = journeyInfo;
}
public String getExplanation() {
	return explanation;
} 
public void setExplanation(String explanation) {
	this.explanation = explanation;
}
public String toString() {
	return "Day: "+journeyInfo.getJourneyDateTime().getDayOfWeek()+
		   ", Time: "+journeyInfo.getJourneyDateTime().toLocalTime().toString()+
		   ", From: "+journeyInfo.getZoneFrom()+
		   ", To: "+ journeyInfo.getZoneTo()+
		   ", Calculated fare: " +calculatedFare+
		   ", Explanation: "+ explanation;
}
}
