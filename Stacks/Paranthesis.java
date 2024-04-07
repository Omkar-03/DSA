import java.util.Stack;

public class Paranthesis {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            } else {
                s.push(ch);
            }
        }

        return false;
    }

    public static void main(String args[]) {
        String str = "({})[]";
        // if (isValid(str)) {
        // System.out.println("Valid Paranthesis");
        // } else {
        // System.out.println("Invalid Paranthesis");
        // }

        String str1 = "(a+b)(c)";
        String str2 = "((a+b)(c))";
        if (isDuplicate(str2)) {
            System.out.println("Duplicate Paranthesis");
        } else {
            System.out.println("No Duplicate Paranthesis");
        }
    }
}
