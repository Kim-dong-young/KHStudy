package test240719.object3;

public class Airplane extends Plane {
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	public Airplane() {
		super();
	}
	

	@Override
	public void flight(int distance) {
		int count = 0;
		
		while(distance >= 10) {
			distance -= 10;
			count ++;
		}
		
		this.setFuelSize(this.getFuelSize() - count * 30);
		
	}
	
}
