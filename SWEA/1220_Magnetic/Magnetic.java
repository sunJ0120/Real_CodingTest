import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Magnetic
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            int n = sc.nextInt();
            int[][] tables = new int[n][n];
            int answer = 0;

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    tables[i][j] = sc.nextInt();
                }
            }

            // 1. Queue을 만들어서 짝을 찾는다.
            Queue<Integer> queue = new ArrayDeque<Integer>();

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if (tables[j][i] != 0) {
                        queue.add(tables[j][i]);
                    }
                }
                // 2. Queue을 검사. top이 1인데 (N) peek이 2(S)이면 통과
                while(queue.size() >= 2){
                    int top = queue.poll();
                    int partners = queue.peek();

                    if (top == 1 && partners == 2) {
                        answer++;
                    }
                }

                queue.clear();
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}