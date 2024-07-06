package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MultipleBracket {

    public static void main(String[] args) {
        System.out.println(brackets("(coder)[byte)]"));
        System.out.println(brackets("(c([od]er))b(yt[e])"));
    }

    private static String brackets(String str) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : str.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if (')' == c || ']' == c) {
                if (stack.empty()) {
                    return "0";
                }
                char cs = stack.pop();
                if ((')' == c && cs != ')') || (']' == c && cs != ']')) {
                    return "0";
                }
                count += 1;

            }
        }
        if (!stack.empty()) {
            return "0";
        }
        System.out.println("Stack: " + stack);
        return count > 0 ? "1 " + count : "1";
    }
}
