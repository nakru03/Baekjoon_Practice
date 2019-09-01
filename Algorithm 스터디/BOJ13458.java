import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ13458 {
	
	static int N;
	static ArrayList<Integer> list;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		
		int allViewer = Integer.parseInt(s2[0]);
		int subViewer = Integer.parseInt(s2[1]);
		
		for(int i=0; i<N; ++i) {
			list.add(Integer.parseInt(s[i])-allViewer);
			answer++;
		}
		
		for(int i=0; i<N; ++i) {
			if(list.get(i)>0) {
				answer+=list.get(i)/subViewer;
				if(list.get(i) % subViewer!=0) {
					answer++;
				}
			}
			
		}
		
		System.out.println(answer);
	}

}
