import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File dateFile = new File("data.txt");

		System.out.println("파일 존재? " + dateFile.exists());
		System.out.println("파일 크기? " + dateFile.length());

		Scanner scan = null;

		try {
			scan = new Scanner(dateFile);
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아, 스캐너 객체를 생성할수 없다.");
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}
}
