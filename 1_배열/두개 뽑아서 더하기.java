import java.util.*;

class 두개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>(); //컴파일 비용을 줄이기 위함이다.

        for(int i = 0; i<numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        두개_뽑아서_더하기 sol = new 두개_뽑아서_더하기();
        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(sol.solution(numbers)));
    }
}