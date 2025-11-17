import java.lang.*;
import java.util.*;
import java.io.*;

public class 자리배정{
    public static final int[] posX = {0,1,0,-1}; // 위 오른쪽 아래 왼쪽
    public static final int[] posY = {1,0,-1,0};

    public static boolean isTruInd(int x, int y, int c, int r) {
        if((0<=x && x<c) && (0<=y && y<r)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());   // x
        int r = Integer.parseInt(st.nextToken());   // y
        int gallery = Integer.parseInt(br.readLine());   // 관객

        if(gallery > c*r){
            System.out.println(0);
            return;
        }

        int x = 0;
        int y = 0;
        int dir = 0;

        boolean[][] isVisit = new boolean[r][c];

        for(int i = 1; i<gallery; i++){
            isVisit[y][x] = true;    // 여기까지가 i이고, 이후는 다음 좌표를 계산하는 것이라 <gallery로 표현
            int nextX = x + posX[dir];
            int nextY = y + posY[dir];

            // 방문한적 있거나 벗어날 경우, 순서상 next를 갖고 검사해야 한다.
            if(!isTruInd(nextX, nextY, c, r) || isVisit[nextY][nextX]){
                dir = (dir+1) % 4;   // 방향 변경
            }

            x += posX[dir];
            y += posY[dir];
        }
        System.out.println((x+1) + " " + (y+1));
    }
}