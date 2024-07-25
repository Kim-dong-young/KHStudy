package l.io.ex3;

public class Run {
	public static void main(String[] args) {
		FileByte fb = new FileByte();
		fb.fileSave();
		fb.fileRead();
		
		FileChar fc = new FileChar();
		fc.fileSave();
		fc.fileRead();
	}
}
