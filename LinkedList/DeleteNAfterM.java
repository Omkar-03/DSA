public class DeleteNAfterM{

    public static class Node{
        int data; 
        Node next;
    }

    public static Node push(Node head_ref, int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head_ref;
        head_ref = newNode;
        return head_ref;
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

    public static void skipMdeleteN(Node head, int m, int n)
    {
        Node curr = head, t;
        int count;

        while(curr!=null)
        {
            for(count=1; count<m && curr !=null; count++)
            {
                curr=curr.next;
            }

            if(curr == null)
            {
                return;
            }

            t = curr.next;
            for(count=1; count<=n && t!=null; count++)
            {
                t=t.next;
            }
            curr.next = t;
            curr=t;
        }
    }

    public static void main(String args[])
    {
        Node head = null;
        int m = 2, n=1;

        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        System.out.println("m = "+m+" n = "+n+"\nOriginal Linked List: \n");
        printList(head);

        skipMdeleteN(head, m, n);
        System.out.println("Linked List on deletion: ");
        printList(head);
    }
}