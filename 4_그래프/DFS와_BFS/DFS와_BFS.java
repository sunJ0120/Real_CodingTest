import java.util.*;
import java.lang.*;
import java.io.*;

public class DFS와_BFS {
    // dfs, bfs를 작은 수부터 올리기 위해서 for문을 반대로 해야 한다...
    public void searchAndAddAsc(boolean[][] graph, boolean[] isVisit,
                                int start, int n, ArrayDeque<Integer> structure){
        for(int i = 1; i<=n; i++){
            if(graph[start][i] && !isVisit[i]){  // 연결되어 있는데 방문하지 않음
                structure.addLast(i);
            }
        }
    }

    public void searchAndAddDesc(boolean[][] graph, boolean[] isVisit,
                                 int start, int n, ArrayDeque<Integer> structure){
        for(int i = n; i>=1; i--){
            if(graph[start][i] && !isVisit[i]){  // 연결되어 있는데 방문하지 않음
                structure.addLast(i);
            }
        }
    }

    public String bfs(boolean[][] graph, int start, int n){
        StringBuilder stb = new StringBuilder();
        //1. 방문 체크 배열 생성
        boolean[] isVisit = new boolean[n+1];   // 이거 하나만 둬야 한다.
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        //2. start 값 찾아서 연결된거 하나 올리기
        queue.addLast(start);
        //3. isEmpty일때까지 진행하기
        while(!queue.isEmpty()){
            //4. top에 있는거 꺼내서
            int top = queue.pollFirst();
            if(isVisit[top]){
                continue;
            }
            isVisit[top] = true;
            stb.append(top + " ");
            //5. 연결된 것 중에 방문 안했고 가장 가까운거 queue에 올리기
            searchAndAddAsc(graph, isVisit, top, n, queue);
        }
        return stb.toString().trim();
    }

    public String dfs(boolean[][] graph, int start, int n){
        StringBuilder stb = new StringBuilder();
        //1. 방문 체크 배열 생성
        boolean[] isVisit = new boolean[n+1];   // 이거 하나만 둬야 한다.
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        //2. start 값 찾아서 연결된거 하나 올리기
        stack.addLast(start);
        //3. isEmpty일때까지 진행하기
        while(!stack.isEmpty()){
            //4. top에 있는거 꺼내서
            int top = stack.pollLast();
            if(isVisit[top]){
                continue;
            }
            isVisit[top] = true;
            stb.append(top + " ");
            //5. 연결된 것 중에 방문 안했고 가장 가까운거 stack에 올리기
            searchAndAddDesc(graph, isVisit, top, n, stack);
        }
        return stb.toString().trim();
    }

    public void solution(boolean[][] graph, int start, int n){
        System.out.println(dfs(graph, start, n));
        System.out.println(bfs(graph, start, n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // node 갯수
        int m = Integer.parseInt(st.nextToken());  // 연결 관계
        int start = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n+1][n+1];  // 연결 관계를 나타내는 그래프

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1][node2] = true;
            graph[node2][node1] = true;    // 양방향 연결
        }

        DFS와_BFS sol = new DFS와_BFS();
        sol.solution(graph, start, n);
    }
}