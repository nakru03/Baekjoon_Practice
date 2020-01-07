import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


//1.... 섬에 넘버링..
//2...각 섬의 해안선에서의 다른 섬까지 가중치..
//3...MST를 크루스칼로 구하기.
public class BOJ17472 {
	static int N; // 세로
	static int M; //가로
	static int[][] board; //보드
	static boolean[][] numberingVisited; // 섬넘버링을 위한 비짓배열
	static int[][] edge; // 섬과 섬사이 다리길이 저장
	static ArrayList<Edge> Elist; // 크루스칼용 어레이리스트
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	///////////////크루스칼용
	static int[] p;
	static int cnt;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		board = new int[N][M];
		numberingVisited = new boolean[N][M];
		Elist = new ArrayList<>();
		
		int isNum = 1; //섬의 시작번호
		for(int y=0; y<N; ++y) {
			s = br.readLine().split("\\s");
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		//입력......
		for(int y=0; y<N; ++y) {
			for(int x=0; x<M; ++x) {
				if(numberingVisited[y][x]) continue;
				if(board[y][x]!=0) {
					numbering(y,x,isNum++);
				}
			}
		}
		//섬에대한 넘버링...
		p = new int[isNum];
		edge = new int[isNum][isNum];
		
		for(int y=0; y<N; ++y) {
			for(int x=0; x<M; ++x) {
				if(board[y][x]!=0) {
					makeBridge(y, x, board[y][x]);
				}				
			}
		}// 다리만들기...
		
		for(int[] e : edge) {
			System.out.println(Arrays.toString(e));
		}
		
		for(int i=0; i<isNum; ++i) {
			for(int j=0; j<isNum; ++j) {
				if(edge[i][j] != 0) {
					Elist.add(new Edge(i,j,edge[i][j]));
				}
			}
		}
		Collections.sort(Elist);
		
		makeSet();
		
		for(Edge e : Elist) {
			if(cnt == isNum-2) break;
			unionSet(e);		
		}
		
		int count = 0;
		
		//외딴섬을 체크하는부분..
		for(int i=1; i<p.length; ++i) {
			if(p[i]==i) count++;
				
		}
		
		
		//크루스칼 알고리즘...
		if(count!=1) System.out.println(-1);
		else System.out.println(result == 0 ? -1 : result);
		
		
		
		
	}
	
	private static void unionSet(Edge e) {
		int x = findSet(e.startV);
		int y = findSet(e.endV);
		
		if(x!=y) {
			p[y] = x;
			result += e.weight;
			cnt++;
		}
	}

	private static int findSet(int startV) {
		if(p[startV] == startV) return startV;
		
		
		return p[startV] = findSet(p[startV]);
	}

	private static void makeSet() {
		for(int i=1; i<p.length; ++i) {
			p[i] = i;
		}
	}
	
	private static void makeBridge(int y, int x, int isNum) {
		int sy = y;
		int sx = x;
		
		
		for(int dir=0; dir<4; ++dir) {
			int weight =1;
			while(true) {
				int ny = sy + dy[dir]*weight;
				int nx = sx + dx[dir]*weight;
				if(ny<0 || nx<0 || ny>=N || nx>=M) break;
				if(board[sy][sx] == board[ny][nx]) break;				
				if(board[sy][sx] != board[ny][nx] && board[ny][nx]!=0) {
					if(weight-1<2) break;
					if(edge[isNum][board[ny][nx]]!=0) {
						edge[isNum][board[ny][nx]] = Math.min(edge[isNum][board[ny][nx]], weight-1);
					}
					else edge[isNum][board[ny][nx]] = weight-1;
					
					break;
				}
				
				weight++;
			}
		}
	}
	
	private static void numbering(int y, int x, int num) {
		Queue<Pair> q = new LinkedList<>();
		numberingVisited[y][x] = true;
		board[y][x] = num;
		q.offer(new Pair(y,x));
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if(numberingVisited[ny][nx] || board[ny][nx]==0) continue;
				q.offer(new Pair(ny, nx));
				numberingVisited[ny][nx] = true;
				board[ny][nx] = num;
			}
			
		}
	}
	
	static void print() {
		for(int[] M : board) {
			System.out.println(Arrays.toString(M));
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int startV;
		int endV;
		int weight;
		
		public Edge(int startV, int endV, int weight) {
			super();
			this.startV = startV;
			this.endV = endV;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [startV=" + startV + ", endV=" + endV + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight == o.weight ? this.startV-o.startV : this.weight - o.weight;
		}
		
	}
	static class Pair{
		int y=0;
		int x=0;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + "]";
		}
				
	}
}
