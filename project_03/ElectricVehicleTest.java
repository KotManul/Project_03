package project_03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectricVehicleTest {
	
	private ElectricVehicle ev;

	@BeforeEach                                         
    public void setUp() throws Exception {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter car model:");
		String carModel = keyboard.nextLine();
		
		System.out.println("Please enter car make:");
		String carMake = keyboard.nextLine();
		
		System.out.println("Please enter kilometers Per kW/hr:");
		int kmkwh = Integer.parseInt(keyboard.nextLine());

		System.out.println("Please enter Max kW/hr in battery:");
		int max = Integer.parseInt(keyboard.nextLine());

		ev = new ElectricVehicle(carModel, carMake, kmkwh, max);
		
		ev.charge(20);
    }	

	@Test
	void testElectricVehicle() {
		assertNotNull(ev.getModel());
		assertNotNull(ev.getMake());
		assertNotNull(ev.getKmPerKiloWattHour());
		assertNotNull(ev.getMaxKiloWattHourInBattery());
	}

	@Test
	void testChargeTrue() {
		assertTrue(ev.charge(20), "Method charge works as expected.");
	}

	@Test
	void testChargeFalse() {
		assertFalse(ev.charge(50), "Method charge works as expected.");
	}

	@Test
	void testDriveTrue() {
		assertTrue(ev.drive(100), "Method drive works as expected.");
	}

	@Test
	void testDriveFalse() {
		assertFalse(ev.drive(1000), "Method drive works as expected.");
	}

	@Test
	void testSetColorEquals() {
		ev.setColor("red");
		if (ev.getColor().equals("red")) {			
			assertEquals("red", "Method setColor works as expected.");
		}
	}

}
