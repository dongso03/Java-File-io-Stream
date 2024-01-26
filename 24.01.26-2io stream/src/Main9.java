import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main9 {
	
	Random ran = new Random();
	
	private Set<Integer> randomSet(){
		Set<Integer> set = new TreeSet<>();
		while (set.size()<6) {
			set.add(ran.nextInt(45)+1);
		}
		return set;
	}
	
	public static void main(String[] args) {
		// 오늘의 랜덤 행운의 로또 번호를 생성해서
		// 파일로 기록하기
		
		Main9 m = new Main9();
		Set<Integer> set = m.randomSet();
		System.out.println(set.toString());
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("Lotto.txt"));
			fw.write(set.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw!= null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
