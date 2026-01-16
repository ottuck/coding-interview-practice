// LeetCode 20 ValidParentheses
package javalang.queuestack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 닫는 괄호인 경우
            if (map.containsKey(c)) {
                 // 스택이 비었거나 짝이 안 맞으면 실패
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
            // 여는 괄호인 경우
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    // -------------------------------------
    public static void main(String[] args) {
        String[] tests = {
            "(]",
            "{[()]}"
        };

        for (String test : tests) {
            System.out.println(test + " -> " + isValid(test));
        }
    }
}