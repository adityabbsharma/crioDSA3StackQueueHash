/*
*Make Middle Node head of the list
* Problem Description
Given a singly linked list, find the middle node of the linked list and move that node to the head of the list. Return the head of the list. In the case of a list with an even number of nodes, use the second middle one.

Input format
There are 2 lines of input

N - An integer denoting the number of nodes in the linked list.

N integers follow where ith integer denotes the ith node value in the linked list

Output format
Return the head of the modified list after moving the middle node to head.

Constraints
0 <= N<= 10^5

-10^9 <= value <= 10^9

Sample Input 1
6

2 3 4 5 6 7

Sample Output 1
5 2 3 4 6 7

Explanation 1
The middle node here is [5]. Moving that to the head of the list gives us the output shown.

Sample Input 2
5

1 2 3 4 5

Sample Output 2
3 1 2 4 5

Explanation 2
The middle node here is [3]. Moving that to the head of the list gives us the output shown.
* */
class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class MakeMiddleNodeHeadLinkedList {
    public static ListNode moveMiddleToHead(ListNode head) {
        int middleCount=0;
        ListNode node = head;
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        while(node!=null){
            middleCount++;
            node = node.next;
        }
        middleCount = middleCount/2;
        int count =1;
        node = head;
        while(true){
            if(count==middleCount){
                ListNode temp = head;
                head = node.next;
                node.next = node.next.next;
                head.next = temp;
                break;
            }
            count++;
            node = node.next;
        }

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
//        start.next.next = new ListNode(11);
//        start.next.next.next = new ListNode(9);
//        start.next.next.next.next = new ListNode(12);
//        start.next.next.next.next.next = new ListNode(11);
        //start.next.next.next.next.next.next = new ListNode(10);
        System.out.println("Linked list before moving middle node to head:");
        printList(start);

        ListNode start1 = moveMiddleToHead(start);

        System.out.println("\nLinked list after reversing :");
        printList(start1);
    }
}
