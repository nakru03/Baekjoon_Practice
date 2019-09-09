import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ3985 {
	
	static int L;
	static int[] roleCake;
	static int N;
	static int maxEx;
	static int maxExNum;
	
	static int max;
	static int maxNum;
	static ArrayList<Pair> list = new ArrayList<Pair>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		roleCake = new int[L];
		int maxEx = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<=N; ++i) {
			String[] s = br.readLine().split("\\s");
			
			int p = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);			
			list.add(new Pair(p-1,k-1));
			if(maxEx < k-p) {
				maxEx = k-p;
				maxExNum = i;
			}			
		}
		
		
		for(int i=0; i<list.size(); ++i) {
			Pair curr = list.get(i);
			for(int j=curr.p; j<=curr.k; ++j) {
				if(roleCake[j]!=0) continue;
				roleCake[j] = i+1;
			}
		}
		
		for(int i=1; i<=N; ++i) {
			int count = 0;
			for(int j=0; j<roleCake.length; ++j) {
				if(roleCake[j]==i)
					count++;
			}
			if(count>max) {
				max = count;
				maxNum = i;
			}
			
		}
		
		System.out.println(maxExNum);
		System.out.println(maxNum);
	}
	
	
	static class Pair{
		int p;
		int k;
		public Pair(int p, int k) {
			super();
			this.p = p;
			this.k = k;
		}
	}

}
