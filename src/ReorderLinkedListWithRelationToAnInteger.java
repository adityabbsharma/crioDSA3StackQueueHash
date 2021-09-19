//import java.util.LinkedList;
//import java.util.Queue;
//
///*
//* Reorder LinkedList With Relation To An Integer
//* Problem Description
//Given a linked list and an integer X, partition the LL around X, such that all nodes less than X come
//* before all nodes greater than X. If X is contained within the list, then those nodes need
//
//to be after the elements less than X and before the elements greater than X, i.e. they should appear
//* between the left and right partitions.
//
//
//You can also see if you can preserve the order for elements on either side of the partition. For instance,
//* for given LL 2, 6, 5, 7, 1 and X = 5, the answer should be 2, 1, 5, 6, 7 only, instead of 1, 2, 5, 6, 7.
//
//Input format
//N - An integer denoting the number of nodes in the linked list.
//
//N integers follow where ith integer denotes the ith node value in the linked list
//
//X - An integer denoting the value that you must use to partition the given list
//
//Output format
//Return the head after partitioning the list
//
//Constraints
//1 <= N <= 10^5
//
//-10^9 <= value, X <= 10^9
//
//Sample Input 1
//7
//
//3 5 8 5 10 2 1
//
//5
//
//Sample Output 1
//3 2 1 5 5 8 10
//
//Explanation 1
//The nodes [3], [1] and [2] are less than [5] so they are present before [8] and [10].
//
//There are also other possible answers for the same input.
//
//Sample Input 2
//5
//
//3 1 3 1 4
//
//2
//
//Sample Output 2
//1 1 4 3 3
//
//Explanation 2
//All nodes with values less than 2 come before all nodes with values greater than 2.
//* */
//class ListNode {
//
//    public int val;
//    public ListNode next;
//    ListNode() {}
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
//public class ReorderLinkedListWithRelationToAnInteger {
//    public static ListNode partition( ListNode head , int x) {
//        ListNode node = head;
//        Queue<ListNode> leftQ = new LinkedList<>();
//        Queue<ListNode> rightQ = new LinkedList<>();
//        Queue<ListNode> sameQ = new LinkedList<>();
//        while(node!=null){
//                if(node.val<x){
//                    ListNode temp = new ListNode(node.val);
//                    leftQ.add(temp);
//                }
//                else if(node.val>x){
//                    ListNode temp = new ListNode(node.val);
//                    rightQ.add(temp);
//                }
//                else{
//                    ListNode temp = new ListNode(x);
//                    sameQ.add(temp);
//                }
//                node = node.next;
//
//        }
//        if(!leftQ.isEmpty())
//            node = leftQ.remove();
//        else if(!sameQ.isEmpty())
//            node = sameQ.remove();
//        else
//            node = rightQ.remove();
//        head = node;
//        while(!leftQ.isEmpty()){
//            node.next = leftQ.remove();
//            node = node.next;
//        }
//        while(!sameQ.isEmpty()){
//            node.next = sameQ.remove();
//            node = node.next;
//        }
//        while(!rightQ.isEmpty()){
//            node.next = rightQ.remove();
//            node = node.next;
//        }
//        return head;
//
//    }
//    static void printList(ListNode head)
//    {
//        while (head != null)
//        {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//    }
//
//    public static void main(String[] args) {
//        //LinkedListRemoveDuplicates linkedListRemoveDuplicates = new LinkedListRemoveDuplicates();
//        ListNode start = new ListNode(3);
//        start.next = new ListNode(3);
//        start.next.next = new ListNode(3);
//        start.next.next.next = new ListNode(3);
////        start.next.next.next.next = new ListNode(10);
////        start.next.next.next.next.next = new ListNode(2);
////        start.next.next.next.next.next.next = new ListNode(1);
////        start.next.next.next.next.next.next.next = new ListNode(8);
////        start.next.next.next.next.next.next.next.next = new ListNode(6);
//
//        System.out.println("Linked list original");
//        printList(start);
//
//        ListNode start1 = partition(start,5);
//
//        System.out.println("\nLinked list after reversing :");
//        printList(start1);
//    }
//}
