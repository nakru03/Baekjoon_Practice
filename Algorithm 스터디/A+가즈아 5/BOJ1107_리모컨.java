import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 
 * brute force..
 * 1부터 해당 채널까지 하나씩눌러보면서 최소 거리 갱신
 * 50000까진데 +- 가능 하므로 *2
 */
public class Main {
	static boolean[] broken = new boolean[11];
	static int N, M;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		if(M!=0) {
			String[] s = br.readLine().split("\\s");
			
			for(int i=0; i<M; ++i) {
				broken[Integer.parseInt(s[i])] = true;
			}
		}
		
		
		
		answer = Math.abs(N-100);//최대치
		
		for(int i=0; i<1000001; ++i) {
			int length = check(i);
			
			if(length>0) {
				answer = Math.min(answer, length+Math.abs(i-N)); //+든 -든 횟수이므로 절대값
			}
		}
		
		System.out.println(answer);
	}
	private static int check(int channel) {//버튼 누를 수 있나 없나
		int length = 0;
		if(channel == 0) {
			return broken[0] ? 0 : 1; //0 divide 처리
		}
		while(channel>0) {
			if(broken[channel % 10]) {
				return 0;
			}
			length++;
			channel /=10;
		}
		return length;
	}
}
