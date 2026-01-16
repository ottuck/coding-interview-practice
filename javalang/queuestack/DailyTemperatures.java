// LeetCode 739 DailyTemperatures
package javalang.queuestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i); // 다음 날자가 더 안 따뜻할때
        }
        return answer;
    }

    // ---------------------------------------
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(result));
        // 기대 출력: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
