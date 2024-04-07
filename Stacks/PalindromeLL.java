import java.util.Stack;

public class PalindromeLL {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static boolean isPalin(Node head) {
        Node temp = head;
        boolean isPalin = true;
        Stack<Integer> s = new Stack<>();

        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        while (head != null) {
            int i = s.pop();
            if (head.data == i) {
                isPalin = true;
            } else {
                isPalin = false;
                break;
            }

            head = head.next;
        }

        return isPalin;
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        if (isPalin(head)) {
            System.out.println("Given Linked List is Palindrome");
        } else {
            System.out.println("Given Linked List is not Palindrome");
        }
    }
}
