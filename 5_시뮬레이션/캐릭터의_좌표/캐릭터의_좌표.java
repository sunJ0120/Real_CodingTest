class 캐릭터의_좌표 {
    public static int xInd;
    public static int yInd;

    public void move(int moveX, int moveY, int[] answer){
        int nextX = answer[0] + moveX;
        int nextY = answer[1] + moveY;

        if(Math.abs(nextX) <= xInd &&  Math.abs(nextY) <= yInd){
            answer[0] = nextX;
            answer[1] = nextY;
        }
    }

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        xInd = board[0] / 2;
        yInd = board[1] / 2;

        for (String input : keyinput) {
            if ("left".equals(input)) {
                move(-1, 0, answer);
            } else if ("right".equals(input)) {
                move(1, 0, answer);
            } else if ("up".equals(input)) {
                move(0, 1, answer);
            } else {
                move(0, -1, answer);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        캐릭터의_좌표 sol = new 캐릭터의_좌표();
        String[] keyinput = { "left", "right", "up", "right", "right" };
        int[] board = { 11, 11 };
        int[] result = sol.solution(keyinput, board);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}