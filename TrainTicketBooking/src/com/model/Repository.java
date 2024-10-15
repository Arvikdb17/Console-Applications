package com.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.dto.Ticket;
import com.dto.TicketStatus;

public class Repository {
	public static int pnrNo;
	private static Repository repository;
	public Scanner sc=new Scanner(System.in);
	public   char[][] chart;
	public Queue<Ticket> waitingList;
	public List<Ticket> tickets;
	
	
	
	public Repository() {
		  chart=initializeChart();
		  waitingList=new LinkedList<>();
		  tickets=new ArrayList<>();
		  this.pnrNo++;
	}
	
	private char[][] initializeChart() {
		chart=new char[9][6];
		//for seats
		char station='A';
		char seat='1';
		for(int i=0;i<chart.length;i++) {
			for(int j=0;j<chart[0].length;j++) {
				if(i==0 && j>0) {
					chart[i][j]=station++;
				}
				else if(j==0 && i>0) {
					chart[i][j]=seat++;
				}
				else {
					chart[i][j]=' ';
				}
			}
		}
		
		return chart;
	}

	

	public static Repository getInstance() {
		if(repository==null) {
			repository=new Repository();
		}
		return repository;
	}

	public boolean isSeatsAvailable(int noOfSeats,char source,char destination) {
		
		
			for(int j=(source-'A'+1);j<destination-'A'+1;j++) {
				int i=1;
				int seats=noOfSeats;
				while(i<9) {
					if(chart[i++][j]==' ') {
						seats--;
						if(seats==0) break;
					}
				}
				if(seats >0) return false;
			}
		
		return true;
	}

	
		public Ticket getBookedTicket(int noOfSeats, char source, char destination) {
		//creating
		Ticket ticket=new Ticket(source,destination,noOfSeats);
		ticket.setTicketStatus(TicketStatus.Booked);
		tickets.add(ticket);
		
		return ticket;
	}

		public void bookTicket(int noOfSeats, char source, char destination) {
			//Booking ticket in chart:
			for(int j=(source-'A'+1);j<destination-'A'+1;j++) {
				int i=1;
				int totalSeats=noOfSeats;
				while(i<9) {
					if(chart[i][j]==' ') {
						chart[i][j]='*';
						totalSeats--;
						
						if(totalSeats==0) break;
					}
					i++;
				}
			}
			
		}

		public boolean isValidForWaitingList(int noOfSeats) {
			int totalWaitingSeat=2;
			int currentNoOfWaitingSeats=0;
			for(Ticket t :waitingList) {
				currentNoOfWaitingSeats+=t.getNoOfSeats();
			}
			if(noOfSeats<=totalWaitingSeat &&  currentNoOfWaitingSeats+noOfSeats<=totalWaitingSeat) 
				return true;
			
			return false;
		}

		public Ticket bookWaitingListTicket(int noOfSeats, char source, char destination) {
			Ticket waitingTicket=new Ticket(source,destination,noOfSeats);
			waitingTicket.setTicketStatus(TicketStatus.Waiting);
			waitingList.add(waitingTicket);
			return waitingTicket;
			
		}

		public boolean isValidForCancelling(int pnrNo, int noOfSeats) {
		
			for(Ticket t:tickets)
			{
				if(t.getTicketStatus().equals(TicketStatus.Booked)) {
					if(t.getPnrNo()==pnrNo) {
						if(t.getNoOfSeats()>=noOfSeats) {
							return true;
						}
					}
				}
				/*if(t.getPnrNo()==pnrNo && t.getTicketStatus().equals(TicketStatus.Booked)) {
					if(t.getNoOfSeats()>=noOfSeats) {
						return true;
					}
					else return false;
				}*/
			}
			return false;
			
		}

		public void cancelTickets(int pnrNo, int noOfSeats) {
			for(Ticket t:tickets)
			{
				if(t.getPnrNo()==pnrNo && t.getTicketStatus().equals(TicketStatus.Booked)) {
					t.setNoOfSeats(t.getNoOfSeats()-noOfSeats);
					
					if(t.getNoOfSeats()==0) t.setTicketStatus(TicketStatus.Cancelled);
					
				}
			}
			
		}

		public void updateCancellingInChart(int pnrNo, int noOfSeats) {
			Ticket cancellingTicket=null;
			for(Ticket t:tickets)
			{
				if(t.getPnrNo()==pnrNo ) {
					cancellingTicket=t;
				}
			}
			//Cancelling
			for(int j=(cancellingTicket.getSource()-'A'+1);j<cancellingTicket.getDestination()-'A'+1;j++) {
				int i=8;
				int totalSeats=noOfSeats;
				while(i>0) {
					if(chart[i][j]=='*') {
						chart[i][j]=' ';
						totalSeats--;
						
						if(totalSeats==0) break;
					}
					i--;
				}
			}
			
		}

		public boolean isWaitingListAvailableToConfirm() {
			boolean isAvailable;
			for(Ticket t :waitingList) {
			  	isAvailable=isSeatsAvailable(t.getNoOfSeats(), t.getSource(), t.getDestination());
			  	if(isAvailable) return true;
			}
			return false;
		}

		public Ticket confirmWaitingListAndGetTicket() {
			boolean isAvailable;
			Ticket confirmingTicket=null;
			for(Ticket t :waitingList) {
			  	isAvailable=isSeatsAvailable(t.getNoOfSeats(), t.getSource(), t.getDestination());
			  	if(isAvailable){
			  		bookTicket(t.getNoOfSeats(),t.getSource(),t.getDestination());
			  		t.setTicketStatus(TicketStatus.Booked);
			  		tickets.add(t);
			  		confirmingTicket=t;
			  	}
			}
			if(confirmingTicket != null)
			{
				waitingList.remove(confirmingTicket);
			}
			return confirmingTicket;
		}

}
