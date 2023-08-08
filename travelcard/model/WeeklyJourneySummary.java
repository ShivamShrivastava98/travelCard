package travelcard.model;

import java.util.ArrayList;
import java.util.List;

public class WeeklyJourneySummary {
	private List<DailyJourneySummary> journeySummary=new ArrayList<>();
	private Integer calculatedFare;
	private int weekNumber;
	
public List<DailyJourneySummary> getJourneySummary() {
		return journeySummary;
	}
	public void setJourneySummary(List<DailyJourneySummary> journeySummary) {
		this.journeySummary = journeySummary;
	}
	public Integer getCalculatedFare() {
		return calculatedFare;
	}
	public void setCalculatedFare(Integer calculatedFare) {
		this.calculatedFare = calculatedFare;
	}
	public int getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
@Override
public String toString() {
	StringBuilder builder=new StringBuilder();
	builder.append("******************* Weekly *******************");
	builder.append("\t Week Number ").append(weekNumber).append("\n");
	builder.append("=================== Daily =====================");
	for(DailyJourneySummary item : journeySummary) {
		builder.append(item.toString()).append("\n");
	}
	builder.append("************************************************");
	builder.append("\t Weekly total for  Week Number ").append(weekNumber)
	.append(" is:").append(calculatedFare);
	return builder.toString();
	
}

}
