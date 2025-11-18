import java.lang.*;
import java.util.*;
import java.io.*;

public class 창고_다각형{
    public static int areaCalcul(ArrayDeque<int[]> deque){
        int answer = 0;
        while(!deque.isEmpty()){
            int[] a = deque.pollFirst();
            if(!deque.isEmpty()){
                int[] top = deque.peekFirst();
                answer += Math.abs(top[0] - a[0]) * a[1];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] pillar = new int[cnt][2];
        ArrayDeque<int[]> deque = new ArrayDeque<int[]>();

        int answer = 0;
        int maxHeight = 0;
        int maxInd = 0;    // 1. 가장 긴거 인덱스 구한다.

        for(int i = 0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            maxHeight = Math.max(maxHeight,y);

            pillar[i] = new int[]{x,y};
        }

        // x 기준으로 정렬하기
        Arrays.sort(pillar, (a,b) -> Integer.compare(a[0], b[0]));

        // maxInd 찾기
        for(int i = 0; i<cnt; i++){
            if(pillar[i][1] == maxHeight){
                maxInd = i;
                break;
            }
        }

        // 2. 왼쪽 넓이 구하기
        // 2-1. y가 증가추세면 올린다.
        deque.addLast(pillar[0]);
        for(int i = 1; i<=maxInd; i++){
            int[] top = deque.peekLast();
            if(top[1] <= pillar[i][1]){
                deque.addLast(pillar[i]);
            }
        }

        // 2-2. (top x - 뺀거 x) * 뺀거 y로 왼쪽 넓이 계산
        answer += areaCalcul(deque);

        // 3. 오른쪽 넓이 구하기
        // 3-1. 끝에서부터, y가 증가추세면 올린다.
        deque.addLast(pillar[cnt-1]);
        for(int i = cnt-2; i>=maxInd; i--){
            int[] top = deque.peekLast();
            if(top[1] <= pillar[i][1]){
                deque.addLast(pillar[i]);
            }
        }

        // 3-2. (top x - 뺀거 x) * 뺀거 y로 왼쪽 넓이 계산
        answer += areaCalcul(deque);

        answer += pillar[maxInd][1];

        System.out.println(answer);
    }
}