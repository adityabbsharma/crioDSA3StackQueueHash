/*
* Reverse Contiguous even elements
* Problem Description
Given a singly linked list of integers, reverse every contiguous set of nodes that have only even values.

Input format
N - An integer denoting the number of nodes in the linked list.

N integers follow where ith integer denotes the ith node value in the linked list

Output format
Return the head of the modified list

Constraints
0 <= N <= 10^5

-10^9 <= value <= 10^9

Sample Input 1
8

1 2 3 3 4 6 8 5

Sample Output 1
1 2 3 3 8 6 4 5

Explanation 1
There are two sublists of even elements, which [2] and [4->6->8]. The sublist [4->6->8] has been reversed and the single sublist [2] need not be reversed.

Sample Input 2
6

1 3 2 5 4 6

Sample Output 2
1 3 2 5 6 4

Explanation 2
There are two sublists of even elements which are [2] and [4 6]. The [4,6] sublist has been reversed and the single sublist [2] need not be reversed. Rest of the odd values remain constant.
* */

import java.util.LinkedList;
import java.util.Stack;

class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ReverseEvenElements {
    public static ListNode reverseEvenElements(ListNode head)
    {
        ListNode prev=null;
        ListNode next;
        ListNode node = head;
        LinkedList<ListNode> list;
        while(node!=null){
            if(prev==null&& node.val%2==0){
                ListNode next1 = node;
                ListNode next2 = new ListNode(node.val);
                ListNode tempFirst = next2;
                next1 = next1.next;
                while(next1!=null && next1.val%2==0){
                    ListNode next3 = new ListNode(next1.val);
                    next2.next = next3;
                    next2 = next2.next;
                    next1 = next1.next;
                }
                next2 = null;
                if(next1!=node){
                    list = reverseLinkedList(tempFirst);
                    head = list.get(0);
                    list.get(1).next = next1;
                    node = next1;
                }
                else{
                    prev = node;
                    node = node.next;
                }
            }
            else{
                if(node.val%2==0){
                    ListNode next1 = node;
                    ListNode next2 = new ListNode(node.val);
                    ListNode tempFirst = next2;
                    next1 = next1.next;
                    while(next1!=null && next1.val%2==0){
                        ListNode next3 = new ListNode(next1.val);
                        next2.next = next3;
                        next2 = next2.next;
                        next1 = next1.next;
                    }
                    next2 = null;
                    if(next1!=node){
                        list = reverseLinkedList(tempFirst);
                        prev.next = list.get(0);
                        list.get(1).next = next1;
                        node = next1;
                    }
                    else{
                        prev = node;
                        node = node.next;
                    }
                }
                else{
                    prev = node;
                    node = node.next;
                }
            }
        }
        return head;
    }
    public static LinkedList<ListNode> reverseLinkedList(ListNode head){
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
        LinkedList<ListNode> list = new LinkedList<>();
        list.add(head);
        list.add(node);
        return list;
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
        ListNode start = new ListNode(2);
        start.next = new ListNode(4);
        start.next.next = new ListNode(6);
        start.next.next.next = new ListNode(8);
        start.next.next.next.next = new ListNode(10);
        start.next.next.next.next.next = new ListNode(12);
        start.next.next.next.next.next.next = new ListNode(14);
        start.next.next.next.next.next.next.next = new ListNode(16);
        start.next.next.next.next.next.next.next.next = new ListNode(19);

        System.out.println("Linked list original");
        printList(start);

        ListNode start1 = reverseEvenElements(start);

        System.out.println("\nLinked list after reversing :");
        printList(start1);
    }
}
