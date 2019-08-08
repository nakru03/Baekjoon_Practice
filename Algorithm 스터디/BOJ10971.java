import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJO10971 {
	static int weight[][];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		weight = new int[N][N];
		for(int i=0; i<N; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; ++j) {
				weight[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		int[] city = new int[N];
		for(int i=0; i<city.length; ++i) {
			city[i] = i;
		}
		tsp(city, 0);
		System.out.println(min);
		
	}
	private static void tsp(int[] city, int start) {
		
		if(start == city.length) {
			int cost = 0;
			for(int i=0; i<city.length-1; ++i) {
				if(weight[city[i]][city[i+1]] == 0) return;
				cost += weight[city[i]][city[i+1]];					
			}
			if(weight[city[city.length-1]][city[0]]==0) return;
			cost+= weight[city[city.length-1]][city[0]];
			
			min = Math.min(min, cost);
		}
		
		for(int next=start; next<city.length; ++next) {
			swap(city, start, next);
			tsp(city, start+1);
			swap(city, next, start);
			
		}
	}
	private static void swap(int[] city, int start, int next) {
		int tmp = city[start];
		city[start] = city[next];
		city[next] = tmp;
		
	}
}
