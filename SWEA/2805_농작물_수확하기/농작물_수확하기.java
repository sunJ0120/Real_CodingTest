import java.io.*;
import java.lang.*;
import java.util.*;

class 농작물_수확하기
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
            int n = sc.nextInt();
            int[][] maps = new int[n][n];
            int ans = 0;

            for(int i = 0; i<n; i++) {
                char[] c = sc.next().toCharArray();
                for(int j = 0; j<n; j++) {
                    maps[i][j] = c[j] - '0';
                }
            }

            int start = n/2;
            int end = n/2;
            int row = 0;

            // 1. 위 라인 구하기
            while(start > 0 && end < n-1){
                for(int i = start; i<=end; i++){
                    ans += maps[row][i];
                }
                row++;
                start--;
                end++;
            }
            // 2. 아래 라인 구하기
            while(start <= end){
                for(int i = start; i<=end; i++){
                    ans += maps[row][i];
                }
                row++;
                start++;
                end--;
            }
            bw.write("#"+ test_case + " " + ans + "\n");
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
    }
}