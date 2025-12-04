import java.io.*;
import java.util.*;
import java.lang.*;

public class 수열{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());    // 연속되는 일
        int ans = 0;

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        // 초기값
        for(int i = 0; i<k; i++){
            a += nums[i];
        }
        ans = a;

        for(int i = k; i<n; i++){
            int b = a + nums[i] - nums[i - k];    // k를 기준으로 k 뒤에 있는 수를 빼는 방식을 이용한다.
            ans = Math.max(ans, b);
            a = b;
        }

        System.out.println(ans);
    }
}