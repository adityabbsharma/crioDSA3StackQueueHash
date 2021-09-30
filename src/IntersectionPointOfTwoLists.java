/*
*   INTERSECTION POINT OF 2 LISTS
* Problem Description
There are 2 LLs, and they intersect at a node N, after which they merge into 1 list.

Write a program to find the node at which the intersection of two singly linked lists begins.

Note :

If the two linked lists have no intersection at all, return null.

The linked lists must retain their original structure after the function returns.

You may assume there are no cycles anywhere in the entire linked structure.

Your code should preferably run in O(M + N) time where M and N are the lengths of given lists and use only O(1) memory.

Input format
There are 6 lines of input.

First line contains N - An integer denoting the number of elements before the intersection point in the first list.

Next line contains N integers representing the node values of the first LL before the intersection point.

Next line contains M - An integer denoting the number of elements before the intersection point in the second list.

M integers follow where jth integer denotes the jth node value in the linked list.

Next line contains P - An integer denoting the number of elements after the intersection point.

Next line contains P integers - the node values after and including the intersection point of the LL.


Note that the input accepts all these values, but you’ll have access only to the two heads, which you’ll have to make use of.

Output format
Return the intersection node of the lists.

Function Definition
You have to complete the given function. It accepts two arguments - the heads of each LL. You have to return a pointer to the intersection node of the two LLs.

Constraints
0 <= N <= 10^5

-10^9 <= value <= 10^9

0 <= M <= 10^5

-10^9 <= value <= 10^9

0 <= P <= 10^5

-10^9 <= value <= 10^9

Sample Input 1
3

3 1 7

2

2 6

3

9 15 7

Sample Output 1
9
* The value of the element at the intersection point of the two lists is 9.

Sample Input 2
5

1 2 3 4 5

5

6 7 8 9 10

0

Sample Output 2
Null

Explanation 2
The two lists don’t intersect, return Null.
* */

import java.util.HashMap;
import java.util.HashSet;
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
public class IntersectionPointOfTwoLists {
    public static ListNode listIntersectionPoint(ListNode head1, ListNode head2) {
        int sizeOfHead1 = sizeOfLinkedList(head1);
        int sizeOfHead2 = sizeOfLinkedList(head2);
        ListNode ansNode=null;
        if(sizeOfHead1>sizeOfHead2){
            int diff = sizeOfHead1 - sizeOfHead2;
            ListNode temp1 = head1;
            ListNode temp2 = head2;
            while(diff-->0){
                temp1 = temp1.next;
            }
            while(temp1!=null && temp2!=null){
                if(temp1.val!=temp2.val){
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                else{
                    ansNode = temp1;
                    break;
                }
            }
        }
        else{
            int diff = sizeOfHead2 - sizeOfHead1;
            ListNode temp1 = head1;
            ListNode temp2 = head2;
            if(sizeOfHead1==sizeOfHead2){
                return head1;
            }
            while(diff-->0){
                temp2 = temp2.next;
            }
            while(temp1!=null && temp2!=null){
                if(temp1.val!=temp2.val){
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                else{
                    ansNode = temp2;
                    break;
                }
            }
        }

        return ansNode;
    }

    public static int sizeOfLinkedList(ListNode head){
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
        return lengthOfList;
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
        ListNode start1 = new ListNode(3);
        start1.next = new ListNode(1);
        start1.next.next = new ListNode(7);
        start1.next.next.next = new ListNode(9);
        start1.next.next.next.next = new ListNode(15);
        start1.next.next.next.next.next = new ListNode(7);
        ListNode start2 = new ListNode(2);
        start2.next = new ListNode(6);
        start2.next.next = new ListNode(9);
        start2.next.next.next = new ListNode(15);
        start2.next.next.next.next = new ListNode(7);
        ListNode start3 = listIntersectionPoint(start1, start2);
        System.out.println("\nLinked list after sum :");
        System.out.println(start3.val);
       // printList(start3);
    }
}
