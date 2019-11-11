import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2170 {
	static int N;
	static ArrayList<Pair> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; ++i) {
			String[] s = br.readLine().split("\\s");
			list.add(new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
		}
		Collections.sort(list);
		long end = list.get(0).dst;
		long result = list.get(0).dst-list.get(0).st;
		
		for(int i=1; i<list.size(); ++i) {
			if(end>list.get(i).st) {
				if(list.get(i).dst>end) {
					result += list.get(i).dst - end;
					end = list.get(i).dst;
				}
				else continue;
			}
			else {
				result += list.get(i).dst-list.get(i).st;
				end = list.get(i).dst;
			}
		}
		System.out.println(result);
	}
	static class Pair implements Comparable<Pair>{
		long st;
		long dst;
		
		public Pair(long st, long dst) {
			super();
			this.st = st;
			this.dst = dst;
		}

		@Override
		public int compareTo(Pair o) {	
			return (int) (this.st == o.st ? this.dst - o.dst : this.st - o.st);
		}
		
		
	}
}
