import java.util.*;
import java.io.*;
import java.lang.*;

public class 스타트와_링크{
    public static int minDiff = Integer.MAX_VALUE;

    public static int score(int[][] stats, int num, List<Integer> teams){
        int ans = 0;

        for(int i = 0; i<num/2; i++){
            int a = teams.get(i);
            for(int j = i+1; j<num/2; j++){
                int b = teams.get(j);
                ans += stats[b][a];
                ans += stats[a][b];
            }
        }

        return ans;
    }

    public static int difference(int[][] stats, int num, List<Integer> left){
        // 오른쪽 구하기
        List<Integer> right = new ArrayList<Integer>();
        for(int i = 0; i<num; i++){
            if(!left.contains(i)){
                right.add(i);
            }
        }
        // 오른쪽과 왼쪽의 차이 구하기
        int leftSum = score(stats, num, left);
        int rightSum = score(stats, num, right);

        return Math.abs(leftSum - rightSum);
    }

    public static void chooseTeam(int[][] stats, int num, int start, List<Integer> left){
        if(left.size() == num/2){    // left 사이즈가 n/2라서 팀이 꾸려 졌으면 계산식을 소환한다.
            minDiff = Math.min(difference(stats, num, left), minDiff);
            return;
        }

        // 왼쪽팀을 구한다.
        for(int i = start; i<num; i++){
            left.add(i);
            chooseTeam(stats, num, i+1, left);
            left.remove(left.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] stats = new int[num][num];
        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<num; j++){
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chooseTeam(stats, num, 0, new ArrayList<Integer>());
        System.out.println(minDiff);
    }
}