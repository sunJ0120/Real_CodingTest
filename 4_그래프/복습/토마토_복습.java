import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 토마토_복습 {
    public static final int[] posX = {0, 0, -1, 1};
    public static final int[] posY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[][] tomatos = new String[n][m];
        boolean[][] isVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            tomatos[i] = br.readLine().split(" ");
        }

        토마토_복습 sol = new 토마토_복습();

        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        // 1. 현재 토마토가 있는 위치를 전부 큐에 담는다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("1".equals(tomatos[i][j]) && !isVisit[i][j]) {
                    sol.addQueue(queue, isVisit, j, i, 0);
                }
            }
        }

        int answer = sol.bfs(tomatos, queue, isVisit, m, n);

        // 4. 검사해서 0이 있으면 -1, 아니면 depth가 최종이다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("0".equals(tomatos[i][j])) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

    public void addQueue(ArrayDeque<Node> queue, boolean[][] isVisit, int x, int y, int depth) {
        Node node = new Node(x, y, depth);
        queue.addLast(node);
        isVisit[y][x] = true;
    }

    public boolean isTrueInd(int x, int y, int m, int n) {
        if ((0 <= x && x < m) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }

    public int bfs(String[][] tomatos, ArrayDeque<Node> queue,
                   boolean[][] isVisit, int m, int n) {
        int ans = 0;
        // 3. 결과적으로 queue가 다 비어서 더 이상 갈 곳이 없으면 끝이다.
        while (!queue.isEmpty()) {
            Node top = queue.pollFirst();
            // 2. 4방향으로 퍼져나가며 -1 이 아니면 1로 변환한다.
            for (int i = 0; i < 4; i++) {
                int nextX = top.x + posX[i];
                int nextY = top.y + posY[i];
                if (isTrueInd(nextX, nextY, m, n) && !isVisit[nextY][nextX]
                        && !("-1".equals(tomatos[nextY][nextX]))) {
                    addQueue(queue, isVisit, nextX, nextY, top.depth + 1);
                    tomatos[nextY][nextX] = "1";
                    ans = Math.max(top.depth + 1, ans);
                }
            }
        }
        return ans;
    }

    static class Node {
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}