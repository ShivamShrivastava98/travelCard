package travelcard.logic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import travelcard.model.DailyJourneySummary;
import travelcard.model.JourneyInfo;
import travelcard.model.JourneySummary;
import travelcard.model.TransactionResult;
import travelcard.model.WeeklyJourneySummary;
import travelcard.model.ZoneFare;
import travelcard.repositary.IFaresRepository;
import travelcard.repositary.IPeakHoursRepository;

public class JourneyHandler {
    private IFaresRepository fareRepo;
    private IPeakHoursRepository peakHoursRepo;

    public JourneyHandler(IFaresRepository fareRepo, IPeakHoursRepository peakHoursRepo) {
        this.fareRepo = fareRepo;
        this.peakHoursRepo = peakHoursRepo;
    }

    public int getJourneyPrice(JourneyInfo journey, JourneySummary outSummary) {
//        outSummary = new JourneySummary();

        boolean isPeakHour = peakHoursRepo.isPeakHours(journey);

        ZoneFare fare = fareRepo.getFare(journey);
        outSummary.setFare(fare);
        outSummary.setPeakHour(isPeakHour);
        outSummary.setJourneyInfo(journey);

        return setPeakHours(outSummary);
    }

    public int setPeakHours(JourneySummary summary) {
        int fare = 0;
        if (summary.isPeakHour()) {
            fare = summary.getFare().getPeakHourFare();
            summary.setExplanation("Peak hours Single fare");
        } else {
            fare = summary.getFare().getOffPeakHourFare();
            summary.setExplanation("Off-peak single fare");
        }

        return fare;
    }

    
    
    
    
    
    
    
    public void reInitializeJourney(Integer weeklyCap, DailyJourneySummary dailySummary, Integer dailyCap, JourneySummary summary) {

        DayOfWeek dayOfWeek = summary.getJourneyInfo().getJourneyDateTime().getDayOfWeek();
        int weekNumber = summary.getJourneyInfo().getJourneyDateTime().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        dailySummary.setDay(dayOfWeek);
        dailySummary.setDailyCapAmountApplicable(dailyCap);
        dailySummary.setWeeklyCapAmountApplicable(weeklyCap);
        dailySummary.setExplanation("Daily cap not reached");
    }
    
    
    
    public Map<Integer, Map<LocalDate, List<JourneyInfo>>> getJourneysByWeek(List<JourneyInfo> journeys) {
        Map<Integer, Map<LocalDate, List<JourneyInfo>>> journeyByWeek = new HashMap<>();
        
        for (JourneyInfo journey : journeys) {
            int weekNumber = calculateWeekNumber(journey.getJourneyDateTime());
            
            if (!journeyByWeek.containsKey(weekNumber)) {
                journeyByWeek.put(weekNumber, new HashMap<>());
            }
            
            Map<LocalDate, List<JourneyInfo>> weekJourneys = journeyByWeek.get(weekNumber);

            if (!weekJourneys.containsKey(journey.getJourneyDateOnly())) {
                weekJourneys.put(journey.getJourneyDateOnly(), new ArrayList<>());
            }
            
            weekJourneys.get(journey.getJourneyDateOnly()).add(journey);
        }
        return journeyByWeek;
    }

    private int calculateWeekNumber(LocalDateTime dateTime) {
        int dayOfYear = dateTime.getDayOfYear();
        int dayOfWeek = dateTime.getDayOfWeek().getValue();
        int daysInWeek = 7;
        int daysTillFirstDayOfWeek = (dayOfWeek - 1 + daysInWeek) % daysInWeek;
        int weekNumber = (dayOfYear - daysTillFirstDayOfWeek) / daysInWeek + 1;
        
        return weekNumber;
    }


