import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static String I;
	static String C;
	static int[] memory;
	static int pointer;
	static char[] command;
	static Queue<Character> input = new LinkedList<>();
	static int visited[];
	static ArrayList<Integer> cycle = new ArrayList<>();
	static String answer;
	static Node[] bracket;
	static int maxCounter = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			C = st.nextToken();
			I = st.nextToken();
			
			cycle.clear();
			input.clear();
			memory = new int[M];
			
			command = br.readLine().toCharArray();
			bracket = new Node[command.length];
			for(int i=0; i<command.length; ++i) {
				bracket[i] = new Node(0,0);
			}
			char[] tmp = br.readLine().toCharArray();
			
			for(int i=0; i<tmp.length; ++i) {
				input.offer(tmp[i]);
			}
			int counter = 0;
			int index=0;
			Stack<Node> s = new Stack<>();
			Node node1;
			for(int i=0; i<command.length; ++i) {
				if(command[i]=='[') {
					bracket[i].start = i;
					
					s.push(bracket[i]);
				}else if(command[i]==']') {
					node1 = s.pop();
					bracket[i].start= node1.start;
					bracket[i].end = i;
					bracket[node1.start].end = i;
				}
			}
			
			
			while(true) {
				
				if(counter==command.length) {
					answer = "Terminates";
					break; //명령어 종료
				}
				if(index>50000000) {
					answer = "Loops";
					break;
				}
				
				switch(command[counter]) {
				case '+':
					memory[pointer] = (memory[pointer]+1) % 256;
					break;
				case '-':
					memory[pointer] = memory[pointer]-1;
					if(memory[pointer]==-1) memory[pointer]=255;
					break;
				case '<':
					pointer = pointer-1;
					if(pointer==-1) {
						pointer = memory.length-1;
					}
					break;
				case '>':
					pointer = pointer+1;
					if(pointer==memory.length) {
						pointer = 0;
					}
					break;
				case '[':
					if(memory[pointer]==0) {
						counter = bracket[counter].end;
						counter--;
					}
					break;
				case ']':
					
					if(memory[pointer]!=0) {
						counter = bracket[counter].start;
						counter--;
					}
					break;
				case '.':
					break;
				case ',':
					if(!input.isEmpty())
						memory[pointer] = input.poll();
					else {
						memory[pointer] = 255;
					}
					break;
				}
				
				index++;
				counter++;
				maxCounter = Math.max(maxCounter, counter);
			}
			if(answer == "Terminates") {
				System.out.println(answer);
			}else {
				System.out.println(answer + " "+ bracket[maxCounter].start + " " + bracket[maxCounter].end);
			}
			pointer = 0;
			answer = "";
			maxCounter = -1;
		}
	}
	static class Node{
		int start;
		int end;
		
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
}

