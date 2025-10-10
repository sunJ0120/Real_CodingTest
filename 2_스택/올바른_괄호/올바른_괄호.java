package 올바른_괄호;

import java.util.*;
import java.lang.*;

public class 올바른_괄호 {
    boolean solution(String s) {
        Deque<Character> st = new ArrayDeque<Character>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()){ //짝 안맞음
                    return false;
                }
                st.pop(); //짝 맞음
            }
        }

        return st.isEmpty(); //짝 맞음
    }

    public static void main(String[] args) {
        올바른_괄호 sol = new 올바른_괄호();
        String s = "(())()";
        System.out.println(sol.solution(s));
    }
}
