package yaja;

import java.util.Scanner;
import java.util.Stack;

public class BJO2493 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 0;
		String towers = null;
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		sc.nextLine();
		towers = sc.nextLine();
		
		sc.close();
		String[] towerSplit = towers.split(" ");
		Stack<Pair> st = new Stack<>();
		
		for (int i = 0; i < n; ++i) {
			//int tower = sc.nextInt();
			Pair currT = new Pair(Integer.parseInt(towerSplit[i]), i+1);
			if(st.isEmpty()) {
				st.push(currT);
				sb.append("0 ");
			}				
			else if(st.peek().data<currT.data && !st.isEmpty()) {
				while(st.peek().data<currT.data) {
					st.pop();
					if(st.isEmpty()) break;
				}				
				if(st.isEmpty()) sb.append("0 ");
				else sb.append(st.peek().index +" ");
				st.push(currT);
			}else {
				sb.append(st.peek().index +" ");
				st.push(currT);
			}
			
		}
		
		System.out.println(sb);

	}

static class Pair {
	public int data;
	public int index;
	Pair(int data, int index) {
		this.data = data;
		this.index = index;

	}
}

}
