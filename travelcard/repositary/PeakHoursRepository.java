package travelcard.repositary;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import travelcard.model.CrossZonePeakHourDetails;
import travelcard.model.JourneyInfo;
import travelcard.model.PeakHourDetails;
import travelcard.model.Zones;

public class PeakHoursRepository implements IPeakHoursRepository {
    private static List<PeakHourDetails> peakHours;
    private static List<CrossZonePeakHourDetails> crossZoneOffPeakHours;

    static {
        populateEntitiesFromDB();
    }

    private static void populateEntitiesFromDB() {
        peakHours = new ArrayList<>();
        peakHours.add(new PeakHourDetails(DayOfWeek.MONDAY, LocalTime.of(7, 0, 0), LocalTime.of(10, 30, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.TUESDAY, LocalTime.of(7, 0, 0), LocalTime.of(10, 30, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.WEDNESDAY, LocalTime.of(7, 0, 0), LocalTime.of(10, 30, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.THURSDAY, LocalTime.of(7, 0, 0), LocalTime.of(10, 30, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.FRIDAY, LocalTime.of(7, 0, 0), LocalTime.of(10, 30, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.MONDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.TUESDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.WEDNESDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.THURSDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.FRIDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.SATURDAY, LocalTime.of(9, 0, 0), LocalTime.of(11, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.SUNDAY, LocalTime.of(9, 0, 0), LocalTime.of(11, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.SATURDAY, LocalTime.of(18, 0, 0), LocalTime.of(22, 0, 0)));
        peakHours.add(new PeakHourDetails(DayOfWeek.SUNDAY, LocalTime.of(18, 0, 0), LocalTime.of(22, 0, 0)));

        crossZoneOffPeakHours = new ArrayList<>();
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.MONDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0), Zones.Zone1));
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.TUESDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0), Zones.Zone1));
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.WEDNESDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0), Zones.Zone1));
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.THURSDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0), Zones.Zone1));
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.FRIDAY, LocalTime.of(17, 0, 0), LocalTime.of(20, 0, 0), Zones.Zone1));
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.SATURDAY, LocalTime.of(18, 0, 0), LocalTime.of(22, 0, 0), Zones.Zone1));
        crossZoneOffPeakHours.add(new CrossZonePeakHourDetails(DayOfWeek.SUNDAY, LocalTime.of(18, 0, 0), LocalTime.of(22, 0, 0), Zones.Zone1));
    }

    @Override
    public boolean isPeakHours(JourneyInfo journey) {
        boolean isPeakHour = isRegularPeakHours(journey);

        if (isPeakHour && !journey.getZoneFrom().equals(journey.getZoneTo())) {
            boolean offPeakHour = isCrossZoneOffPeakHours(journey);
            isPeakHour = !offPeakHour;
        }

        return isPeakHour;
        }
    
    private boolean isRegularPeakHours(JourneyInfo journey) {
        return peakHours.stream()
                .anyMatch(p -> p.getDay() == journey.getJourneyDateTime().getDayOfWeek()
                        && p.getFrom().isBefore(journey.getJourneyTimeOnly())
                        && p.getTo().isAfter(journey.getJourneyTimeOnly()));
    }

    private boolean isCrossZoneOffPeakHours(JourneyInfo journey) {
        return crossZoneOffPeakHours.stream()
                .anyMatch(p -> p.getDay() == journey.getJourneyDateTime().getDayOfWeek()
                        && p.getFrom().isBefore(journey.getJourneyTimeOnly())
                        && p.getTo().isAfter(journey.getJourneyTimeOnly())
                        && p.getZoneTo() == journey.getZoneTo());
    }    
}