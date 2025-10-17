/**
 * 클래스 이름: 올바른_괄호
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-17
 * <p>
 * 저작권 주의: Copyright (c) 2025 sspur
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호 {
    public static void main(String[] args) {
        올바른_괄호 sol = new 올바른_괄호();
        String s = "(())()";
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        // 1. 스택에 (를 올린다.
        for (int i = 0; i < s.length(); i++) {
            // 2. )가 나오면 스택에 있는걸 지운다.
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                // 3. 짝이 없으면 마감, 짝이 있으면 지운다.
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        // 4. 짝이 맞지 않는 괄호가 남아있다면 지운다.
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
