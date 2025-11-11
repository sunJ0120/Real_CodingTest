import java.lang.*;
import java.util.*;

class 롤_케이크_자르기 {
    public static int ans = 0;
    public static boolean[] isVisit;

    public HashSet<Integer> makeSet(int start, int end, int[] topping){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = start; i<end; i++){
            set.add(topping[i]);
        }
        return set;
    }

    public void cutRollCake(int mid, int[] topping){
        // 5. end == -1이거나 end == n-1이면 return으로 종료
        if(mid == 0 || mid == topping.length){
            return;
        }

        // 이미 방문 했으면 종료
        if(isVisit[mid]){
            return;
        }

        isVisit[mid] = true;    // 방문 체크

        // 2. end로 왼쪽(미포함), 오른쪽 나눈다.
        Set<Integer> setA = makeSet(0, mid, topping);
        Set<Integer> setB = makeSet(mid, topping.length, topping);

        // 3. 왼쪽 set == 오른쪽 set이면 통과
        if(setA.size() == setB.size()){
            ans++;
        }
        // 4. end-1한거랑 end+1 한거를 mid로 두고 재귀한다
        cutRollCake(mid+1, topping);
        cutRollCake(mid-1, topping);
    }

    public int solution(int[] topping) {
        // 1. 가운데 기준으로 end 값을 구한다.
        int mid = topping.length / 2;
        // 방문 체크를 해야 같은 곳 방문을 안한다.
        isVisit = new boolean[topping.length];
        cutRollCake(mid, topping);

        // 6. ans return 한다.
        return ans;
    }
}