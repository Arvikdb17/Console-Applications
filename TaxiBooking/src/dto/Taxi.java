package dto;

public class Taxi {
	
	private String taxiNo;
	private String taxiType;
	private String assignedTaxiType;
	private String driverName;
	private long driverNumber;
	private double totalEarnings;
    private char currentLocation;
    private char pickUpLocation;
    private char dropLocation;
    private int otp;
    private boolean isAvailable;
	public String getTaxiNo() {
		return taxiNo;
	}
	public void setTaxiNo(String taxiNo) {
		this.taxiNo = taxiNo;
	}
	public String getTaxiType() {
		return taxiType;
	}
	public void setTaxiType(String taxiType) {
		this.taxiType = taxiType;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public long getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(long driverNumber) {
		this.driverNumber = driverNumber;
	}
	public double getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public char getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(char currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public char getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(char pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public char getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(char dropLocation) {
		this.dropLocation = dropLocation;
	}
	public String getAssignedTaxiType() {
		return assignedTaxiType;
	}
	public void setAssignedTaxiType(String assignedTaxiType) {
		this.assignedTaxiType = assignedTaxiType;
	}
	
	
	@Override
	public String toString() {
		return "Taxi No : "+getTaxiNo()+"/nTaxi Type : "+getTaxiType()+ "/nDriver Name : "+getDriverName()+"/nDriver No :"+getDriverNumber()+"/nCurrent Location : "+getCurrentLocation()+"/nTotal Earnings : "+getTotalEarnings();
				
	}
	

}
