import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ1235 {
	static int N;
	static String[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		
		
		for(int i=0; i<N; ++i) {
			arr[i] = br.readLine();
		}
		int idx = 1;
		while(true) {
			HashSet<String> hs = new HashSet<>();
			
			if(idx > arr[0].length()) break;
			
			for(int i=0; i<arr.length; ++i) {						
				String tmp = arr[i].substring(arr[i].length()-idx);
				hs.add(tmp);	
			}
			
			
			
			if(hs.size()==N) {
				System.out.println(idx);
				break;
			}
			idx++;
		}
		
		
	}

}
