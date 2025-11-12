import java.lang.*;
import java.util.*;

class 롤_케이크_자르기 {
    public void moveTopping(HashMap<Integer, Integer> left, HashSet<Integer> right, int topping){
        right.add(topping);
        left.put(topping, left.get(topping) - 1);

        if(left.get(topping) == 0){
            left.remove(topping);
        }
    }

    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        for(int top : topping){
            left.put(top, left.getOrDefault(top,0) + 1);
        }

        HashSet<Integer> right = new HashSet<Integer>();

        for(int top : topping){
            moveTopping(left, right, top);
            if(right.size() == left.size()){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        롤_케이크_자르기 sol = new 롤_케이크_자르기();
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(sol.solution(topping));
    }
}