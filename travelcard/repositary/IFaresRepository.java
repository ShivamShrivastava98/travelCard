package travelcard.repositary;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import travelcard.model.JourneyInfo;
import travelcard.model.ZoneFare;
public interface IFaresRepository {
	 ZoneFare getFare(JourneyInfo journey);
	 ZoneFare getMaxDailyCapInJourneys(Map<LocalDate, List<JourneyInfo>> map);
     ZoneFare getMaxDailyCapInJourneys(List<JourneyInfo> journeys);
}










