import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static char[][] board;
    static boolean[][][] visited;
    static Pos start;
    static final int[] dy = {0,1,0,-1};
    static final int[] dx = {1,0,-1,0};
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][1<<6];
        for(int y=0; y<N; ++y) {
            board[y] = br.readLine().toCharArray();
            for(int x=0; x<M; ++x) {
                if(board[y][x]=='0') start = new Pos(y,x,0,0);
            }
        }

        bfs(start);
        System.out.println(answer);
    }

    private static void bfs(Pos start) {
        Queue<Pos> q = new LinkedList<>();
        visited[start.y][start.x][start.key] = true;
        q.offer(start);
        int ny, nx, nkey, gate;

        while(!q.isEmpty()) {

            Pos curr = q.poll();
            if(board[curr.y][curr.x]=='1') {
                answer = curr.dist;
                return;
            }
            for(int dir=0; dir<4; ++dir) {
                ny = curr.y + dy[dir];
                nx = curr.x + dx[dir];

                if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
                if(visited[ny][nx][curr.key] || board[ny][nx]=='#') continue;

                if(Character.isLowerCase(board[ny][nx])) { // 열쇠일때
                    nkey = curr.key | (1<<(board[ny][nx]-'a'));
                    visited[ny][nx][nkey] = true;
                    q.offer(new Pos(ny,nx,nkey,curr.dist+1));
                }
                else if(Character.isUpperCase(board[ny][nx])) {
                	gate = 1<<(board[ny][nx]-'A');
                	if((curr.key & gate) == gate) {
                		visited[ny][nx][curr.key] = true;
                		q.offer(new Pos(ny,nx,curr.key,curr.dist+1));
                	}
                }
                else {
                	visited[ny][nx][curr.key] = true;
            		q.offer(new Pos(ny,nx,curr.key,curr.dist+1));
                }
            }
        }

    }

    static class Pos{
        int y;
        int x;
        int key;
        int dist;
        public Pos(int y, int x, int key, int dist) {
            super();
            this.y = y;
            this.x = x;
            this.key = key;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Pos [y=" + y + ", x=" + x + ", key=" + key + "]";
        }

    }
}