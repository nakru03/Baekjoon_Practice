import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		for(int i=0; i<N+M; ++i) {
			s = br.readLine().split("\\s");
			board[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
		}
		
		int answer = bfs();
		System.out.println(answer);
	}

	private static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(1, 0));
		visited[1] = true;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			if(curr.pos==100) {
				return curr.count;
			}
			
			for(int i=1; i<=6; ++i) { //주사위 만큼이동..
				int ns = curr.pos + i;
				
				if(ns>100 || visited[ns]) continue;
				if(board[ns]!=0) {
					q.offer(new Pair(board[ns], curr.count+1));
					visited[board[ns]] = true;
					continue;
				}
				q.offer(new Pair(ns, curr.count+1));
				visited[ns] = true;
			}
		}
		return -1;
	}
	
	static class Pair{
		int pos;
		int count;
		
		public Pair(int pos, int count) {
			super();
			this.pos = pos;
			this.count = count;
		}
		
	}
}
