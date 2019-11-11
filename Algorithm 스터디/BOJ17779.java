import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17779 {
	static int N;
	static int[][] board;
	static ArrayList<Pair> leftSide = new ArrayList<>();
	static ArrayList<Pair> rightSide= new ArrayList<>();
	
	static int[] dy = {1,1};
	static int[] dx = {-1,1};
	static boolean[][] visited;
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int y=0; y<N; ++y) {
			String[] s = br.readLine().split("\\s");
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		for(int y=0; y<N; ++y) {
			for(int x=0; x<N; ++x) {
				MAX = Integer.MIN_VALUE;
				MIN = Integer.MAX_VALUE;
				visited = new boolean[N][N];
				pick(new Pair(y,x));
			}
		}
		System.out.println(answer);
	}
	
	private static void pick(Pair start) {
		//왼쪽편 대각선으로 진행

		int count = 1;		
		while(true) {
			int ny = start.y + dy[0] * count;
			int nx = start.x + dx[0] * count;
			
			if(ny>=N || nx<0 || nx>=N) break;
			leftSide.add(new Pair(ny, nx));
			visited[ny][nx] = true;
			count++;
		}
		//오른쪽 대각선으로 진행
		int count2 = 1;
		while(true) {
			int ny = start.y + dy[1] * count2;
			int nx = start.x + dx[1] * count2;
			
			if(ny>=N || nx<0 || nx>=N) break;
			rightSide.add(new Pair(ny, nx));
			visited[ny][nx] = true;
			count2++;
		}
		
		if(leftSide.isEmpty() || rightSide.isEmpty()) return;
		
		for(int i=0; i<leftSide.size(); ++i) {
			for(int j=0; j<rightSide.size(); ++j) {
				Pair crossPoint = check(leftSide.get(i),rightSide.get(j));
				if(crossPoint==null) continue;
				calc(start, leftSide.get(i), rightSide.get(j), crossPoint);
			}
		}
	}
	
	
	static ArrayList<Integer> sums = new ArrayList<>();
	private static void calc(Pair start, Pair left, Pair right, Pair crossPoint) {
		int section1 = 0;
		int section2 = 0;
		int section3 = 0;
		int section4 = 0;
		int section5 = 0;
		
		sums.add(sum(new Pair(0,0), start.x+1, left.y));
		sums.add(sum1(new Pair(0,N-1),start.x, right.y+1));
		sums.add(sum2(new Pair(N-1,0),crossPoint.x,left.y-1));
		sums.add(sum3(new Pair(N-1,N-1),crossPoint.x-1, right.y));
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				if(visited[i][j]) continue;
				section5+=board[i][j];
			}
		}
		sums.add(section5);
		for(int i=0; i<sums.size(); ++i) {
			MAX = Math.max(MAX, sums.get(i));
			MIN = Math.min(MIN, sums.get(i));
		}
		answer = Math.min(answer, MAX-MIN);
	}

	private static int sum(Pair pair, int sx, int sy) {
		int sum = 0;
		for(int i=pair.y; i<sy; ++i) {
			for(int j=pair.x; j<sx; ++j) {
				if(visited[i][j]) break;
				sum += board[i][j];
			}
		}
		return sum;
	}
	
	private static int sum1(Pair pair, int sx, int sy) {
		int sum = 0;
		for(int i=pair.y; i<sy; ++i) {
			for(int j=pair.x; j>sx; --j) {
				if(visited[i][j]) break;
				sum += board[i][j];
			}
		}
		return sum;
	}
	
	private static int sum2(Pair pair, int sx, int sy) {
		int sum = 0;
		for(int i=pair.y; i>sy; --i) {
			for(int j=pair.x; j<sx; ++j) {
				if(visited[i][j]) break;
				sum += board[i][j];
			}
		}
		return sum;
	}
	
	private static int sum3(Pair pair, int sx, int sy) {
		int sum = 0;
		for(int i=pair.y; i>sy; --i) {
			for(int j=pair.x; j>sx; --j) {
				if(visited[i][j]) break;
				sum += board[i][j];
			}
		}
		return sum;
	}

	private static Pair check(Pair leftstart, Pair rightstart) {
		// TODO Auto-generated method stub
		Pair result=null;
		int count = 1;		
		while(true) {
			int ny = leftstart.y + dy[1] * count;
			int nx = leftstart.x + dx[1] * count;
			
			if(ny>=N || nx<0 || nx>=N) break;
			visited[ny][nx] = true;
			count++;
		}
		
		int count1 = 1;		
		while(true) {
			int ny = rightstart.y + dy[0] * count1;
			int nx = rightstart.x + dx[0] * count1;
			
			if(ny>=N || nx<0 || nx>=N) break;
			if(visited[ny][nx]) {
				result=new Pair(ny,nx);
				break;
			}
			visited[ny][nx] = true;
			count1++;
		}
		return result;
	}



	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}

}
