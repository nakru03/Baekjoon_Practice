import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 세로 가로
    static char board[][];
    static int T; //던지는 횟수
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};

    static boolean[][] visited;
    static ArrayList<Pair> list = new ArrayList<>(); //클러스터 리스트
    static Queue<Pair> q = new LinkedList<>(); // BFS Q

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String[] s = br.readLine().split("\\s");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        board = new char[N][M];

        for(int y=0; y<N; ++y) {
            board[y] = br.readLine().toCharArray();
        }

        T = Integer.parseInt(br.readLine()); 

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; ++i) { //짝수면 left 홀수 right
            if(i%2==0)
                throwing(N-Integer.parseInt(st.nextToken()),1);//1은 레프트 -1은 라이트
            else
                throwing(N-Integer.parseInt(st.nextToken()),-1);
        }
        for(int y=0; y<N; ++y) {
            for(int x=0; x<M; ++x) {
                sb.append(board[y][x]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void throwing(int line, int side) {
        if(side == 1) {
            for(int x=0; x<M; ++x) {
                if(board[line][x]=='x') {
                    board[line][x] = '.';
                    if(clustercheck()) {
                        falling();
                    }                   
                    break;
                }
            }
        }else {
            for(int x=M-1; x>=0; --x) {
                if(board[line][x]=='x') {
                    board[line][x] = '.';
                    if(clustercheck()) {
                        falling();
                    }
                    break;
                }
            }
        }
    }

    private static void falling() {
        boolean flag = false;
        while(true) {
            if(flag) break;
            for(Pair curr : list) {
            	if(curr.y+2>=N) flag = true;
                if(curr.y+2<N && visited[curr.y+2][curr.x]) flag = true;
                board[curr.y][curr.x] = '.';
                curr.y++;
                board[curr.y][curr.x] = 'x';
            }
        }

    }
    private static boolean clustercheck() {
        visited = new boolean[N][M];
        for(int x=0; x<M; ++x) {
            if(visited[N-1][x] || board[N-1][x]=='.') continue;
            bfs(N-1,x);
        }
        list.clear();
        for(int y=N-2; y>=0; --y) {
            for(int x=M-1; x>=0; --x) {
                if(!visited[y][x]&&board[y][x]=='x') {
                    list.add(new Pair(y,x));
                }
            }
        }
        if(list.isEmpty()) return false;
        else return true;
    }

    private static void bfs(int sy, int sx) {
        q.clear();
        visited[sy][sx] = true;
        q.offer(new Pair(sy,sx));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            for(int dir=0; dir<4; ++dir) {
                int ny = curr.y + dy[dir];
                int nx = curr.x + dx[dir];

                if(ny<0 || nx<0|| ny>=N || nx>=M) continue;
                if(visited[ny][nx] || board[ny][nx] == '.') continue;

                visited[ny][nx] = true;
                q.offer(new Pair(ny, nx));
            }

        }
    }

    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pair [y=" + y + ", x=" + x + "]";
        }

    }
}