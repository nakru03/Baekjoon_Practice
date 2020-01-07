import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
	static int[] p;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		p = new int[N+1];
		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; ++i) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=i; ++j) {
				dp[i] = Math.max(dp[i],dp[i-j]+p[j]); 
			}
		}
		System.out.println(dp[N]);
	}

}
