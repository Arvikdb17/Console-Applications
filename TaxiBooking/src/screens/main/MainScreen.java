package screens.main;

import repositary.TaxiBookingRepositary;
import screens.BaseScreen;
import screens.add.AddScreen;
import screens.book.BookScreen;
import screens.cancel.CancelScreen;
import screens.stop.StopScreen;

public class MainScreen extends BaseScreen{
   private MainScreenModel mainScreenModel;
   
   public MainScreen() {
	   this.mainScreenModel=new MainScreenModel(this);
   }
	
   public void onCreate() {
	   printMessage("********  Welcome to Bola cabs  ********");
	   printMessage("Please select the operation :");
	   int option=0;
	   
	   
	   
	   while(option !=6) {
		   printMessage("1. Add Taxi");
		   printMessage("2. Book Taxi");
		   printMessage("3. Cancel Taxi");
		   printMessage("4. Stop Taxi");
		   printMessage("5. Print Taxi");
		   printMessage("6. Exit");
	  option=TaxiBookingRepositary.scanner.nextInt();
	   switch(option) {
	   case 1: 
		   AddScreen as=new AddScreen();
		   as.onCreate();
		   break;
	   case 2: 
		   BookScreen bs=new BookScreen();
		   bs.onCreate();
		   break;
	   case 3: 
		   CancelScreen cs=new CancelScreen();
		   cs.onCreate();
		   break;
	   case 4: 
		   StopScreen ss=new StopScreen();
		   ss.onCreate();
		   break;
	   case 5: 
		   mainScreenModel.printTaxiDetails();
		   break;
	   case 6 :
		   printMessage("ThankYou .....");
		   break;
	   default : 
		   printMessage("Invalid input please try again");
		   break;
	   }
	   }
	   
   }

}
