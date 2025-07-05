package transportation_system;

public class Scooter extends Transport{
	boolean surgeHour;
	
	Scooter(String source, String destination, double fare, int seats, String driverName, int licenseNumber, boolean surgeHour){
		super(source, destination, fare, seats, driverName, licenseNumber);
		this.surgeHour = surgeHour;
	}

	public double calculateFare(int amountOfSeats, boolean surgeHours) {
		if(surgeHour) {
			fare = amountOfSeats * 200;			
		}else {
			fare = amountOfSeats * 100;
		}
		return fare;
	}

	@Override
	public void displayInfo() {
		driver.driverDetails();
		
	}
	
	
}
