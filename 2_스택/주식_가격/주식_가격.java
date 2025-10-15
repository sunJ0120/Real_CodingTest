package 주식_가격;
import java.util.*;
import java.lang.*;

public class 주식_가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 1. 스택 정의
        Deque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(0); // 초기 인덱스 올리기
        int ind;

        // 2. top (이전 가격) & push (이후 가격) 비교
        for(ind = 1; ind < answer.length; ind++){ //시작점
            while(!stack.isEmpty() && prices[stack.peek()] > prices[ind]){
                int indx = stack.pop();
                answer[indx] = ind-indx;
            }
            stack.push(ind);
        }

        // 3. 비우기
        while(!stack.isEmpty()){
            int indx = stack.pop();
            answer[indx] = ind-indx-1;
        }

        return answer;
    }

    public static void main(String[] args) {
        주식_가격 sol = new 주식_가격();
        int[] list = {1,2,4,5,2,3,1};
        System.out.println(Arrays.toString(sol.solution(list)));
    }
}
