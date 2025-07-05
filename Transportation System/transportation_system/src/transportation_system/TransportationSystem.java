package transportation_system;

import java.util.ArrayList;
import java.util.List;

public class TransportationSystem {
	List<Transport> activeVehicles = new ArrayList<>();
	
	public void addVehicles(Transport t){
		activeVehicles.add(t);
	}
	
	public void showActiveVehicles() {
		if(activeVehicles.isEmpty()) {
			System.out.println("No Vehicles Active");
		} else if(activeVehicles.size() == 1) {
			System.out.println(activeVehicles.size() + " vehicle is active");
		} else {
			System.out.println(activeVehicles.size() + " vehicles are active");
		}
	}
	
	public static void main(String args[]) {
		TransportationSystem T = new TransportationSystem();
		
		Bus bus1 = new Bus("Karachi", "Lahore", 5, 10, "Ali", 6969);
		Bus bus2 = new Bus("Karachi", "Lahore", 9, 3, "Shoaib", 4200);
		Train train1 = new Train("Karachi", "Islamabad", 100, "8am", "12pm");
		Taxi taxi1 = new Taxi("North Karachi", "Gulshan", 50, 5, "Tappu" , 4201 , true);
		
		T.addVehicles(bus1);
		T.addVehicles(bus2);
		T.addVehicles(taxi1);
		T.addVehicles(train1);
		T.showActiveVehicles();
		
		bus1.displayInfo();
		bus1.bookSeat(19901,1);
		System.out.println(train1.seats);
		train1.bookSeat(19901, 40, "business");
		train1.displayInfo();
		System.out.println(train1.seats);
		

		
	}
}
