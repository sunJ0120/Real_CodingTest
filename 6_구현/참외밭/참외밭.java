import java.lang.*;
import java.util.*;
import java.io.*;

public class 참외밭{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        int[][] length = new int[6][2];

        for(int i = 0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            length[i][0] = Integer.parseInt(st.nextToken());   // 방향
            length[i][1] = Integer.parseInt(st.nextToken());   // 길이
        }

        int maxHeight = 0;  // (4,3) 중 가장 긴거
        int maxWight = 0;  // (2,1) 중 가장 긴거
        for(int[] len : length){
            if(len[0] == 4 || len[0] == 3){
                maxHeight = Math.max(len[1],maxHeight);
            }else{
                maxWight = Math.max(len[1],maxWight);
            }
        }

        // 인덱스 구하기
        int maxhInd = 0;
        int maxwInd = 0;
        for(int i = 0; i<6; i++){
            if(length[i][0] == 4 || length[i][0] == 3){
                if(length[i][1] == maxHeight){
                    maxhInd = i;
                }
            }else{
                if(length[i][1] == maxWight){
                    maxwInd = i;
                }
            }
        }

        int minusHeight = length[(maxwInd+3)%6][1];
        int minusWight = length[(maxhInd+3)%6][1];

        int answer = ((maxHeight * maxWight) - (minusHeight * minusWight)) * k;
        System.out.println(answer);
    }
}