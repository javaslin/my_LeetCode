package leetcode;

public class CycleList {


    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head.next;

        ListNode slow = head;


        while (fast != null && fast.next != null) {
            if (fast.equals(slow)) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;


    }


}
