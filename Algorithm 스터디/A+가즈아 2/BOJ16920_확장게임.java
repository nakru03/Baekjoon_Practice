import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int P;
    static int[] range;
    static char[][] board;
    static int field;

    static final int[] dy = {0,1,0,-1};
    static final int[] dx = {1,0,-1,0};

    static Queue<Castle>[] qlist;
    static Queue<Integer> q;
    
    static int[] castleCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("\\s");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        P = Integer.parseInt(s[2]);

        field = N*M;
        
        board = new char[N][M];
        
        s = br.readLine().split("\\s");
        range = new int[s.length];
        for(int i=0; i<s.length; ++i) {
            range[i] = Integer.parseInt(s[i]);
        }

        qlist = new Queue[P+1];
        castleCount = new int[P+1];
        for(int i=1; i<P+1; ++i) {
            qlist[i] = new LinkedList<Castle>();
        }
        
        for(int y=0; y<N; ++y) {
            board[y] = br.readLine().toCharArray();
            for(int x=0; x<M; ++x) {
                if(Character.isDigit(board[y][x])){
                    qlist[board[y][x]-'0'].offer(new Castle(y,x));
                    castleCount[board[y][x]-'0']++;
                    field--;
                }
            }
        }
        
        bfs();

        for(int i=1; i<castleCount.length; ++i) {
        	System.out.print(castleCount[i]+" ");
        }
    }

    private static void bfs() {
        while(true) {
            if(field==0) break;
            if(checkQ()) break;
            for(int i=1; i<P+1; ++i) { //qlist순회
            	
            	for(int r = 0; r<range[i-1]; ++r) {
            		
            		int nowSize = qlist[i].size(); //현재사이즈만큼 순회
            		if(nowSize==0) break;
            		
            		while(nowSize-- > 0){ //q사이즈 만큼순회
            			
                		Castle curr = qlist[i].poll();
                		
                		for(int dir=0; dir<4; ++dir) {
                			int ny = curr.y + dy[dir];
                			int nx = curr.x + dx[dir];
                			
                			if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
                			if(board[ny][nx]!='.') continue;
                			
                			qlist[i].offer(new Castle(ny, nx));
							board[ny][nx] = (char)(i+'0');
							castleCount[i]++;
							field--;
                		}
                	}
            	}       	
            	
            }
        }
    }
    static boolean checkQ() {
    	boolean flag = true;
    	for(int i=1; i<P+1; ++i) {
    		if(!qlist[i].isEmpty()) flag = false; 
    	}
		return flag;    	
    }
    static String print() {
    	String temp = "";
    	for(int y=0; y<N; ++y) {
    		for(int x=0; x<M; ++x) {
    			temp += board[y][x];
    		}
    		temp+="\n";
    	}
    	
    	return temp;
    }
    static class Castle {
        int y;
        int x;
        public Castle(int y, int x) {
            super();

            this.y = y;
            this.x = x;
        }       
    }
}