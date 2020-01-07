import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int K;
    static int[][] board;
    static int[] KH = new int[20];
    static int[] MH = new int[20];
    static ArrayList<Integer> JW  = new ArrayList<>();
    static int[] winning = new int[3];
    static boolean[] visited;
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("\\s");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        board = new int[N][N];
        visited = new boolean[N];

        for(int y=0; y<N; ++y) {
            s = br.readLine().split("\\s");
            for(int x=0; x<N; ++x) {
                board[y][x] = Integer.parseInt(s[x]);
            }
        }

        s = br.readLine().split("\\s");
        String[] s1 = br.readLine().split("\\s");
        for(int i=0; i<20; ++i) {
            KH[i] = Integer.parseInt(s[i])-1;
            MH[i] = Integer.parseInt(s1[i])-1;
        }

        doPerm(0);
        System.out.println(answer);

    }
    static int answer;
    private static void doPerm(int depth) {
        if(depth == N) {
            answer = doGame();
            if(answer == 1) {
            	System.out.println(1);
            	System.exit(0);
            }
            
            //init
            for(int i=0; i<3; ++i) {
            	winning[i] = 0;
            }
            return;
        }
        for(int i=0; i<N; ++i) {
            if(visited[i]) continue;
            visited[i] = true;
            JW.add(i);
            doPerm(depth+1);
            JW.remove(JW.size()-1);
            visited[i] = false;
        }
    }
    //지우가 내야할 가위바위보 순열.. 
    //생각 해야 할점 : 무승부면 순서가 뒤사람이 이긴걸로침.. 지우는 모든 가위바위보 수를 하나씩 다냄 다내서 더이상 낼것이 없으면 0출력

    private static int doGame() {
        int JWOrder = 0;
        int KHOrder = 1;
        int MHOrder = 2;
        Queue<Integer> q  = new LinkedList<>();
        
        int idx = 0;
        int idx_K=0;
        int idx_M = 0;
        q.offer(JWOrder);
        q.offer(KHOrder);
        q.offer(MHOrder);

        while(true) {
        	if(idx>=N) break; //가위바위보 X인경우
            
            if(winning[0]==K ||winning[1]==K||winning[2]==K) break;

            int firstP = q.poll();
            int secondP = q.poll();
            int notP = q.poll();
            
            int res = 0;
            
            //3명이서 가위바위보 하는 경우
            
            // 지우 경희
            if(firstP == JWOrder && secondP == KHOrder) {
            	res = board[JW.get(idx++)][KH[idx_K++]];
            }
            else if(firstP==KHOrder && secondP==JWOrder) {
            	res = board[KH[idx_K++]][JW.get(idx++)];
            }
            //지우 민호
            else if(firstP==JWOrder && secondP==MHOrder) {
            	res = board[JW.get(idx++)][MH[idx_M++]];
            }
            else if(firstP==MHOrder && secondP==JWOrder) {
            	res = board[MH[idx_M++]][JW.get(idx++)];
            }
            //경희 민호
            else if(firstP==KHOrder && secondP==MHOrder) {
            	res = board[KH[idx_K++]][MH[idx_M++]];
            }
            else {
            	res = board[MH[idx_M++]][KH[idx_K++]];
            }
            
            //승무패 판단
            switch(res) {
            case 0:
            	winning[secondP]++;
            	q.offer(secondP);
            	q.offer(notP);
            	q.offer(firstP);
            	break;
            case 1:
            	if(firstP<secondP) {
            		winning[secondP]++;
                	q.offer(secondP);
                	q.offer(notP);
                	q.offer(firstP);
            	}
            	else {
            		winning[firstP]++;
            		q.offer(firstP);
            		q.offer(notP);
            		q.offer(secondP);
            	}
            	break;
            case 2:
            	winning[firstP]++;
        		q.offer(firstP);
        		q.offer(notP);
        		q.offer(secondP);
        		break;
            }
           
        }
        if(winning[0]==K) return 1;
        else return 0;

    }

}