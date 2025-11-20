import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class 햄버거_다이어트
{
    public static int limit;
    public static int maxScore;

    public static void dfs(int[][] cal, int start, int kcal, int score, int cnt){
        if (kcal > limit) {
            return;
        }
        maxScore = Math.max(maxScore, score);
        for (int i = start; i<cnt; i++) {
            dfs(cal, i+1, kcal + cal[i][1], score + cal[i][0], cnt);
        }
    }

    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            int cnt = sc.nextInt();
            limit = sc.nextInt();
            maxScore = 0;

            int[][] cal = new int[cnt][2];

            for(int i = 0; i<cnt; i++){
                cal[i][0] = sc.nextInt();    // 재료 점수
                cal[i][1] = sc.nextInt();    // 재료 칼로리
            }

            // for 돌면서 시작점 잡아서 dfs
            for(int i = 0; i<cnt; i++){
                dfs(cal, i, 0, 0, cnt);
            }

            bw.write("#" + test_case + " " + maxScore + "\n");
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
    }
}