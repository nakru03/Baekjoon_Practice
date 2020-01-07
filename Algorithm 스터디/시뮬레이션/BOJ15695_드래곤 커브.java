import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*0,0 1,0

0,0 - 1,0

1,-1

0     1    2 1     2 32 1     2 3 0 32 3 2 1  세대별 규칙

0세대 

0

1세대

1

2세대 

2

1

3세대 

23 21


2-> 23
23->2303
5세대
2303 0103  23032321*/
public class Main {
	static int[][] board = new int[102][102];
	static final int[] dx = {1,0,-1,0};
	static final int[] dy = {0,-1,0,1};
	static ArrayList<Integer> dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int t=0; t<N; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());		
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int startDir = Integer.parseInt(st.nextToken());
			int gene = Integer.parseInt(st.nextToken());
			board[startX][startY] = 1;
			startX = startX + dx[startDir];
			startY = startY + dy[startDir];
			board[startX][startY] = 1;
			startDir = (startDir+1)%4;
			
			dir = new ArrayList<>();
			dir.add(startDir);
			
			dragonCurve(startX, startY, gene, 0);
		}
		int result = 0;
		for(int i=0; i<101; ++i) {
			for(int j=0; j<101; ++j) {
				if(board[i][j] == 1 && board[i][j+1] == 1 && board[i+1][j] ==1 && board[i+1][j+1] == 1) {
					//System.out.println(i + " " +j);
					result++;
				}
			}
		}
		System.out.println(result);
	}
	private static void dragonCurve(int startX, int startY, int gene, int depth) {
		if(depth == gene) {
			return;
		}
		//board[startX][startY] = 1;
		ArrayList<Integer> tmp = (ArrayList<Integer>) dir.clone();
		//System.out.println(tmp);
		for(int i=0; i<dir.size(); ++i) {
			startY = startY + dy[dir.get(i)];
			startX = startX + dx[dir.get(i)];

			board[startX][startY] = 1;
		}
		dir.clear();
		
		for(int i=0; i<tmp.size(); ++i) {	
			
			if(i<tmp.size()/2) {
				dir.add(tmp.get(i));
			}
			else {
				int nextIdx = Math.abs(i - tmp.size())-1;
				dir.add((tmp.get(nextIdx)+1)%4);
			}
			
		}
		for(int i=0; i<tmp.size(); ++i) {
			dir.add(tmp.get(i));
		}
		
		dragonCurve(startX, startY, gene, depth+1);
	}

}
