import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N;
	static int K;
	static int L;
	static int[][] board;
	static int bodySize;
	static ArrayList<Pos> apple = new ArrayList<>();
	static ArrayList<Command> command = new ArrayList<>();
	static Pos head = new Pos(0,0,0);
	static Pos tail = new Pos(0,0,0);
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};//우하좌상 순으로 탐색
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		for(int i=0; i<K; ++i) {
			String[] s = br.readLine().split("\\s");
			apple.add(new Pos(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
			board[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 9;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; ++i) {
			String[] s = br.readLine().split("\\s");
			command.add(new Command(Integer.parseInt(s[0]), s[1]));
		}
		int time=0;
		int idx = 0;
		int tailidx=0;
		board[0][0] = 1;
		while(true) {
			time++;
			
			
			/*System.out.println("#########################"	+ time +"dir : "+head.dir);
			System.out.println("head: "+head.y+", "+ head.x);
			System.out.println("tail: "+tail.y+", "+ tail.x);
			for(int[] m : board) {
				
				System.out.println(Arrays.toString(m));
			}*/
			int ny = head.y + dy[head.dir];
			int nx = head.x + dx[head.dir];
			if(ny<0 || nx<0 || nx>=N || ny>=N) break;
			if(board[ny][nx]==1) break;
			
			
			if(board[ny][nx]==9) {
				head.y = ny;
				head.x = nx;
				bodySize++;
				board[head.y][head.x] = 0;
				
			}else {
				
				
				if(head.y!=tail.y || head.x!=tail.x) {
					board[tail.y][tail.x]=0;
				}
				else if(bodySize==0) {
					board[head.y][head.x]=0;
				}
				tail.y = tail.y+dy[tail.dir];
				tail.x = tail.x+dx[tail.dir];
				
				head.y = ny;
				head.x = nx;
				
			}
			board[head.y][head.x] = 1;
			
			if(idx<command.size() && time==command.get(idx).time) {
				if(command.get(idx).command.equals("L")) {
					head.dir = (head.dir+3)%4;
				}else {
					head.dir = (head.dir+1)%4;
				}
				idx++;
			}
			if(idx<command.size() && time==command.get(tailidx).time+bodySize) {
				if(command.get(tailidx).command.equals("L")) {
					tail.dir = (tail.dir+3)%4;
				}else {
					tail.dir = (tail.dir+1)%4;
				}
				tailidx++;
			}
		}
		
		System.out.println(time);
	}
	static class Pos{
		int y;
		int x;
		int dir;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public Pos(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
		
	}
	static class Command{
		int time;
		String command;
		public Command(int time, String command) {
			super();
			this.time = time;
			this.command = command;
		}
		
		
	}
}
