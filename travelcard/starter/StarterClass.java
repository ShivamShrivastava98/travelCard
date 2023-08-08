package travelcard.starter;

import java.util.List;
import travelcard.logic.BLRCard;
import travelcard.model.JourneyInfo;
import travelcard.model.TransactionResult;
import travelcard.repositary.FaresRepository;
import travelcard.repositary.PeakHoursRepository;
import travelcard.tester.TestDataSet;

public class StarterClass {

	public static void main(String[] args) {
		

//		One Day journey  
		List<JourneyInfo> inputJourneys1=TestDataSet.GetData1();
		BLRCard card1=new BLRCard(new FaresRepository(),new PeakHoursRepository());
	    TransactionResult result1=card1.CalculateFares(inputJourneys1);
	    int total1=result1.getTotal();
	    System.out.println(total1);
		
		
//		Two Day Journey
//	    List<JourneyInfo> inputJourneys2=TestDataSet.GetData2();
//	    BLRCard card2=new BLRCard(new FaresRepository(),new PeakHoursRepository());
//	    TransactionResult result2=card2.CalculateFares(inputJourneys2);
//	    int total2=result2.getTotal();
//	    System.out.println(total2);
		
//		one Week journey completed with one more day 
	    List<JourneyInfo> inputJourneys3=TestDataSet.GetData3();
	    BLRCard card3=new BLRCard(new FaresRepository(),new PeakHoursRepository());
	    TransactionResult result3=card3.CalculateFares(inputJourneys3);
	    int total3=result3.getTotal();
	    System.out.println(total3);
	}

}
