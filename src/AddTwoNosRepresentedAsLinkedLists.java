import org.ietf.jgss.GSSManager;

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
public class AddTwoNosRepresentedAsLinkedLists {

    public static ListNode sumLists1( ListNode head1 , ListNode head2) {
        int lengthOfHead1 = sizeOfLinkedList(head1);
        int lengthOfHead2 = sizeOfLinkedList(head2);
        if(lengthOfHead1==lengthOfHead2){
            ListNode reversedHead1 = reverseLinkedList(head1);
            ListNode reversedHead2 = reverseLinkedList(head2);
            head1 = reversedHead1;
            head2 = reversedHead2;
            ListNode sumHead = new ListNode(0) ;
            int carry=0;
            if(head1!=null && head2!=null){
                sumHead.val = head1.val + head2.val;
                if(sumHead.val>9){
                    carry = 1;
                    sumHead.val = sumHead.val -10;
                }
                else{
                    carry = 0;
                }
            }
            ListNode sumHead1 = sumHead;
            head1 = head1.next;
            head2 = head2.next;
            recursiveHelper1(head1,head2,sumHead,carry);
            return reverseLinkedList(sumHead1);
        }
        else{
            if(lengthOfHead1>lengthOfHead2){
                ListNode reversedHead1 = reverseLinkedList(head1);
                ListNode reversedHead2 = reverseLinkedList(head2);
                head1 = reversedHead1;
                head2 = reversedHead2;
                ListNode sumHead = new ListNode(0) ;
                int carry=0;
                if(head1!=null && head2!=null){
                    sumHead.val = head1.val + head2.val;
                    if(sumHead.val>9){
                        carry = 1;
                        sumHead.val = sumHead.val -10;
                    }
                    else{
                        carry = 0;
                    }
                }
                ListNode sumHead1 = sumHead;
                head1 = head1.next;
                head2 = head2.next;
                int smallLength = lengthOfHead2-1;
                recursiveHelper2(head1,head2,sumHead,carry,smallLength);
                return reverseLinkedList(sumHead1);
            }
            else{
                ListNode reversedHead1 = reverseLinkedList(head1);
                ListNode reversedHead2 = reverseLinkedList(head2);
                head1 = reversedHead2;
                head2 = reversedHead1;
                ListNode sumHead = new ListNode(0) ;
                int carry=0;
                if(head1!=null && head2!=null){
                    sumHead.val = head1.val + head2.val;
                    if(sumHead.val>9){
                        carry = 1;
                        sumHead.val = sumHead.val -10;
                    }
                    else{
                        carry = 0;
                    }
                }
                ListNode sumHead1 = sumHead;
                head1 = head1.next;
                head2 = head2.next;
                int smallLength = lengthOfHead1-1;
                recursiveHelper2(head1,head2,sumHead,carry,smallLength);
                return reverseLinkedList(sumHead1);
            }
        }


    }
    public static ListNode reverseLinkedList(ListNode head){
        if(head==null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
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
        node.next= null;
        return head;
    }
    public static void recursiveHelper1(ListNode head1,ListNode head2,ListNode sumHead,int carry){

        if(head1==null || head2==null){
            if(carry==0)
                sumHead.next = null;
            else{
                ListNode temp = new ListNode(1);
                sumHead.next = temp;
                sumHead.next.next = null;
            }
        }
        if(head1!=null && head2!=null){
            int sum = head1.val + head2.val + carry;
            if(sum>9){
                carry = 1;
                sum = sum -10;
                ListNode temp = new ListNode(sum);
                sumHead.next = temp;
            }
            else{
                carry = 0;
                ListNode temp = new ListNode(sum);
                sumHead.next = temp;
            }
            head1 = head1.next;
            head2 = head2.next;
            sumHead = sumHead.next;
            recursiveHelper1(head1,head2,sumHead,carry);
        }
    }
    public static void recursiveHelper2(ListNode head1,ListNode head2,ListNode sumHead,int carry,int smallHead){
//head1 will always be large length one
        if(smallHead==0){
            if(carry==0)
                sumHead.next = head1;
            else{
                if(head1==null){
                    sumHead.next = new ListNode(1);
                    sumHead.next.next = null;
                    return;
                }
                int sum = carry + head1.val;
                if(sum<10){
                    ListNode temp = new ListNode(1+head1.val);
                    sumHead.next = temp;
                    sumHead.next.next = head1.next;
                }
                else{
                    carry = 1;
                    sum = sum -10;
                    ListNode temp = new ListNode(sum);
                    sumHead.next = temp;
                    head1 = head1.next;
                   // head2 = head2.next;
                    sumHead = sumHead.next;
                    recursiveHelper2(head1,head2,sumHead,carry,smallHead);
                }

            }
        }
        else{
            int sum = head1.val + head2.val + carry;
            if(sum>9){
                carry = 1;
                sum = sum -10;
                ListNode temp = new ListNode(sum);
                sumHead.next = temp;
            }
            else{
                carry = 0;
                ListNode temp = new ListNode(sum);
                sumHead.next = temp;
            }
            head1 = head1.next;
            head2 = head2.next;
            sumHead = sumHead.next;
            recursiveHelper2(head1,head2,sumHead,carry,smallHead-1);
        }
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
            ListNode start1 = new ListNode(1);
//            start1.next = new ListNode(5);
//            start1.next.next = new ListNode(5);
            ListNode start2 = new ListNode(9);
            start2.next = new ListNode(9);
            start2.next.next = new ListNode(9);
            ListNode start3 = sumLists1(start1, start2);
            System.out.println("\nLinked list after sum :");
            printList(start3);
        }
}

