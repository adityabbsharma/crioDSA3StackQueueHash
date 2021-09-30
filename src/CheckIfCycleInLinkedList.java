public class CheckIfCycleInLinkedList {
    public static boolean linkedListCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        if(head.next==null)
            return false;
        while(fastPointer!=null && slowPointer!=null){
            if(fastPointer==slowPointer){
                return true;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return false;
    }
    public static void main(String[] args) {
        //LinkedListRemoveDuplicates linkedListRemoveDuplicates = new LinkedListRemoveDuplicates();
        ListNode start1 = new ListNode(3);
        start1.next = new ListNode(1);
        start1.next.next = new ListNode(7);
        start1.next.next.next = new ListNode(9);
        start1.next.next.next.next = new ListNode(15);
        start1.next.next.next.next.next = new ListNode(7);
        start1.next.next.next.next.next.next = start1.next;
        System.out.println(linkedListCycle(start1));


        // printList(start3);
    }

}
