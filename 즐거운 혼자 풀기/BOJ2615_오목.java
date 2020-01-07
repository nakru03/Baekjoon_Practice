import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2615 {
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[19][19];
		
		for(int y=0; y<19; ++y) {
			String[] s = br.readLine().split("\\s");
			for(int x=0; x<19; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		for(int y=0; y<19; ++y) {
			for(int x=0; x<19; ++x) {
				if(board[y][x]!=0) {
					check1(y,x);//가로
					check2(y,x);//세로
					check3(y,x);//우하향 대각
					check4(y,x);//좌하향 대각
				}
				
			}
		}
		System.out.println(0);
	}
	static ArrayList<Pair> list = new ArrayList<>();
	private static void check4(int y, int x) {
		for(int i=0; i<5; ++i) {
			if(y+i>=19 || x-i<0) return;
			if(board[y+i][x-i]!=board[y][x]) return;
			
			if(x+1<19 && y!=0 && board[y-1][x+1]==board[y][x])return;
			
			
		}
		if(y+4+1<19 && x-4-1>=0 && board[y+4+1][x-4-1]==board[y][x]) return;
		for(int i=0; i<5; ++i) {
			list.add(new Pair(y+i+1,x-i+1));
		}
		System.out.println(board[y][x]);
		Collections.sort(list);
		System.out.println(list.get(0).y+" "+list.get(0).x);
		System.exit(0);
	}
	private static void check3(int y, int x) {
		for(int i=0; i<5; ++i) {
			if(y+i>=19 || x+i>=19) return;			
			if(board[y+i][x+i]!=board[y][x]) return;
			if(x!=0 && y!=0 && board[y-1][x-1]==board[y][x])return;
			
			
		}
		if(y+4+1<19 && x+4+1<19 && board[y+4+1][x+4+1]==board[y][x]) return;
		for(int i=0; i<5; ++i) {
			list.add(new Pair(y+i+1,x+i+1));
		}
		System.out.println(board[y][x]);
		Collections.sort(list);
		System.out.println(list.get(0).y+" "+list.get(0).x);
		System.exit(0);
	}
	private static void check2(int y, int x) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; ++i) {
			if(y+i>=19) return;
			if(board[y+i][x]!=board[y][x]) return;			
			if(y!=0 && board[y-1][x]==board[y][x])return;
			
			
		}
		if(y+4+1<19 && board[y+4+1][x]==board[y][x]) return;
		for(int i=0; i<5; ++i) {
			list.add(new Pair(y+i+1,x+1));
		}
		System.out.println(board[y][x]);
		Collections.sort(list);
		System.out.println(list.get(0).y+" "+list.get(0).x);
		System.exit(0);
		
	}
	private static void check1(int y, int x) {
		for(int i=0; i<5; ++i) {
			if(x+i>=19) return;
			if(board[y][x+i]!=board[y][x]) return;			
			if(x!=0 && board[y][x-1]==board[y][x])return;			
			
		}
		if(x+4+1<19 && board[y][x+4+1]==board[y][x]) return;
		for(int i=0; i<5; ++i) {
			list.add(new Pair(y+1,x+i+1));
		}
		System.out.println(board[y][x]);
		Collections.sort(list);
		System.out.println(list.get(0).y+" "+list.get(0).x);
		System.exit(0);
	}
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.x==o.x ? this.y-o.y : this.x - o.x;
		}
		
	}
}
