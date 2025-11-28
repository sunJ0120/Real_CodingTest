import java.util.*;
import java.lang.*;
import java.io.*;

public class 색종이{
    public static final int max = 100;

    public static int put(boolean[][] field, int x, int y){
        int ans = 0;
        for(int i = y; i< y+10; i++){
            for(int j = x; j< x+10; j++){
                if(!field[i][j]){
                    field[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[][] field = new boolean[max][max];
        int ans = 0;

        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ans += put(field, x, y);
        }

        System.out.println(ans);
    }
}