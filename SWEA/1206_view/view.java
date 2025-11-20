import java.io.*;
import java.lang.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class view
{
    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();
        int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            int answer = 0;

            int num = sc.nextInt();
            int[] building = new int[num];

            for(int i = 0; i<num; i++) {
                building[i] = sc.nextInt();
            }

            for(int i = 2; i<num-2; i++) {
                int maxAround = Math.max(
                        Math.max(building[i-2], building[i-1]),
                        Math.max(building[i+2], building[i+1])
                );

                if(building[i] > maxAround){
                    answer += building[i] - maxAround;
                }
            }

            bw.write("#" + test_case + " " + answer + "\n");
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
    }
}