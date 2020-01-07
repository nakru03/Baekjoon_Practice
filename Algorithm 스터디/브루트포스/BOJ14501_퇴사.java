import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] time;
	static int[] profit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		time = new int[n+1];
		profit = new int[n+1];
		
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}

		dobbyfree(0, 0);
		System.out.println(max);
		
	}
	static int max = Integer.MIN_VALUE;
	private static void dobbyfree(int day, int sum) {		
		if(day>n) return;
		if(day == n) {
			max = Math.max(max, sum);			
			return;
		}
		dobbyfree(day+1, sum);		
		dobbyfree(day+time[day], sum+profit[day]);
	}
}