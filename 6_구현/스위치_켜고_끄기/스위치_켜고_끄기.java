import java.io.*;
import java.util.*;
import java.lang.*;

public class 스위치_켜고_끄기 {
    public static void boy(int number, int[] switches, int len){
        for(int i = number-1; i<len; i+= number){
            switches[i] = Math.abs(switches[i]-1);
        }
    }

    public static void girl(int number, int[] switches, int len){
        switches[number-1] = Math.abs(switches[number-1]-1);

        int startInd = number-2;
        int endInd = number;

        while(startInd >= 0 && endInd < len && switches[startInd] == switches[endInd]){
            switches[startInd] = Math.abs(switches[startInd]-1);
            switches[endInd] = Math.abs(switches[endInd]-1);
            startInd--;
            endInd++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] switches = new int[len];
        for(int i = 0; i<len; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());

        for(int i = 0; i<students; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if(gender == 1){   //남자
                boy(number, switches, len);
            }else{  //여자
                girl(number, switches, len);
            }
        }

        for(int i = 0; i<len; i++){
            stb.append(switches[i]);

            if((i+1) % 20 == 0){    // 한 줄에 20개씩이라 필수
                stb.append("\n");
            }else{
                stb.append(" ");
            }
        }
        System.out.println(stb.toString());
    }
}