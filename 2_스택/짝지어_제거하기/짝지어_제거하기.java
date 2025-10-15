package 짝지어_제거하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class 짝지어_제거하기 {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) { // 1. 하나씩 올린다.
                stack.push(ch);
            } else {
                while (!stack.isEmpty() && stack.peek() == ch) {
                    // 2. 가장 최근것과 비교해서, 같으면 다를 때까지 pop한다.
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        짝지어_제거하기 sol = new 짝지어_제거하기();
        String s = "baabaa";
        System.out.println(sol.solution(s));
    }
}
