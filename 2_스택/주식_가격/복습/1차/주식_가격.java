import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 클래스 이름: 주식_가격
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-18
 * <p>
 * 저작권 주의: Copyright (c) 2025 sspur
 */
public class 주식_가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 1. 스택으로 최신 가격을 본다.
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 2. 최신 가격과 비교해서, 이전 가격이 높으면 뺀다.
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int prePriceIdx = stack.pop();
                // 3. 최신 가격 기준, 얼마나 떨어져 있느냐를 보면 된다.
                answer[prePriceIdx] = i - prePriceIdx;
            }
            stack.push(i);
        }
        // 4. 스택에 남아있는거 하나씩 뺀다.
        while (!stack.isEmpty()) {
            int prePriceIdx = stack.pop();
            answer[prePriceIdx] = prices.length - 1 - prePriceIdx;
        }
        return answer;
    }

    public static void main(String[] args) {
        주식_가격 sol = new 주식_가격();
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(sol.solution(prices)));
    }
}
