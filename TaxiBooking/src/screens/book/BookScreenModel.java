package screens.book;

import java.util.ArrayList;
import java.util.List;

import dto.Taxi;
import repositary.TaxiBookingRepositary;
import repositary.Utility;

public class BookScreenModel {
   private BookScreen bookScreen;
   
   BookScreenModel(BookScreen bookScreen){
	   this.bookScreen=bookScreen;
   }

public void bookTaxi(char pickUpLocation, char dropLocation, String taxiType) {
	    List<Taxi> availableTaxis=TaxiBookingRepositary.getInstance().getAvailableTaxis();
	    List<Taxi> taxis=new ArrayList<>();
	    for(Taxi t : availableTaxis) {
	    	if(t.getTaxiType().equals(taxiType)) {
	    		taxis.add(t);
	    	}
	    }
	    
	    if(taxis.size()<1) taxis=new ArrayList<>(availableTaxis);
	    Taxi bookingTaxi=getBookingTaxi(pickUpLocation,taxis);
	    int costOfRaid=Utility.getEarnings(pickUpLocation,dropLocation,taxiType);
	    TaxiBookingRepositary.getInstance().updateTaxiDetails(bookingTaxi,pickUpLocation,dropLocation,taxiType);
	    bookScreen.printBookingDetails(bookingTaxi,costOfRaid);
	    
	
}
   private Taxi getBookingTaxi(char pickUpLocation,List<Taxi> taxis) {
	
	int minDistance=Integer.MAX_VALUE;
    Taxi bookingTaxi=new Taxi();
    for(Taxi t : taxis) {
    	int distance=Math.abs(pickUpLocation-t.getCurrentLocation());
    	if(distance<minDistance) {
    		minDistance=distance;
    		bookingTaxi=t;
    	}
    }
	return bookingTaxi;
   }
}
