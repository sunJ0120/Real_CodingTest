import java.io.*;
import java.lang.*;
import java.util.*;

public class 로봇_청소기{
    public static final int[] posX = {0,1,0,-1};    // 북,동,남,서
    public static final int[] posY = {-1,0,1,0};

    public boolean searchZero(int r, int c, String[][] map){
        // 2. 현재 칸 주변 4칸 중 청소한 곳 있는지 보기
        for(int i = 0; i<4; i++){
            int nextX = c + posX[i];
            int nextY = r + posY[i];
            if("0".equals(map[nextY][nextX])){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());    // 로봇 y
        int c = Integer.parseInt(st.nextToken());    // 로봇 x
        int dir = Integer.parseInt(st.nextToken());  // 로봇 방향

        int ans = 0;

        String[][] map = new String[n][m];
        for(int i = 0; i<n; i++){
            map[i] = br.readLine().split(" ");
        }

        로봇_청소기 sol = new 로봇_청소기();

        while(true){
            // 1. 현재 칸 청소
            if("0".equals(map[r][c])){
                map[r][c] = "2";
                ans++;
            }
            // 2. 빈곳 없음
            if(!sol.searchZero(r, c, map)){
                int backInd = (dir + 2) % 4;
                int backX = c + posX[backInd];
                int backY = r + posY[backInd];
                if("1".equals(map[backY][backX])){
                    break; //후진 불가
                }

                c = backX;
                r = backY;
            }else{ // 3. 빈곳 있음
                int spinlInd = (dir + 3) % 4;
                int spinX = c + posX[spinlInd];
                int spinY = r + posY[spinlInd];

                if("0".equals(map[spinY][spinX])){
                    c = spinX;
                    r = spinY;
                }
                dir = (dir + 3) % 4;  // 방향 바뀐대로 전환
            }
        }
        System.out.println(ans);
    }
}