package com.viewmodel;

import com.dto.Ticket;
import com.model.Repository;
import com.view.MainView;

public class CancelViewModel {
     MainView mv;
     
     public CancelViewModel(MainView mv){
    	 this.mv=mv;
     }

	public void cancelTickets(String[] inputArray) {
		mv.printMessage("****************************");
		int pnrNo=Integer.parseInt(inputArray[1]);
		int noOfSeats=Integer.parseInt(inputArray[2]);
		if(Repository.getInstance().isValidForCancelling(pnrNo,noOfSeats)) {
			
			Repository.getInstance().cancelTickets(pnrNo,noOfSeats);
			
			Repository.getInstance().updateCancellingInChart(pnrNo,noOfSeats);
			
			if(Repository.getInstance().isWaitingListAvailableToConfirm()) {
				Ticket confirmedTicket=Repository.getInstance().confirmWaitingListAndGetTicket();
				//Repository.getInstance().bookTicket(confirmedTicket.getNoOfSeats(), confirmedTicket.getSource(), confirmedTicket.getDestination());
				if(confirmedTicket !=null) {
					mv.printMessage(noOfSeats+" seats in PNR number "+pnrNo+" cancelled successfully.");
					mv.printMessage("Ticket number "+confirmedTicket.getPnrNo()+" confirmed from waiting list.");
				}
			}
			else {
				mv.printMessage(noOfSeats+" seats in PNR number "+pnrNo+" cancelled successfully.");
			}
		}
		else {
			mv.printError("Provided information is not valid for cancelation.");
		}
		
		mv.printMessage("****************************");
	}
}
