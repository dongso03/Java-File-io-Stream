import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// 콘솔창에서
// 사람이름,나이를 입력받아

//절대경로 d:\\mydata\\person.txt 파일에 출력하기
//출력형식은 '문자' 정보이며
//첫번째 줄에른 이름
//두번째줄에는 나이
//기록한다

public class Main8 {
	private static String name;
	private static int age;

	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("d:\\mydata\\person.txt"));
			Scanner scan = new Scanner(System.in);

			for (int i = 0; i < 3; i++) {
				System.out.println("이름?");
				String name = scan.nextLine();
				System.out.println("나이?");
				String age = scan.nextLine();

				pw.println("이름: " + name + "/ 나이: "+age);

			}
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

}
