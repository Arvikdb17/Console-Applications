package screens.stop;

import repositary.TaxiBookingRepositary;
import screens.BaseScreen;

public class StopScreen extends BaseScreen{
   private StopScreenModel stopScreenModel;
   
   public StopScreen() {
	   this.stopScreenModel=new StopScreenModel(this);
   }

public void onCreate() {
	printMessage("Enter Otp to stop.");
	int otp=TaxiBookingRepositary.scanner.nextInt();
	
	stopScreenModel.stopTaxi(otp);
	
}
  
}
