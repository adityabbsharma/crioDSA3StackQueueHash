/*
* Delete kth node from end of the list
* Problem Description
Given a linked list, remove the Kth node from the end of the list and return its head.

Note: the given K will always be a valid node.

Input format
There are three lines of input

First line contains N, the number of nodes in the linked list

Second line contains N integers, denoting the values of the linked list

Third line contains K, the node to be deleted from the end.

Output format
Return the head of the LL after deleting the Kth node from the end.

Function definition
You have to complete the given function. It accepts two arguments - the head of the linked list, and k. You have to return the head of the LL after making the necessary change.

Constraints
1 <= N<= 10^5

-10^9 <= value <= 10^9

1 <= K <= N

Sample Input 1
5

1 5 2 4 3

2

Sample Output 1
1 5 2 3

Explanation 1
The 2nd node from the end is 4, removing which, gives us 1 5 2 3
* Sample Input 2
5

3 1 3 2 4

4

Sample Output 2
3 3 2 4

Explanation 2
The 4th node from the end is 1, removing which, gives us 3 3 2 4
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
public class DeleteKthFromLastInLinkedList {
    public static ListNode deleteKthToLast(ListNode head, int k) {
        if(head.next==null && k==1){
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int midCount =1;
        int c =0,d=0;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            if(fastPointer!=null)
                d++;
            slowPointer = slowPointer.next;
            midCount++;
            c++;
        }
        int lengthOfList;
        if(c!=d)
            lengthOfList = (midCount-1)*2;   // even no of nodes

        else
            lengthOfList = midCount*2 - 1;   // odd no of nodes


        if(k==lengthOfList)
            return head.next;

        if(lengthOfList-k > midCount){
            while(midCount++ < lengthOfList-k){
                slowPointer = slowPointer.next;
            }
            ListNode temp = slowPointer.next.next;
            slowPointer.next = temp;
            return head;
        }
        else{
            int count=1;
            ListNode node = head;
            while(count++<lengthOfList- k){
                node = node.next;
            }
            ListNode temp = node.next.next;
            node.next = temp;
            return head;
        }

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
        ListNode start = new ListNode(1);
        start.next = new ListNode(5);
        start.next.next = new ListNode(2);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(3);
//        start.next.next.next.next.next = new ListNode(6);
//        start.next.next.next.next.next.next = new ListNode(7);
//        start.next.next.next.next.next.next.next = new ListNode(8);
//        start.next.next.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Linked list original");
        printList(start);

        ListNode start1 = deleteKthToLast(start,3);

        System.out.println("\nLinked list after reversing :");
        printList(start1);
    }
}
