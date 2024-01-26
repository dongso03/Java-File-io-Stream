import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main7 {
	public static void main(String[] args) {
		String data = "문자 단위의 기록을 연습하기!@!";

		File file = new File("data.txt");

		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			
//			char[] c = data.toCharArray();
//			for(int i = 0; i< c.length;i++) {
//				fw.write(c[i]);
//			}
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
