package m.api.ex1;

public class Run {

	public static void main(String[] args) {
		new A_Math().method01();
		System.out.println();
		B_String st = new B_String();
		st.method01();
		st.method02();
		st.method03();
		new C_Wrapper().method01();
		new D_Date().method01();
	}

}
