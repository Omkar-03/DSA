public class Intersection {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getIntersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (head2 == temp) {
                    return temp;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String args[]) {
        Node head1, head2;
        head1 = new Node(10);
        head2 = new Node(3);

        Node newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30);
        head1.next.next = newNode;

        head1.next.next.next = null;
        head2.next.next.next.next = null;

        Node intersectionPoint = getIntersectionNode(head1, head2);

        if (intersectionPoint == null) {
            System.out.println("No Intersection Point !!!");
        } else {
            System.out.println("Intersection Point: " + intersectionPoint.data);
        }
    }
}