package leetcode;

public class ReverseBetween {

    /*
    题解：
    https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode/
    对比反转链表 1
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (m-- > 1) {
            pre = cur;
            cur = cur.next;
            n--;
        }

        ListNode con = pre, tail = cur;

        ListNode temp = null;
        while (n > 0) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            n--;
        }

        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }

        tail.next = cur;

        return head;


    }
}
