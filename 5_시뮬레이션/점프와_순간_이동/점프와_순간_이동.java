/*
1. 거꾸로 가면서 홀수면 -1을 하고
2. 짝수면 /2를 한다
3. 그럼 그게 최소이다.
*/

public class 점프와_순간_이동 {
    public int solution(int n) {
        int ans = 1;

        while(n > 2){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        점프와_순간_이동 sol = new 점프와_순간_이동();
        int n = 5000;
        System.out.println(sol.solution(n));
    }
}