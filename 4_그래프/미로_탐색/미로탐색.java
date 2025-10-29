import java.util.*;
import java.lang.*;
import java.io.*;

class 미로탐색 {
    // 0. x, y, dist를 가진 Node를 생성한다.
    class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public final static int[] posX = {0,0,-1,1};  // 상, 하, 좌, 우
    public final static int[] posY = {-1,1,0,0};

    public int solution(char[][] maps, int n, int m){
        // 1. isVisit를 생성한다.
        boolean[][] isVisit = new boolean[n][m];
        // 2. 최소 거리 이므로 BFS를 위한 큐를 생성한다.
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node firstNode = new Node(0,0,1);
        queue.addLast(firstNode);
        isVisit[0][0] = true;
        // 3. TOP에 있는 X,Y를 4방향으로 이동하면서
        while(!queue.isEmpty()){
            Node top = queue.pollFirst();
            int topX = top.x;
            int topY = top.y;
            int topDist = top.dist;
            // 7. x = n-1, y = m-1이면 끝내고, dist를 출력한다.
            if(topX == m-1 && topY == n-1){
                return topDist;
            }

            for(int i = 0; i<4; i++){
                int moveX = topX + posX[i];
                int moveY = topY + posY[i];
                // 4. 인덱스 범위에 맞는지, isVisit false인지, 1이어서 갈 수 있는지를 본다.
                if(isTrueInd(moveX, moveY, m, n)
                        && maps[moveY][moveX] == '1'
                        && !isVisit[moveY][moveX]){
                    // 5. 큐에 올린다.
                    queue.addLast(new Node(moveX, moveY, topDist+1));
                    // 6. isVisit true라고 표시한다.
                    isVisit[moveY][moveX] = true;
                }
            }
        }
        return 0;
    }

    public boolean isTrueInd(int x, int y, int m, int n){
        if((0 <=x && x<m )&&( 0<=y && y<n )){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // y
        int m = Integer.parseInt(st.nextToken());   // x

        char[][] maps = new char[n][m];

        for(int i = 0; i<n; i++){
            maps[i] = br.readLine().toCharArray();
        }

        미로탐색 sol = new 미로탐색();
        System.out.println(sol.solution(maps, n, m));
    }
}