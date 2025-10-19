import java.util.*;
import java.lang.*;
import java.io.*;

class 요세푸스_문제{
    public static String toSequence(List<Integer> list){
        StringBuilder stb = new StringBuilder();
        stb.append("<");
        for(Integer num : list){
            stb.append(num + ", ");
        }
        stb.delete(stb.length()-2, stb.length());    // 마지막 , 삭제
        stb.append(">");
        return stb.toString();
    }
    public static String solution(int n, int k){
        // 1. 모든 N을 양방향 큐에 올린다.
        Deque<Integer> que = new ArrayDeque<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i<=n; i++){
            que.addLast(i);
        }
        // 2. k가 될때까지 pollFirst, addLast
        // 4. isEmpty()까지 반복
        int cnt = 1;
        while(!que.isEmpty()){
            // 3. k면 빼서 배열에 등록
            if(cnt == k){
                list.add(que.pollFirst());
                cnt = 1;    // 초기화
                continue;
            }
            que.addLast(que.pollFirst());
            cnt++;
        }
        return 요세푸스_문제.toSequence(list);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(요세푸스_문제.solution(n, k));
    }
}