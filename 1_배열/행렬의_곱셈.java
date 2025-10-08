import java.util.Arrays;

public class 행렬의_곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        int n = arr1.length; // 최종 값의 행
        int m = arr2[0].length; // 최종 값의 열
        int x = arr2.length; // 곱하기 위한 기준값

        answer = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                for(int z = 0; z<x; z++){
                    answer[i][j] += (arr1[i][z] * arr2[z][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        행렬의_곱셈 sol = new 행렬의_곱셈();
        int[][] arr1 = {{1,4},{2,5},{3,6}};
        int[][] arr2 = {{3,3},{3,3}};
        System.out.println(Arrays.deepToString(sol.solution(arr1, arr2)));
    }
}
