package 괄호_회전하기;

import java.util.*;
import java.lang.*;

public class 괄호_회전하기 {
    // 괄호 init을 위한 method
    public HashMap<Character,Character> init(HashMap<Character,Character> map){
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        return map;
    }
    public int solution(String s) {
        int answer = 0;
        // 1. 괄호 짝 맞추기
        HashMap<Character,Character> map = new HashMap<Character,Character>(); // map으로 괄호 짝 저장하기
        map = init(map);
        s+=s; // string을 이어 붙여서 i 움직여서 **뒤로 간 것 같은 효과**주기

        Deque<Character> stack = new ArrayDeque<Character>(); // 가장 최근 것을 매칭하기 위해 stack 개념 활용

        for(int i = 0; i<s.length()/2; i++){ //시작점
            boolean flag = true;
            for(int j = i; j<(s.length()/2)+i; j++){
                if(map.containsKey(s.charAt(j))){ //시작 괄호
                    stack.push(s.charAt(j));
                }else{
                    // 짝이 없을 경우
                    if(stack.isEmpty() || !map.get(stack.pop()).equals(s.charAt(j))){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty()){
                answer++;
            }
        }
        // 2. 짝이 맞을 경우의 수를 추가한다.
        return answer;
    }

    public static void main(String[] args) {
        괄호_회전하기 sol = new 괄호_회전하기();
        String s = "[](){}";
        System.out.println(sol.solution(s));
    }
}
