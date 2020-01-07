import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
	static ArrayList<Meetup> list = new ArrayList<Meetup>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Meetup(start, end));
			
		}
		Collections.sort(list, new Comparator<Meetup>() {

			@Override
			public int compare(Meetup o1, Meetup o2) {
				return o1.end==o2.end ? o1.start-o2.start : o1.end - o2.end;
			}
			
		});
		Meetup now = list.get(0);
		int count = 1;
		for(int i=1; i<list.size(); ++i) {
			if(now.end>list.get(i).start) continue;
			else {
				now=list.get(i);
				//System.out.println(now);
				count++;
			}			
			
		}
		System.out.println(count);
		
	}
	static class Meetup{
		int start;
		int end;
		Meetup(int start, int end){
			this.start = start;
			this.end = end;
		}
//		@Override
//		public String toString() {
//			return "Meetup [start=" + start + ", end=" + end + "]";
//		}
		
	}
}
