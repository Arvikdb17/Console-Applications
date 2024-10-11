package screens.cancel;

import repositary.TaxiBookingRepositary;
import screens.BaseScreen;

public class CancelScreenModel {

	
	private CancelScreen cancelScreen;
	
	CancelScreenModel(CancelScreen cancelScreen){
		this.cancelScreen=cancelScreen;
	}

	public void canceltaxi(int otp) {
		if(TaxiBookingRepositary.getInstance().hasTaxiWithGivenOtp(otp)) {
			TaxiBookingRepositary.getInstance().cancelTaxi(otp);
			cancelScreen.printMessage("Taxi cancelled successfully");
		}
		else {
			cancelScreen.printError("Invalid OTP");
		}
		
	}
}
