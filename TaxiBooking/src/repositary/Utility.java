package repositary;

public class Utility {

	public static int getEarnings(char pickUpLocation, char dropLocation, String assignedTaxiType) {
		int cost=100;
		int distance=Math.abs(dropLocation-pickUpLocation);
		while(distance>1) {
			cost+=150;
			distance--;
		}
		if(assignedTaxiType.equals("sedan")) {
			cost=cost+(cost*(10/100));
		}
		else if(assignedTaxiType.equals("suv")) {
			cost=cost+(cost*(20/100));
		}
		
		return cost;
	}

}
