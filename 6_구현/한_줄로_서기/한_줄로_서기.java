import java.util.*;
import java.io.*;
import java.lang.*;

public class 한_줄로_서기{
    public static void stand(int[] count, int ind, int[] answer){
        int cnt = 0;
        for(int i = 0; i<answer.length; i++){
            // cnt랑 해당 i번째랑 같으면 answer[]에 넣는다.
            if(count[ind] == cnt && answer[i] == 0){
                answer[i] = ind+1; // 몇 번째 사람이 그 자리인지 체크
                return;
            }
            if(answer[i] == 0){  // 빈 자리이면 체크
                cnt++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] count = new int[num];
        int[] answer = new int[num];

        for(int i = 0; i<num; i++){
            count[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<num; i++){
            stand(count, i, answer);
        }

        for(int i = 0; i<num; i++){
            stb.append(answer[i] + " ");
        }

        System.out.println(stb.toString());
    }
}