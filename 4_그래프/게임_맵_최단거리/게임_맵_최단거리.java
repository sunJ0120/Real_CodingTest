
import java.util.*;
import java.lang.*;

class 게임_맵_최단거리 {
    public final static int[] xInd = {0,0,1,-1};
    public final static int[] yInd = {1,-1,0,0};

    class Node{
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public void init(ArrayDeque<Node> queue, boolean[][] isVisit){
        queue.addLast(new Node(0,0,1));
        isVisit[0][0] = true;
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int m = maps.length;   // y
        int n = maps[0].length;    // x
        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[][] isVisit = new boolean[m][n];

        // 1. 0,0에서 출발한다.
        init(queue, isVisit);
        // 4. queue가 비었는데 answer가 0이면 -1
        return bfs(queue, isVisit, n, m, maps);
    }

    public int bfs(ArrayDeque<Node> queue, boolean[][] isVisit, int n, int m, int[][] maps){
        while(!queue.isEmpty()){
            Node top = queue.pollFirst();
            // 3. n,m에 도달하면 dist를 출력한다.
            if(top.x == n-1 && top.y == m-1){
                return top.dist;
            }
            for(int i = 0; i<4; i++){
                int newX = top.x + xInd[i];
                int newY = top.y + yInd[i];
                // 2. x,y 보면서 갈 수 있는 곳(1) 이면 간다.
                if(isTrueIndex(n, m, newX, newY) && maps[newY][newX] == 1 && !isVisit[newY][newX]){
                    queue.addLast(new Node(newX,newY,top.dist+1));    // 거리 하나 증가
                    isVisit[newY][newX] = true;
                }
            }
        }
        return -1;
    }

    public boolean isTrueIndex(int n, int m, int x, int y){
        if((x>=0 && x<n) && (y>=0 && y<m)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        게임_맵_최단거리 sol = new 게임_맵_최단거리();
        int[][] task = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(sol.solution(task));
    }
}