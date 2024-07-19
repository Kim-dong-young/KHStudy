package test240719.object3;

public class PlaneTest {
	public static void main(String[] args) {
		Airplane airplane = new Airplane("L747",1000);
		Cargoplane cargoplane = new Cargoplane("C40",1000);
		
		System.out.printf("%-14s %-8s\n","Plane","fuelSize");
		System.out.println("-------------------------");
		System.out.printf("%-14s %-8s\n",airplane.getPlaneName(),airplane.getFuelSize());
		System.out.printf("%-14s %-8s\n",cargoplane.getPlaneName(),cargoplane.getFuelSize());
		
		System.out.println("100 운항");
		airplane.flight(100);
		cargoplane.flight(100);
		
		System.out.printf("%-14s %-8s\n","Plane","fuelSize");
		System.out.println("-------------------------");
		System.out.printf("%-14s %-8s\n",airplane.getPlaneName(),airplane.getFuelSize());
		System.out.printf("%-14s %-8s\n",cargoplane.getPlaneName(),cargoplane.getFuelSize());
		
		System.out.println("200 주유");
		airplane.refuel(200);
		cargoplane.refuel(200);
		
		System.out.printf("%-14s %-8s\n","Plane","fuelSize");
		System.out.println("-------------------------");
		System.out.printf("%-14s %-8s\n",airplane.getPlaneName(),airplane.getFuelSize());
		System.out.printf("%-14s %-8s\n",cargoplane.getPlaneName(),cargoplane.getFuelSize());
		
		
	}
}
