class 이진_변환_반복하기 {
    public String binary(int len){
        StringBuilder stb = new StringBuilder();
        while(len > 0){
            stb.append(len % 2);
            len /= 2;
        }
        return stb.reverse().toString();
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int loop = 0;
        int zero = 0;

        while(!("1".equals(s))){
            String removedZero = s.replace("0","");
            int len = removedZero.length();

            zero += s.length() - len;
            s = binary(len);

            loop++;
        }
        answer[0] = loop;
        answer[1] = zero;

        return answer;
    }

    public static void main(String[] args) {
        이진_변환_반복하기 sol = new 이진_변환_반복하기();
        String s = "110010101001";
        int[] result = sol.solution(s);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}