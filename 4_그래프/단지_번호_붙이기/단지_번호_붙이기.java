import java.util.*;
import java.io.*;
import java.lang.*;

public class 단지_번호_붙이기{
    public static int ans;
    public static final int[] posX = {0,0,-1,1}; // 상, 하, 좌, 우
    public static final int[] posY = {-1,1,0,0};

    public boolean isTrueInd(int x, int y, int n){
        if((0 <= x && x < n) && (0 <= y && y < n)){
            return true;
        }
        return false;
    }

    public void dfs(char[][] map, boolean[][] isVisit, int n, int x, int y){
        // 3. 재귀로 4방향 들어간다.
        for(int i = 0; i<4; i++){
            int nextX = posX[i] + x;
            int nextY = posY[i] + y;
            // 4. isVisit 안했고, 1일때, 인덱스 overflow 안될때 들어간다
            if(isTrueInd(nextX, nextY, n)
                    && !isVisit[nextY][nextX]
                    && map[nextY][nextX] == '1'){
                isVisit[nextY][nextX] = true;
                // 5. 갯수는 들어가기 전에 추가한다.
                ans++;
                dfs(map, isVisit, n, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][] isVisit = new boolean[n][n];
        List<Integer> answers = new ArrayList<Integer>();

        // 1. 배열을 저장한다.
        for(int i = 0; i<n; i++){
            char[] chars = br.readLine().toCharArray();
            map[i] = chars;
        }

        단지_번호_붙이기 sol = new 단지_번호_붙이기();

        // 2. for 이중으로 돌면서 start 점 찾는다.
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!isVisit[i][j] && map[i][j] == '1'){
                    // 6. 진입하기 전에 ans 초기화 하고 배열에 저장한다.
                    isVisit[i][j] = true;
                    ans = 1;
                    sol.dfs(map, isVisit, n, j, i);
                    answers.add(ans);
                }
            }
        }
        // 7. 오름차순 정렬하고 프린트 한다.
        Collections.sort(answers);
        System.out.println(answers.size());
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}