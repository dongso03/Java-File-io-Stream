import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main5 {
	public static void main(String[] args) {
		File file = new File("data.txt");

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			int length = (int) file.length();
			byte[] bytes = new byte[length];
			
			fis.read(bytes, 0, length);
			fis.read(bytes); //둘다 상관 x
			
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
