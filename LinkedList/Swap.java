public class Swap{
    public static class Node{
        int data; 
        Node next;
        
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void swapNodes(int x, int y)
    {
        if(x==y)
        {
            return;
        }

        Node prevX = null, currX = head;
        while(currX!=null && currX.data !=x)
        {
            prevX=currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while(currY!=null && currY.data !=y)
        {
            prevY=currY;
            currY = currY.next;
        }

        if(currX==null || currY == null)
        {
            return;
        }

        if(prevX!=null)
        {
            prevX.next = currY;
        }
        else{
            head = currY;
        }

        if(prevY !=null)
        {
            prevY.next = currX;
        }
        else{
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public static void main(String args[])
    {
        push(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);
        
        System.out.println("Linked List before: ");
        printList(head);

        swapNodes(6, 3);
        System.out.println("Linked List after: ");
        printList(head);
    }
}