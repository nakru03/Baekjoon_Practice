import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 바퀴는 4개
 * 톱니는 8개
 * 돌아가는 부분 2번과 6번
 * 12시 S극은 점수 N은 0점
 * 서로 N극 S극으로 달라야 회전
 * 회전시에 인접 바퀴는 반대방향으로 회전
 * 
 */
public class BOJ14891 {
	static ArrayList<String>[] gear;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new ArrayList[4];

		for(int t=0; t<4; ++t) {
			String[] str = br.readLine().split("");
			gear[t] = new ArrayList<String>();
			for(int i=0; i<str.length; ++i ) {
				gear[t].add(str[i]);
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numOfGear = Integer.parseInt(st.nextToken())-1;
			int turnDir = Integer.parseInt(st.nextToken());
			checkLeft(numOfGear-1, turnDir*-1);
			checkRight(numOfGear+1, turnDir*-1);
			rotate(numOfGear, turnDir);
			
		}
		
		int score = 0;
		for(int i=0; i<4; ++i) {
			if(gear[i].get(0).equals("1")) {
				score+= Math.pow(2, i);
			}
		}
		System.out.println(score);
	}
	
	
	private static void checkLeft(int numOfGear, int turnDir) {
		if(0>numOfGear) return;
		if(!gear[numOfGear].get(2).equals(gear[numOfGear+1].get(6))) {
			checkLeft(numOfGear-1, turnDir*-1);
			rotate(numOfGear, turnDir);
		}
		
	}
	private static void checkRight(int numOfGear, int turnDir) {
		if(numOfGear>3) return;
		if(!gear[numOfGear].get(6).equals(gear[numOfGear-1].get(2))) {
			checkRight(numOfGear+1, turnDir*-1);
			rotate(numOfGear, turnDir);
		}
		
	}
	//톱니 돌리기.
	private static void rotate(int numOfGear, int turnDir) {
		if(turnDir == -1) {
			String tmp = gear[numOfGear].get(0);
			gear[numOfGear].remove(0);
			gear[numOfGear].add(tmp);
		}
		else {
			String tmp = gear[numOfGear].get(7);
			gear[numOfGear].remove(7);
			gear[numOfGear].add(0,tmp);
		}
	}
}
