package travelcard.tester;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import travelcard.model.JourneyInfo;
import travelcard.model.Zones;

public class TestDataSet {

	public static List<JourneyInfo> GetData1() {
	List<JourneyInfo> dataSet1=new ArrayList<>(); 
	dataSet1.add(new JourneyInfo(LocalDateTime.of(2023, 7, 31, 10, 20,0),Zones.Zone2, Zones.Zone1));
	dataSet1.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 10,45,0),Zones.Zone1, Zones.Zone1));
	dataSet1.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 16,15,0),Zones.Zone1, Zones.Zone1));
	dataSet1.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 18,15,0),Zones.Zone1, Zones.Zone1));
	dataSet1.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 19,00,0),Zones.Zone1, Zones.Zone2));
	return dataSet1;
	}
	public static List<JourneyInfo> GetData2() {
		List<JourneyInfo> dataSet2=new ArrayList<>(); 
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 10,20,0),Zones.Zone2, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 10,45,0),Zones.Zone1, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 16,15,0),Zones.Zone1, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 18,15,0),Zones.Zone1, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 19,00,0),Zones.Zone1, Zones.Zone2));
		
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 10,28,0),Zones.Zone2, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 10,48,0),Zones.Zone1, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 16,18,0),Zones.Zone1, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 18,18,0),Zones.Zone1, Zones.Zone1));
		dataSet2.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 19,8,0),Zones.Zone1, Zones.Zone2));
		return dataSet2;
	}
	public static List<JourneyInfo> GetData3() {
		List<JourneyInfo> dataSet3=new ArrayList<>(); 
		//monday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 10,20,0),Zones.Zone2, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 10,45,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 16,15,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 18,15,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,7, 31, 19,00,0),Zones.Zone1, Zones.Zone2));
		//tuesday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 10,28,0),Zones.Zone2, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 10,48,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 16,18,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 18,18,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 1, 19,8,0),Zones.Zone1, Zones.Zone2));
		// wednesday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 2, 10,28,0),Zones.Zone2, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 2, 10,48,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 2, 16,18,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 2, 18,18,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 2, 19,8,0),Zones.Zone1, Zones.Zone2));
		//thursday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 3, 10,28,0),Zones.Zone2, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 3, 10,48,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 3, 16,18,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 3, 18,18,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 3, 19,8,0),Zones.Zone1, Zones.Zone2));
		//friday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 4, 7,40,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 4, 10,40,0),Zones.Zone1, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 4, 12,48,0),Zones.Zone1, Zones.Zone1));
		//saturday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 5, 9,0,0),Zones.Zone1, Zones.Zone2));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 5, 10,30,0),Zones.Zone2, Zones.Zone1));
		//sunday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 6, 9,0,0),Zones.Zone1, Zones.Zone2));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 6, 10,30,0),Zones.Zone2, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 6, 11,45,0),Zones.Zone1, Zones.Zone2));
		//Monday
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 7, 9,0,0),Zones.Zone1, Zones.Zone2));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 7, 10,30,0),Zones.Zone2, Zones.Zone1));
		dataSet3.add(new JourneyInfo(LocalDateTime.of(2023,8, 7, 17,30,0),Zones.Zone1, Zones.Zone2));
		return dataSet3;
	}
}

