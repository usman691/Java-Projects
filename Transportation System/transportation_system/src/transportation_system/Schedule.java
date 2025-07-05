package transportation_system;

public class Schedule {
	String departureTime;
	String arrivalTime;
	
	Schedule(String departureTime, String arrivalTime){
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	public void showSchedule() {
		System.out.println("Leaves  at: " + departureTime);
		System.out.println("Arrives at: " + arrivalTime);
	}
}
