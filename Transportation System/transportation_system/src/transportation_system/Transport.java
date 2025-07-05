package transportation_system;

public abstract class Transport {
		String destination;
		String source;
		double fare;
		int seats;
		Schedule schedule;
		Driver driver;
		
		Transport(String source, String destination, double fare, int seats, String driverName, int licenseNumber){
			this.destination = destination;
			this.source = source;
			this.fare = fare;
			this.seats = seats;
			this.driver = new Driver(driverName, licenseNumber);
		}
		
		Transport(String source, String destination, int seats , String departureTime, String arrivalTime){
			this.source = source;
			this.destination = destination;
			this.seats = seats;
			this.schedule = new Schedule(departureTime, arrivalTime);
		}

		

		abstract public double calculateFare(int amountOfSeats);
		abstract public void displayInfo();	
}
