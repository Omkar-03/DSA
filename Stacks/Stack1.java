import java.util.*;

// Stack using ArrayLists
public class Stack1 {

    static ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        int top = list.get(list.size() - 1);
        return top;
    }

    public static void main(String args[]) {
        Stack1 s = new Stack1();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
