import java.io.File;
import java.io.IOException;

public class Main4 {
	public static void main(String[] args) {
		File created = new File("hello.txt");
		boolean exist = created.exists();
		
		System.out.println("파일존재? "+exist);
	
		try {
			created.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("파일존재? "+created.exists());
	}
}
