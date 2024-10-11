package screens.add;

import repositary.TaxiBookingRepositary;
import screens.BaseScreen;

public class AddScreen extends BaseScreen{
	private AddScreenModel addScreenModel;
	
	public AddScreen() {
		this.addScreenModel=new AddScreenModel(this);
	}

	public void onCreate() {
		printMessage("Enter the Taxi no. (TN 19 AS 3099)format");
		String taxiNo =TaxiBookingRepositary.scanner.next();
		printMessage("Enter the Taxi type.   (mini/sedan/suv)");
		String type=TaxiBookingRepositary.scanner.next();
		printMessage("Enter the Driver Name.");
		String driverName=TaxiBookingRepositary.scanner.next();
		printMessage("Enter the Driver Number.");
		long driverNumber=TaxiBookingRepositary.scanner.nextLong();
		
		addScreenModel.addTaxi(taxiNo,type,driverName,driverNumber);
		
	}

}
