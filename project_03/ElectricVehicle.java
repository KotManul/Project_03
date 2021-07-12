package project_03;

import java.util.Scanner;

public class ElectricVehicle {
	static Scanner keyboard = new Scanner(System.in);
	
    // list of attributes
    private String Make;
    private String Model;
    private String color;
    private int kmPerKiloWattHour;
    private int MaxKiloWattHourInBattery;
    private int CurrentKiloWattHourInBattery = 0;
    	
	public static void main(String[] args) {
		System.out.println("Please enter car model:");
		String carModel = keyboard.nextLine();
		
		System.out.println("Please enter car make:");
		String carMake = keyboard.nextLine();
		
		System.out.println("Please enter kilometers Per kW/hr:");
		int kmkwh = Integer.parseInt(keyboard.nextLine());

		System.out.println("Please enter Max kW/hr in battery:");
		int max = Integer.parseInt(keyboard.nextLine());

		ElectricVehicle ev = new ElectricVehicle(carModel, carMake, kmkwh, max);
		
		System.out.println("Enter battery charge (in kW/hr):");
		int chargeKw = Integer.parseInt(keyboard.nextLine());
		ev.charge(chargeKw);
		
		System.out.println("Enter kilometers you want to drive:");
		ev.drive(Integer.parseInt(keyboard.nextLine()));
	}
	
	public ElectricVehicle (
			String mk, String md, int kmkwh, int max) {
		Make = mk;
		Model = md;
		kmPerKiloWattHour = kmkwh;
		MaxKiloWattHourInBattery = max;
	}
	
	public boolean charge(int kwhr) {	
		if (kwhr > 0) {
			CurrentKiloWattHourInBattery = CurrentKiloWattHourInBattery + kwhr;
			if (CurrentKiloWattHourInBattery > MaxKiloWattHourInBattery) {
				System.out.println("The battery exceeded the maximum charge of " + MaxKiloWattHourInBattery);
				return false;
			}
		} else {
			System.out.println("The kW/hr value cannot be negative");
			return false;
		}
		
		System.out.println("Battery is charged and equals to " + CurrentKiloWattHourInBattery + "kW/hr");
		return true;
	}
	
	public boolean drive(int kmToDrive) {
		
		if ( (CurrentKiloWattHourInBattery - kmToDrive / kmPerKiloWattHour) < 0 ) {
			System.out.println("Current battery charge " + CurrentKiloWattHourInBattery + 
					"kW/hr is less than " + kmToDrive / kmPerKiloWattHour + "kW/hr");
			System.out.println("You could not drive that far!");
			return false;
		}
		
		System.out.println("Current battery charge " + CurrentKiloWattHourInBattery + 
				"kW/hr is greater than " + kmToDrive / kmPerKiloWattHour + "kW/hr");
		System.out.println("You could drive that far!");
		return true;
	}

	public String getMake() {
		return Make;
	}

	public String getModel() {
		return Model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getKmPerKiloWattHour() {
		return kmPerKiloWattHour;
	}

	public int getMaxKiloWattHourInBattery() {
		return MaxKiloWattHourInBattery;
	}

	public int getCurrentKiloWattHourInBattery() {
		return CurrentKiloWattHourInBattery;
	}

}
