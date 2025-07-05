package transportation_system;

public class Driver {
	String name;
	int licenseNumber;
	
	Driver(String name, int licenseNumber){
		this.name = name;
		this.licenseNumber = licenseNumber;
	}
	
	public void driverDetails() {
		System.out.println("Driver name: " + name);
		System.out.println("License No.: " + licenseNumber);
	}
}
