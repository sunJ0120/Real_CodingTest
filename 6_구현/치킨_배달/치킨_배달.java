import java.util.*;
import java.lang.*;
import java.io.*;

public class 치킨_배달{
    public static int answer = Integer.MAX_VALUE;

    public static int direct(List<int[]> chooses, List<int[]> houses, int[][] map, int n){
        int ans = 0;

        for(int[] house : houses){   // 1이면 가장 가까운 치킨 거리를 구해야 한다.
            int minn = Integer.MAX_VALUE;
            for(int[] choose : chooses){   // 1이면 가장 가까운 치킨 거리를 구해야 한다.
                int dir = Math.abs(house[1] - choose[1]) + Math.abs(house[0]  - choose[0]);
                minn = Math.min(minn, dir);
            }
            ans += minn;
        }

        return ans;
    }

    public static void choose(List<int[]> chickens, List<int[]> houses, int[][] map,
                              int n, int m, int start, List<int[]> chooses){
        if(chooses.size() == m){
            answer = Math.min(answer,direct(chooses, houses, map, n));
            return;
        }

        for(int i = start; i<chickens.size(); i++){
            chooses.add(chickens.get(i));
            choose(chickens, houses, map, n, m, i+1, chooses);
            chooses.remove(chooses.size()-1);    // 백트래킹, 새로운 가지를 넣기 위함
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 최대 치킨집

        int[][] map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> chickens = new ArrayList<int[]>();
        List<int[]> houses = new ArrayList<int[]>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 2){
                    chickens.add(new int[]{j, i});
                }else if(map[i][j] == 1){
                    houses.add(new int[]{j, i});
                }
            }
        }

        choose(chickens, houses, map, n, m, 0, new ArrayList<int[]>());

        System.out.println(answer);
    }
}