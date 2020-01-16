import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int S;
	static boolean visited[][] = new boolean[2000][2000];
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		S = Integer.parseInt(br.readLine());
		
		visited[1][0] = true;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(1,0,0));
		
		int ns, nc;
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			if(curr.screen==S) {
				answer = curr.second;
				break;
			}
			
			nc = curr.screen;
			if(!visited[curr.screen][nc]) {
				visited[curr.screen][nc] = true;
				q.offer(new Pos(curr.screen, nc, curr.second+1));
			}
			ns = curr.screen-1;
			if(ns==-1) ns = 0;
			if(!visited[ns][curr.clipboard] && ns>=0) {
				visited[ns][curr.clipboard] = true;
				q.offer(new Pos(ns,curr.clipboard, curr.second+1));
			}
			
			ns = curr.screen+curr.clipboard;
			
			if(!visited[ns][curr.clipboard] && curr.clipboard!=0 && ns<=S) {
				visited[ns][curr.clipboard] = true;
				q.offer(new Pos(ns,curr.clipboard, curr.second+1));
			}
		}
		System.out.println(answer);	
	}
	
	static class Pos{
		int screen;
		int clipboard;
		int second;
		
		public Pos(int screen, int clipboard, int second) {
			super();
			this.screen = screen;
			this.clipboard = clipboard;
			this.second = second;
		}
	}
}
