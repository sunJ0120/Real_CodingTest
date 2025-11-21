import java.lang.*;
import java.util.*;

class 일차_복습 {
    static class Node{
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static final int[] posX = {0,0,-1,1};
    public static final int[] posY = {-1,1,0,0};

    public boolean isTrueInd(int x, int y, int m, int n) {
        if((0 <= x && x < m) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }

    public void addQueue(boolean[][] isVisit, ArrayDeque<Node> queue, int x, int y, int depth){
        Node node = new Node(x, y, depth);
        queue.addLast(node);
        isVisit[y][x] = true;
    }

    public int bfs(int[][] maps, int m, int n){
        // 1. 우선 isVisit를 만들어서 방문을 체크한다.
        boolean[][] isVisit = new boolean[n][m];
        // 2. ArrayDeque를 만들어서 넣는다.
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        addQueue(isVisit, queue, 0, 0, 1);

        while(!queue.isEmpty()){
            // 3. top에서 for로 4방향을 돌면서 체크한다.
            Node top = queue.pollFirst();

            // 5. x,y가 m,n과 같아지면 depth를 내보낸다.
            if(top.x == m-1 && top.y == n-1){
                return top.depth;
            }

            for(int i = 0; i<4; i++){
                int nextX = top.x + posX[i];
                int nextY = top.y + posY[i];
                if(isTrueInd(nextX, nextY, m, n) && !isVisit[nextY][nextX] && maps[nextY][nextX] == 1){
                    // 4. ArrayDeque에 x, y, 넣으면서 depth를 늘린다.
                    addQueue(isVisit, queue, nextX, nextY, top.depth+1);
                }
            }
        }
        return -1;  // 못감
    }

    public int solution(int[][] maps) {
        int m = maps[0].length;
        int n = maps.length;

        return bfs(maps, m, n);
    }

    public static void main(String[] args) {
        일차_복습 sol = new 일차_복습();
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(sol.solution(maps));  // 11
    }
}