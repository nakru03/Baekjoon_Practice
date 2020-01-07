import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ11399 {
	
	static ArrayList<human> list;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<human>();
		String[] s = br.readLine().split("\\s");
		for(int i=1; i<=N; ++i) {
			list.add(new human(i, Integer.parseInt(s[i-1])));
		}
		
		Collections.sort(list);
		int idx = 0;
		while(true) {
			idx++;
			if(idx>list.size()) break;
			for(int i=0; i<idx; ++i) {
				sum += list.get(i).cost;
			}
		}
		System.out.println(sum);
		
	}
	
	
	static class human implements Comparable<human>{
		int n;
		int cost;
		public human(int n, int cost) {
			super();
			this.n = n;
			this.cost = cost;
		}
		@Override
		public int compareTo(human o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}
}
