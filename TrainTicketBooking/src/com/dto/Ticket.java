package com.dto;

import com.model.Repository;

public class Ticket {
	private int pnrNo;
	private char source;
	private char destination;
	private int noOfSeats;
	private TicketStatus ticketStatus;
	public Ticket(char source,char destination,int noOfSeats) {
		this.source=source;
		this.destination=destination;
		this.noOfSeats=noOfSeats;
		this.pnrNo=Repository.pnrNo++;
		
	}
	
	public Ticket() {
		Repository.pnrNo++;
	}
	public  int getPnrNo() {
		return pnrNo;
	}
	public  void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public char getSource() {
		return source;
	}
	public void setSource(char source) {
		this.source = source;
	}
	public char getDestination() {
		return destination;
	}
	public void setDestination(char destination) {
		this.destination = destination;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	@Override
    public String toString() {
        return String.format("PNR Number: %-10s Source: %-15s Destination: %-15s NoOfSeats: %-15s Status: %-10s",
                             pnrNo, source, destination,noOfSeats, ticketStatus);
    }

}
