package com.viewmodel;

import com.dto.Ticket;
import com.model.Repository;
import com.view.MainView;

public class BookViewModel {
	MainView mv;
	public BookViewModel(MainView mv){
		this.mv=mv;
	}
	
	public void bookTickets(String[] inputArray) {
		mv.printMessage("****************************");
		char source=inputArray[1].charAt(0);
		char destination=inputArray[2].charAt(0);
		int noOfSeats=Integer.parseInt(inputArray[3]);
		if(Repository.getInstance().isSeatsAvailable(noOfSeats,source,destination)) {
			Repository.getInstance().bookTicket(noOfSeats,source,destination);
			Ticket bookedTicket=Repository.getInstance().getBookedTicket(noOfSeats,source,destination);
			mv.printMessage("Ticket Booked successfully.");
			mv.printMessage(bookedTicket.toString());
			
		}
		else if(Repository.getInstance().isValidForWaitingList(noOfSeats)) {
			Ticket bookWaitingListTicket=Repository.getInstance().bookWaitingListTicket(noOfSeats,source,destination);
			mv.printMessage("Booked as Waiting List.");
			mv.printMessage(bookWaitingListTicket.toString());
		}
		else {
			mv.printError("No seats Available..");
		}
		mv.printMessage("****************************");
	}

}
