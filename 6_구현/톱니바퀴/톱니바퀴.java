import java.util.*;
import java.io.*;
import java.lang.*;

public class 톱니바퀴{
    public static boolean isSpin(int[][] wheels, int ind, int[] startInds, int nextInd){
        // 나의 왼쪽이 nextInd이면, 내가 6번, 상대가 2번
        if(ind > nextInd){
            int targetInd = (startInds[ind] + 6) % 8;
            int nextTargetInd = (startInds[nextInd] + 2) % 8;

            if(wheels[ind][targetInd] != wheels[nextInd][nextTargetInd]){
                return true;
            }
            return false;
        }else{
            int targetInd = (startInds[ind] + 2) % 8;
            int nextTargetInd = (startInds[nextInd] + 6) % 8;

            if(wheels[ind][targetInd] != wheels[nextInd][nextTargetInd]){
                return true;
            }
            return false;
        }
    }
    // 1. 해당하는 것의 오른쪽 왼쪽을 따로 구해야 한다.
    public static void spin(int[] startInds, int[][] wheels, int ind, int dir){
        List<int[]> spinInds = new ArrayList<int[]>();
        spinInds.add(new int[]{ind,dir});

        //왼쪽
        int leftDir = dir;
        for(int i = ind-1;i>=0; i--){
            leftDir = -leftDir;    // 그냥 -1, 1 이므로 - 붙이면 된다.

            if(isSpin(wheels, i+1, startInds, i)){
                int[] li = {i,leftDir};
                spinInds.add(li);
            }else{    // 전파 방지
                break;
            }
        }

        // 오른쪽
        int rightDir = dir;
        for(int i = ind+1;i<4; i++){
            rightDir = -rightDir;

            if(isSpin(wheels, i-1, startInds, i)){
                int[] li = {i,rightDir};
                spinInds.add(li);
            }else{    // 전파 방지
                break;
            }
        }

        // 회전시킨다. **시계 방향이면 반대로 뒤로 가야한다.
        for(int[] spinInd : spinInds){
            startInds[spinInd[0]] = (startInds[spinInd[0]] - spinInd[1] + 8) % 8;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] wheels = new int[4][8];
        for(int i = 0; i<4; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j<8; j++){
                wheels[i][j] = ch[j] - '0';
            }
        }

        int roop = Integer.parseInt(br.readLine());
        int[] startInds = new int[4];
        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());    // 톱니 번호
            int dir = Integer.parseInt(st.nextToken());    // 방향

            spin(startInds, wheels, num-1, dir);
        }

        // startInd에 누적해서 값 구하기
        int ans = 0;
        for(int i = 0;i<4; i++){
            int startInd = startInds[i];
            if(wheels[i][startInd] == 1){    // 12시 방향이 S극이면
                ans += Math.pow(2,i);
            }
        }
        System.out.println(ans);
    }
}