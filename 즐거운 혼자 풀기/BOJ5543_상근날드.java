import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ5543 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list.add(Integer.parseInt(br.readLine()));
		list.add(Integer.parseInt(br.readLine()));
		list.add(Integer.parseInt(br.readLine()));
		list.add(Integer.parseInt(br.readLine()));
		list.add(Integer.parseInt(br.readLine()));
		int min = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i=0; i<3; ++i) {
			min = Math.min(min, list.get(i));
		}
		for(int i=3; i<5; ++i) {
			min2 = Math.min(min, list.get(i));
		}
		System.out.println(min+min2-50);
	}

}
