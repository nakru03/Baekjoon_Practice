import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5373 {
	static String[][] top;	
	static String[][] bottom;
	static String[][] front;	
	static String[][] back;
	static String[][] left;	
	static String[][] right;	
	static String[][] tmp;
		
	static String tmp1, tmp2,tmp3,tmp4,tmp5,tmp6,tmp7, tmp8, tmp9;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; ++i) {
			reset();
			int c = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for(int j=0; j<c; ++j) {				
				cubing(s[j]);				
			}
			for(int y=0; y<3; ++y) {
				for(int x=0; x<3; ++x) {
					System.out.print(top[y][x]);
				}
				System.out.println();
			}
		}
		
	}


	private static void reset() {
		top = new String[3][3];
		for(int i=0; i<3; ++i) {
			Arrays.fill(top[i], "w");
		}
		
		
		bottom = new String[3][3];
		for(int i=0; i<3; ++i) {
			Arrays.fill(bottom[i], "y");
		}
		
		front = new String[3][3];
		for(int i=0; i<3; ++i) {
			Arrays.fill(front[i], "r");
		}
		
		back = new String[3][3];
		for(int i=0; i<3; ++i) {
			Arrays.fill(back[i], "o");
		}
		
		left = new String[3][3];
		for(int i=0; i<3; ++i) {
			Arrays.fill(left[i], "g");
		}
		
		right = new String[3][3];
		for(int i=0; i<3; ++i) {
			Arrays.fill(right[i], "b");
		}
	}


	private static void cubing(String command) {
		switch(command) {
		case("U+"):
			uSwap();			
			break;
			
		case("U-"):
			for(int i=0; i<3; ++i) {
				uSwap();
			}
			break;
			
		case("D+"):
			for(int i=0; i<3; ++i) {
				dSwap();
			}			
			break;
			
		case("D-"):
			dSwap();
			break;
			
		case("F+"):
			fSwap();
			break;
		case("F-"):
			for(int i=0; i<3; ++i) {
				fSwap();
			}
			break;
		case("B+"): //시계방향 반시계방향 반대로 착각
			for(int i=0; i<3; ++i) {
				bSwap();
			}			
			break;
		case("B-"):
			bSwap();
			break;
			
		case("L+"):
			for(int i=0; i<3; ++i) {
				lSwap();
			}
			break;
		case("L-"):
			lSwap();
			break;
			
		case("R+"):
			rSwap();
			break;
		case("R-"):
			for(int i=0; i<3; ++i) {
				rSwap();
			}
			break;
		}
	}
	private static void rSwap() {
		tmp = new String[3][3];
		
		tmp[0][2] = front[0][2];
		tmp[1][2] = front[1][2];
		tmp[2][2] = front[2][2];
		
		front[0][2] = bottom[0][2];
		front[1][2] = bottom[1][2];
		front[2][2] = bottom[2][2];		
		
		bottom[0][2] = back[2][2];
		bottom[1][2] = back[1][2];
		bottom[2][2] = back[0][2];
		
		back[2][2] = top[0][2];
		back[1][2] = top[1][2];
		back[0][2] = top[2][2];
		
		top[0][2] = tmp[0][2];
		top[1][2] = tmp[1][2];
		top[2][2] = tmp[2][2];
		//////////////////////////////////////////
		tmp1 = right[0][0];
		tmp2 = right[0][1];
		tmp3 = right[0][2];
		 
        tmp4 = right[1][0];
        tmp5 = right[1][1]; 
        tmp6 = right[1][2];
        
        tmp7 = right[2][0];
        tmp8 = right[2][1];
        tmp9 = right[2][2];

        right[0][0] = tmp7;
        right[1][0] = tmp8;
        right[2][0] = tmp9;
        
        right[0][1] = tmp4;
        right[1][1] = tmp5;
        right[2][1] = tmp6;
        
        right[0][2] = tmp1;
        right[1][2] = tmp2;
        right[2][2] = tmp3;
		
	}


	private static void lSwap() { //반시계
		tmp = new String[3][3];
		
		tmp[0][0] = front[0][0];
		tmp[1][0] = front[1][0];
		tmp[2][0] = front[2][0];
		
		front[0][0] = bottom[0][0];
		front[1][0] = bottom[1][0];
		front[2][0] = bottom[2][0];		
		
		bottom[0][0] = back[2][0];
		bottom[1][0] = back[1][0];
		bottom[2][0] = back[0][0];
		
		back[2][0] = top[0][0];
		back[1][0] = top[1][0];
		back[0][0] = top[2][0];
		
		top[0][0] = tmp[0][0];
		top[1][0] = tmp[1][0];
		top[2][0] = tmp[2][0];
		
		//////////////////////////////////////////
		 tmp1 = left[0][0];
		 tmp2 = left[0][1];
		 tmp3 = left[0][2];
		 
         tmp4 = left[1][0];
         tmp5 = left[1][1]; 
         tmp6 = left[1][2];
         
         tmp7 = left[2][0];
         tmp8 = left[2][1];
         tmp9 = left[2][2];

         left[0][0] = tmp3;
         left[1][0] = tmp2;
         left[2][0] = tmp1;
         
         left[0][1] = tmp6;
         left[1][1] = tmp5;
         left[2][1] = tmp4;
         
         left[0][2] = tmp9;
         left[1][2] = tmp8;
         left[2][2] = tmp7;
	}


	private static void bSwap() { //반시
		tmp = new String[3][3];
		
		tmp[0][2] = right[0][2];
		tmp[1][2] = right[1][2];
		tmp[2][2] = right[2][2];
		
		right[0][2] = top[0][0];
		right[1][2] = top[0][1];
		right[2][2] = top[0][2];		
		
		top[0][0] = left[2][0];
		top[0][1] = left[1][0];
		top[0][2] = left[0][0];
		
		left[2][0] = bottom[2][2];
		left[1][0] = bottom[2][1];
		left[0][0] = bottom[2][0];
		
		bottom[2][2] = tmp[0][2];
		bottom[2][1] = tmp[1][2];
		bottom[2][0] = tmp[2][2];
		//////////////////////////////////////////
		tmp1 = back[0][0];
		tmp2 = back[0][1];
		tmp3 = back[0][2];
		 
        tmp4 = back[1][0];
        tmp5 = back[1][1]; 
        tmp6 = back[1][2];
        
        tmp7 = back[2][0];
        tmp8 = back[2][1];
        tmp9 = back[2][2];

        back[0][0] = tmp7;
        back[1][0] = tmp8;
        back[2][0] = tmp9;
        
        back[0][1] = tmp4;
        back[1][1] = tmp5;
        back[2][1] = tmp6;
        
        back[0][2] = tmp1;
        back[1][2] = tmp2;
        back[2][2] = tmp3;
	}


	private static void fSwap() {
		tmp = new String[3][3];
		
		tmp[0][0] = right[0][0];
		tmp[1][0] = right[1][0];
		tmp[2][0] = right[2][0];
		
		right[0][0] = top[2][0];
		right[1][0] = top[2][1];
		right[2][0] = top[2][2];		
		
		top[2][0] = left[2][2];
		top[2][1] = left[1][2];
		top[2][2] = left[0][2];
		
		left[2][2] = bottom[0][2];
		left[1][2] = bottom[0][1];
		left[0][2] = bottom[0][0];
		
		bottom[0][2] = tmp[0][0];
		bottom[0][1] = tmp[1][0];
		bottom[0][0] = tmp[2][0];
		//////////////////////////////////////////
		 tmp1 = front[0][0];
		 tmp2 = front[0][1];
		 tmp3 = front[0][2];
		 
         tmp4 = front[1][0];
         tmp5 = front[1][1]; 
         tmp6 = front[1][2];
         
         tmp7 = front[2][0];
         tmp8 = front[2][1];
         tmp9 = front[2][2];

         front[0][0] = tmp7;
         front[1][0] = tmp8;
         front[2][0] = tmp9;
         
         front[0][1] = tmp4;
         front[1][1] = tmp5;
         front[2][1] = tmp6;
         
         front[0][2] = tmp1;
         front[1][2] = tmp2;
         front[2][2] = tmp3;
		
	}


	private static void dSwap() { //반시계
		tmp = new String[3][3];
		
		tmp[2][0] = right[2][0];
		tmp[2][1] = right[2][1];
		tmp[2][2] = right[2][2];
		
		right[2][0] = back[2][2];
		right[2][1] = back[2][1];
		right[2][2] = back[2][0];		
		
		back[2][2] = left[2][0];
		back[2][1] = left[2][1];
		back[2][0] = left[2][2];
		
		left[2][0] = front[2][0];
		left[2][1] = front[2][1];
		left[2][2] = front[2][2];
		
		front[2][0] = tmp[2][0];
		front[2][1] = tmp[2][1];
		front[2][2] = tmp[2][2];
		//////////////////////////////
		 tmp1 = bottom[0][0];
		 tmp2 = bottom[0][1];
		 tmp3 = bottom[0][2];
		 
         tmp4 = bottom[1][0];
         tmp5 = bottom[1][1]; 
         tmp6 = bottom[1][2];
         
         tmp7 = bottom[2][0];
         tmp8 = bottom[2][1];
         tmp9 = bottom[2][2];

         bottom[0][0] = tmp3;
         bottom[1][0] = tmp2;
         bottom[2][0] = tmp1;
         
         bottom[0][1] = tmp6;
         bottom[1][1] = tmp5;
         bottom[2][1] = tmp4;
         
         bottom[0][2] = tmp9;
         bottom[1][2] = tmp8;
         bottom[2][2] = tmp7;
	}


	private static void uSwap() {
		tmp = new String[3][3];
		
		tmp[0][0] = right[0][0];
		tmp[0][1] = right[0][1];
		tmp[0][2] = right[0][2];
		
		right[0][0] = back[0][2];
		right[0][1] = back[0][1];
		right[0][2] = back[0][0];		
		
		back[0][2] = left[0][0];
		back[0][1] = left[0][1];
		back[0][0] = left[0][2];
		
		left[0][0] = front[0][0];
		left[0][1] = front[0][1];
		left[0][2] = front[0][2];
		
		front[0][0] = tmp[0][0];
		front[0][1] = tmp[0][1];
		front[0][2] = tmp[0][2];
		/////////////////////////
				
		 tmp1 = top[0][0];
		 tmp2 = top[0][1];
		 tmp3 = top[0][2];
		 
         tmp4 = top[1][0];
         tmp5 = top[1][1]; 
         tmp6 = top[1][2];
         
         tmp7 = top[2][0];
         tmp8 = top[2][1];
         tmp9 = top[2][2];

         top[0][0] = tmp7;
         top[1][0] = tmp8;
         top[2][0] = tmp9;
         
         top[0][1] = tmp4;
         top[1][1] = tmp5;
         top[2][1] = tmp6;
         
         top[0][2] = tmp1;
         top[1][2] = tmp2;
         top[2][2] = tmp3;
		
	}
	

}
