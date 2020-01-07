import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2290_LCDTEST {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int s = Integer.parseInt(split[0]);
		String n = split[1];
		int size = 2*s+3;
		for(int i=0; i<size; ++i) {
			if(i==0) { //상단
				for(int j=0; j<n.length(); ++j) {
					if(n.charAt(j)== '1' || n.charAt(j) == '4') {
						System.out.print(" ");
						for(int k=0; k<s; ++k) {
							System.out.print(" ");
						}
						System.out.print(" ");
						System.out.print(" ");
					}else {
						System.out.print(" ");
						for(int k=0; k<s; ++k) {
							System.out.print("-");
						}
						System.out.print(" ");
						System.out.print(" ");
					}
				}
			}
			else if(0<i && i<size/2) {
				for(int j=0; j<n.length(); ++j) {
					if(n.charAt(j)== '1' || n.charAt(j)=='2' || n.charAt(j)=='3' || n.charAt(j)=='7') {
						for(int k=0; k<s+2; ++k) {
							if(k==(s+2)-1) {
								System.out.print("|");
							}
							else System.out.print(" ");
							
						}
						System.out.print(" ");
					}
					else if(n.charAt(j)=='5' || n.charAt(j)=='6') {
						for(int k=0; k<s+2; ++k) {
							if(k==0) {
								System.out.print("|");
							}
							else System.out.print(" ");
							
						}
						System.out.print(" ");
					}
					else {
						for(int k=0; k<s+2; ++k) {
							if(k==0 || k==(s+2)-1) {
								System.out.print("|");
							}
							else System.out.print(" ");
							
						}
						System.out.print(" ");
					}
				}
				
			}
			else if(i==size/2) {
				for(int j=0; j<n.length(); ++j) {
					if(n.charAt(j)== '1' || n.charAt(j) == '7' || n.charAt(j) == '0') {
						System.out.print(" ");
						for(int k=0; k<s; ++k) {
							System.out.print(" ");
						}
						System.out.print(" ");
						System.out.print(" ");
					}else {
						System.out.print(" ");
						for(int k=0; k<s; ++k) {
							System.out.print("-");
						}
						System.out.print(" ");
						System.out.print(" ");
					}
				}
			}
			else if(size/2 < i && i < size-1) {
				for(int j=0; j<n.length(); ++j) {
					if(n.charAt(j)== '1' || n.charAt(j)=='3' || n.charAt(j)=='4' || n.charAt(j)=='5' || n.charAt(j)=='7'  || n.charAt(j)=='9') {
						for(int k=0; k<s+2; ++k) {
							if(k==(s+2)-1) {
								System.out.print("|");
							}
							else System.out.print(" ");
							
						}
						System.out.print(" ");
					}
					else if(n.charAt(j)=='2') {
						for(int k=0; k<s+2; ++k) {
							if(k==0) {
								System.out.print("|");
							}
							else System.out.print(" ");
							
						}
						System.out.print(" ");
					}
					else {
						for(int k=0; k<s+2; ++k) {
							if(k==0 || k==(s+2)-1) {
								System.out.print("|");
							}
							else System.out.print(" ");
							
						}
						System.out.print(" ");
					}
				}
			}
			else {
				for(int j=0; j<n.length(); ++j) {
					if(n.charAt(j)== '1' || n.charAt(j) == '4'|| n.charAt(j) == '7') {
						System.out.print(" ");
						for(int k=0; k<s; ++k) {
							System.out.print(" ");
						}
						System.out.print(" ");
						System.out.print(" ");
					}else {
						System.out.print(" ");
						for(int k=0; k<s; ++k) {
							System.out.print("-");
						}
						System.out.print(" ");
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

}
