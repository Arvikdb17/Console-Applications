package com.view;

import com.model.Repository;
import com.viewmodel.BookViewModel;
import com.viewmodel.CancelViewModel;
import com.viewmodel.DisplayViewModel;

public class MainView {
	String input="";
	
	
	public void onCreate() {
		System.out.println("**** Welcome to Train ticket Booking Application **** ");
		System.out.println();
		while( true) {
			
			printMessage(" Route of our train ==>");
			printMessage(" A--> B--> C--> D--> E");
			printMessage("");
			printMessage("For Booking Enter details in this format -->(book,Pickup,Destination,No. of seats) ");
			printMessage("");
			printMessage("For Cancelling enter details in this format -->(cancel,PNR number,No. of seats");
			printMessage("");
			printMessage("For booking summary and chart enter (chart)");
			printMessage("");
			printMessage("For Exit enter (Exit)");
			printMessage("");
			input=Repository.getInstance().sc.next();
			String[] inputArray=input.split(",");
			switch(inputArray[0]) {
			case "book":
				BookViewModel bvm=new BookViewModel(this);
				bvm.bookTickets(inputArray);
				break;
			case "cancel":
				CancelViewModel cvm=new CancelViewModel(this);
				cvm.cancelTickets(inputArray);
				break;
			case "chart":
				DisplayViewModel dvm=new DisplayViewModel(this);
				dvm.displayChart();
				break;
			case "exit" :
				System.exit(0);
				break;
			default :
				printError("Please enter valid input.");
			}

		}
		
		
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	public void printError(String error) {
		System.err.println(error);
	}

	public void print(String string) {
		System.out.print(string);
		
	}

}
