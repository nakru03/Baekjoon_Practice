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
	static final int[] dy = {-99,0,0,-1,1}; //편의상 0,0을 사용안함.
	static int N;
	static int M;	
	static int startY;
	static int startX;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
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

		for(int i=0; i<c; ++i) {
			int command = Integer.parseInt(st.nextToken());
			rollDice(command); //주사위를 굴림.
			
		}
		System.out.println(sb);
		
	}	
	
	private static void rollDice(int command) {
		
		//바닥은 고정되있다 생각하고 숫자를 스왑해서 주사위를 굴림.
		switch (command){
			case 1:
				if(boundaryCheck(command)) {
					swap(1,4);
					swap(1,3);
					swap(1,5);
					
					if(board[startY][startX]==0) 
						board[startY][startX] = dice[1]; //0일때 바닥복사
					else{
						dice[1] = board[startY][startX];
						board[startY][startX] = 0; 		//칸의 숫자를 복사
					}
					
					sb.append(dice[3]+"\n");
					
				}
				
				break;
			case 2:
				if(boundaryCheck(command)) {
					swap(1,5);
					swap(1,3);
					swap(1,4);
					
					if(board[startY][startX]==0) 
						board[startY][startX] = dice[1]; //0일때 바닥복사
					else{
						dice[1] = board[startY][startX];
						board[startY][startX] = 0; 		//칸의 숫자를 복사
					}
					
					sb.append(dice[3]+"\n");
				}
				
				break;
			case 3:
				if(boundaryCheck(command)) {
					swap(0,1);
					swap(0,2);
					swap(0,3);
					
					if(board[startY][startX]==0) 
						board[startY][startX] = dice[1]; //0일때 바닥복사
					else{
						dice[1] = board[startY][startX];
						board[startY][startX] = 0; 		//칸의 숫자를 복사
					}
					
					sb.append(dice[3]+"\n");
				}
				
				break;
			case 4:
				if(boundaryCheck(command)) {
					swap(1,2);
					swap(0,3);
					swap(0,2);
					
					if(board[startY][startX]==0) 
						board[startY][startX] = dice[1]; //0일때 바닥복사
					else{
						dice[1] = board[startY][startX];
						board[startY][startX] = 0; 		//칸의 숫자를 복사
					}
					
					sb.append(dice[3]+"\n");
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
	
	public static boolean boundaryCheck(int dir) { //바운더리 체크
		int ny = startY + dy[dir];
		int nx = startX + dx[dir];
		if(ny >= 0 && nx >= 0 && ny<N && nx<M) {
			startY = ny;
			startX = nx;
			return true;
			
		}else {
			return false;		
		}
		
		
	}

}
