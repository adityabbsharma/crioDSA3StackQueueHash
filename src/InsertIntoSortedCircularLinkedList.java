/*
* Insert into Sorted Circular Linked List
* Problem Description
Given a pointer to a node in a sorted circular singly linked list( sorted in ascending order),
* write a function to insert a value K into the list such that the linked list still remains a
* sorted circular list.


Note1: If the given pointer is null i.e. empty list, create a circular list with a new node and
* return the reference to the new node. Otherwise,return the initial input pointer given.


Note2: The list could have duplicate values. You can insert the new value in any place which
* will keep the list sorted.

Input Format
First line contains N, the number of nodes in the linked list.

The next line contains N space-separated integers, representing the nodes of the circular linked list.

The last line contains a single integer K, denoting the value that is to be inserted.

Output Format
Return the original pointer given as an argument, after modifying the list by inserting the value.
* The output prints the modified linked list starting from the returned node.

Constraints
0 <= N <= 10^5

0 <= value <= 10^9

0 <= K <= 10^9

Sample Input 1
7

4 5 9 10 0 1 2

7

Sample Output 1
4 5 7 9 10 0 1 2

Explanation 1
The input is a sorted circular linked list and the given pointer is a reference to node [4].
* A new node with [7] has to be inserted between [5] and [9] for the list to remain sorted.
* Return node [4] which is the input pointer given.

Sample Input 2
0

4

Sample Output 2
4

Explanation 2
The input is a sorted circular linked list which is empty. Create a circular linked list with
* a new node [4] and return the new node.
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
public class InsertIntoSortedCircularLinkedList {
    public static ListNode insertIntoSortedCircularList(ListNode head,int insertVal) {
        ListNode node = head;
        ListNode nodeToBeInserted = new ListNode(insertVal);
        if(node == null){
            head = nodeToBeInserted;
            nodeToBeInserted.next = nodeToBeInserted;
        }
        else if(node.next==node){
            if(insertVal>node.val){
                node.next = nodeToBeInserted;
                nodeToBeInserted.next = node;
            }
            else{
                nodeToBeInserted.next = node;
                node.next = nodeToBeInserted;
                head = nodeToBeInserted;
            }
        }
        else{
            while(node.val<node.next.val){
                node = node.next;
            }
            while(node.val==node.next.val){
                node = node.next;
            }
            head = node.next;
            if(insertVal<node.next.val){
                nodeToBeInserted.next = node.next;
                node.next = nodeToBeInserted;
                head = nodeToBeInserted;
            }
            else{
                node = node.next;
                while(node.next.val<insertVal && node.next!=head){
                    node = node.next;
                }
                if(node.next==head){
                    nodeToBeInserted.next = head;
                    node.next = nodeToBeInserted;
                }
                else{
                    nodeToBeInserted.next = node.next;
                    node.next = nodeToBeInserted;
                }
            }

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
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
//        start.next.next = start;
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);
        start.next.next.next.next.next = start;
//        start.next.next.next.next.next = new ListNode(1);
//        start.next.next.next.next.next.next = new ListNode(2);
        //start.next.next.next.next.next.next.next = start;
        System.out.println("Linked list before moving middle node to head:");
        //printList(start);

        ListNode start1 = insertIntoSortedCircularList(start,0);

        System.out.println("\nLinked list after reversing :");
        printList(start1);
    }

}
