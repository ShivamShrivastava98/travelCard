package travelcard.logic;

import java.util.List;
import travelcard.model.DailyJourneySummary;
import travelcard.model.JourneyInfo;
import travelcard.model.TransactionResult;
import travelcard.model.WeeklyJourneySummary;
import travelcard.repositary.IFaresRepository;
import travelcard.repositary.IPeakHoursRepository;

public class BLRCard {
    private IFaresRepository fareRepo;
    private IPeakHoursRepository peakHoursRepo;

    public BLRCard(IFaresRepository faresRepo, IPeakHoursRepository peakHoursRepo) {
        this.fareRepo = faresRepo;
        this.peakHoursRepo = peakHoursRepo;
    }
    

    public TransactionResult CalculateFares(List<JourneyInfo> journeys) {
        JourneyHandler journeyHandler = new JourneyHandler(fareRepo, peakHoursRepo);
        return journeyHandler.calculateFares(journeys);
      }

    public void printDailySummary(WeeklyJourneySummary weeklyJourney) {
        for (DailyJourneySummary summary : weeklyJourney.getJourneySummary()) {
            System.out.println(summary.toString());
        }
    }
    public void PrintWeeklySummary(TransactionResult result) {
        for (WeeklyJourneySummary summary : result.getWeeklySummary()) {
            System.out.println(summary.toString());
        }
    }
}
