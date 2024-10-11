package repositary;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import dto.Taxi;

public class TaxiBookingRepositary {
	private static  TaxiBookingRepositary taxiBookingRepositary;
	public static Scanner scanner=new Scanner(System.in);
	public static List<Taxi> taxis;
	
	private TaxiBookingRepositary() {
		this.taxis=new ArrayList<>();
	}
	
	public static TaxiBookingRepositary getInstance() {
		if(taxiBookingRepositary==null) {
			taxiBookingRepositary=new TaxiBookingRepositary();
		}
		
		return  taxiBookingRepositary;
	}

	public  boolean hasTaxiWithGivenOtp(int otp) {
		for(Taxi t : taxis) {
			if(t.getOtp()==otp)
				return true;
		}
		return false;
	}

	public void cancelTaxi(int otp) {
		for(Taxi t : taxis) {
			if(t.getOtp()==otp) {
				t.setCurrentLocation(t.getPickUpLocation());
				t.setDropLocation(t.getCurrentLocation());
			}
		}
		
	}

	public void StopTaxi(int otp) {
		for(Taxi t : taxis) {
			if(t.getOtp()==otp) {
				t.setCurrentLocation(t.getDropLocation());
				t.setPickUpLocation(t.getCurrentLocation());
				t.setDropLocation(t.getCurrentLocation());
				t.setOtp(0);
				int earnings=Utility.getEarnings(t.getPickUpLocation(),t.getDropLocation(),t.getAssignedTaxiType());
				t.setTotalEarnings(t.getTotalEarnings()+earnings);
			}
		}
		
	}

	public List<Taxi> getAvailableTaxis(){
		List<Taxi> availableTaxis=new ArrayList<>();
		for(Taxi t : taxis) {
			if(t.isAvailable())
				availableTaxis.add(t);
		}
		return availableTaxis;
	}

	public void updateTaxiDetails(Taxi bookingTaxi, char pickUpLocation, char dropLocation, String assignedTaxiType) {
		for(Taxi t : taxis) {
			if(t.getTaxiNo().equals(bookingTaxi.getTaxiNo())) {
				t.setPickUpLocation(pickUpLocation);
				t.setDropLocation(dropLocation);
				t.setAssignedTaxiType(assignedTaxiType);
			}
		}
		
	}

}
