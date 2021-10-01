import java.util.HashSet;

public class RemoveCycleFromLinkedList {
    public static boolean detectAndRemoveCycle(ListNode head){
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode prev = head;
        boolean cycleFlag=false;
        if(head.next==null)
            return false;
        while(fastPointer!=null && slowPointer!=null && fastPointer.next!=null){
            System.out.println("prev.val="+prev.val);
            prev = slowPointer;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(slowPointer==head){
                prev.next = null;
                return true;
            }
            if(fastPointer==slowPointer){
                cycleFlag = true;
                break;
            }
        }
        if(!cycleFlag)
            return false;
        else{
            HashSet<ListNode> hSet = new HashSet<>();
            ListNode prev1 =prev;
            int count=0;
            while(true){
                if(hSet.contains(prev)){
                    break;
                }
                else{
                    hSet.add(prev);
                    prev1 = prev;
                    prev = prev.next;
                    count++;
                }
            }
            System.out.println("count ="+count);
            ListNode temp1 = head;
            ListNode temp2 = head;
            ListNode prev3 = temp1;
            int c = count;
            while(c-->0){
                temp2 = temp2.next;
            }
            while(true){
                if(temp1==temp2){
                    System.out.println("prev3="+prev3.val+" prev3.next="+prev3.next.val);
                    prev3.next = null;
                    break;
                }
                prev3 = temp2;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return true;
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
        ListNode start1 = new ListNode(3);
        start1.next = new ListNode(1);
        start1.next.next = new ListNode(5);
        start1.next.next.next = start1;
//        start1.next.next.next.next = new ListNode(15);
//        start1.next.next.next.next.next = new ListNode(7);
//        start1.next.next.next.next.next.next = start1.next;
        System.out.println(detectAndRemoveCycle(start1));
        printList(start1);

        // printList(start3);
    }
}
