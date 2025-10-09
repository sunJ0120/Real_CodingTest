package 실패율;

import java.util.*;
import java.lang.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Map<Integer, Float> map = new HashMap<Integer, Float>();
        int[] challenges = new int[N+2]; //도달한 사람 수, N+1까지 가능하므로 N+2로 설정

        for(int num : stages){
            challenges[num]++;
        }

        float total = stages.length;
        for(int ind = 1; ind <= N; ind++){
            float a = challenges[ind]; //도달했는데 못깬

            if(total == 0){ //도달한 사람이 아예 없음
                map.put(ind,0.0f);
            }else{
                map.put(ind,a/total);
                total -= challenges[ind]; //다음 계산을 위해 제거
            }
        }

        answer = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Float>comparingByValue().reversed())
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        실패율 sol = new 실패율();
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(sol.solution(N, stages)));
    }
}
