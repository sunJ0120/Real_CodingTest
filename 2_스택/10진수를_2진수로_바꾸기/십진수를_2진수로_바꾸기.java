import java.util.*;
import java.lang.*;

public class 십진수를_2진수로_바꾸기 {
    String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int num = Integer.parseInt(s); //str to int

        //StringBuilder에 저장해서 바로 반환 + 뒤집어서 읽기
        while(num > 0){ //0일때 멈춰야 함
            answer.append(num%2);
            num /= 2;
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        십진수를_2진수로_바꾸기 sol = new 십진수를_2진수로_바꾸기();
        String s1 = "10";
        System.out.println(sol.solution(s1)); //1010

        String s2 = "27";
        System.out.println(sol.solution(s2)); //11011

        String s3 = "12345";
        System.out.println(sol.solution(s3)); //11000000111001
    }
}
