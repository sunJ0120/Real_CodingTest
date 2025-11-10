import java.util.Arrays;

class 이진_변환_반복하기 {
    public static final int binary = 2;

    public String changeBinary(int length) {
        StringBuilder stb = new StringBuilder();
        // 1. 몫이 나누는 수보다 더 작다면 끝낸다.
        while (length >= binary) {
            // 2. 나머지를 올리고, 수는 계속 나눈다.
            stb.append(length % binary);
            length /= binary;
        }
        // 3. 마지막에 몫을 올린다.
        stb.append(length);

        return stb.reverse().toString();
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int binaryCnt = 0;

        // 4. 이 과정을 s가 1이 될때까지 반복
        while (!("1".equals(s))) {
            int preLen = s.length();
            // 1. replace로 0을 제거한다.
            s = s.replace("0", "");
            // 2. 이전 length()와 비교해서 0을 누적한다.
            zeroCnt += preLen - s.length();
            // 3. 이진 변환한다
            s = changeBinary(s.length());
            binaryCnt++;
        }

        answer[0] = binaryCnt;
        answer[1] = zeroCnt;

        return answer;
    }

    public static void main(String[] args) {
        이진_변환_반복하기 sol = new 이진_변환_반복하기();
        String s = "110010101001";
        int[] result = sol.solution(s);
        System.out.println(Arrays.toString(result));
    }
}