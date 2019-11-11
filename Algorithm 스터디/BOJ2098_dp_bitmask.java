import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2098 {
	static int val[][], mem[][], size; //val 그래프 mem
	static final int START=0, MAX=98765432;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		val = new int[size][size];
		mem  =new int[size][1<<size];
		StringTokenizer st;
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				val[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int[] m : mem) Arrays.fill(m, -1);
		System.out.println(tsp(START, 1<<START));
	}
	private static int tsp(int here, int visited) {
		if(mem[here][visited]!=-1) return mem[here][visited];
		
		if(visited == (1<<size)-1) {
			if(val[here][START]!=0)
				return mem[here][visited]=val[here][START];
			else {
				return mem[here][visited]=MAX;
			}
		}
		
		mem[here][visited]=MAX;
		for(int i=0; i<size; i++) {
			if(val[here][i]==0 || (visited&(1<<i))>0) continue;
			mem[here][visited] = Math.min(mem[here][visited], tsp(i, visited|(1<<i)) + val[here][i]);
		}
		return mem[here][visited];
	}
}
