/*
1. yellow의 배수들을 구한다. 배수는 1부터 나눠 떨어지는 것을 묶는다.
2. 여기서 이제 (yellow의 가로 + 2) * (yellow의 세로 + 2) - yello 넓이 == 주어진 brown 갯수인지 본다.
3. 맞다면, 긴 변을 첫번째로 저장해서 배열로 내보낸다.
*/

import java.util.Arrays;

class 카펫 {
    public boolean isCarpet(int brown, int yellowWidth, int yelloHeight){
        int yellow = yellowWidth * yelloHeight;
        return ((yellowWidth + 2) * (yelloHeight + 2)) == (yellow + brown);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i<= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                int yelloHeight = i;
                int yellowWidth = yellow / i;

                if(isCarpet(brown, yellowWidth, yelloHeight)){
                    return new int[]{yellowWidth + 2, yelloHeight + 2};
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        카펫 sol = new 카펫();
        int brown = 24;
        int yellow = 24;
        int[] result = sol.solution(brown, yellow);
        System.out.println(Arrays.toString(result));
    }
}