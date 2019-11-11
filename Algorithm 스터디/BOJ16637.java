import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16637 {
    static int N;
    static ArrayList<Integer> operand;
    static ArrayList<String> operator;
    static boolean[] permVisited;
    static final int INF = Integer.MIN_VALUE;
    static int pickSize;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        operand = new ArrayList<>();
        operator = new ArrayList<>();

        String[] s = br.readLine().split("");
        for(int i=0; i<s.length; ++i) {
            if(i%2==1) {
                operator.add("0");
                operator.add(s[i]);
            }else {
                operand.add(Integer.parseInt(s[i]));
                operand.add(INF);
            }
        }       
        pickSize = operator.size();
        permVisited = new boolean[pickSize];
        doPerm(0);
        System.out.println(answer);

    }
    static ArrayList<Integer> res = new ArrayList<>();
    private static void doPerm(int depth) {
        if(depth == pickSize) {
            System.out.println(res);
            int tmp = doCalc();
            answer = Math.max(answer, tmp);
            return;
        }
        for(int i=1; i<pickSize; i+=2) {
            if(permVisited[i]) continue;
            permVisited[i] = true;
            res.add(i);
            doPerm(depth+2);
            permVisited[i] = false;
            res.remove(res.size()-1);
        }
    }
    private static int doCalc() {
        ArrayList<Integer> tmp = (ArrayList<Integer>) operand.clone();
        boolean[] checker = new boolean[tmp.size()];
        int cache = 0;
        int back = 0;
        Queue<String> q = new LinkedList<>();
        
        for(int i=0; i<res.size(); ++i) {
        	
            switch(operator.get(res.get(i))) {
            case "+" :
                cache = tmp.get(res.get(i)-1) + tmp.get(res.get(i)+1);
                tmp.set(res.get(i)-1,cache);
                tmp.set(res.get(i)+1,cache);
                break;
            case "-" :
                cache = tmp.get(res.get(i)-1) - tmp.get(res.get(i)+1);
                tmp.set(res.get(i)-1,cache);
                tmp.set(res.get(i)+1,cache);
                break;
            case "*" :
                cache = tmp.get(res.get(i)-1) * tmp.get(res.get(i)+1);
                tmp.set(res.get(i)-1,cache);
                tmp.set(res.get(i)+1,cache);
                break;
            }
        }
        return Collections.max(tmp);
    }

}
