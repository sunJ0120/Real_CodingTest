import java.util.*;
import java.lang.*;

class 미로탈출 {
    class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        Node(int x, int y){
            this(x,y,0);
        }
    }
    // 상 하 좌 우
    // 4. 4가지 방향 (상하좌우) 설정한다.
    public static final int[] posX = {0,0,-1,1};
    public static final int[] posY = {-1,1,0,0};

    public int solution(String[] maps) {
        int answer = 0;

        int n = maps[0].length(); //x
        int m = maps.length; //y

        char[][] mapsToChar = new char[m][n];

        for(int i = 0; i<m; i++){
            mapsToChar[i] = maps[i].toCharArray();
        }

        int sToL = bfs(mapsToChar, n, m,'S','L');
        int lToE = bfs(mapsToChar, n, m,'L','E');
        if(sToL == -1 || lToE == -1){
            return -1;
        }

        return sToL + lToE;
    }

    // start 찾는 method
    public Node makeStartNode(char start, char[][] mapsToChar, int n, int m){
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mapsToChar[i][j] == start){
                    return new Node(j,i);
                }
            }
        }
        return null;
    }

    // 3. S > L && L > E 구한다.
    public int bfs(
            char[][] mapsToChar,
            int n, int m,
            char start, char end)
    {
        // 1. 최단거리 이므로, 큐를 사용하기 위해 BFS 개념을 활용한다.
        ArrayDeque<Node> queue = new ArrayDeque<Node>();

        // 2. isVisit를 생성해서 체크한다.
        boolean[][] isVisit = new boolean[m][n];
        Node startNode = makeStartNode(start, mapsToChar, n, m);
        queue.addLast(startNode);
        isVisit[startNode.y][startNode.x] = true;

        // 5. pop해서 isVisit 체크하고 값을 저장한다.
        while(!queue.isEmpty()){
            Node top = queue.pollFirst();
            int topX = top.x;
            int topY = top.y;
            int dist = top.dist;
            // 8. end에 해당하면 dist return 한다.
            if(mapsToChar[topY][topX] == end){
                return dist;
            }
            // 6. 상하좌우로 이동한 값을 전부 큐에 넣는다.
            for(int i = 0; i<4; i++){
                // 7. 이때, 인덱스의 값이 유효한지 & X가 아닌지, isVisit 한적 없는지 체크한다.
                int nextX = topX + posX[i];
                int nextY = topY + posY[i];
                if(isTrueInd(nextX, nextY, n, m)
                        && !isVisit[nextY][nextX] && mapsToChar[nextY][nextX] != 'X'){
                    queue.addLast(new Node(nextX, nextY, dist+1));
                    isVisit[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }
    public boolean isTrueInd(int nextX, int nextY, int n, int m){
        if((0<= nextX && nextX < n) && (0 <= nextY && nextY < m)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        미로탈출 sol = new 미로탈출();
        int ans = sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
        System.out.println(ans);
    }
}