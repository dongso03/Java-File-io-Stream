import java.util.Arrays;

public class Main4 {

	public static void main(String[] args) {
		String line = "Text Line";
		
		System.out.println(line);
		
		byte[] arr = line.getBytes();
		
		System.out.println(Arrays.toString(arr));
	
		String kor = "한글 정보";
		byte[] arr2 = kor.getBytes();
		System.out.println(Arrays.toString(arr2));
		
		System.out.println(new String(arr));
		System.out.println(new String(arr2));
	}
}
