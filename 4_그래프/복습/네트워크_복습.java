import java.lang.*;

class 네트워크_복습 {
    public void dfs(int n, int[][] computers, boolean[] isVisit, int y){
        // 2. dfs 재귀로 배열 순환해서 연결된거 (1)을 전부 돈다.
        for(int i = 0; i<n; i++){
            // 4. x를 끝까지 돌 되, 연결된 것을 돌기 위해 x를 (i) y로 변경하여 재귀를 돈다.
            if(computers[y][i] == 1 && !isVisit[i]){
                isVisit[i] = true;
                dfs(n, computers, isVisit, i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 1. isVisit 배열을 마련한다.
        boolean[] isVisit = new boolean[n];
        // 3. n만큼만 들어간다. 사실상 for문은 행만큼만 돌면서 정해주면 된다.
        for(int i = 0; i<n; i++){
            if(!isVisit[i]){
                isVisit[i] = true;
                dfs(n, computers, isVisit, i);
                // 5. dfs가 끝나면 answer를 증가시킨다
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        네트워크_복습 sol = new 네트워크_복습();
        int n = 3;
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(sol.solution(n, computers));
    }
}