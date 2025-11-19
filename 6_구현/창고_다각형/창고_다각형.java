import java.lang.*;
import java.util.*;
import java.io.*;

public class 창고_다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] sticks = new int[num][2];
        int maxHeight = 0;
        int maxInd = 0;
        StringTokenizer st;
        int ans = 0;

        // 1. list에 넣기, 최대 높이 찾기
        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sticks[i] = new int[]{x,y};

            maxHeight = Math.max(y, maxHeight);
        }

        //2. list x로 정렬...이거 꼭 외우기
        Arrays.sort(sticks, (a,b) -> Integer.compare(a[0], b[0]));

        //3. 최대 인덱스를 구한다.
        for(int i = 0; i<num; i++){
            if(sticks[i][1] == maxHeight){
                maxInd = i;
                break;
            }
        }

        // 4. 왼쪽 구하기, 증가하면 x 구한다.
        int start = 0;
        int end = 1;
        while(end <= maxInd){
            if(sticks[start][1] <= sticks[end][1]){
                ans += (Math.abs(sticks[end][0]-sticks[start][0]) * sticks[start][1]);
                start = end; // start가 end 자리로 가서 자리 바꿔야 한다.
                end++;
                continue;
            }
            end++;
        }

        // 5. 오른쪽 구하기, 증가하면 x 구한다.
        start = num-1;
        end = num-2;
        while(end >= maxInd){
            if(sticks[start][1] <= sticks[end][1]){
                ans += (Math.abs(sticks[end][0]-sticks[start][0]) * sticks[start][1]);
                start = end; // start가 end 자리로 가서 자리 바꿔야 한다.
                end--;
                continue;
            }
            end--;
        }
        // 6. 긴거 너비 더하기
        ans += sticks[maxInd][1];

        System.out.println(ans);
    }
}