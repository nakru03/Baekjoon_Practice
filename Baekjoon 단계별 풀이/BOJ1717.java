/*
 * 유니온 파인드 합집합에서 원소찾기..
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1717 {
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		array = new int[n+1];
		makeSet(array);
		for(int i=0; i<m; ++i) {
			split = br.readLine().split(" ");
			int a = Integer.parseInt(split[1]);
			int b = Integer.parseInt(split[2]);
			
			if(split[0].equals("0")) {
				
				union(a,b);
			}
			else {
				int p1 = findSet(a);
				int p2 = findSet(b);
				if(p1 == p2) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
		
	}
	
	
	private static int findSet(int a) {
		if(array[a]==a)
			return a;
		else {
			int p = findSet(array[a]);
			array[a] = p;
			return p;
		}
	}
	private static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a!=b) {
			array[b] = a;
		}
	}
	private static void makeSet(int[] array) {
		for(int i=1; i<array.length; ++i) {
			array[i] = i;
		}
	}

}

