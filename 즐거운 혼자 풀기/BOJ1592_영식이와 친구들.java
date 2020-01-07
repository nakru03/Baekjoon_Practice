import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1592 {
	static int N;
	static int M;
	static int L;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		
		
		arr = new int[N];
		int idx = 0;
		int count = 0;
		while(true) {
			arr[idx]++;
			if(arr[idx] == 2) break;
						
			idx = (idx + L) % N;
			count++;			
		}
		//System.out.println(Arrays.toString(arr));
		System.out.println(count * (M-1));
	}
}
