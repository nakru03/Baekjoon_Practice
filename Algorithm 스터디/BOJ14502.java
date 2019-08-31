import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ14502_2 {

	static int N;
	static int M;
	static int max = Integer.MIN_VALUE;
	static int wallCount;
	static int virusCount;
	
	static int[][] board;
	static int[][] board2;
	
	static ArrayList<Pair> list;
	static ArrayList<Pair> virusList;
	static ArrayList<Pair> selecWall;
	
	static final int[] dy = {0,-1,0,1};
	static final int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		board2 = new int[N][M];
		
		list = new ArrayList<Pair>();
		virusList = new ArrayList<Pair>();
		selecWall = new ArrayList<Pair>();
		
		for(int y=0; y<N; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
				if(board[y][x]==0) {
					list.add(new Pair(y,x));
				}
				else if(board[y][x]==2) {
					virusList.add(new Pair(y,x));
					virusCount++;
				}
				else wallCount++;
			}
		}
		
		combi(0,0);
		System.out.println(max);
	
	}
	private static void combi(int idx, int depth) {
		if(depth == 3) {						
			bfs();
			return;
		}
		for(int i=idx; i<list.size(); ++i) {
			selecWall.add(list.get(i));
			combi(i+1, depth+1);
			selecWall.remove(selecWall.size()-1);
		}
	}
	private static void bfs() {
		arrayCopy(board, board2);
		for(int i=0; i<selecWall.size(); ++i) {
			board2[selecWall.get(i).y][selecWall.get(i).x] = 1;
		}
		
		Queue<Pair> q = new LinkedList<>();
		int count = 0;//확산 바이러스 카운트.
		for(int i=0; i<virusList.size(); ++i) {
			q.offer(new Pair(virusList.get(i).y, virusList.get(i).x));
		}
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(ny < 0 || nx < 0 || ny>=N || nx>=M) continue;
				if(board2[ny][nx]!=0) continue;
				board2[ny][nx] = 2;
				q.offer(new Pair(ny, nx));
			}
		}
		int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board2[i][j] ==0) {
                    result ++;
                }
            }
        }
        
		max = max < result ? result : max;
	}
	
	public static void arrayCopy(int[][] board, int[][] board2) {
        for (int i = 0; i < N; i++) {
            board2[i] = board[i].clone();
        }
    }
	
	static class Pair{
        int x ;
        int y ;
        public Pair(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
        
    }

}
