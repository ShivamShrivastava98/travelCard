package travelcard.repositary;

import travelcard.model.JourneyInfo;
import travelcard.model.ZoneFare;
import travelcard.model.Zones;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FaresRepository implements IFaresRepository {

	private static List<ZoneFare> fares;
	 static {
	        populateEntitiesFromDB();
	    }
	 private static void populateEntitiesFromDB() {
	        fares = new ArrayList<>();
	        fares.add(new ZoneFare(Zones.Zone1, Zones.Zone1, 30, 25, 100, 500));
	        fares.add(new ZoneFare(Zones.Zone1, Zones.Zone2, 35, 30, 120, 600));
	        fares.add(new ZoneFare(Zones.Zone2, Zones.Zone1, 35, 30, 120, 600));
	        fares.add(new ZoneFare(Zones.Zone2, Zones.Zone2, 25, 20, 80, 400));
	    }
	
	@Override
	public ZoneFare getFare(JourneyInfo journey) {
		return fares.stream()
                .filter(f -> f.getFrom() == journey.getZoneFrom() && f.getTo()==journey.getZoneTo())
                .findFirst()
                .orElse(null);
	}
	private List<ZoneFare> getRatesForJourneys(List<JourneyInfo> journeys) {
        return journeys.stream()
                .flatMap(journey -> fares.stream()
                        .filter(f -> f.getFrom() == journey.getZoneFrom() && f.getTo() == journey.getZoneTo()))
                .collect(Collectors.toList());
    }
    @Override
	public ZoneFare getMaxDailyCapInJourneys(Map<LocalDate, List<JourneyInfo>> journeysInADay) {
    	  List<JourneyInfo> journeys = new ArrayList<>();
          journeysInADay.values().forEach(journeys::addAll);
          return getMaxWeeklyCapInJourneys(journeys);
	}

	@Override
	public ZoneFare getMaxDailyCapInJourneys(List<JourneyInfo> journeys) {
		 List<ZoneFare> rates = getRatesForJourneys(journeys);
	        return rates.stream()
	                .max((r1, r2) -> Integer.compare(r1.getDailyCap(), r2.getDailyCap()))
	                .orElse(null);
	}
	 private ZoneFare getMaxWeeklyCapInJourneys(List<JourneyInfo> journeys) {
	        List<ZoneFare> rates = getRatesForJourneys(journeys);
	        return rates.stream()
	                .max((r1, r2) -> Integer.compare(r1.getWeeklyCap(), r2.getWeeklyCap()))
	                .orElse(null);
	    }
	}
