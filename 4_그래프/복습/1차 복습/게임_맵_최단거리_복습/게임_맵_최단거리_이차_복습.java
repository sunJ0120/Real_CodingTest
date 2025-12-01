import java.util.*;
import java.lang.*;

class 게임_맵_최단거리_이차_복습 {
    public static final int[] posX = {0,0,-1,1};
    public static final int[] posY = {-1,1,0,0};

    public class Node{
        int x;
        int y;
        int dist = 1;

        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public boolean isTrueInd(int x, int y, int n, int m){
        return ((0<=x && x<n) && (0<=y && y<m));
    }

    public int bfs(int[][] maps, ArrayDeque<Node> queue, boolean[][] isVisit, int n, int m){
        int x = 0;
        int y = 0;

        Node initNode = new Node(x,y,1);  // 초기
        queue.addLast(initNode);
        isVisit[0][0] = true;

        while(!queue.isEmpty()){
            Node top = queue.pollFirst();
            if(top.x == n-1 && top.y == m-1){
                return top.dist;
            }
            // 네 방향 전부 살펴본다.
            for(int i = 0; i<4; i++){
                int nextX = top.x + posX[i];
                int nextY = top.y + posY[i];

                if(isTrueInd(nextX, nextY, n, m) && maps[nextY][nextX] == 1 && !isVisit[nextY][nextX]){
                    queue.addLast(new Node(nextX, nextY, top.dist+1));
                    isVisit[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        int n = maps[0].length;   // 가로
        int m = maps.length;   // 세로

        boolean[][] isVisit = new boolean[m][n];

        return bfs(maps, queue, isVisit, n, m);
    }

    public static void main(String[] args) {
        이차_복습 sol = new 이차_복습();
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