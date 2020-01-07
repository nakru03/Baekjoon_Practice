import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2798 {
	static int N;
	static int M;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("\\s");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		arr = new int[N];
		s = br.readLine().split("\\s");
		for(int i=0; i<arr.length; ++i) {
			arr[i] = Integer.parseInt(s[i]);
		}
		//입력끝
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; ++i) {
			for(int j=i+1; j<arr.length; ++j) {
				for(int k=j+1; k<arr.length; ++k) {
					if(arr[i]+arr[j]+arr[k] <= M)
						max = Math.max(max, arr[i]+arr[j]+arr[k]);
				}
			}
		}
		System.out.println(max);
	}

}
