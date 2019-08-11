import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ2331 {
	static int[] visited = new int[300000];
	static int a;
	static int p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		a = Integer.parseInt(tokenizer.nextToken());
		p = Integer.parseInt(tokenizer.nextToken());
		int cnt = 0;
		dfs(a);
		for(int i=0; i<visited.length; ++i) {
			if(visited[i]==1)
				cnt++;
		}
		System.out.println(cnt);

	}
	private static void dfs(int start) {
		if(visited[start]==3) {
			return;
		}
		else visited[start]++;
		int next = 0;
		while(start!=0) {
			next += (int)Math.pow(start%10, p);
			start /= 10;
		}
		//System.out.println(next);		
		dfs(next);
	}

}
