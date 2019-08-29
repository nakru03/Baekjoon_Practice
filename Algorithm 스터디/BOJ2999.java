import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2999 {
	static int R;
	static int C;
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		
		for(int i=1; i<=s.length(); ++i) {
			if(s.length()%i==0) {
				arr.add(i);
			}
		}

		if(arr.size()%2 == 0) {
			R = arr.get(arr.size()/2-1);
		}
		else R = arr.get(arr.size()/2);
		
		C = s.length() / R;
		
		board = new char[R][C];
		
		int k=0;
		for(int i=0; i<C; ++i) {
			for(int j=0; j<R; ++j) {
				board[j][i] = s.charAt(k);
				k++;
			}
		}
		
		for(int i=0; i<R; ++i) {
			for(int j=0; j<C; ++j) {
				System.out.print(board[i][j]);	
			}
		}
	}
}
