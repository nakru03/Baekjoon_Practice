import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 17825
 * 주사위 윷놀이
 * 시뮬레이션.
 * @author nakru03
 *
 */
public class Main {
   //                  시작        1     2    3     4    5       6    7   8    9        10      
   static int[] board0 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40}; //22개   
   static int[] board1 = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40 };
   static int[] board2 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40 };
   static int[] board3 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40 };
   
   static int[] dice = new int[10];
   static Info[] save = new Info[4];
   
   static int answer = Integer.MIN_VALUE;
   public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i=0; i<10; ++i) {
         dice[i] = Integer.parseInt(st.nextToken());
      }
      
      
      dfs(0); //중복순열 0 1 2 3 의 말 이동 순서를 뽑음
      
      System.out.println(answer);
   }
   static ArrayList<Integer> seq = new ArrayList<>();
   private static void dfs(int depth) {
      
      if(depth == 10) {
        
         answer = Math.max(answer, move());
         return;
      }
      for(int i=0; i<4; ++i) {
         seq.add(i);
         dfs(depth+1);
         seq.remove(seq.size()-1);
      }
   }
   private static int move() {
	   
	  for(int i=0; i<4; ++i) {
           save[i] = new Info(0,0);
       }

      int res = 0;
      
      
	  for(int t=0; t<10; ++t) {
		  Info curr = save[seq.get(t)];
		  int nextindex = curr.index + dice[t];	      
	      int nextboard = curr.boardnum;
	      
	      
	      if(nextboard==0 && nextindex==5) {
	    	  nextboard = 1;
	      }
	      else if(nextboard==0 && nextindex==10) {
	    	  nextboard = 2;
	      }
	      else if(nextboard==0 && nextindex==15) {
	    	  nextboard = 3;
	      }
	      
	      curr.boardnum = nextboard;
	      curr.index = nextindex;
	      
	      boolean flag = false;
	      
	      for(int i=0; i<4; ++i) {
	    	  if(seq.get(t)==i) continue;
	    	  
	    	  if(save[i].boardnum==nextboard && save[i].index==nextindex) {
	    		  flag = true;
	    		  break;
	    	  }
	    	  //25번
	    	  else if((nextboard==1 && nextindex==9) || (nextboard==2 && nextindex == 13) || (nextboard==3 && nextindex==19)) {
	    		  
	    		  if(save[i].boardnum==1 && save[i].index==9) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==2 && save[i].index == 13) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==3 && save[i].index == 19) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  
	    	  }
	    	  //30번
	    	  else if((nextboard==1 && nextindex==10) || (nextboard==2 && nextindex == 14) || (nextboard==3 && nextindex==20)) {
	    		  
	    		  if(save[i].boardnum==1 && save[i].index==10) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==2 && save[i].index == 14) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==3 && save[i].index == 20) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  
	    	  }
	    	  
	    	  //35번
	    	  
	    	  else if((nextboard==1 && nextindex==11) || (nextboard==2 && nextindex == 15) || (nextboard==3 && nextindex==21)) {
	    		  
	    		  if(save[i].boardnum==1 && save[i].index==11) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==2 && save[i].index == 15) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==3 && save[i].index == 21) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  
	    	  }
	    	  //40번
	    	  else if((nextboard==1 && nextindex==12) || (nextboard==2 && nextindex == 16) || (nextboard==3 && nextindex==22) || (nextboard==0 && nextindex==20)) {
	    		  
	    		  if(save[i].boardnum==1 && save[i].index==12) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==2 && save[i].index == 16) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==3 && save[i].index == 22) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  else if(save[i].boardnum==0 && save[i].index==20) {
	    			  flag = true;
		    		  break;
	    		  }
	    		  
	    	  }    	  
	    	  
	      }
	      
	      if(flag) {
	    	  return Integer.MIN_VALUE;
	      }
	      if(nextboard == 0 && nextindex < board0.length) {
	    	  res += board0[nextindex];
	      }
	      
	      else if(nextboard == 1 && nextindex < board1.length) {
	    	  res += board1[nextindex];
	      }
	     
	      else if(nextboard == 2 && nextindex < board2.length) {
	    	  res += board2[nextindex];
	      }
	     
	      else if(nextboard == 3 && nextindex < board3.length) {
	    	  res += board3[nextindex];
	      }
	     
	  }
      return res;
   }
   

static class Info{
      int boardnum;
      int index;
      
      public Info(int boardnum, int index) {
         super();
         this.boardnum = boardnum;
         this.index = index;
      }      
   }
}
