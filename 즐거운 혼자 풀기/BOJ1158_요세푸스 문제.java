import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		ArrayList<Integer> circle = new ArrayList<Integer>();
		for(int i=1; i<=N; ++i) {
			circle.add(i);
		}
		System.out.print("<");
		josephus(circle, K);
		System.out.print(">");
	}

	private static void josephus(ArrayList<Integer> circle, int k) {
		int idx = k-1;
		k = k-1;
		while(true) {			
			System.out.print(circle.get(k));
			circle.remove(k);
			if(circle.isEmpty()) break;
			System.out.print(", ");
			k = k + idx;
			if(k>=circle.size())
				k = k % circle.size();
		}
		
	}
}
