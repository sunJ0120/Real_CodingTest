import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<Character>();

        char[] ch = s.toCharArray();

        for(char c : ch) {
            if(c == '('){
                stack.add(c);
            }else{
                if(stack.isEmpty()){
                    answer = false;
                    return answer;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            answer = false;
            return answer;
        }

        return answer;
    }
}