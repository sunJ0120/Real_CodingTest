import java.lang.*;
import java.util.*;
import java.io.*;

public class 자리배정{
    public static final int[] posX = {0,1,0,-1}; // 위 오른쪽 아래 왼쪽
    public static final int[] posY = {1,0,-1,0};
    public static int ans;
    public static int x;
    public static int y;

    public static boolean pos(int dir, int gallery, int end){
        for(int i = 0; i<end; i++){
            x += posX[dir];
            y += posY[dir];
            ans++;

            if(ans == gallery){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int gallery = Integer.parseInt(br.readLine());

        if(gallery > c*r){
            System.out.println(0);
            return;
        }

        ans = 0;
        x = 0;
        y = -1;

        while(true){
            if(pos(0, gallery, r)){
                break;
            }
            r--;

            if(pos(1, gallery, c-1)){
                break;
            }
            c--;

            if(pos(2, gallery, r)){
                break;
            }
            r--;

            if(pos(3, gallery, c-1)){
                break;
            }
            c--;
        }
        System.out.println((x+1) + " " + (y+1));
    }
}