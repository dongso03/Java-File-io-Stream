import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) {
		File file = new File("data.txt");

		// 파일 입력 스트림은 byte 단위로 파일을 읽습니다.
		// 파일 입력 스트림 선언 초기화(null)
		FileInputStream fis = null;

		try {
			// 파일 입력 스트림 생성(checked 예외발생)
			fis = new FileInputStream(file);
			int b;
			while ((b = fis.read()) != -1) { //End of File 에 도달할 때까지 ,byte 단위로 읽어 지역 변수b에 대입연산
				System.out.println(b);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 예외로 파일을 읽을 수 없습니다.");
		} finally {// 파일 입력 스트림 사용후, 차원 해제를 위한 finally 블럭
			// 널 체크
			if (fis != null) {
				try {
					fis.close();// 파일 입력 스트림 자원 해제 호출
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
