import java.util.*;
import java.lang.*;

class 주식_가격_2차 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 1. 스택을 생성한다.
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        // 2. top (올라간것) 보다 data (올라갈 것)가 더 작으면 1부터 길이 고정한다. (스택 계속 보기)
        for(int i = 1; i<prices.length; i++){
            int data = prices[i];
            while(!stack.isEmpty()){
                int topInd = stack.peek();
                if(prices[topInd] > data){
                    answer[topInd] = i-topInd;  // 이 부분 시간의 차이를 구하는 것이라는걸 명심하자.
                    stack.pop();
                }else{
                    break;
                }
            }
            // 스택에 인덱스 올린다.
            stack.push(i);
        }
        // 3. 끝까지 남은 것들은 길이 - 인덱스 - 1 해서 앞에서 남은 길이를 구해서 넣는다.
        while(!stack.isEmpty()){
            int ind = stack.pop();
            answer[ind] = prices.length - ind - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        주식_가격_2차 sol = new 주식_가격_2차();
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(sol.solution(prices)));
    }
}