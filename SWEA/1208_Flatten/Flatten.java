import java.io.*;
import java.lang.*;
import java.util.*;

class Flatten
{
    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        //T=sc.nextInt();
        T=10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            int num = sc.nextInt();
            int[] height = new int[100];
            for(int i = 0; i<100; i++){
                height[i] = sc.nextInt();
            }

            // 2. 정렬한다.
            Arrays.sort(height);

            // 1. 덤프횟수
            for(int i = 0; i<num; i++){
                height[99]--;
                height[0]++;

                // 덤프 후에는 최대 최소가 아닐 수 있으므로 재정렬한다.
                Arrays.sort(height);

                // 3. 최대 최소 차이 1이면 바로 끝
                if(height[99] - height[0] <= 1){
                    break;
                }
            }
            int minus = height[99] - height[0];
            bw.write("#" + test_case + " " + minus + "\n");
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
    }
}