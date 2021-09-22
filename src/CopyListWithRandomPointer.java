/*
* Create a copy of the given linked list
* Problem Description
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Input format:
Next line contains X space separated integers, elements of the linked list.

Next line contains X space separated integers, random pointers of each node in the linked list.

Output format
Return a deep copy of the list.

Sample Input 1
10 20

2 2

Sample Output 1
10 20

20 20

Explanation 1
========================

View of the Linked list

========================

{10.next} -> {20}

and

{20.next} -> {null}

{10.random} -> {20}

and

{20.random} -> {20}

Constraints
3 <= K <= N <= 105

|A[i]| <= 109
*
* */
import java.util.Scanner;
import java.util.*;
import java.lang.*;



class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};


class CopyListWithRandomPointer {


    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hMap = new HashMap<>();
        Node node = head;
        Node prev = head;
        Node copy = prev;
        hMap.put(prev,node);
        node = node.next;
        while(node!=null){
            Node temp = new Node();
            temp.val = node.val;
            prev.next = temp;
            hMap.put(temp,node);
            prev = temp;
            node = node.next;
        }
        for(Node temp:hMap.keySet()){
            temp.random = hMap.get(temp).random;
        }
        //System.out.println(head.val);
        return copy;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();

        for(int i = 0 ; i < n ;i++) {
            nums.add(scanner.nextInt());
        }

        List<String> random = new ArrayList<>();
        for(int i = 0 ; i < n ;i++) {
            random.add(scanner.next());
        }

        Node list = new Node().makeList(nums, random);
        Node clonedList = new CopyListWithRandomPointer().copyRandomList(list);

        if (clonedList != null) {
            clonedList.print(clonedList);
        }
    }
}
