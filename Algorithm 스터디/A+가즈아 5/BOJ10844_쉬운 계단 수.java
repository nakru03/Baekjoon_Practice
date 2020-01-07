import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[][] dp = new long[101][11];
	static final long MOD = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		//계단수 dp 점화식 0과 9 제외 하고 나머지 수는 자신의 윗 level에서 현재 조합된 수의 가지수 ex) 1과 2로 만들 수 있는 계단수 1로 만드는 계단수 + 2로 만드는 계단수
		
		for(int i=1; i<10; ++i) {
			dp[1][i] = 1;
		}//초기값
		
		for(int i=2; i<=N; ++i) {
			for(int j=0; j<10; ++j) {
				if(j==0) {
					dp[i][j] = dp[i-1][j+1];
				}
				else if(j==9) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % MOD;
				}
			}
		}
		long sum = 0;
		for(int i=0; i<10; ++i) {
			sum+= dp[N][i];
		}
		System.out.println(sum % MOD);
	}

}
