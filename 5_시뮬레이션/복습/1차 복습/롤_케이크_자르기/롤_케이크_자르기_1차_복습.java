/*
1. Map으로 오른쪽에 종류, 개수
2. 하나씩 지나가면서 Map에 있는 것 지우기
3. Map key 개수 == Set 개수이면 return한다.
*/

import java.util.*;
import java.lang.*;

class 롤_케이크_자르기_1차_복습 {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> right = new HashMap<Integer,Integer>();
        HashSet<Integer> left = new HashSet<Integer>();

        for(int top : topping){
            right.put(top, right.getOrDefault(top,0)+1);
        }

        for(int top : topping){
            left.add(top);

            right.put(top, right.get(top)-1);
            if(right.get(top) == 0){    // 0이 되는 순간 없애야 반영이 된다.
                right.remove(top);
            }

            if(right.size() == left.size()){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        롤_케이크_자르기_복습 sol = new 롤_케이크_자르기_복습();
        int[] topping = {1,2,1,3,1,4,1,2};
        int result = sol.solution(topping);
        System.out.println(result);
    }
}