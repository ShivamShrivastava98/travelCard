package travelcard.model;

import java.util.ArrayList;
import java.util.List;

public class TransactionResult {
private List<WeeklyJourneySummary> weeklySummary=new ArrayList<>();
private int total =0;
public List<WeeklyJourneySummary> getWeeklySummary() {
	return weeklySummary;
}
public void setWeeklySummary(List<WeeklyJourneySummary> weeklySummary) {
	this.weeklySummary = weeklySummary;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}


}
