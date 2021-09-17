/*
* Remove duplicates from linked list
* Problem Description
Given a linked list(need not be sorted) with duplicates, remove all duplicates, such that only the first occurrence of each element must remain in the LL, and return the head.

Input format
There are 2 lines of input

First-line contains N, the number of elements in the linked list.

The next line contains N space-separated integers, elements of the linked list.

Output format
Print the linked list after removing duplicates. Only the first occurrence of an element should be present in the list.

Function definition
The function you have to complete accepts the head as an argument. You will make the necessary changes, and return the head.

Sample Input 1
5

1 2 2 3 3

Sample Output 1
1 2 3

Explanation 1
Node 2 and 3 have 2 occurrences each.

Sample Input 2
5

3 1 3 1 4

Sample Output 2
3 1 4

Explanation 1
The first occurrence of nodes 3 and 1 remains in the list and 4 has no duplicates.

Constraints
0 <= Number of nodes <= 105

-109 <= ListNode.val <= 109
* */
import java.io.*;
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
public class Removeduplicateskeepfirst {
    public static ListNode removeDuplicatesFromList(ListNode head) {
        HashMap<Integer,ListNode> hMap = new HashMap<>();
        HashSet<Integer> hSet = new HashSet<>();
        ListNode node = head;
        ListNode prev = node;
//        hSet.add(node.val);
//        node = node.next;
        //hMap.put(node.val,prev);
        while(node != null){
            if(hSet.contains(node.val)){
                node = node.next;
                prev.next = node;
            }
            else{
                hSet.add(node.val);
                prev= node;
                node = node.next;
            }
        }
        return head;
    }
    /*
    * Linked list before removing duplicates:
 10 12 11 11 12 11 10
Linked list after removing duplicates:
 10 12 11
    * */
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
        System.out.println("Linked list before removing duplicates :");
        printList(start);

        ListNode start1 = removeDuplicatesFromList(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start1);
    }
}
