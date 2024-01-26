import java.io.File;

public class Main {
	public static void main(String[] args) {
		
		//상대적경로
		File file = new File("my.txt");
		System.out.println(file.exists());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		
		//절대적경로
		File realfile = new File("d:\\realfile.txt");
		System.out.println(realfile.exists());
		System.out.println(realfile.length());
		System.out.println(realfile.getPath());
	}
}
