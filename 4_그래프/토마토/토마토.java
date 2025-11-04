import java.io.*;
import java.lang.*;
import java.util.*;

public class 토마토{
    public static int m;
    public static int n;
    public static final int[] posX = {0,0,-1,1};
    public static final int[] posY = {-1,1,0,0};

    public boolean isTrueInd(int x, int y){
        if((0<=x && x<m) && (0<=y && y<n)){
            return true;
        }
        return false;
    }

    public void addQueue(ArrayDeque<int[]> queue, boolean[][] isVisit, int x, int y, int depth){
        int[] pos = new int[3];
        pos[0] = x;
        pos[1] = y;
        pos[2] = depth;
        queue.addLast(pos);
        isVisit[y][x] = true;
    }

    public int bfs(ArrayDeque<int[]> queue, boolean[][] isVisit, String[][] tomatos){
        int depth = 0;

        // 3. 큐가 비었다면 더 갈곳 없는거라 끝낸다.
        while(!queue.isEmpty()){
            int[] top = queue.pollFirst();
            int topDepth = top[2];
            depth = Math.max(topDepth,depth);  // 밖에서 depth 갱신

            // 2. 큐에 있는거 4방향을 체크해서 올린다.
            for(int i = 0; i<4; i++){
                int nextX = top[0] + posX[i];
                int nextY = top[1] + posY[i];

                if(isTrueInd(nextX, nextY)
                        && !isVisit[nextY][nextX]
                        && !("-1".equals(tomatos[nextY][nextX]))){
                    addQueue(queue, isVisit, nextX, nextY,topDepth+1);
                    tomatos[nextY][nextX] = "1";    // 🍅 익음
                }
            }
        }
        return depth;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   //가로
        n = Integer.parseInt(st.nextToken());   //세로

        String[][] tomatos = new String[n][m];
        boolean[][] isVisit = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();    // bfs

        for(int i = 0; i<n; i++){
            tomatos[i] = br.readLine().split(" ");
        }

        토마토 sol = new 토마토();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                // 1. isVisit 하지 않고, 1이면 큐에 올린다.
                if(!isVisit[i][j] && "1".equals(tomatos[i][j])){
                    sol.addQueue(queue, isVisit, j, i, 0);
                }
            }
        }

        int ans = sol.bfs(queue, isVisit, tomatos);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                // 4. 0이 있으면 return -1, 아니면 ans 내보낸다.
                if("0".equals(tomatos[i][j])){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}