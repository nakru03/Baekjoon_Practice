import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;


public class BOJ17413 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		boolean flag = false;
		
		s = s.replaceAll("<","@<");
		s = s.replaceAll(">",">@");
		for(int i=0; i<s.length(); ++i) {
			if(s.charAt(i)=='<')
				flag = true;
		}
		
		if(flag) {
			String[] split = s.split("@");
			for(int i=0; i<split.length; ++i) {
	
				if(split[i].contains("<")) {
					System.out.print(split[i]);
				}
				else {
					String[] split2 = split[i].split(" ");
					for(int j=0; j<split2.length; ++j) {
						sb.append(split2[j]);
						if(split2.length>=2) {
							if(j<split2.length-1)
								System.out.print(sb.reverse()+" ");
							else
								System.out.print(sb.reverse());
						}
						else System.out.print(sb.reverse());	
						sb.setLength(0);
					}
					
				}
			}
		}
		else {
			String[] split = s.split("\\s");
			for(int i=0; i<split.length; ++i) {
				sb.append(split[i]);
				System.out.print(sb.reverse() + " ");
				sb.setLength(0);
			}
		}
		
		
		
	}

}
