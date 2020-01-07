import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 뒤 0 바닥 1 앞2 위 3 왼 4 오 5 
 */
public class BOJ14499 {
	static int[][] board;
	static int[] dice = new int[6];
	static final int[] dx = {-99,1,-1,0,0}; //동서북남
	static final int[] dy = {-99,0,0,-1,1};
	static int N;
	static int M;	
	static int startY;
	static int startX;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		//말판..
		//시작점...
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; ++i) {
//			for(int j=0; j<M; ++j) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i=0; i<c; ++i) {
			int command = Integer.parseInt(st.nextToken());
			rollDice(startY, startX, command);
			System.out.println(startY + " " + startX);
		}
		
	}
	
	private static void rollDice(int startY, int startX, int command) {
		if(board[startY][startX]==0) 
			board[startY][startX] = dice[1];
		else{
			dice[1] = board[startY][startX];
		}
		System.out.println(dice[1]);
		switch (command){
			case 1:
				if(boundaryCheck(command)) {
					swap(1,4);
					swap(1,3);
					swap(1,5);
					System.out.println(dice[3]);
				}
				else {
					System.out.println(dice[3]);
				}
				break;
			case 2:
				if(boundaryCheck(command)) {
					swap(1,5);
					swap(1,3);
					swap(1,4);
					System.out.println(dice[3]);
				}
				else {
					System.out.println(dice[3]);
				}
				break;
			case 3:
				if(boundaryCheck(command)) {
					swap(0,1);
					swap(0,2);
					swap(0,3);
					System.out.println(dice[3]);
				}
				else {
					System.out.println(dice[3]);
				}
				break;
			case 4:
				System.out.println("4 호출" + command);
				if(boundaryCheck(command)) {
					swap(1,2);
					swap(0,2);
					swap(0,3);
					System.out.println(dice[3]);
				}
				else {
					System.out.println(dice[3]);
				}
				break;
		}
	}
	
	public static void swap(int i, int j){
		int tmp;
		tmp = dice[i];
		dice[i] = dice[j];
		dice[j] = tmp;
	}
	
	public static boolean boundaryCheck(int dir) {
		int ny = startY + dy[dir];
		int nx = startX + dx[dir];
		System.out.println(ny + " " + nx);
		if(ny >= 0 && nx >= 0 && ny<N && nx<M) {
			System.out.println("통과");
			startY = ny;
			startX = nx;
			return true;
			
		}
		return false;		
		
	}

}
