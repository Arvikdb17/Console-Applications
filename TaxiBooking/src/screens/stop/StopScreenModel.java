package screens.stop;

import repositary.TaxiBookingRepositary;

public class StopScreenModel {
	private StopScreen stopScreen;
	
	

	public StopScreenModel(StopScreen stopScreen) {
		this.stopScreen=stopScreen;
	}



	public void stopTaxi(int otp) {
		if(TaxiBookingRepositary.getInstance().hasTaxiWithGivenOtp(otp)) {
			TaxiBookingRepositary.getInstance().StopTaxi(otp);
			stopScreen.printMessage("taxi stoped succesfully");
		}
		else {
			stopScreen.printError("Invalid OTP");
		}
		
	}

}
