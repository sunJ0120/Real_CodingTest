package 방문_길이;

import java.lang.*;
import java.util.*;

public class 방문_길이 {
    // 방향을 저장하기 위한 map
    private static final HashMap<Character, int[]> location = new HashMap<Character, int[]>();
    //location을 저장한 HashMap을 init 하기 위함.
    public static void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }

    public int solution(String dirs) {
        initLocation(); //초기화
        StringBuilder stb = new StringBuilder();
        HashSet<String> answer = new HashSet<>(); // 이동 좌표를 저장하기 위한 set

        int x = 5;
        int y = 5;

        for(int i = 0; i<dirs.length(); i++){
            int dirX = x + location.get(dirs.charAt(i))[0];
            int dirY = y + location.get(dirs.charAt(i))[1];

            if(!isTrue(dirX, dirY)){
                continue; // 넘을 경우 무시
            }
            stb.append(x).append(">").append(dirX).append(", ")
                    .append(y).append(">").append(dirY);
            answer.add(new String(stb));
            stb.setLength(0); //비우기

            stb.append(dirX).append(">").append(x).append(", ")
                    .append(dirY).append(">").append(y);
            answer.add(new String(stb)); //방향성이 없으므로 반대도 넣어준다.
            stb.setLength(0); //비우기

            x = dirX;
            y = dirY;
        }

        return (answer.size())/2;
    }

    public boolean isTrue(int x, int y){
        if(x >= 0 && x <= 10 && y >= 0 && y <= 10){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        방문_길이 sol = new 방문_길이();
        String dirs = "ULURRDLLU";
        System.out.println(sol.solution(dirs));
    }
}
