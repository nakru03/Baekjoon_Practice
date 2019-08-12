import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9466 {
	static int[] arr;
	static boolean[] visited;
	static boolean[] cycle;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visited = new boolean[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; ++i) {				
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<arr.length; ++i) {
				dfs(i, i);
			}
			
			System.out.println(count);
		}
	}
	static int count = 0;
	private static void dfs(int start, int fixstart) {
		if(start == fixstart && visited[start]) {
			cycle[fixstart] = true;
			return;
		}
		visited[start] = true;
		for(int next=1; next<arr.length; ++next) {
			visited[next] =true;
			dfs(next, fixstart);
		}
	}
}
