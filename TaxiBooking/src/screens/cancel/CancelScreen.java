package screens.cancel;

import repositary.TaxiBookingRepositary;
import screens.BaseScreen;

public class CancelScreen extends BaseScreen{
	private CancelScreenModel cancelScreenModel;
	
	public CancelScreen() {
		this.cancelScreenModel=new CancelScreenModel(this);
	}

	public void onCreate() {
		printMessage("Enter the otp to cancel");
		int otp=TaxiBookingRepositary.scanner.nextInt();
		
		cancelScreenModel.canceltaxi(otp);
		
	}

}
