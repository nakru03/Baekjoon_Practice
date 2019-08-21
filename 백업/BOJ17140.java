import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;



public class BOJ17140 {
	static int[][] board = new int[100][100];
	static int[] count = new int[101];
	static int maxY;
	static int maxX;
	static ArrayList<Pair> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		board = new int[100][100];
		for(int y=0; y<3; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<3; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
			maxY=3;
			maxX=3;
		}
		
		int result = 0;
		while(true) {
			if(result>100) {
				System.out.println(-1);
				break;
			}
			if(board[r][c] == k) {
				System.out.println(result);
				break;
			}
			//R연산
			if(maxY>=maxX) {
				Rcalc();
				System.out.println();
				for(int y=0; y<maxY; ++y) {
					for(int x=0; x<maxX; ++x) {
						System.out.print(board[y][x]+" ");
					}
					System.out.println();
				}
			}
			//C연산
			else {
				Ccalc();
				System.out.println();
				for(int y=0; y<maxY; ++y) {
					for(int x=0; x<maxX; ++x) {
						System.out.print(board[y][x]+" ");
					}
					System.out.println();
				}
				
			}
			result++;
		}

	}
	private static void Ccalc() {
		
		arr = new ArrayList<>();
		int tmp =0;
		for(int y=0; y<maxX; ++y) {
			for(int x=0; x<maxY; ++x) {
				if(board[x][y]==0) continue;
				count[board[x][y]]++;
				board[x][y] = 0;
									
				
				
			}
			for(int i=1; i<count.length; ++i) {
				if(count[i]!=0)
					arr.add(new Pair(i, count[i]));
			}
			Collections.sort(arr, new Comparator<Pair>() {

				@Override
				public int compare(Pair arg0, Pair arg1) {
					return arg0.count-arg1.count;
				}		
			});
			int idx=0;
			
			for(Pair p : arr){
				board[idx++][y] = p.num;
				board[idx++][y] = p.count;
			}
			tmp = Math.max(tmp, idx);
			arr.clear();
			Arrays.fill(count, 0);
		}
		maxY = tmp;
		
	}
	private static void Rcalc() {
		arr = new ArrayList<>();
		int tmp =0;
		for(int y=0; y<maxY; ++y) {
			for(int x=0; x<maxX; ++x) {
				if(board[x][y]==0) continue;
				count[board[y][x]]++;
				board[y][x] = 0;
						
			}
			for(int i=0; i<count.length; ++i) {
				if(count[i]!=0)
					arr.add(new Pair(i, count[i]));
			}
			Collections.sort(arr, new Comparator<Pair>() {

				@Override
				public int compare(Pair arg0, Pair arg1) {
					 return arg0.count-arg1.count;
				}		
			});
			int idx=0;
			
			for(Pair p : arr){
				board[y][idx++] = p.num;
				board[y][idx++] = p.count;
			}
			tmp = Math.max(tmp, idx);
			arr.clear();
			Arrays.fill(count, 0);
		}
		maxX = tmp;
	}
	
	static void checkSize(){
		for(int y=0; y<board.length; ++y) {
			for(int x=0; x<board.length; ++x) {
				if(board[y][x]==0) continue;
				maxY = Math.max(maxY, y);
				maxX = Math.max(maxX, x);
			}
		}
	}
	
	static class Pair{
		int num;
		int count;
		Pair(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
}
