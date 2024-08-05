package test240710.object3;

public class SnackController {
	private Snack s = new Snack();

	public SnackController() {
		super();
		// System.out.println("SnackController 생성됨");
	}
	
	// TODO
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다.";
	}
	
	// TODO
	public String confirmData() {
		return s.information();
	}
	
	
}
