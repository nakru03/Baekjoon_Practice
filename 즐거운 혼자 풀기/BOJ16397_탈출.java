import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16397 {
	static int N, T, G;
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		int[] visited = new int[100000];
		Arrays.fill(visited, 987654321);
		
		Queue<Integer> q = new LinkedList<>();
		visited[N] = 0;
		q.offer(N);
		while(!q.isEmpty()){
			int curr = q.poll();
			if(visited[curr]>T) {
				break;
			}
			if(curr == G) {
				answer = visited[curr];
				break;
			}
			
			int next;
			
			next = curr + 1;
			if(next>99999) continue;
			if(visited[next]>visited[curr]+1) {
				visited[next] = visited[curr]+1;
				q.offer(next);
			}
			
			
			next = curr * 2;
			if(next>99999) continue;
			
			if(next==0) next = 0;
			else {
				String tmp = String.valueOf(next);
				next = (int) (next - Math.pow(10,tmp.length()-1));
			}
		
			
			if(visited[next]>visited[curr]+1) {
				visited[next] = visited[curr]+1;
				q.offer(next);
			}
			
		}
		
		System.out.println(answer==Integer.MAX_VALUE ? "ANG" : answer);
	}
}
