import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class 원재의_메모리_복구하기
{
    public static void reverse(char[] init, char targetNum, int start){
        for(int i = start; i<init.length; i++){
            init[i] = targetNum;
        }
    }
    public static void main(String args[]) throws Exception
    {
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
            char[] memory = sc.next().toCharArray();
            char[] init = new char[memory.length];

            // 초기화
            Arrays.fill(init, '0');

            int ans = 0;

            for(int i = 0; i<memory.length; i++){
                String a = new String(memory);
                String b = new String(init);

                if (a.equals(b)) {
                    break;
                }

                char num = memory[i]; //반대로 바꾸기 위함이다.

                if(memory[i] != init[i]){
                    if (num == '1') {
                        reverse(init, '1', i);
                    }else{
                        reverse(init, '0', i);
                    }
                    ans++;
                }
            }
            bw.write("#" + test_case + " " + ans + "\n");
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
    }
}