import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BOJ8983 {
	static long M;
	static long N;
	static long L;
	static int count;
	static ArrayList<Long> shotPlace;
	static LinkedList<Animal> animal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("\\s");
		
		M = Long.parseLong(s[0]);
		N = Long.parseLong(s[1]);
		L = Long.parseLong(s[2]);
		shotPlace = new ArrayList<>();
		animal = new LinkedList<>();
		
		s = br.readLine().split("\\s");
		for(int i=0; i<M; ++i) {
			shotPlace.add(Long.parseLong(s[i]));
		}
		
		
		for(int i=0; i<N; ++i) {			
			animal.add(new Animal(Long.parseLong(s[0]),Long.parseLong(s[1])));
		}
		
		
		for(int i=0; i<shotPlace.size(); ++i) {
			Iterator<Animal> it = animal.iterator();
			while(it.hasNext()) {
				Animal curr = it.next();
				if(Math.abs(shotPlace.get(i)-curr.x)+curr.y<=L) {
					count++;
					it.remove();
				}
			}
		}
		System.out.println(count);
	}
	static class Animal{
		
		long x;
		long y;
		
		public Animal(long x,long y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
}
