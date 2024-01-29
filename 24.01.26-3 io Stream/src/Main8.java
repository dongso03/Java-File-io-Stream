import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.Scanner;

// 콘솔창에서
// 사람의 이름, 나이를 입력받아

// 절대경로 d:\\mydata\\person.txt 파일에 출력하기

// 출력 형식은 '문자' 정보이며
// 첫번째 줄에는 이름
// 두번째 줄에는 나이
// 를 기록한다.

// ----------------

// 만약, (길동, 22) (둘리, 33) (도우너, 44)
// ???

// 파일을 여러개만드는 방법
// 1.인적정보 파일 이름이 각각 달라야 한다.>> 여러사람에 대해 여러파일이 만들어 진다.
// >> 그래서 ,상위폴더를 만들고 여러파일 생산

public class Main8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름?");
		String name = scan.nextLine();
		System.out.println("나이?");
		int age = scan.nextInt();

		File folder = new File("d:\\mydata\\person\\");
		if (!folder.exists()) {
			folder.mkdir();
		}
		String[] filenames = folder.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String n) {
				if (n.startsWith(name) && n.endsWith(".txt")) {
					return true;
				}
				return false;
			}
		});

		File output = new File(folder, name + (filenames.length + 1) + ".txt");
		// 동명이인이 있을경우, 기존 정보가 사라지기 대문에 => 기존이름을 변경한다.
//		if (output.exists()) {
//			output.renameTo(new File(folder, name + "- old" + ".txt"));
//		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(output);

			pw.println("이름 : " + name);
			pw.println("나이 : " + age);
			pw.flush();

			System.out.println("인적 정보가 파일에 기록되었습니다.");
			System.out.println(output.getAbsolutePath() + "를 확인해보세요.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
