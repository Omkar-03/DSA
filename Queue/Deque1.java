import java.util.*;

public class Deque1 {
    public static void main(String args[]) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        System.out.println(dq);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
        System.out.println("First element: " + dq.getFirst());
        System.out.println("Last element: " + dq.getLast());
    }
}
