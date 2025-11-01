import java.util.*;
import java.lang.*;
import java.io.*;

public class 유기농_배추 {
    public static final int[] posX = {0,0,-1,1};
    public static final int[] posY = {-1,1,0,0};

    public boolean isTrueInd(int x, int y, int m, int n){
        if((0<=x && x<m) && (0<=y && y<n)){
            return true;
        }
        return false;
    }

    public void dfs(int[][] field, boolean[][] isVisit, int x, int y, int m, int n){
        isVisit[y][x] = true;
        for(int i = 0; i<4; i++){
            int nextX = x + posX[i];
            int nextY = y + posY[i];
            if(isTrueInd(nextX, nextY, m, n)
                    && field[nextY][nextX] == 1
                    && !isVisit[nextY][nextX]){
                dfs(field, isVisit, nextX, nextY, m, n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());
        for(int i = 0; i<roop; i++){
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());    // 가로
            int n = Integer.parseInt(st.nextToken());    // 세로
            int cabbage = Integer.parseInt(st.nextToken());    // 배추 갯수

            int[][] field = new int[n][m];
            boolean[][] isVisit = new boolean[n][m];

            for(int j = 0; j<cabbage; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;    // 배추 심기
            }

            유기농_배추 sol = new 유기농_배추();

            // 1. 시작점을 찾는다.
            for(int j = 0; j<n; j++){
                for(int z = 0; z<m; z++){
                    if(field[j][z] == 1 && !isVisit[j][z]){
                        sol.dfs(field, isVisit, z, j, m, n);
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}