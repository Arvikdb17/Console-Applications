package screens.book;

import dto.Taxi;
import repositary.TaxiBookingRepositary;
import screens.BaseScreen;

public class BookScreen extends BaseScreen{
	private BookScreenModel bookScreenModel;
	
	public BookScreen() {
		this.bookScreenModel=new BookScreenModel(this);
	}

	public void onCreate() {
		printMessage("Available Bola cab service locations");
		printMessage("A <--> B <--> C <--> D <--> E <--> F <--> G");
		printMessage("Enter the pick up location :");
		char pickUpLocation=TaxiBookingRepositary.scanner.next().charAt(0);
		printMessage("Enter the drop location :");
		char dropLocation=TaxiBookingRepositary.scanner.next().charAt(0);
		printMessage("Enter the Taxi type :  available type => (mini/sedan/suv)");
		String taxiType=TaxiBookingRepositary.scanner.next();
		
		bookScreenModel.bookTaxi(pickUpLocation,dropLocation,taxiType);
		
	}

	public void printBookingDetails(Taxi bookingTaxi, int costOfRaid) {
		printMessage("Taxi Booked Successfully");
		printMessage("Taxi No : "+bookingTaxi.getTaxiNo());
		printMessage("Driver Name : "+bookingTaxi.getDriverName());
		printMessage("Driver No : "+bookingTaxi.getDriverNumber());
		printMessage("Cost of raid : "+costOfRaid);
		printMessage("Otp : "+bookingTaxi.getOtp());
		
	}

}
