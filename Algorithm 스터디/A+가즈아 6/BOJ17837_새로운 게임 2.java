import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 백준 17837
 * 새로운게임2
 * 시뮬레이션
 * 삼성 2019 하반기 공채 오전 2번
 * 
 * @author Nakru
 *
 */
public class Main {
   
   static int N;
   static int K;
   static int[][] board;
   static ArrayList<Piece>[][] mboard;
   static ArrayList<Piece> process;
   
   static int maxLength;
   
   static final int[] dy = {0,0,-1,1};
   static final int[] dx = {1,-1,0,0};
   
   public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = null;
      
      st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      
      board = new int[N][N];
      
      for(int y=0; y<N; ++y) {
         st = new StringTokenizer(br.readLine());
         for(int x=0; x<N; ++x) {
            board[y][x] = Integer.parseInt(st.nextToken());
         }
      }
      
      
      mboard = new ArrayList[N][N];
      process = new ArrayList<>();
      
      for(int y=0; y<N; ++y) {
         for(int x=0; x<N; ++x) {
            mboard[y][x] = new ArrayList<>();
         }
      }
      
      for(int i=0; i<K; ++i) {
         st = new StringTokenizer(br.readLine());
         
         int y = Integer.parseInt(st.nextToken())-1;
         int x = Integer.parseInt(st.nextToken())-1;
         int dir = Integer.parseInt(st.nextToken())-1;
         
         Piece tmp = new Piece(y,x,dir,i);
         mboard[y][x].add(tmp);
         process.add(tmp);
      }
      
      maxLength = 1;
      int turn = 0;
      
      while(maxLength < 4 && turn<=1000) {
         
         turn++;
                  
         for(int i=0; i<process.size(); ++i) {
            
            Piece curr = process.get(i); //현재원소
            
            
            int ny = curr.y + dy[curr.dir];
            int nx = curr.x + dx[curr.dir];
            
            if(ny < 0 || nx < 0 || ny>=N || nx>=N || board[ny][nx]==2) {
               
               int ndir;
               if(curr.dir==0 || curr.dir==1) {
                  ndir = (curr.dir+1) % 2;
               }
               else {
            	  ndir = ((curr.dir-1) % 2)+2;
               }
               
               int nny = curr.y + dy[ndir];
               int nnx = curr.x + dx[ndir];
               if(nny < 0 || nnx < 0 || nny>=N || nnx>=N || board[nny][nnx]==2) {
                  curr.dir = ndir;
                  continue;
               }
               else {
            	   curr.dir = ndir;
            	   ny = nny;
                   nx = nnx;
               }
            } //파란색이거나 out of bound 일때
            
            if(board[ny][nx]==1) {
               
               boolean flag = false;
              Iterator<Piece> it = mboard[curr.y][curr.x].iterator();
              Stack<Piece> s = new Stack<>();
              while(it.hasNext()) {
                 Piece currIt = it.next();
                 if(currIt.num == curr.num) flag = true;
                 if(flag) {
                    curr.y = ny;
                      curr.x = nx;
                      currIt.y = ny;
                      currIt.x = nx;
                      s.add(currIt);
                      it.remove();
                 }
              }
              
              while(!s.isEmpty()) {
                 mboard[ny][nx].add(s.pop());
              }
              maxLength = Math.max(maxLength, mboard[ny][nx].size());
               
            }
            
            if(board[ny][nx]==0) {
               boolean flag = false;
              Iterator<Piece> it = mboard[curr.y][curr.x].iterator();
              while(it.hasNext()) {
                 Piece currIt = it.next();
                 if(currIt.num == curr.num) flag = true;
                 if(flag) {
                    curr.y = ny;
                      curr.x = nx;
                      currIt.y = ny;
                      currIt.x = nx;
                      mboard[ny][nx].add(currIt);
                      it.remove();
                 }
              }
              maxLength = Math.max(maxLength, mboard[ny][nx].size());
            }
            
         }
      }
      System.out.println(turn == 1001 ? -1 : turn);
   }
   
   static class Piece{
      
      int y;
      int x;
      int dir;
      int num;
      public Piece(int y, int x, int dir, int num) {
         super();
         this.y = y;
         this.x = x;
         this.dir = dir;
         this.num = num;
      }
   @Override
   public String toString() {
      return num+"";
   }
      
   }
}