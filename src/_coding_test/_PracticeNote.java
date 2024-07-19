package _coding_test;

class Cake{
	public void yummy() {
		System.out.println("cake yummy");
	}
}
class CheeseCake extends Cake{
	@Override
	public void yummy() {
		System.out.println("cheese yummy");
	}
}

public class _PracticeNote {
    public static void main(String[] args) {
    	Cake c1 = new CheeseCake();
    	CheeseCake c2 = new CheeseCake();
    	
    	((Cake)c1).yummy();
    }
}
