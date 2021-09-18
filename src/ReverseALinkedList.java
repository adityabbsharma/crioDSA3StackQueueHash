/*
* Reverse a Linked List
* */
import java.util.*;

class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ReverseALinkedList {
    public static ListNode reverseLinkedList(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        if(head==null)
            return null;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        head = stack.pop();
        node = head;
        while(!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        node.next= null;
        return head;
    }
    static void printList(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        //LinkedListRemoveDuplicates linkedListRemoveDuplicates = new LinkedListRemoveDuplicates();
        ListNode start = new ListNode(10);
        start.next = new ListNode(12);
        start.next.next = new ListNode(11);
        start.next.next.next = new ListNode(11);
        start.next.next.next.next = new ListNode(12);
        start.next.next.next.next.next = new ListNode(11);
        start.next.next.next.next.next.next = new ListNode(10);
        System.out.println("Linked list before reversing:");
        printList(start);

        ListNode start1 = reverseLinkedList(start);

        System.out.println("\nLinked list after reversing :");
        printList(start1);
    }

}
