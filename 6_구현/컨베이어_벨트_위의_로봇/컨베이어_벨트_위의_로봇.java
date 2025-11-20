import java.io.*;
import java.util.*;

public class 컨베이어_벨트_위의_로봇 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> belt = new ArrayList<>();
        boolean[] robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            belt.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;

        while(true){
            cnt++;

            // 1. 벨트 회전
            int end = belt.get(belt.size()-1);
            belt.remove(belt.size()-1);
            belt.add(0, end);

            // 2. 로봇 회전
            for(int i = n-1; i > 0; i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;    // 처음 위치
            robot[n-1] = false;  // 내리는 위치는 로봇이 못온다.

            // 3. 로봇 이동 (n-2부터, n-1은 이동 불가)
            for(int i = n-2; i >= 0; i--){  // n-2부터!
                if(robot[i] && !robot[i+1] && belt.get(i+1) > 0){
                    robot[i] = false;
                    robot[i+1] = true;
                    belt.set(i+1, belt.get(i+1) - 1);    // set을 이용하면 된다.
                }
            }
            robot[n-1] = false;  // 이동 후에도 내림

            // 4. 로봇 올리기
            if(belt.get(0) > 0){
                robot[0] = true;
                belt.set(0, belt.get(0) - 1);
            }

            // 5. 0 개수 체크
            int zeroCnt = 0;
            for(int b : belt){
                if(b == 0) zeroCnt++;
            }

            if(zeroCnt >= k) break;
        }

        System.out.println(cnt);
    }
}