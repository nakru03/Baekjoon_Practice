import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int A;
	static int B;
	static int C;
	static int X;
	static int Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("\\s");
		
		A = Integer.parseInt(s[0]);
		B = Integer.parseInt(s[1]);
		C = Integer.parseInt(s[2]);
		X = Integer.parseInt(s[3]);
		Y = Integer.parseInt(s[4]);
		
		int result = 0;
		if(A+B<C*2) {
			result = (A*X) + (B*Y);
		}else {
			int less = Math.min(X, Y);
			int tmp = (Math.max(X, Y)-less);
			
			if(X>Y) {
				if(A>C*2) {
					result = (tmp * C * 2) + (less * C * 2);
				}else
					result = tmp * A + (less * C * 2);
			}
			else {
				if(B>C*2) {
					result = (tmp * C * 2) + (less * C * 2);
				}else
					result = tmp * B + (less * C * 2);
			}
		}
		System.out.println(result);
	}
}
