import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main8 {
	public static void main(String[] args) {
		File origin = new File("data.txt");
		File copy = new File("copy.txt");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(origin);
			fos = new FileOutputStream(copy);
			
			int length= (int) origin.length();
			// 복사할때는 손실이일어나지도 용량이 과도하게늘어나지않도록 정확한 값을넣어주자!
			byte[] bytes = new byte[length];
			fis.read(bytes);
			
			System.out.println(fis.read());
			System.out.println(fis.read());
			
			fos.write(bytes);
			
			System.out.println("복사가 완료 되었습니다.");
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
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
