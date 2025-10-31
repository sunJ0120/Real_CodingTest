import java.lang.*;
import java.io.*;
import java.util.*;

public class 바이러스 {
    public static int ans = 0;

    public void dfs(HashMap<Integer, ArrayList<Integer>> graph, int start, boolean[] isVisit){
        // 2. for문으로 돌면서 연결된 것을 다 돌아다닌다.
        ArrayList<Integer> values = graph.get(start);
        for(int value : values){
            if(!isVisit[value]){
                isVisit[value] = true;
                // 3. 방문 안한 노드이면 더해준다.
                ans++;
                dfs(graph, value, isVisit);
            }
        }
    }

    public void makeLink(HashMap<Integer, ArrayList<Integer>> graph, int node1, int node2){
        if(graph.containsKey(node1)){
            ArrayList<Integer> values = graph.get(node1);
            values.add(node2);
        }else{
            ArrayList<Integer> values = new ArrayList<Integer>();
            values.add(node2);
            graph.put(node1,values);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        boolean[] isVisit = new boolean[node+1];
        isVisit[1] = true; // 시작 노드 더하기
        바이러스 sol = new 바이러스();

        for(int i = 0; i<link; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            // 1. 양쪽으로 연결관계를 넣어준다.
            sol.makeLink(graph, node1, node2);
            sol.makeLink(graph, node2, node1);
        }
        sol.dfs(graph, 1, isVisit);
        System.out.println(ans);
    }
}