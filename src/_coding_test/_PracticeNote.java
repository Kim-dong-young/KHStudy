package _coding_test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class _PracticeNote {
	
	public void output() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt",true);
			fw.write(97);
			fw.write(95);
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e) {
			
		}
	}
	
    public static void main(String[] args) {
    	
    }
}