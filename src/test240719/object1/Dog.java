package test240719.object1;

public class Dog extends Animal {
	public final static String PLACE = "애견카페";
	private int weight;
	
	public Dog() {
		super();
	}
	
	public Dog(String name, String kinds,int weight) {
		super(name, kinds);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public static String getPlace() {
		return PLACE;
	}

	@Override
	public void speak() {
		System.out.println(super.toString() + " 몸무게는 "+ weight + "kg 입니다.");
	}


	
	
}
