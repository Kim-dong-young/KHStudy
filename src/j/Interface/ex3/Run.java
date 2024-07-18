package j.Interface.ex3;

public class Run {

	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] result = pc.method();
		
		for(String spec : result) {
			System.out.println(spec+"\n");
		}

	}

}
