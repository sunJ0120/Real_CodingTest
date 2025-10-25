import java.lang.*;

class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisit = new boolean[n];

        for(int i = 0; i<n; i++){
            if(isVisit[i]){
                continue;
            }
            dfs(i, computers, isVisit, n);
            answer++;
        }
        return answer;
    }

    public void dfs(int start, int[][] computers, boolean[] isVisit, int size){
        isVisit[start] = true;
        for(int i = 0; i<size; i++){
            if(!isVisit[i] && computers[start][i] == 1){
                dfs(i, computers, isVisit, size);
            }
        }
    }

    public static void main(String[] args) {
        네트워크 sol = new 네트워크();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(sol.solution(n, computers));
    }
}