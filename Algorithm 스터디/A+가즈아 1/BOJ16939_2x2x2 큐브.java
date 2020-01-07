import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cube = new int[25];
	static int[] copy = new int[25];
	static int tmp, tmp2;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=24; ++i) {
			cube[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=12; ++i) {
			copy();
			rotate(i);
			answer = check();
			if(answer == 1) break;
			
		}
		
		System.out.println(answer);
		
	}

	private static int check() {
		
		for(int i=2; i<=4; ++i) {
			if(copy[1]!=copy[i]) return 0;
		}
		
		for(int i=6; i<=8; ++i) {
			if(copy[5]!=copy[i]) return 0;
		}
		
		for(int i=10; i<=12; ++i) {
			if(copy[9]!=copy[i]) return 0;
		}
		
		for(int i=14; i<=16; ++i) {
			if(copy[13]!=copy[i]) return 0;
		}
		for(int i=18; i<=20; ++i) {
			if(copy[17]!=copy[i]) return 0;
		}
		for(int i=22; i<=24; ++i) {
			if(copy[21]!=copy[i]) return 0;
		}
		return 1;
		
	}

	private static void copy() {
		for(int i=0; i<cube.length; ++i) {
			copy[i] = cube[i];
		}
	}

	private static void rotate(int i) {
		switch(i) {
		case 1:
			tmp = copy[22];
			tmp2 = copy[24];
			
			copy[22] = copy[3];
			copy[24] = copy[1];
			
			copy[3] = copy[7];
			copy[5] = copy[9];
			
			copy[11] = tmp;
			copy[9]  = tmp2;
			break;
		case 2:
			for(int j=0; j<3; ++j) {
				rotate(1);
			}
			break;
		case 3:
			tmp = copy[21];
			tmp2 = copy[23];
			copy[21] = copy[4];
			copy[23] = copy[2];
			
			copy[4] = copy[8];
			copy[2] = copy[6];
			
			copy[6] = copy[10];
			copy[8] = copy[12];
			
			copy[10] = tmp2;
			copy[12] = tmp;
			break;
		case 4:
			for(int j=0; j<3; ++j) {
				rotate(3);
			}
			break;
		case 5:
			tmp = copy[9];
			tmp2 = copy[10];
			
			copy[9] = copy[14];
			copy[10] = copy[16];
			
			copy[14] = copy[4];
			copy[16] = copy[3];
			
			copy[4] = copy[19];
			copy[3] = copy[17];
			
			copy[17] = tmp2;
			copy[19] = tmp;
			break;
		case 6:
			for(int j=0; j<3; ++j) {
				rotate(5);
			}
			break;
		case 7:
			tmp = copy[11];
			tmp2 = copy[12];
			
			copy[11] = copy[13];
			copy[12] = copy[15];

			copy[13] = copy[2];
			copy[15] = copy[1];

			copy[2] = copy[20];
			copy[1] = copy[18];

			copy[20] = tmp;
			copy[18] = tmp2;
			break;
		case 8:
			for(int j=0; j<3; ++j) {
				rotate(7);
			}
			break;
		case 9:
			tmp = copy[18];
			tmp2 = copy[17];
			copy[18] = copy[22];
			copy[17] = copy[21];

			copy[22] = copy[14];
			copy[21] = copy[13];

			copy[13] = copy[5];
			copy[14] = copy[6];

			copy[5] = tmp2;
			copy[6] = tmp;
			break;
		case 10:
			for(int j=0; j<3; ++j) {
				rotate(9);
			}
			break;
		case 11:
			tmp = copy[19];
			tmp2 = copy[20];
			
			copy[20] = copy[24];
			copy[19] = copy[23];

			copy[24] = copy[16];
			copy[23] = copy[15];

			copy[16] = copy[8];
			copy[15] = copy[7];

			copy[8] = tmp2;
			copy[7] = tmp;
			break;
		case 12:
			for(int j=0; j<3; ++j) {
				rotate(11);
			}
			break;
		}

	}

}
