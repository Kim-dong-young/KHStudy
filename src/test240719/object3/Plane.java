package test240719.object3;

public abstract class Plane {
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		super();
	}
	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	
	public void refuel(int fuel) {
		this.fuelSize += fuel;
	}
	
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	public abstract void flight(int distance);
	
}
