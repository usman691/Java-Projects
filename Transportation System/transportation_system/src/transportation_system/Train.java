package transportation_system;

import java.util.HashMap;
import java.util.Map;

public class Train extends Transport{
	String leavingTime;
	Map<String, Integer> tier;
	
	
    Train(String source, String destination, int seats, String departureTime, String arrivalTime) {
        super(source, destination, seats, departureTime, arrivalTime);

        tier = new HashMap<>();
        tier.put("economy", 500);
        tier.put("business", 1000); 
    }
	
	public double calculateFare(int amountOfSeats, String tierType) {
		if(tier.containsKey(tierType)) {
			return amountOfSeats * tier.get(tierType);
		} else {
			throw new IllegalArgumentException("Invalid tier");
		}
	}
	
	public void bookSeat(int id, int amountOfSeats, String tierType){
		if (amountOfSeats <= seats) {
			if (amountOfSeats == 1) {
				System.out.println(amountOfSeats + " seat has been booked under the id: " + id);
				System.out.println("The total fare is: " + calculateFare(amountOfSeats, tierType));
				seats -= amountOfSeats;
			} else {
				System.out.println(amountOfSeats + " seats have been booked under the id: " + id);
				System.out.println("The total fare is: " + calculateFare(amountOfSeats, tierType));
				seats -= amountOfSeats;
			}
		} else {
			throw new IllegalStateException("The train is full");
		}
	}
	
	@Override
	public void displayInfo() {
		schedule.showSchedule();
		System.out.println("From: " + source + " -TO- " + destination);
		System.out.println("Number of passengers: " + seats);
	}

}
