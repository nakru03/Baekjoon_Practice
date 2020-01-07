

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][][] cube = new int[5][5][5];
    static int[][][] copyCube = new int[5][5][5];
    static boolean[] visited = new boolean[5];
    static boolean[][][] bfsVisited;

    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int z=0; z<5; ++z) {
            for(int y=0; y<5; ++y) {
                String[] s = br.readLine().split("\\s");
                for(int x=0; x<5; ++x) {
                    cube[z][y][x] = Integer.parseInt(s[x]);
                }
            }
        }
        stacking(0); //판을 쌓는 순열
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }

    static ArrayList<Integer> list = new ArrayList<>(); //쌓을 순서를 저장

    private static void stacking(int depth) {
        if(depth == 5) {
            doPerm(0);
            return;
        }
        for(int i=0; i<5; ++i) {
            if(visited[i]) continue;
            list.add(i);
            visited[i] = true;
            stacking(depth+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

    static ArrayList<Integer> sList = new ArrayList<>();

    private static void doPerm(int depth) { //각판의 회전 횟수를 정함
        if(depth == 5) {
            shuffle();
            if(copyCube[0][0][0]==1 && copyCube[4][4][4]==1) { //체크 필수!!!
            	int tmp = bfs();
                if(tmp!=-1) answer = Math.min(answer, tmp);
            }
            
            return;
        }
        for(int i=0; i<4; ++i) {
            sList.add(i);
            doPerm(depth+1);
            sList.remove(sList.size()-1);
        }
    }

    private static void shuffle() { //회전
        for(int z=0; z<list.size(); ++z) {
            for(int y=0; y<5; ++y) {
                for(int x=0; x<5; ++x) {

                    switch(sList.get(z)) {
                    case 0:
                        copyCube[z][x][4-y] = cube[list.get(z)][y][x];
                        break;
                    case 1:
                        copyCube[z][4-y][4-x] = cube[list.get(z)][y][x];
                        break;
                    case 2:
                        copyCube[z][4-x][y] = cube[list.get(z)][y][x];
                        break;
                    case 3:
                        copyCube[z][y][x] = cube[list.get(z)][y][x];
                        break;
                    }

                }
            }

        }
    }

    private static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        bfsVisited = new boolean[5][5][5];
        q.offer(new Pos(0,0,0,0));
        bfsVisited[0][0][0] = true;
        while(!q.isEmpty()) {
            Pos curr = q.poll();

            if(curr.x == 4 && curr.y == 4 && curr.z==4) {
                return curr.count;
            }

            for(int dir=0; dir<6; ++dir) {
                int nx = curr.x+dx[dir];
                int ny = curr.y+dy[dir];
                int nz = curr.z+dz[dir];
                if(nx<0 || ny<0 || nz<0 || nx>=5 || ny>=5 || nz>=5) continue;
                if(bfsVisited[nz][ny][nx] || copyCube[nz][ny][nx]==0) continue;
                bfsVisited[nz][ny][nx] = true;
                q.offer(new Pos(nz,ny,nx,curr.count+1));
            }
        }

        return -1;
    }

    static void print() {
        for(int z=0; z<5; ++z) {
            for(int y=0; y<5; ++y) {
                for(int x=0; x<5; ++x) {
                    System.out.print(copyCube[z][y][x]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static class Pos{
        int z;
        int y;
        int x;
        int count;
        public Pos(int z, int y, int x, int count) {
            super();
            this.z = z;
            this.y = y;
            this.x = x;
            this.count = count;

        }

    }
}