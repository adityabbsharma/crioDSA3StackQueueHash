/*
* Remove Duplicates from a linked list
* Problem Description
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the head of the updated linked list. Note that the final list should also be sorted as well.

Input format
First-line contains N, the number of elements in the linked list.

The next line contains N space-separated integers, elements of the linked list.

Output format
Print the linked list after removing duplicates.

Constraints
0 <= N <= 10^5

-10^9 <= value <= 10^9

Sample Input 1
5

1 2 2 3 3

Sample Output 1
1

Explanation 1
The numbers 2 and 3 had duplicates, they have been removed.

Sample Input 2
5

4 4 6 6 6

Sample Output 2
Null

Explanation 2
Both the numbers 4 and 6 have duplicates. Removing them leaves an empty list.
*
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
public class LinkedListRemoveDuplicates {
    public static ListNode removeDuplicatesFromList(ListNode head) {
//        HashMap<Integer,Integer> hMap = new HashMap<>();
//        ListNode node = head;
//        ListNode  prev = node;
//        while(node!=null){
//            hMap.put(node.val,hMap.getOrDefault(node.val,0)+1);
//            node= node.next;
//        }
//        if(hMap.size()==1){
//            for(Integer i:hMap.keySet())
//                if(hMap.get(i)>1)
//                    return null;
//        }
//        node = head;
//        ListNode node1=node;
//        while(node!=null){
//            if(hMap.get(node.val)==1){
//                prev = node;
//                node= node.next;
//            }
//            else{
//                node1 = node;
//                while(hMap.get(node1.val)!=1){
//                    node1 = node1.next;
//                    if(node1==null){
//                        prev.next=null;
//                        return head;
//                    }
//                }
//                assert prev != null;
//                prev.next = node1;
//                node = node1;
//                prev = node;
//            }
//        }
//        return head;
        //HashMap<Integer,ListNode> hMap = new HashMap<>();
        if(head==null)
            return null;
        HashSet<Integer> hSet = new HashSet<>();
        ListNode node = head;
        ListNode prev = node;
        HashSet<Integer> hSet2 = new HashSet<>();
        hSet.add(node.val);
        node = node.next;
        while(node != null){
            if(hSet.contains(node.val)){
                hSet2.add(node.val);
                node = node.next;
                prev.next = node;
            }
            else{
                hSet.add(node.val);
                prev= node;
                node = node.next;
            }
        }
        //System.out.println("hSet="+hSet);
        //System.out.println("hSet2="+hSet2);
        ListNode node1 = head;
        ListNode prev1 = node1;
        while(node1 != null){
            if(hSet2.contains(node1.val)){
                node1 = node1.next;
                prev1.next = node1;
            }
            else{
                prev1= node1;
                node1 = node1.next;
            }
        }
        //System.out.println("head.val="+head.val);
        if(hSet2.contains(head.val)){
            return head.next;
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
        LinkedListRemoveDuplicates linkedListRemoveDuplicates = new LinkedListRemoveDuplicates();
        ListNode start = new ListNode(1);
//        start.next = new ListNode(1);
//        start.next.next = new ListNode(1);
//        start.next.next.next = new ListNode(1);
//        start.next.next.next.next = new ListNode(1);
//        start.next.next.next.next.next = new ListNode(1);
//        start.next.next.next.next.next.next = new ListNode(1);
        System.out.println("Linked list before removing duplicates :");
        printList(start);

        ListNode start2 = removeDuplicatesFromList(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start2);
    }

}
