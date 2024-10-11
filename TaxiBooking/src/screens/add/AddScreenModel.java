package screens.add;

import java.util.Random;

import dto.Taxi;
import repositary.TaxiBookingRepositary;

public class AddScreenModel {
   private AddScreen addScreen;
   
   AddScreenModel(AddScreen addScreen){
	   this.addScreen=addScreen;
   }

public void addTaxi(String taxiNo, String type, String driverName, long driverNumber) {
	Taxi taxi=new Taxi();
	taxi.setDriverName(driverName);
	taxi.setTaxiType(type);
	taxi.setTaxiNo(taxiNo);
	taxi.setDriverNumber(driverNumber);
	taxi.setCurrentLocation('A');
	taxi.setOtp(getOtp());
	taxi.setTotalEarnings(0);
	taxi.setAvailable(true);
	
	TaxiBookingRepositary.getInstance().taxis.add(taxi);
	addScreen.printMessage("Taxi no. "+ taxiNo +" added susscesfully.");
}

private int getOtp() {
	Random r=new Random();
	
	return 1000+r.nextInt(8999);
}
}
