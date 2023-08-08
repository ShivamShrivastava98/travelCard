package travelcard.repositary;

import travelcard.model.JourneyInfo;

public interface IPeakHoursRepository {
	boolean isPeakHours(JourneyInfo journey);
}
