import java.util.*;
import java.lang.*;
import java.io.*;

public class 숨바꼭질 {
    public static final int maxMove = 100000;

    public boolean isTrueRange(int x){
        if(0 <= x && x <= maxMove){
            return true;
        }
        return false;
    }

    public void addQueue(ArrayDeque<int[]> queue, int x, int depth, boolean[] isVisit){
        if(isTrueRange(x) && !isVisit[x]){
            int[] node = {x, depth};
            queue.addLast(node);
            isVisit[x] = true;
        }
    }

    public int bfs(boolean[] isVisit, int n, int k){
        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
        addQueue(queue, n, 0, isVisit);

        while(!queue.isEmpty()){
            int[] top = queue.pollFirst();
            int topX = top[0];
            int topDepth = top[1];
            // 4. top에서 검사해서 k랑 같으면 return 하고 depth 뱉는다.
            if(topX == k){
                return topDepth;
            }
            // 3. 주어진대로 세 번 움직여서 queue에 담기
            addQueue(queue, topX-1, topDepth+1, isVisit);
            addQueue(queue, topX+1, topDepth+1,isVisit);
            addQueue(queue, topX*2, topDepth+1,isVisit);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1. isVisit와 큐 마련
        boolean[] isVisit = new boolean[maxMove+1];
        숨바꼭질 sol = new 숨바꼭질();
        int ans = sol.bfs(isVisit, n, k);

        System.out.println(ans);
    }
}