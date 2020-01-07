import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		
		for(int t=0; t<tc; ++t) {
			
			String command = br.readLine();
			left.clear();
			right.clear();
			
			for(int i=0; i<command.length(); ++i) {
				
				if(command.charAt(i) == '<') {
					if(!left.isEmpty()) {
						right.addFirst(left.pollLast());
					}
					
				}else if(command.charAt(i)=='>') {
					if(!right.isEmpty()) {
						left.addLast(right.pollFirst());
					}
					
				}else if(command.charAt(i)=='-') {
					if(!left.isEmpty()) {
						left.pollLast();
					}
					
				}else {
					left.offerLast(command.charAt(i));
				}
				
			}
			
			while(!left.isEmpty()) {
				sb.append(left.pollFirst());
			}
			while(!right.isEmpty()) {
				sb.append(right.pollFirst());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
