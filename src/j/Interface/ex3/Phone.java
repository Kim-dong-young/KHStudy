package j.Interface.ex3;

public interface Phone {
	// interface에서 변수 = public final static
	char[] NUMBERPAD = {'1','2','3','4','5','6','7','8','9','*','0','#'};
	
	// public abstract가 생략되어있다
	String makeCall();
	String takeCall();
}
