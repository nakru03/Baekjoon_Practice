import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3052 {
	static int[] count = new int[1000];
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; ++i) {
			int n = Integer.parseInt(br.readLine());
			count[n%42]++;			
		}
		for(int i=0; i<count.length; ++i) {
			if(count[i] != 0) {
				res++;
			}
		}
		System.out.println(res);
	}

}
