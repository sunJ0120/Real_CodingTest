package SWEA.복기;

import java.lang.*;
import java.util.*;

class XOR
{
    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] numbers = new int[n];
            for(int i = 0; i<n; i++) {
                numbers[i] = sc.nextInt();
            }

            int ans = 0;

            for(int i = 0; i<n; i++){    // 시작점
                for(int j = i; j<n; j++){   //더하는거
                    int xorValue = 0;
                    if(i == j){    // 같으면 자기것을 더한다.
                        ans += numbers[i];
                    }else{
                        // ^ 비트 마스킹 연산 이용 (XOR)
                        for(int k = i; k<=j; k++){
                            xorValue ^= numbers[k];
                        }
                        ans += xorValue;
                    }
                }
            }
            // 표준출력(화면)으로 답안을 출력합니다.
            System.out.println("#" + test_case + " " + ans);
        }

        sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
    }
}

