package transportation_system;

public class Bus extends Transport {
	Bus(String source, String destination,double fare, int seats, String driverName, int licenseNumber){
		super(source, destination, fare, seats, driverName, licenseNumber);
	}

	public double calculateFare(int amountOfSeats){
		fare = amountOfSeats * 50;
		return fare;
	}

	
	public void bookSeat(int id, int amountOfSeats){
		if (amountOfSeats <= seats){
			if (amountOfSeats == 1){
				System.out.println(amountOfSeats + " seat has been booked under the id: " + id);
				System.out.println("The total fare is: " + calculateFare(amountOfSeats));
				seats -= amountOfSeats;
			} else {
				System.out.println(amountOfSeats + " seats have been booked under the id: " + id);
				System.out.println("The total fare is: " + calculateFare(amountOfSeats));
				seats -= amountOfSeats;
			}
		} else {
			throw new IllegalStateException("The bus is full");
		}
	}
	
	@Override
	public void displayInfo(){
		driver.driverDetails();
		System.out.println("Bus is travelling from: " + source + " -To- " + destination);
	}
	
}
