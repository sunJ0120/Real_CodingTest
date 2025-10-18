import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 크레인_인형_뽑기 {
    public static void main(String[] args) {
        크레인_인형_뽑기 sol = new 크레인_인형_뽑기();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(sol.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 1. 열 하나하나를 스택으로 만든다.
        List<ArrayDeque<Integer>> crain = new ArrayList<ArrayDeque<Integer>>();
        ArrayDeque<Integer> bucket = new ArrayDeque<Integer>();

        for (int m = 0; m < board[0].length; m++) {
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
            for (int n = board.length - 1; n >= 0; n--) {
                if (board[n][m] == 0) {
                    break;
                }
                stack.push(board[n][m]);
            }
            crain.add(stack);
        }
        // 2. 위치에 맞게 pop으로 가져온다. (거꾸로)
        for (int move : moves) {
            // 3. 위치에 따라 (-1해서 인덱스 맞추기) 가져오면서 맞춰본다.
            ArrayDeque<Integer> stack = crain.get(move - 1);
            // System.out.println(stack.toString());
            if (stack.isEmpty()) {
                continue;
            }
            int doll = stack.pop();
            // System.out.println("doll : " + doll);
            // System.out.println("bucket.peek() : " + bucket.peek());
            if (!bucket.isEmpty() && bucket.peek() == doll) {
                // 4. 터지면 두개씩 증가
                answer += 2;
                bucket.pop();
            } else {
                bucket.push(doll);
            }
        }
        return answer;
    }
}