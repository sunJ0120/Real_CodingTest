package 크레인_인형뽑기_게임;

import java.util.ArrayDeque;
import java.util.Deque;

public class 크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 1. 스택 정의하기
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // 2. 깊이 배열 정의하기
        int[] depth = new int[board[0].length];

        // 3. 높이 저장하기
        for (int j = 0; j < board[0].length; j++) { //렬
            for (int i = 0; i < board.length; i++) { //행
                if (board[i][j] == 0) {
                    depth[j]++;
                } else {
                    break;
                }
            }
        }

        // 4. moves를 열로 하면서 맨 위에서부터 하나씩 빼기
        for (int move : moves) {
            if (depth[move - 1] >= board.length) {
                continue;
            }

            int dolls = board[depth[move - 1]][move - 1];
            depth[move - 1]++; // 깊이는 항상 증가

            if (stack.isEmpty() || stack.peek() != dolls) {
                stack.push(dolls);
                continue;
            } else {
                // 5. 스택의 top과 같은지 보고 빼기
                stack.pop();
                answer += 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        크레인_인형뽑기_게임 sol = new 크레인_인형뽑기_게임();
        int[][] solution = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(sol.solution(solution, moves));
    }
}
