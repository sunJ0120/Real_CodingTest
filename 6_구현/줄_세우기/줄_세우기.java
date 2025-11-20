import java.io.*;
import java.util.*;
import java.lang.*;

public class 줄_세우기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] moves = new int[num];
        //1. 배열화
        for(int i = 0; i<num; i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i<num; i++){  // i는 인덱스
            answer.add(moves[i], i+1);
        }

        for(int i = answer.size()-1; i>=0; i--){
            stb.append(answer.get(i));
            if(i > 0){
                stb.append(" ");
            }
        }

        //3. 뒤집기
        System.out.println(stb);
    }
}