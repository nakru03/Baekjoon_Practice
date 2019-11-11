import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 겨란 내구도 무게
 * 내구도 무게 만큼 깍음
 * 왼쪽부터 차례로 박치기
 * 
 */
public class BOJ16987 {

	static int N;
	static int idx;
	static int idx1;
	static int answer;
	static ArrayList<Egg> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; ++i) {
			String s[] = br.readLine().split("\\s");
			list.add(new Egg(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
		}
		for(int i=0; i<N; ++i) {
			dfs(i);
		}
		
	}


	private static void dfs(int i) {
		if()
	}


	static class Egg {
		int s;
		int w;

		public Egg(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}
		
	}
}
