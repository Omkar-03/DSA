import java.util.Stack;

public class directory {

    public static String simplify(String A) {
        Stack<String> s = new Stack<>();
        String res = "";
        res += "/";
        int len_A = A.length();

        for (int i = 0; i < len_A; i++) {
            String dir = "";

            while (i < len_A && A.charAt(i) == '/') {
                i++;
            }

            while (i < len_A && A.charAt(i) != '/') {
                dir += A.charAt(i);
                i++;
            }

            if (dir.equals("..") == true) {
                if (!s.empty()) {
                    s.pop();
                }
            } else if (dir.equals(".") == true) {
                continue;
            } else if (dir.length() != 0) {
                s.push(dir);
            }
        }

        Stack<String> s1 = new Stack<>();

        while (!s.empty()) {
            s1.push(s.pop());
        }

        while (!s1.empty()) {
            if (s1.size() != 1) {
                res += s1.pop() + "/";
            } else {
                res += s1.pop();
            }
        }

        return res;
    }

    public static void main(String args[]) {
        String str = new String("/a/./b/../.././omkar");
        String res = simplify(str);
        System.out.println(res);
    }
}