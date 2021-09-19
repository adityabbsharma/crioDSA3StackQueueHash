/*
* Merge 2 sorted Linked Lists
* Problem Description
Given 2 sorted linked lists, merge them into a new sorted linked list and return head of the merged list. The new list should be made by splicing (adjusting the pointers) together the nodes of the first two lists.

Input format
N - An integer denoting the number of nodes in the linked list.

N integers follow where ith integer denotes the ith node value in the linked list

M - An integer denoting the number of nodes in the linked list.

M integers follow where jth integer denotes the jth node value in the linked list

Output format
Return the sorted list after splicing the nodes of the first two lists.

Constraints
0 <= N <= 10^5

-10^9 <= value <= 10^9

0 <= M <= 10^5

-10^9 <= value <= 10^9

Sample Input 1
3

1 2 4

3

1 3 4

Sample Output 1
1 1 2 3 4 4

Explanation 1
Merging the input lists and keeping the new list sorted results in this.

Sample Input 2
4

1 5 7 6

1

3

Sample Output 2
1 3 5 7 6

Explanation 2
Merging the input lists and keeping the new list sorted results in this.
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
public class MergeTwoSortedLinkedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head,newListNode;
        if(l1.val< l2.val){
            newListNode = l1;
            l1=l1.next;
            head = newListNode;
        }
        else{
            newListNode = l2;
            l2=l2.next;
            head = newListNode;
        }

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                newListNode.next = l1;
                l1 = l1.next;
            }
            else{
                newListNode.next = l2;
                l2 = l2.next;
            }
            newListNode = newListNode.next;
        }
        while(l1!=null){
            newListNode.next = l1;
            l1= l1.next;
            newListNode = newListNode.next;
        }
        while(l2!=null){
            newListNode.next = l2;
            l2= l2.next;
            newListNode = newListNode.next;
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
//        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(8);
//        start.next.next.next.next = new ListNode(10);
//        start.next.next.next.next.next = new ListNode(2);
//        start.next.next.next.next.next.next = new ListNode(1);
//        start.next.next.next.next.next.next.next = new ListNode(8);
//        start.next.next.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Linked list original");
        printList(l1);
        printList(l2);

        ListNode start1 = mergeTwoLists(l1,l2);

        System.out.println("\nLinked list after reversing :");
        printList(start1);
    }

}