    public TransactionResult calculateFares(List<JourneyInfo> journeys) {
    	TransactionResult result = new TransactionResult();
        Map<Integer, Map<LocalDate, List<JourneyInfo>>> weeklyJourneys = getJourneysByWeek(journeys);
        int fareTotal = 0;
       
        WeeklyJourneySummary weeklyJourneySummary;
        for (Map.Entry<Integer, Map<LocalDate, List<JourneyInfo>>> journeyDayPair : weeklyJourneys.entrySet()) {
            weeklyJourneySummary = new WeeklyJourneySummary();
            weeklyJourneySummary.setCalculatedFare(0);
            boolean weeklyLimitReached = false;

            ZoneFare weeklyCapFare = fareRepo.getMaxDailyCapInJourneys(journeyDayPair.getValue());
            
            Integer weeklyCap = (weeklyCapFare != null) ? weeklyCapFare.getWeeklyCap() : null;

            for (List<JourneyInfo> journeyDay : journeyDayPair.getValue().values()) {
                boolean dailyLimitReached = false;
                int dailyFare = 0;
                DailyJourneySummary dailySummary = new DailyJourneySummary();
                boolean isFirstIteration = true;
                if (weeklyLimitReached) {
                    dailySummary.setCalculatedFare(0);
                    dailySummary.setExplanation("A weekly cap of " + weeklyCap + " reached");
                    dailySummary.setDay(journeyDay.get(0).getJourneyDateTime().getDayOfWeek());
                    break;
                }
               
                ZoneFare dailyCapFare = fareRepo.getMaxDailyCapInJourneys(journeyDay);
              
                Integer dailyCap = (dailyCapFare != null) ? dailyCapFare.getDailyCap() : null;

                int journeyFare = 0;
             
                for (JourneyInfo journey : journeyDay) {
                	JourneySummary summary=new JourneySummary();                	
                    journeyFare = getJourneyPrice(journey, summary);
                    if (isFirstIteration) {
                        isFirstIteration = false;
                        reInitializeJourney(weeklyCap, dailySummary, dailyCap, summary);
                    }

                    if (!dailySummary.getZones().contains(journey.getZoneFrom())) {
                        dailySummary.getZones().add(journey.getZoneFrom());
                    }
                    if (!dailySummary.getZones().contains(journey.getZoneTo())) {
                        dailySummary.getZones().add(journey.getZoneTo());
                    }

                    int estimatedFareOfDay = journeyFare + dailyFare;

                    if (dailyCap != null && estimatedFareOfDay > dailyCap) {
                        summary.setExplanation("Daily cap reached " + dailyCap +
                                " for " + summary.getFare().getFrom() + " - " + summary.getFare().getTo() +
                                " charged " + (dailyCap - dailyFare) +
                                " instead of " + journeyFare);
                        journeyFare = dailyCap - dailyFare;
                        dailySummary.setExplanation("Daily cap reached");
                        dailyFare = dailyCap;
                        estimatedFareOfDay = dailyFare;
                        dailyLimitReached = true;
                    }

                    int estimatedFareOfWeek = estimatedFareOfDay + weeklyJourneySummary.getCalculatedFare();

                    if (weeklyCap != null && estimatedFareOfWeek > weeklyCap) {
                        summary.setExplanation("Weekly cap of " + weeklyCap +
                                " reached before the daily cap of " + dailyCap);
                        journeyFare = journeyFare - (estimatedFareOfWeek - weeklyCap);
                        weeklyLimitReached = true;
                    }

                    if (!dailyLimitReached) {
                        dailyFare += journeyFare;
                    }

                    summary.setCalculatedFare(journeyFare);
                    dailySummary.setCalculatedFare(dailyFare);
                    dailySummary.getJourneySummary().add(summary);
                }

                weeklyJourneySummary.getJourneySummary().add(dailySummary);
                weeklyJourneySummary.setCalculatedFare(weeklyJourneySummary.getCalculatedFare() + dailySummary.getCalculatedFare());
            }

            weeklyJourneySummary.setWeekNumber(journeyDayPair.getKey());
            fareTotal += weeklyJourneySummary.getCalculatedFare();
            result.getWeeklySummary().add(weeklyJourneySummary);
            result.setTotal(fareTotal);
        }

        return result;
    }
    
}
