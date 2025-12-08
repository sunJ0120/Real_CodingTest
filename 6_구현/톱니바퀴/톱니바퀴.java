import java.util.*;
import java.lang.*;
import java.io.*;

public class 톱니바퀴 {
    private static final int WHEEL_CNT = 4;
    private static final int SAW_TOOTH = 8;

    // 인덱스 판단
    public static boolean isTrueInd(int ind){
        return ind >= 0 && ind < WHEEL_CNT;
    }

    // 회전 가능 여부 판단
    public static boolean canSpin(int[][] wheels, int currentInd, int nextInd, int[] start){
        int currentTooth;
        int nextTooth;

        if(currentInd < nextInd){  // 오른쪽으로 가고 있음
            currentTooth = (start[currentInd] + 2) % SAW_TOOTH;
            nextTooth = (start[nextInd] + 6) % SAW_TOOTH;
        }else{
            currentTooth = (start[currentInd] + 6) % SAW_TOOTH;
            nextTooth = (start[nextInd] + 2) % SAW_TOOTH;
        }

        return wheels[currentInd][currentTooth] != wheels[nextInd][nextTooth];
    }

    // 회전 재귀 메서드
    public static void spin(int[][] wheels, int[] start, int currentInd, int from, int dir){
        if(from >= currentInd && isTrueInd(currentInd-1) && canSpin(wheels, currentInd, currentInd-1, start)){   // 왼쪽
            spin(wheels, start, currentInd-1, currentInd, -dir);
        }

        if(from <= currentInd && isTrueInd(currentInd+1) && canSpin(wheels, currentInd, currentInd+1, start)){ // 오른쪽
            spin(wheels, start, currentInd+1, currentInd, -dir);
        }

        // spin을 못할 경우, 자기 자신의 start 변경, 회전 방향과 반대
        start[currentInd] = (start[currentInd] - dir + SAW_TOOTH) % SAW_TOOTH;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] wheels = new int[WHEEL_CNT][SAW_TOOTH];
        for(int i = 0; i<WHEEL_CNT; i++){
            char[] tooths = br.readLine().toCharArray();
            for(int j = 0; j<SAW_TOOTH; j++){
                wheels[i][j] = tooths[j] - '0';
            }
        }

        int[] start = new int[WHEEL_CNT];
        int ans = 0;

        int roop = Integer.parseInt(br.readLine());
        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ind = Integer.parseInt(st.nextToken());    // 톱니 인덱스
            int dir = Integer.parseInt(st.nextToken());    // 회전 방향
            spin(wheels, start, ind-1, ind-1, dir);
        }

        // start에 있는거 전부 더하기
        for(int i = 0; i<WHEEL_CNT; i++){
            int startInd = start[i];
            ans += (wheels[i][startInd] * Math.pow(2, i));
        }
        System.out.println(ans);
    }
}