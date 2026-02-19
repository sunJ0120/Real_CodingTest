import java.util.*;

class 주식_가격_3차 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(0);

        for(int i = 1; i<prices.length; i++){
            int cnt = 1;
            while(!stack.isEmpty()){
                int preInd = stack.peek();
                if(prices[i] < prices[preInd]){
                    answer[stack.pop()] = i - preInd; // 시간의 차이
                }else{
                    break;
                }
            }
            stack.push(i);
        }

        // ** 스택 비우기, 총길이 - 인덱스 - 1
        while(!stack.isEmpty()){
            int ind = stack.pop();
            answer[ind] = prices.length - ind - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        주식_가격_3차 sol = new 주식_가격_3차();
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(sol.solution(prices)));
    }
}