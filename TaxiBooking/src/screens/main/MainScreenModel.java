package screens.main;

import java.util.List;

import dto.Taxi;
import repositary.TaxiBookingRepositary;

public class MainScreenModel {
     private MainScreen mainScreen;
     
     MainScreenModel(MainScreen mainScreen){
    	 this.mainScreen=mainScreen;
     }

	

	public void printTaxiDetails() {
		List<Taxi> taxis=TaxiBookingRepositary.getInstance().taxis;
		if(taxis.size()>0) {
			for(Taxi t : taxis) {
				mainScreen.printMessage(t.toString());
				if(t.isAvailable())
					mainScreen.printMessage("Status : Available");
				else
					mainScreen.printMessage("Status : Not Available");
			}
		}
		else
			mainScreen.printError("No Taxis in the list.");
		
		
	}
}
