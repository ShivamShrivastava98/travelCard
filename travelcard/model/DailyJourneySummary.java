package travelcard.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.DayOfWeek;

public class DailyJourneySummary {
private DayOfWeek day;
private List<JourneySummary> journeySummary=new ArrayList<>();
private int calculatedFare;
private Set<Zones> zones=new HashSet<>();
private Integer dailyCapAmountApplicable;
private Integer weeklyCapAmountApplicable;
private String explanation;
public DayOfWeek getDay() {
	return day;
}
public void setDay(DayOfWeek day) {
	this.day = day;
}
public List<JourneySummary> getJourneySummary() {
	return journeySummary;
}
public void setJourneySummary(List<JourneySummary> journeySummary) {
	this.journeySummary = journeySummary;
}
public int getCalculatedFare() {
	return calculatedFare;
}
public void setCalculatedFare(int calculatedFare) {
	this.calculatedFare = calculatedFare;
}
public Set<Zones> getZones() {
	return zones;
}
public void setZones(Set<Zones> zones) {
	this.zones = zones;
}
public Integer getDailyCapAmountApplicable() {
	return dailyCapAmountApplicable;
}
public void setDailyCapAmountApplicable(Integer dailyCapAmountApplicable) {
	this.dailyCapAmountApplicable = dailyCapAmountApplicable;
}
public Integer getWeeklyCapAmountApplicable() {
	return weeklyCapAmountApplicable;
}
public void setWeeklyCapAmountApplicable(Integer weeklyCapAmountApplicable) {
	this.weeklyCapAmountApplicable = weeklyCapAmountApplicable;
}
public String getExplanation() {
	return explanation;
}
public void setExplanation(String explanation) {
	this.explanation = explanation;
}

public String toString(){
	StringBuilder builder= new StringBuilder();
	builder.append("Day: ").append(day);
    builder.append(", Zones: ").append(String.join("-", zones.toString()));
    builder.append(", Fare: ").append(calculatedFare);
    builder.append(", Explanation: ").append(explanation).append("\n");
    builder.append("-------------------------------------\n");
    for (JourneySummary item : journeySummary) {
        builder.append(item.toString()).append("\n");
    }
    builder.append("-------------------------------------\n");
    return builder.toString();
}
}
