import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 토마토 {
    public static final int[] posX = {0, 0, -1, 1};
    public static final int[] posY = {-1, 1, 0, 0};
    public static int n;
    public static int m;
    public static int ans = 0;
    public static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());    // 가로
        n = Integer.parseInt(st.nextToken());    // 세로

        String[][] tomatos = new String[n][m];
        boolean[][] isVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            tomatos[i] = br.readLine().split(" ");
        }

        토마토 sol = new 토마토();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1. 방문한적 없고 1인 곳을 찾는다.
                if (!isVisit[i][j] && "1".equals(tomatos[i][j])) {
                    isVisit[i][j] = true;
                    sol.dfs(tomatos, isVisit, j, i, 0);
                    ans += days;
                    days = 0;
                }
            }
        }

        // 4. 다 빠져 나오고 검사해서 0이 있으면 -1로 return 한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("0".equals(tomatos[i][j])) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
    }

    public boolean isTrueInd(int x, int y) {
        if ((0 <= x && x < m) && (0 <= y && y < n)) {
            return true;
        }
        return false;
    }

    public void dfs(String[][] tomatos, boolean[][] isVisit, int x, int y, int day) {
        // 2. 4방향 탐색으로 재귀 돈다.
        for (int i = 0; i < 4; i++) {
            int nextX = x + posX[i];
            int nextY = y + posY[i];
            if (isTrueInd(nextX, nextY)
                    && !isVisit[nextY][nextX]
                    && !("-1".equals(tomatos[nextY][nextX]))) {

                isVisit[nextY][nextX] = true;
                tomatos[nextY][nextX] = "1";

                dfs(tomatos, isVisit, nextX, nextY, day + 1);
            }
        }
    }
}