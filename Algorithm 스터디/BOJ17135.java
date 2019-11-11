import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import BOJ17472.Pair;

public class BOJ17135 {

	static int N;
	static int M;
	static int D;
	
	static int[][] board;
	static int[][] copyBoard;
	static int[][] tmpBoard;
	static boolean[] visited;
	
	static ArrayList<Pos> archerList = new ArrayList<>();
	static ArrayList<Pos> enemy = new ArrayList<>();
	static ArrayList<Pos> copyEnemy;
	static Queue<Pos> deadman = new LinkedList<>();
	
	static int enemyCount;
	static int answer = Integer.MIN_VALUE;
	static int tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		D = Integer.parseInt(s[2]);
		
		board = new int[N+1][M];
		
		visited = new boolean[M];
		for(int y=0; y<N; ++y) {
			s = br.readLine().split("\\s");
			for(int x=0; x<M;  ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				if(board[y][x]==1) enemy.add(new Pos(y,x,true));
			}
		}
		
		enemyCount = enemy.size();

		placeArcher(0, 0);
		System.out.println(answer);
	}

	private static void placeArcher(int idx, int depth) {
		if(depth == 3) {
			copy();
			for(int[] i : copyBoard) {
				System.out.println(Arrays.toString(i));
			}
			System.out.println();
			startGame();
			System.out.println(tmp);
			answer = Math.max(tmp, answer);
			//초기화..
			enemyCount = enemy.size();
			tmp = 0;
		}
		for(int i=idx; i<M; ++i) {
			if(visited[i]) continue;
			board[N][i] = 9;
			archerList.add(new Pos(N,i));
			visited[i] = true;
			placeArcher(idx, depth+1);
			archerList.remove(archerList.size()-1);
			visited[i] = false;
			board[N][i] = 0;
		}
	}
	private static void copy() {
		copyBoard = new int[N+1][M];
		copyEnemy = new ArrayList<>();
		for(int y=0; y<N+1; ++y) {
			for(int x=0; x<M; ++x) {
				copyBoard[y][x] = board[y][x];
			}
		}
		for(int i=0; i<enemy.size(); ++i) {
			Pos curr = enemy.get(i);
			copyEnemy.add(new Pos(curr.y,curr.x,curr.live));
		}
	}

	private static void startGame() {
		while(true) {
			if(enemyCount == 0) break;
			//System.out.println(1);
			readyToShot();
			for(int[] i : copyBoard) {
				System.out.println(Arrays.toString(i));
			}
			shot();
			for(int[] i : copyBoard) {
				System.out.println(Arrays.toString(i));
			}
			move();
			for(int[] i : copyBoard) {
				System.out.println(Arrays.toString(i));
			}
		}
	}
	///////////// 수정
	private static void move() {
		copyBoard = new int[N+1][M];
		for(int i=0; i<copyEnemy.size(); ++i) {
			Pos curr = copyEnemy.get(i);
			if(!curr.live) continue;
			else {
				copyBoard[curr.y][curr.x]=0;
				curr.y = curr.y + 1;
				
				if(curr.y>N-1) {
					enemyCount--;
					curr.live = false;
				}
				else {
					copyBoard[curr.y][curr.x]=1;
				}
			}
			
		}
		
	}

	private static void shot() {
		while(!deadman.isEmpty()) {
			Pos curr = deadman.poll();
			if(copyBoard[curr.y][curr.x]==0) continue;
			else{
				copyBoard[curr.y][curr.x] = 0;
				enemyCount--;
				tmp++;
			}
			
		}
	}

	private static void readyToShot() {
		for(int i=0; i<archerList.size(); ++i) {
			Pos currArcher = archerList.get(i);
			for(int j=0; j<copyEnemy.size(); ++j) {
				Pos currEnemy = copyEnemy.get(j);
				int check = Math.abs(currArcher.y-currEnemy.y) + Math.abs(currArcher.x-currEnemy.x);
				if(check<=D) {
					deadman.offer(new Pos(currEnemy.y,currEnemy.x));
					currEnemy.live = false;
					break;
				}
			}
		}
	}
	
	
	static class Pos{
		int y;
		int x;
		boolean live;
		public Pos(int y, int x, boolean live) {
			super();
			this.y = y;
			this.x = x;
			this.live = live;
		}
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", live=" + live + "]";
		}
		
	}

}
